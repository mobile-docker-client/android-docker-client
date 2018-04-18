package ru.mail.park.androiddockerclient.di.App;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.park.androiddockerclient.di.Profile.ConfigModule;
import ru.mail.park.androiddockerclient.di.Profile.ProfileComponent;
import ru.mail.park.androiddockerclient.fragments.JsonViewFragmentRecyclerViewAdapter;

@Singleton
@Component(modules =
        {
                CacheModule.class,
                DataNodeModule.class,
                TabsModule.class
        })
public interface AppComponent {

    ProfileComponent plusFragmentsComponent();

}
