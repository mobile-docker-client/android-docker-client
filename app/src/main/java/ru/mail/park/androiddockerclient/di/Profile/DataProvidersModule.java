package ru.mail.park.androiddockerclient.di.Profile;

import com.google.common.cache.Cache;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;
import ru.mail.park.androiddockerclient.services.ContainersFragmentsDataProvider;
import ru.mail.park.androiddockerclient.services.IAsyncTaskHandler;

@Module
public class DataProvidersModule {

    @ProfileScope
    @Provides
    public ContainersFragmentsDataProvider provideContainerApiService(ContainerApi api,
                                                                      IAsyncTaskHandler requestHandler,
                                                                      Cache<String, ContainerInspectResponse> inspectResponseCache,
                                                                      Cache<String, ContainerSummary> containerSummaryCache) {
        return new ContainersFragmentsDataProvider(api, requestHandler, inspectResponseCache, containerSummaryCache);

    }



}
