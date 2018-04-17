package ru.mail.park.androiddockerclient.modules;


import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import io.swagger.client.api.ImageApi;
import io.swagger.client.api.VolumeApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mail.park.androiddockerclient.services.ApiConfig;
import ru.mail.park.androiddockerclient.services.AsyncRequestHandler;
import ru.mail.park.androiddockerclient.services.IAsyncRequestHandler;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public ContainerApi provideContainerApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ContainerApi.class);

    }

    @Provides
    @Singleton
    public ImageApi provideImageApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ImageApi.class);

    }

    @Provides
    @Singleton
    public VolumeApi provideModuleApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VolumeApi.class);
    }

    @Provides
    @Singleton
    IAsyncRequestHandler provideAsyncRequestHandler() {
        return new AsyncRequestHandler(Executors.newSingleThreadExecutor());
    }
}
