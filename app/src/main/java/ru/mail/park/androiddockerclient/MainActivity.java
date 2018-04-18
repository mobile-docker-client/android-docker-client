package ru.mail.park.androiddockerclient;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.park.androiddockerclient.services.ContainerFragmentsProvider;

public class MainActivity extends AppCompatActivity {

    @Inject
    ContainerFragmentsProvider service;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build());

        Application.getProfileComponent().inject(this);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
    }


    @OnClick(R.id.containers_button)
    public void onContainersButtonClick(View view) {
        service.onCreateInspectFragment(fragmentManager, "a7eff1b246c1203b20fef06134aa6b3d10e64d48d3398d7e1a2c6f52a2867523", view);
    }
}
