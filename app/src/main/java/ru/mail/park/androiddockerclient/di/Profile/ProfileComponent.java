package ru.mail.park.androiddockerclient.di.Profile;


import dagger.Subcomponent;
import ru.mail.park.androiddockerclient.MainActivity;

@ProfileScope
@Subcomponent(modules = {ApiModule.class, DataProvidersModule.class, FragmentProvidersModule.class, ConfigModule.class})
public interface ProfileComponent {
    void inject(MainActivity activity);
}
