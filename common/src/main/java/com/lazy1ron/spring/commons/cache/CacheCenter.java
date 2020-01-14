package com.lazy1ron.spring.commons.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:Lazy1ron
 * @date:2019/12/22 20:00
 */
@Component
public class CacheCenter {

    private CacheCenter() {}

    private static volatile ConcurrentHashMap<Long, Object> cache = new ConcurrentHashMap();


    @Bean(value = "cache", destroyMethod = "clear")
    public static Map<Long, Object> getCache() {
        return cache;
    }

    public static void addEntry(Long id, Object o) {
       cache.put(id, o);
    }

    public static void clearCache() {
        cache.clear();
    }

}
