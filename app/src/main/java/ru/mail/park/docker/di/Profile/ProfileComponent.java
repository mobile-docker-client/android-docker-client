package ru.mail.park.docker.di.Profile;


import dagger.Subcomponent;
import ru.mail.park.docker.MainActivity;
import ru.mail.park.docker.fragments.container.ContainerInspectFragment;
import ru.mail.park.docker.fragments.container.ContainerInspectFragmentPager;
import ru.mail.park.docker.fragments.image.ImageInspectFragmentPager;
import ru.mail.park.docker.fragments.image.ImagesInspectFragment;

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
