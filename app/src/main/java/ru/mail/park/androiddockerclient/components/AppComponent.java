package ru.mail.park.androiddockerclient.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.mail.park.androiddockerclient.MainActivity;
import ru.mail.park.androiddockerclient.fragments.JsonViewFragmentRecyclerViewAdapter;
import ru.mail.park.androiddockerclient.modules.ApiModule;
import ru.mail.park.androiddockerclient.modules.ConfigModule;
import ru.mail.park.androiddockerclient.modules.DataNodeModule;
import ru.mail.park.androiddockerclient.modules.ServicesModule;

@Singleton
@Component(modules =
        {
                ApiModule.class,
                ServicesModule.class,
                DataNodeModule.class,
                ConfigModule.class
        })
public interface AppComponent {

    void inject(JsonViewFragmentRecyclerViewAdapter adapter);

    void inject(MainActivity activity);

}
