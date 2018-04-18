package ru.mail.park.androiddockerclient.di.Profile;


import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;
import ru.mail.park.androiddockerclient.services.ContainerFragmentsProvider;
import ru.mail.park.androiddockerclient.services.ContainersFragmentsDataProvider;

@Module
public class FragmentProvidersModule {

    @Provides
    @ProfileScope
    public ContainerFragmentsProvider providerContainerFragmentsProvider(ContainersFragmentsDataProvider dataProvider, IDataNodeMapper dataNodeMapper) {
        return new ContainerFragmentsProvider(dataProvider, dataNodeMapper);
    }


}
