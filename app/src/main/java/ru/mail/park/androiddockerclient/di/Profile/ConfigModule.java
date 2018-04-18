package ru.mail.park.androiddockerclient.di.Profile;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.services.ApiConfig;

@Module
@ProfileScope
public class ConfigModule {

    @Provides
    @ProfileScope
    public ApiConfig provideApiConfig() {
        return new ApiConfig("http://46.101.7.101:2376");
    }

}
