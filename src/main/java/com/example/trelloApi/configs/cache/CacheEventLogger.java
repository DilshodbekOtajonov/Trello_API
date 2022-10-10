package com.example.trelloApi.configs.cache;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * @author "Otajonov Dilshodbek
 * @since 9/5/22 10:51 PM (Monday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {
    @Override
    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        System.out.println("Cache event listener => " + cacheEvent.getKey() + cacheEvent.getOldValue() + cacheEvent.getNewValue());
    }
}