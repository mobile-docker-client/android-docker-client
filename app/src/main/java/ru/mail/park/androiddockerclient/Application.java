package ru.mail.park.androiddockerclient;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import ru.mail.park.androiddockerclient.di.App.AppComponent;
import ru.mail.park.androiddockerclient.di.App.DaggerAppComponent;
import ru.mail.park.androiddockerclient.di.Profile.ProfileComponent;

public class Application extends android.app.Application {

    private static AppComponent appComponent;

    private static ProfileComponent profileComponent;


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

    public static ProfileComponent getProfileComponent() {
        if (profileComponent == null) {
            profileComponent = appComponent.plusFragmentsComponent();
        }
        return profileComponent;
    }

    public static void cleanProfileComponent() {
        profileComponent = null;
    }

}
