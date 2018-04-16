package ru.mail.park.androiddockerclient.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.mail.park.androiddockerclient.R;


public class ContainersInspectFragment extends Fragment {


    private static final String ARG_DATASET = "dataset";

    private OnListFragmentInteractionListener mListener;

    private List<DataNode> mDataset;

    private RecyclerView mRecylerView;

    public ContainersInspectFragment() {
    }

    public static ContainersInspectFragment newInstance(ArrayList<DataNode> dataset) {
        ContainersInspectFragment fragment = new ContainersInspectFragment();
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
            recyclerView.setAdapter(new ContainersInspectRecyclerViewAdapter(mDataset, mListener));
            mRecylerView = recyclerView;
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onExpanded(final int idx, final int size) {
       mRecylerView.getAdapter().notifyItemRangeInserted(idx, size);
    }
    public void onCollapsed(final int idx, final int size) {
        mRecylerView.getAdapter().notifyItemRangeRemoved(idx, size);
    }

    public interface OnListFragmentInteractionListener {
        void onDataNodeClick(final int pos, List<DataNode> dataset);
    }
}
