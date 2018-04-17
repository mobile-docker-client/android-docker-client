package ru.mail.park.androiddockerclient;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.common.collect.Ordering;
import com.orhanobut.logger.Logger;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.park.androiddockerclient.fragments.DataNode;
import ru.mail.park.androiddockerclient.fragments.JsonViewFragment;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;
import ru.mail.park.androiddockerclient.services.ContainersService;
import ru.mail.park.androiddockerclient.services.JsonViewFragmentService;

public class MainActivity extends AppCompatActivity implements JsonViewFragment.OnListFragmentInteractionListener {

    @Inject
    ContainersService service;

    @Inject
    JsonViewFragmentService jsonViewFragmentService;

    @Inject
    IDataNodeMapper mapper;

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

        Application.getAppComponent().inject(this);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
    }


    @Override
    public void onDataNodeClick(final int position, List<DataNode> dataset) {
        DataNode node = dataset.get(position);
        JsonViewFragment fragment = (JsonViewFragment) fragmentManager.findFragmentById(R.id.container);
        List<DataNode> childes = node.getChildes();
        if (!node.getExpanded()) {
            Ordering<DataNode> ordering = Ordering
                    .natural()
                    .onResultOf(DataNode::getKey)
                    .nullsLast();
            node.setExpanded(true);
            Collections.sort(childes, ordering);
            dataset.addAll(position + 1, childes);
            fragment.onExpanded(position, childes.size());
        } else {
            dataset.subList(position + 1, position + 1 + node.getChildes().size()).clear();
            node.setExpanded(false);
            fragment.onCollapsed(position, childes.size());

        }

    }


    @OnClick(R.id.containers_button)
    public void onContainersButtonClick(View view) {

        service.containerInspect("a7eff1b246c1203b20fef06134aa6b3d10e64d48d3398d7e1a2c6f52a2867523",
                true,
                input -> {
                    runOnUiThread(() -> {
                        Fragment fragment = jsonViewFragmentService.produceJsonViewFragment(input);
                        jsonViewFragmentService.setupFragment(this, fragment, R.id.container);
                    });
                    return null;
                },

                input -> {
                    runOnUiThread(() -> {
                        Logger.e("fail: %s", input.message());

                        Toast toast = Toast.makeText(
                                getApplicationContext(),
                                "SORRY!",
                                Toast.LENGTH_SHORT
                        );
                        toast.show();
                    });
                    return null;
                });

    }


}
