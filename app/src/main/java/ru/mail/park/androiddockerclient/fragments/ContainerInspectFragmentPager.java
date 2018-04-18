package ru.mail.park.androiddockerclient.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import ru.mail.park.androiddockerclient.Application;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.services.TabDataFiltersProvider;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

public class ContainerInspectFragmentPager extends Fragment {

    private static final String ARG_CONTAINER_ID = "container_id";

    @BindView(R.id.pager)
    ViewPager pager;


    @Inject
    TabDataFiltersProvider tabsDataFiletersProvider;

    private String mContainerId;

    List<String> tabs;

    @BindString(R.string.summary)
    String summaryTab;

    @BindString(R.string.host_config)
    String hostTab;


    @BindString(R.string.network)
    String networkTab;

    public ContainerInspectFragmentPager() {

    }

    public static ContainerInspectFragmentPager newInstance(String containerId) {
        ContainerInspectFragmentPager fragment = new ContainerInspectFragmentPager();
        Bundle args = new Bundle();
        args.putString(ARG_CONTAINER_ID, containerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mContainerId = args.getString(ARG_CONTAINER_ID);
        }
        Application.getProfileComponent().inject(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_container_inspect_fragment_pager, container, false);
        ButterKnife.bind(this, view);
        tabs = Lists.newArrayList(summaryTab, hostTab, networkTab);
        Set<String> allowedHostKeys = Sets.newHashSet("HostConfig", "HostnamePath", "HostsPath");
        Set<String> allowedSummaryKeys = Sets.newHashSet("Id", "Created", "Path", "Args", "GraphDriver", "Config");
        Set<String> allowedNetworkKeys = Sets.newHashSet("NetworkSettings");

        tabsDataFiletersProvider.registerFilter(summaryTab, input -> {
            String key = input.getKey();
            return key != null && allowedSummaryKeys.contains(key);
        });

        tabsDataFiletersProvider.registerFilter(hostTab, input -> {
            String key = input.getKey();
            return key != null && allowedHostKeys.contains(key);
        });

        tabsDataFiletersProvider.registerFilter(networkTab, input -> {
            String key = input.getKey();
            return key != null && allowedNetworkKeys.contains(key);
        });
        pager.setAdapter(new ContainerInspectPageAdapter(getFragmentManager()));
        return view;
    }

    public class ContainerInspectPageAdapter extends FragmentStatePagerAdapter {

        public ContainerInspectPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String tab = tabs.get(position);
            ContainerInspectFragment fragment = ContainerInspectFragment.newInstance(mContainerId, tab);
            return fragment;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs.get(position);
        }

        @Override
        public int getCount() {
            return tabs.size();
        }
    }

}
