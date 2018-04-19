package ru.mail.park.docker.di.Profile;


import dagger.Module;
import dagger.Provides;
import ru.mail.park.docker.services.ApiConfig;

@Module
@ProfileScope
public class ConfigModule {

    @Provides
    @ProfileScope
    public ApiConfig provideApiConfig() {
        return new ApiConfig("http://46.101.7.101:2376");
    }

}
