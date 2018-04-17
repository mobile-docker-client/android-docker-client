package ru.mail.park.androiddockerclient.services;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import ru.mail.park.androiddockerclient.fragments.DataNode;
import ru.mail.park.androiddockerclient.fragments.JsonViewFragment;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;

public class JsonViewFragmentService {

    private IDataNodeMapper mMapper;

    public JsonViewFragmentService(IDataNodeMapper mapper) {
        mMapper = mapper;
    }

    public <V> JsonViewFragment produceJsonViewFragment(V source) {
        ArrayList<DataNode> dataNodes = mMapper.mapToDataNodes(source, source.getClass());
        return JsonViewFragment.newInstance(dataNodes);
    }

    public void setupFragment(AppCompatActivity activity, Fragment fragment, int id) {
        FragmentManager manager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }


}
