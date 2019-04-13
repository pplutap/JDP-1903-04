package com.kodilla.ecommercee.domain.users;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GuavaCacheService {

    private static LoadingCache<User, Long> userCache;

    static{
        userCache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterAccess(5, TimeUnit.MINUTES) //Narazie do testow
                .build(
                        new CacheLoader<User, Long>() {
                            @Override
                            public Long load(User key) throws Exception {
                                return createCacheValue(key);
                            }
                        }
                );
    }

    private static Long createCacheValue(User user) {
        return new Random().nextInt(100000) + 39928* user.hashCode() + 35 * 2L;
    }

    public static LoadingCache<User, Long> getUserCache() {
        return userCache;
    }
}

