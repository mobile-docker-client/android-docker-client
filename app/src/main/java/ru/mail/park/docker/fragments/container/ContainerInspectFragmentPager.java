package ru.mail.park.docker.fragments.container;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.park.docker.Application;
import ru.mail.park.docker.R;
import ru.mail.park.docker.filters.DataNodeKeyFilter;
import ru.mail.park.docker.services.FiltersRegistry;

public class ContainerInspectFragmentPager extends Fragment {

    private static final String ARG_CONTAINER_ID = "container_id";

    @BindView(R.id.pager)
    ViewPager pager;

    @Inject
    FiltersRegistry filtersRegistry;

    private String mContainerId;

    @BindArray(R.array.containers_tabs)
    String[] tabs;

    @BindArray(R.array.container_summary_allowed_keys)
    String[] summaryAllowedKeys;

    @BindArray(R.array.container_host_allowed_keys)
    String[] hostAllowedKeys;

    @BindArray(R.array.container_networks_allowed_keys)
    String[] networksAllowedKeys;

    @BindString(R.string.container_summary_tab_name)
    String summaryTab;

    @BindString(R.string.container_host_tab_name)
    String hostTab;

    @BindString(R.string.container_network_tab_name)
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
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.container_inspect_pager, container, false);
        ButterKnife.bind(this, view);

        filtersRegistry.registerFilter(summaryTab, new DataNodeKeyFilter(summaryAllowedKeys));
        filtersRegistry.registerFilter(hostTab, new DataNodeKeyFilter(hostAllowedKeys));
        filtersRegistry.registerFilter(networkTab, new DataNodeKeyFilter(networksAllowedKeys));

        pager.setAdapter(new ContainerInspectPageAdapter(getFragmentManager()));
        return view;
    }

    class ContainerInspectPageAdapter extends FragmentStatePagerAdapter {

        ContainerInspectPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String tab = tabs[position];
            return ContainerInspectFragment.newInstance(mContainerId, tab);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return tabs.length;
        }
    }

}
