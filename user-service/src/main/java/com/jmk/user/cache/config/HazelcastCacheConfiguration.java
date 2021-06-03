package com.jmk.user.cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizePolicy;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
@EnableCaching
public class HazelcastCacheConfiguration {

	private final Logger log = LoggerFactory.getLogger(HazelcastCacheConfiguration.class);

	private static final String USERS_CAHCE_BY_USERNAME = "usersCacheByUsername";
	
	private static final String USERS_CACHE_BY_ID = "usersCacheById";

	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Value("${spring.datasource.url}")
	private String dbURL;
	
	@Value("${spring.datasource.username}")
	private String dbUserName;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;

	/*
	 * @PreDestroy public void destroy() { log.info("Closing Cache Manager");
	 * Hazelcast.shutdownAll(); }
	 * 
	 */	@Bean
	public CacheManager cacheManager() {
		return new HazelcastCacheManager(hazelcastInstance());
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config());
		return hazelcastInstance;
	}

	@Bean
	public Config config() {
		Config config = new Config();
		config.addMapConfig(usersCacheByUsernameMapConfig());
		config.addMapConfig(usersCacheByIdMapConfig());
		config.setInstanceName("UserService");
		config.getNetworkConfig().setPort(5701);
		config.getNetworkConfig().setPortAutoIncrement(true);
		
		/*
		 * Below two lines says multicast should be disable in kubernates because the
		 * same thing can be done by enabling kubernetes config
		 */
		config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
		/*
		 * configure the Kubernetes Discovery Strategy. this configuration will form a
		 * Hazelcast with all Hazelcast instances assigned to services in the current
		 * namespace.
		 */
		config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(true);

		// In development, remove multicast auto-configuration
		if (activeProfile.equals("dev")) {
			System.setProperty("hazelcast.local.localAddress", "127.0.0.1");

			config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);

			config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);
			config.getNetworkConfig().getJoin().getKubernetesConfig().setEnabled(false);
		}
		
		/*
		 * Hazelcast Management Center enables monitoring and management of nodes
		 * running Hazelcast IMDG or Jet. This includes monitoring the overall state of
		 * clusters, as well as detailed analysis and browsing of data structures in
		 * real time, updating map configurations, and taking thread dumps from nodes.
		 */		
		config.setManagementCenterConfig(new ManagementCenterConfig());
		return config;
	}

	private MapConfig usersCacheByUsernameMapConfig() {
		final MapConfig mapConfig = new MapConfig(USERS_CAHCE_BY_USERNAME);
		mapConfig.setTimeToLiveSeconds(3600);
		mapConfig.setMaxIdleSeconds(1800);
		mapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.LRU);
		/*
		 * Maximum size of the map. When max size is reached, map is evicted based on
		 * the policy defined. Any integer between 0 and Integer.MAX_VALUE. 0 means
		 * Integer.MAX_VALUE. Default is 0.
		 */
		mapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.USED_HEAP_SIZE);
		return mapConfig;
	}
	
	private MapConfig usersCacheByIdMapConfig() {
		final MapConfig mapConfig = new MapConfig(USERS_CACHE_BY_ID);
		mapConfig.setTimeToLiveSeconds(3600);
		mapConfig.setMaxIdleSeconds(1800);
		mapConfig.getEvictionConfig().setEvictionPolicy(EvictionPolicy.LRU);
		/*
		 * Maximum size of the map. When max size is reached, map is evicted based on
		 * the policy defined. Any integer between 0 and Integer.MAX_VALUE. 0 means
		 * Integer.MAX_VALUE. Default is 0.
		 */
		mapConfig.getEvictionConfig().setMaxSizePolicy(MaxSizePolicy.USED_HEAP_SIZE);
		return mapConfig;
	}
}
