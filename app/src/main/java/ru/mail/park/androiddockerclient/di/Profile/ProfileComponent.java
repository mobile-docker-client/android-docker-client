package ru.mail.park.androiddockerclient.di.Profile;


import dagger.Subcomponent;
import ru.mail.park.androiddockerclient.MainActivity;
import ru.mail.park.androiddockerclient.fragments.ContainerInspectFragment;

@ProfileScope
@Subcomponent(modules = {ApiModule.class, DataProvidersModule.class,  ConfigModule.class})
public interface ProfileComponent {
    void inject(MainActivity activity);

    void inject(ContainerInspectFragment containerInspectFragment);
}
