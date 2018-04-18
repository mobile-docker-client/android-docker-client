package ru.mail.park.androiddockerclient.di.App;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.mail.park.androiddockerclient.mappers.DataNodeMapper;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;

@Module
public class DataNodeModule {

    @Singleton
    @Provides
    public IDataNodeMapper provideContainerInspectMapper() {
        return new DataNodeMapper(new Gson());
    }


}
