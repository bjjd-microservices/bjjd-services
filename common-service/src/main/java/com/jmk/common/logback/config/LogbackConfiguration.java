package com.jmk.common.logback.config;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import ch.qos.logback.classic.AsyncAppender;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.composite.AbstractFieldJsonProvider;
import net.logstash.logback.composite.AbstractPatternJsonProvider;
import net.logstash.logback.composite.loggingevent.LogLevelJsonProvider;
import net.logstash.logback.composite.loggingevent.LoggingEventFormattedTimestampJsonProvider;
import net.logstash.logback.composite.loggingevent.LoggingEventPatternJsonProvider;
import net.logstash.logback.composite.loggingevent.MessageJsonProvider;
import net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder;

@Configuration
@EnableConfigurationProperties
@RefreshScope
@Profile("dev")
public class LogbackConfiguration {
	private static final String LOGSTASH_APPENDER_NAME = "LOGSTASH";
	private static final String ASYNC_LOGSTASH_APPENDER_NAME = "ASYNC_LOGSTASH";
	private final Logger LOG = LoggerFactory.getLogger(LogbackConfiguration.class);
	private final LoggerContext CONTEXT = (LoggerContext) LoggerFactory.getILoggerFactory();
	private final String appName;
	private final String logstashHost;
	private final Integer logstashPort;
	private final Integer logstashQueueSize;

	public LogbackConfiguration(@Value("${spring.application.name}") String appName,
			@Value("${logstash.host}") String logstashHost, @Value("${logstash.port}") Integer logstashPort,
			@Value("${logstash.queue-size}") Integer logstashQueueSize) {
		this.appName = appName;
		this.logstashHost = logstashHost;
		this.logstashPort = logstashPort;
		this.logstashQueueSize = logstashQueueSize;
		addLogstashAppender(CONTEXT);
	}

	private void addLogstashAppender(LoggerContext context) {
		LOG.info("Initializing Logstash logging");
		LogstashTcpSocketAppender logstashAppender = new LogstashTcpSocketAppender();
		logstashAppender.setName(LOGSTASH_APPENDER_NAME);
		logstashAppender.setContext(context);
		logstashAppender.addDestinations(new InetSocketAddress(this.logstashHost, this.logstashPort));

		LoggingEventCompositeJsonEncoder logstashJsonEncoder = new LoggingEventCompositeJsonEncoder();
		logstashJsonEncoder.getProviders().addProvider(new LogLevelJsonProvider());
		logstashJsonEncoder.getProviders().addProvider(new MessageJsonProvider());
		logstashJsonEncoder.getProviders().addProvider(
				withPattern(String.format("{ \"loglevel\": \"%s\" }", "INFO"), new LoggingEventPatternJsonProvider()));
		logstashJsonEncoder.getProviders().addProvider(
				withPattern(String.format("{ \"appName\": \"%s\" }", appName), new LoggingEventPatternJsonProvider()));
		logstashJsonEncoder.getProviders()
				.addProvider(withName("timestamp", new LoggingEventFormattedTimestampJsonProvider()));

		logstashAppender.setEncoder(logstashJsonEncoder);

		logstashAppender.start();
		// Wrap the appender in an Async appender for performance
		AsyncAppender asyncLogstashAppender = new AsyncAppender();
		asyncLogstashAppender.setContext(context);
		asyncLogstashAppender.setName(ASYNC_LOGSTASH_APPENDER_NAME);
		asyncLogstashAppender.setQueueSize(this.logstashQueueSize);
		asyncLogstashAppender.addAppender(logstashAppender);
		asyncLogstashAppender.start();
		context.getLogger("ROOT").addAppender(asyncLogstashAppender);
	}

	private AbstractPatternJsonProvider<ILoggingEvent> withPattern(String pattern,
			AbstractPatternJsonProvider<ILoggingEvent> provider) {
		provider.setPattern(pattern);
		return provider;
	}

	private <T extends DeferredProcessingAware> AbstractFieldJsonProvider<T> withName(String name,
			AbstractFieldJsonProvider<T> provider) {
		provider.setFieldName(name);
		return provider;
	}
}
