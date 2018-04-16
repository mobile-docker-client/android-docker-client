package ru.mail.park.androiddockerclient.modules;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.services.AsyncRequestHandler;
import ru.mail.park.androiddockerclient.services.IAsyncRequestHandler;

@Module
public class AsyncServicesModule {

    @Provides
    @Singleton
    IAsyncRequestHandler provideAsyncRequestHandler() {
        return new AsyncRequestHandler(Executors.newSingleThreadExecutor());
    }

}
