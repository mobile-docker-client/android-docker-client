package ru.mail.park.androiddockerclient.modules;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.services.ApiConfig;

@Module
public class ConfigModule {

    @Provides
    @Singleton
    public ApiConfig provideApiConfig() {
        return new ApiConfig("http://46.101.7.101:2376");
    }

}
