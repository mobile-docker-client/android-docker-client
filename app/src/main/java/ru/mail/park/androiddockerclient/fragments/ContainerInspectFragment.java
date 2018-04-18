package ru.mail.park.androiddockerclient.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.interfaces.OnDataNodeRecyclerViewListener;


public class ContainerInspectFragment extends Fragment implements OnDataNodeRecyclerViewListener {


    private static final String ARG_DATASET = "dataset";

    private List<DataNode> mDataset;

    private RecyclerView mRecylerView;

    public ContainerInspectFragment() {
    }

    public static ContainerInspectFragment newInstance(ArrayList<DataNode> dataset) {
        ContainerInspectFragment fragment = new ContainerInspectFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_DATASET, dataset);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            mDataset = bundle.getParcelableArrayList(ARG_DATASET);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_containersinspect_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new JsonViewFragmentRecyclerViewAdapter(mDataset, this));
            mRecylerView = recyclerView;
        }

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
        RecyclerView.Adapter adapter = mRecylerView.getAdapter();

        adapter.notifyItemRangeInserted(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);

    }

    public void onCollapsed(final int parentIdx, final int size) {
        RecyclerView.Adapter adapter = mRecylerView.getAdapter();
        mRecylerView.getAdapter().notifyItemRangeRemoved(parentIdx + 1, size);
        adapter.notifyItemChanged(parentIdx);
    }

    @Override
    public void onDataNodeClick(int position, List<DataNode> dataset) {
        DataNode node = dataset.get(position);

        List<DataNode> childes = node.getChildes();
        if (!node.getExpanded()) {
            Ordering<DataNode> ordering = Ordering
                    .natural()
                    .onResultOf(DataNode::getKey)
                    .nullsLast();
            node.setExpanded(true);
            Collections.sort(childes, ordering);
            dataset.addAll(position + 1, childes);
            onExpanded(position, childes.size());
        } else {
            dataset.subList(position + 1, position + 1 + node.getChildes().size()).clear();
            node.setExpanded(false);
            onCollapsed(position, childes.size());
        }

    }
}
