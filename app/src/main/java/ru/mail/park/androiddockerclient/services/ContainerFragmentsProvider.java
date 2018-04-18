package ru.mail.park.androiddockerclient.services;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.fragments.ContainerInspectFragment;
import ru.mail.park.androiddockerclient.fragments.DataNode;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;

public class ContainerFragmentsProvider {


    private ContainersFragmentsDataProvider mDataProvider;
    private IDataNodeMapper mMapper;

    public ContainerFragmentsProvider(ContainersFragmentsDataProvider dataProvider, IDataNodeMapper dataNodeMapper) {
        mDataProvider = dataProvider;
        mMapper = dataNodeMapper;
    }

    public void onCreateInspectFragment(FragmentManager manager, String containerId, View messageQueueHolder) {
        mDataProvider.containerInspect(containerId, true,
                input -> {
                    messageQueueHolder.post(() -> {
                        ArrayList<DataNode> dataNodes = mMapper.mapToDataNodes(input, ContainerInspectResponse.class);
                        Fragment fragment = ContainerInspectFragment.newInstance(dataNodes);
                        FragmentTransaction fragmentTransaction = manager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.commitAllowingStateLoss();
                    });
                    return null;
                },
                response -> {
                    Logger.e(String.valueOf(response.errorBody()));
                    //TODO: NO STRING HARDCODE!!!
                    Toast sorry = Toast.makeText(messageQueueHolder.getContext(), "SORRY", Toast.LENGTH_SHORT);
                    sorry.show();
                    return null;
                });
    }

    public void onCreateSummaryFragment(FragmentManager manager, Boolean all, Integer limit, Boolean size, View messageQueueHolder) {
        mDataProvider.containersSummary(all, limit, size,
                input -> {
                    messageQueueHolder.post(() -> {
                        ArrayList<DataNode> dataNodes = mMapper.mapToDataNodes(input, ContainerSummary.class);
                        Fragment fragment = ContainerInspectFragment.newInstance(dataNodes);
                        FragmentTransaction fragmentTransaction = manager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, fragment);
                        fragmentTransaction.commitAllowingStateLoss();
                    });
                    return null;
                },
                response -> {
                    Logger.e(String.valueOf(response.errorBody()));
                    //TODO: NO STRING HARDCODE!!!
                    Toast sorry = Toast.makeText(messageQueueHolder.getContext(), "SORRY", Toast.LENGTH_SHORT);
                    sorry.show();
                    return null;
                });
    }

}
