package ru.mail.park.docker.fragments.image;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.swagger.client.model.Image;
import ru.mail.park.docker.Application;
import ru.mail.park.docker.R;
import ru.mail.park.docker.adapters.jsonView.DataNode;
import ru.mail.park.docker.adapters.jsonView.JsonViewFragmentRecyclerViewAdapter;
import ru.mail.park.docker.interfaces.OnDataNodeRecyclerViewListener;
import ru.mail.park.docker.mappers.IDataNodeMapper;
import ru.mail.park.docker.services.FiltersRegistry;
import ru.mail.park.docker.services.ImagesFragmentsDataProvider;

public class ImagesInspectFragment extends Fragment implements OnDataNodeRecyclerViewListener {

    @Inject
    ImagesFragmentsDataProvider dataProvider;

    @Inject
    IDataNodeMapper mapper;

    @Inject
    FiltersRegistry dataFiltersProvider;

    private static final String ARG_IMAGE_NAME = "image_name";
    private static final String ARG_FILTER_KEY = "filter_key";

    private String mContainerId;

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.loading_bar)
    ProgressBar loading_bar;

    private volatile List<DataNode> mDataset;

    @SuppressWarnings("Guava")
    private Predicate<DataNode> mDataFilter;

    public ImagesInspectFragment() {
    }

    public static ImagesInspectFragment newInstance(String imgId, String filterKey) {
        ImagesInspectFragment fragment = new ImagesInspectFragment();
        Bundle args = new Bundle();

        args.putString(ARG_IMAGE_NAME, imgId);
        args.putString(ARG_FILTER_KEY, filterKey);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Application.getProfileComponent().inject(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mContainerId = bundle.getString(ARG_IMAGE_NAME);
            String filterKey = bundle.getString(ARG_FILTER_KEY);
            if (filterKey != null) {
                mDataFilter = dataFiltersProvider.getFilter(filterKey);
            }
            mDataset = null;
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jsonview, container, false);
        ButterKnife.bind(this, view);
        loading_bar.setVisibility(View.VISIBLE);
        dataProvider.imageInspect(mContainerId,
                responseData -> {
                    mDataset = mapper.mapToDataNodes(responseData, Image.class);

                    if (mDataFilter != null) {
                        List<DataNode> filtered = new ArrayList<>();
                        Iterables.addAll(filtered, Iterables.filter(mDataset, mDataFilter));
                        mDataset = filtered;
                    }

                    mRecyclerView.post(() -> {
                        Context context = mRecyclerView.getContext();
                        loading_bar.setVisibility(View.INVISIBLE);
                        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
                        mRecyclerView.setAdapter(new JsonViewFragmentRecyclerViewAdapter(mDataset, this));
                    });
                    return null;
                },
                response -> {
                    loading_bar.setVisibility(View.INVISIBLE);
                    Logger.e(response.message());
                    Toast.makeText(getContext(), R.string.error_fragment_create, Toast.LENGTH_SHORT)
                            .show();
                    return null;
                });
        return view;
    }


    private void onExpanded(final int parentIdx, final int size) {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();

        adapter.notifyItemRangeInserted(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);

    }

    private void onCollapsed(final int parentIdx, final int size) {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        mRecyclerView.getAdapter().notifyItemRangeRemoved(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);
    }

    @Override
    public Iterable<DataNode> onDataNodeClick(int position, Iterable<DataNode> dataset) {
        DataNode node = Iterables.get(dataset, position);

        Iterable<DataNode> childes = node.getChildes();
        if (!node.getExpanded() && childes != null) {
            Ordering<DataNode> ordering = Ordering
                    .natural()
                    .nullsLast()
                    .onResultOf(DataNode::getKey);

            node.setExpanded(true);
            childes = ordering.sortedCopy(childes);
            List<DataNode> childesList = new ArrayList<>();
            Iterables.addAll(childesList, childes);
            mDataset.addAll(position + 1, childesList);
            onExpanded(position, childesList.size());
        } else {
            mDataset.subList(position + 1, position + 1 + node.getChildes().size()).clear();
            node.setExpanded(false);
            onCollapsed(position, Iterables.size(childes));
        }

        return mDataset;
    }
}
