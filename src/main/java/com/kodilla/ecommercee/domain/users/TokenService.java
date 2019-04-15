package com.kodilla.ecommercee.domain.users;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenService {

    private LoadingCache<User, Long> userCache;

    public TokenService() {
        this.userCache = CacheBuilder.newBuilder()
                .maximumSize(10000)
                .expireAfterAccess(5, TimeUnit.MINUTES) //Narazie do testow
                .build(
                        new CacheLoader<User, Long>() {
                            @Override
                            public Long load(User key) throws Exception {
                                return generateToken();
                            }
                        }
                );
    }

    private Long generateToken() {
        return UUID.randomUUID().getMostSignificantBits()&Long.MAX_VALUE;
    }

    public LoadingCache<User, Long> getUserCache() {
        return userCache;
    }
}

