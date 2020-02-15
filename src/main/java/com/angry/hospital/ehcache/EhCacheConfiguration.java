package com.angry.hospital.ehcache;

import com.angry.hospital.utils.Constants;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class EhCacheConfiguration extends CachingConfigurerSupport {

    @Bean
    public net.sf.ehcache.CacheManager ehcacheManager() {

        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName(Constants.CACHE_NAME);
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000000);
        cacheConfiguration.setTimeToLiveSeconds(1800);


        CacheConfiguration cacheConfiguration1 = new CacheConfiguration();
        cacheConfiguration1.setName(Constants.TEMP);
        cacheConfiguration1.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration1.setMaxEntriesLocalHeap(1000000);
        cacheConfiguration1.setTimeToLiveSeconds(Duration.ofDays(365).getSeconds());


        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.addCache(cacheConfiguration);
        configuration.addCache(cacheConfiguration1);
        return net.sf.ehcache.CacheManager.newInstance(configuration);
    }


    @Bean
    @Override
    public org.springframework.cache.CacheManager cacheManager() {
        return new EhCacheCacheManager(ehcacheManager());
    }
}