package ru.mail.park.androiddockerclient;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.common.collect.Ordering;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.mail.park.androiddockerclient.fragments.ContainersInspectFragment;
import ru.mail.park.androiddockerclient.fragments.DataNode;
import ru.mail.park.androiddockerclient.mappers.DataNodeMapper;
import ru.mail.park.androiddockerclient.services.ContainersService;

public class MainActivity extends AppCompatActivity implements ContainersInspectFragment.OnListFragmentInteractionListener {

    @Inject
    ContainersService service;

    @Inject
    DataNodeMapper mapper;

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
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
    }


    @Override
    public void onDataNodeClick(final int position, List<DataNode> dataset) {
        DataNode node = dataset.get(position);
        ContainersInspectFragment fragment = (ContainersInspectFragment) fragmentManager.findFragmentById(R.id.container);
        List<DataNode> childes = node.getChildes();
        if (node.getExpanded()) {
            Ordering<DataNode> ordering = Ordering
                    .natural()
                    .onResultOf(DataNode::getKey)
                    .nullsLast();

            dataset.addAll(position, ordering.sortedCopy(childes));
            fragment.onExpanded(position, childes.size());
        } else {
            dataset.subList(position + 1, position + 1 + node.getChildes().size()).clear();
            fragment.onCollapsed(position + 1, childes.size());
        }


    }


    @OnClick(R.id.containers_button)
    public void onContainersButtonClick(View view) {
        service.containerInspect("test", true, input -> {
                    runOnUiThread(() -> {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction tx = manager.beginTransaction();
                        Fragment fragment = ContainersInspectFragment.newInstance(mapper.mapToDataNodes(input, DataNodeMapper.class));
                        tx.replace(R.id.container, fragment);
                        tx.commitAllowingStateLoss();
                    });
                    return null;
                },

                input -> {
                    runOnUiThread(() -> {
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
