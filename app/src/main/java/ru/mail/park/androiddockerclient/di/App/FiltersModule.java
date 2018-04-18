package ru.mail.park.androiddockerclient.di.App;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.services.FiltersRegistry;

import javax.inject.Singleton;

@Module
public class FiltersModule {

    @Singleton
    @Provides
    public FiltersRegistry provideFiltersRegistry() {
        return new FiltersRegistry();
    }
}
