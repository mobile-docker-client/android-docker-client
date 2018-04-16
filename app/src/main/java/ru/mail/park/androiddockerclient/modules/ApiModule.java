package ru.mail.park.androiddockerclient.modules;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import io.swagger.client.api.ImageApi;
import io.swagger.client.api.VolumeApi;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ContainerApi provideContainerApi() {

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
                .create(ContainerApi.class);

    }

    @Provides
    @Singleton
    public ImageApi provideImageApi() {

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
                .create(ImageApi.class);

    }

    @Provides
    @Singleton
    public VolumeApi provideModuleApi() {

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
                .create(VolumeApi.class);
    }

}
