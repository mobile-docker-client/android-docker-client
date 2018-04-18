package ru.mail.park.androiddockerclient.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.services.TabDataFiltersProvider;

import javax.inject.Inject;
import java.util.List;

public class ContainerInspectFragmentPager extends Fragment {

    private static final String ARG_CONTAINER_ID = "container_id";

    @BindView(R.id.pager)
    ViewPager pager;

    private String mContainerId;

    public ContainerInspectFragmentPager() {

    }

    public static ContainerInspectFragmentPager newInstance(String containerId) {
        ContainerInspectFragmentPager fragment = new ContainerInspectFragmentPager();
        Bundle args = new Bundle();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_container_inspect_fragment_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public class ContainerInspectPageAdapter extends FragmentStatePagerAdapter {

        List<String> tabs;

        @Inject
        TabDataFiltersProvider tabsDataFiletersProvider;

        public ContainerInspectPageAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            String tab = tabs.get(position);
            ContainerInspectFragment fragment = ContainerInspectFragment.newInstance(mContainerId);
            fragment.setFilter(tabsDataFiletersProvider.getFilter(tab));
            return fragment;
        }

        @Override
        public int getCount() {
            return tabs.size();
        }
    }

}
