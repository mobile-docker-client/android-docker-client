package ru.mail.park.androiddockerclient.components;

import dagger.Component;
import ru.mail.park.androiddockerclient.fragments.ContainersInspectRecyclerViewAdapter;
import ru.mail.park.androiddockerclient.modules.ApiModule;
import ru.mail.park.androiddockerclient.modules.AsyncServicesModule;
import ru.mail.park.androiddockerclient.modules.ServicesModule;

@Component(modules = {ApiModule.class,
        AsyncServicesModule.class,
        ServicesModule.class,
})
public interface AppComponent {

    void inject(ContainersInspectRecyclerViewAdapter adapter);

}
