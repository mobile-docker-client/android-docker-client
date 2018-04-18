package ru.mail.park.androiddockerclient.fragments.image;

import android.os.Bundle;
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
import ru.mail.park.androiddockerclient.Application;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.filters.DataNodeKeyFilter;
import ru.mail.park.androiddockerclient.services.FiltersRegistry;

public class ImageInspectFragmentPager extends Fragment {
    private static final String ARG_IMAGE_NAME = "container_id";

    @BindView(R.id.pager)
    ViewPager pager;

    @BindArray(R.array.images_tabs)
    String[] tabs;

    @BindArray(R.array.image_container_allowed_keys)
    String[] containerAllowedKeys;

    @BindArray(R.array.image_config_allowed_keys)
    String[] configAllowedKeys;

    @BindArray(R.array.image_summary_allowed_keys)
    String[] summaryAllowedKeys;


    @Inject
    FiltersRegistry filtersRegistry;

    private String mImageName;

    @BindString(R.string.images_config_tab_name)
    String configTab;

    @BindString(R.string.images_container_tab_name)
    String containerTab;

    @BindString(R.string.images_summary_tab_name)
    String summaryTab;

    public ImageInspectFragmentPager() {

    }

    public static ImageInspectFragmentPager newInstance(String imageName) {
        ImageInspectFragmentPager fragment = new ImageInspectFragmentPager();
        Bundle args = new Bundle();
        args.putString(ARG_IMAGE_NAME, imageName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mImageName = args.getString(ARG_IMAGE_NAME);
        }
        Application.getProfileComponent().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.container_inspect_pager, container, false);
        ButterKnife.bind(this, view);

        filtersRegistry.registerFilter(summaryTab, new DataNodeKeyFilter(summaryAllowedKeys));
        filtersRegistry.registerFilter(configTab, new DataNodeKeyFilter(configAllowedKeys));
        filtersRegistry.registerFilter(containerTab, new DataNodeKeyFilter(containerAllowedKeys));

        pager.setAdapter(new ImageInspectPageAdapter(getFragmentManager()));
        return view;
    }

    public class ImageInspectPageAdapter extends FragmentStatePagerAdapter {

        public ImageInspectPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String tab = tabs[position];
            ImagesInspectFragment fragment = ImagesInspectFragment.newInstance(mImageName, tab);
            return fragment;
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
