package ru.mail.park.docker.di.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.docker.services.FiltersRegistry;

@Module
public class FiltersModule {

    @Singleton
    @Provides
    public FiltersRegistry provideFiltersRegistry() {
        return new FiltersRegistry();
    }
}
