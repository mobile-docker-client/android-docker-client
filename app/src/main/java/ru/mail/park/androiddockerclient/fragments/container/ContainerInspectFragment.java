package ru.mail.park.androiddockerclient.fragments.container;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.orhanobut.logger.Logger;
import io.swagger.client.model.ContainerInspectResponse;
import ru.mail.park.androiddockerclient.Application;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.adapters.jsonView.DataNode;
import ru.mail.park.androiddockerclient.adapters.jsonView.JsonViewFragmentRecyclerViewAdapter;
import ru.mail.park.androiddockerclient.interfaces.OnDataNodeRecyclerViewListener;
import ru.mail.park.androiddockerclient.mappers.IDataNodeMapper;
import ru.mail.park.androiddockerclient.services.ContainersFragmentsDataProvider;
import ru.mail.park.androiddockerclient.services.FiltersRegistry;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class ContainerInspectFragment extends Fragment implements OnDataNodeRecyclerViewListener {

    @Inject
    ContainersFragmentsDataProvider dataProvider;

    @Inject
    IDataNodeMapper mapper;

    @Inject
    FiltersRegistry dataFiltersProvider;

    private static final String ARG_CONTAINER_ID = "container_id";
    private static final String ARG_FILTER_KEY = "filter_key";

    private String mContainerId;

    @BindView(R.id.list)
    RecyclerView mRecyclerView;

    @BindView(R.id.loading_bar)
    ProgressBar loading_bar;

    private volatile List<DataNode> mDataset;

    private Predicate<DataNode> mDataFilter;

    public ContainerInspectFragment() {
    }

    public static ContainerInspectFragment newInstance(String contId, String filterKey) {
        ContainerInspectFragment fragment = new ContainerInspectFragment();
        Bundle args = new Bundle();

        args.putString(ARG_CONTAINER_ID, contId);
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
            mContainerId = bundle.getString(ARG_CONTAINER_ID);
            String filterKey = bundle.getString(ARG_FILTER_KEY);
            if (filterKey != null) {
                mDataFilter = dataFiltersProvider.getFilter(filterKey);
            }
            mDataset = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jsonview, container, false);
        ButterKnife.bind(this, view);
        loading_bar.setVisibility(View.VISIBLE);
        dataProvider.containerInspect(mContainerId, true,
                responseData -> {
                    mDataset = mapper.mapToDataNodes(responseData, ContainerInspectResponse.class);


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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void onExpanded(final int parentIdx, final int size) {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();

        adapter.notifyItemRangeInserted(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);

    }

    public void onCollapsed(final int parentIdx, final int size) {
        RecyclerView.Adapter adapter = mRecyclerView.getAdapter();
        mRecyclerView.getAdapter().notifyItemRangeRemoved(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);
    }

    @Override
    public Iterable<DataNode> onDataNodeClick(int position, Iterable<DataNode> dataset) {
        DataNode node = Iterables.get(dataset, position);

        Iterable<DataNode> childes = node.getChildes();
        if (!node.getExpanded()) {
            Ordering<DataNode> ordering = Ordering
                    .natural()
                    .onResultOf(DataNode::getKey)
                    .nullsLast();
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
