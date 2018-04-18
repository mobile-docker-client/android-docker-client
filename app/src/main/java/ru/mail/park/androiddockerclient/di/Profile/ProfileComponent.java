package ru.mail.park.androiddockerclient.di.Profile;


import dagger.Subcomponent;
import ru.mail.park.androiddockerclient.MainActivity;
import ru.mail.park.androiddockerclient.fragments.container.ContainerInspectFragment;
import ru.mail.park.androiddockerclient.fragments.container.ContainerInspectFragmentPager;
import ru.mail.park.androiddockerclient.fragments.image.ImageInspectFragmentPager;
import ru.mail.park.androiddockerclient.fragments.image.ImagesInspectFragment;

@ProfileScope
@Subcomponent(modules = {ApiModule.class,
        DataProvidersModule.class,
        ConfigModule.class})
public interface ProfileComponent {
    void inject(MainActivity activity);

    void inject(ContainerInspectFragment containerInspectFragment);

    void inject(ContainerInspectFragmentPager containerInspectFragmentPager);

    void inject(ImagesInspectFragment imagesInspectFragment);

    void inject(ImageInspectFragmentPager imageInspectFragmentPager);
}
