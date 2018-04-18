package ru.mail.park.androiddockerclient.di.App;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;

@Module
public class CacheModule {

    @Provides
    @Singleton
    public Cache<String, ContainerInspectResponse> provideContainerResponseCache() {
        return CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    public Cache<String, ContainerSummary> provideContainerSummaryCache() {
        return CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .build();
    }
}
