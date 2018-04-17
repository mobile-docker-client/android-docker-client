package ru.mail.park.androiddockerclient;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import ru.mail.park.androiddockerclient.components.AppComponent;
import ru.mail.park.androiddockerclient.components.DaggerAppComponent;

public class Application extends android.app.Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent
                .builder()
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }


    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
