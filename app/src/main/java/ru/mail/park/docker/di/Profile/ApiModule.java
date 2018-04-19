package ru.mail.park.docker.di.Profile;


import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import io.swagger.client.api.ImageApi;
import io.swagger.client.api.VolumeApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.mail.park.docker.services.ApiConfig;
import ru.mail.park.docker.services.AsyncTaskHandler;
import ru.mail.park.docker.services.IAsyncTaskHandler;

@Module
@ProfileScope
public class ApiModule {

    @Provides
    @ProfileScope
    public ContainerApi provideContainerApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ContainerApi.class);

    }

    @Provides
    @ProfileScope
    public ImageApi provideImageApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ImageApi.class);

    }

    @Provides
    @ProfileScope
    public VolumeApi provideModuleApi(ApiConfig apiConfig) {

        return new Retrofit.Builder()
                .baseUrl(apiConfig.getBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(VolumeApi.class);
    }


    @Provides
    @ProfileScope
    IAsyncTaskHandler provideAsyncRequestHandler() {
        return new AsyncTaskHandler(Executors.newSingleThreadExecutor());
    }
}
