package ru.mail.park.docker.di.App;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;
import io.swagger.client.model.Image;
import io.swagger.client.model.ImageSummary;

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

    @Provides
    @Singleton
    public Cache<String, Image> provideImageInspectCache() {
        return CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    @Singleton
    public Cache<String, List<ImageSummary>> provideImageSummaryCache() {
        return CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterAccess(1, TimeUnit.MINUTES)
                .build();
    }
}
