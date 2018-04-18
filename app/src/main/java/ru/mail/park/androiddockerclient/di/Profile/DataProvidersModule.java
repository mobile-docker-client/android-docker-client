package ru.mail.park.androiddockerclient.di.Profile;

import com.google.common.cache.Cache;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import io.swagger.client.api.ImageApi;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;
import io.swagger.client.model.Image;
import io.swagger.client.model.ImageSummary;
import ru.mail.park.androiddockerclient.services.ContainersFragmentsDataProvider;
import ru.mail.park.androiddockerclient.services.IAsyncTaskHandler;
import ru.mail.park.androiddockerclient.services.ImagesFragmentsDataProvider;

@Module
public class DataProvidersModule {

    @ProfileScope
    @Provides
    public ContainersFragmentsDataProvider provideContainersDataProvider(ContainerApi api,
                                                                         IAsyncTaskHandler requestHandler,
                                                                         Cache<String, ContainerInspectResponse> inspectResponseCache,
                                                                         Cache<String, ContainerSummary> containerSummaryCache) {
        return new ContainersFragmentsDataProvider(api, requestHandler, inspectResponseCache, containerSummaryCache);

    }


    @ProfileScope
    @Provides
    public ImagesFragmentsDataProvider provideImagesDataProvider(ImageApi api,
                                                                 IAsyncTaskHandler requestHandler,
                                                                 Cache<String, Image> inspectResponseCache,
                                                                 Cache<String, List<ImageSummary>> summaryCache) {
        return new ImagesFragmentsDataProvider(api, requestHandler, inspectResponseCache, summaryCache);

    }

}
