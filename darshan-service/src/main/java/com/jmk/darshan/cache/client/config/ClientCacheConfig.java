package com.jmk.darshan.cache.client.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.NearCacheConfig;

@EnableCaching
@EnableAutoConfiguration
public class ClientCacheConfig {

	@Bean
	public ClientConfig config() {
		ClientConfig clientConfig=new ClientConfig();
		clientConfig.addNearCacheConfig(nearCacheConfig());
		return clientConfig;
	}
	
	private NearCacheConfig nearCacheConfig() {
	    NearCacheConfig nearCacheConfig = new NearCacheConfig();
	    nearCacheConfig.setName("users");
	    nearCacheConfig.setTimeToLiveSeconds(300);
	    return nearCacheConfig;
	  }
}
