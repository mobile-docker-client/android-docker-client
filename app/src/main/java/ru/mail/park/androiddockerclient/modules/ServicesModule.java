package ru.mail.park.androiddockerclient.modules;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.swagger.client.api.ContainerApi;
import ru.mail.park.androiddockerclient.mappers.DataNodeMapper;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;
import ru.mail.park.androiddockerclient.services.ContainersService;
import ru.mail.park.androiddockerclient.services.IAsyncRequestHandler;
import ru.mail.park.androiddockerclient.services.JsonViewFragmentService;

@Module
public class ServicesModule {

    @Singleton
    @Provides
    public ContainersService provideContainerApiService(ContainerApi api, IAsyncRequestHandler requestHandler) {
        return new ContainersService(api, requestHandler);
    }

    @Singleton
    @Provides
    public JsonViewFragmentService provideJsonViewFragmentService(IDataNodeMapper mapper){
        return new JsonViewFragmentService(mapper);
    }
}
