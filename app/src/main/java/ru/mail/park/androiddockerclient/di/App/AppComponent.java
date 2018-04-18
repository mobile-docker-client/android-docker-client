package ru.mail.park.androiddockerclient.di.App;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.park.androiddockerclient.di.Profile.ProfileComponent;

@Singleton
@Component(modules =
        {
                CacheModule.class,
                DataNodeModule.class,
                FiltersModule.class
        })
public interface AppComponent {

    ProfileComponent plusFragmentsComponent();

}
