package ru.mail.park.docker;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import ru.mail.park.docker.di.App.AppComponent;
import ru.mail.park.docker.di.App.DaggerAppComponent;
import ru.mail.park.docker.di.Profile.ProfileComponent;

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

    @SuppressWarnings("unused")
    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static ProfileComponent getProfileComponent() {
        if (profileComponent == null) {
            profileComponent = appComponent.plusFragmentsComponent();
        }
        return profileComponent;
    }

    @SuppressWarnings("unused")
    public static void cleanProfileComponent() {
        profileComponent = null;
    }

}
