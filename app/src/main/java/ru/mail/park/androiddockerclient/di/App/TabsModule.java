package ru.mail.park.androiddockerclient.di.App;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.services.TabDataFiltersProvider;

import javax.inject.Singleton;

@Module
public class TabsModule {

    @Singleton
    @Provides
    public TabDataFiltersProvider provideDataFiltersProvider() {
        return new TabDataFiltersProvider();
    }
}
