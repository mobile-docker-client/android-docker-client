package ru.mail.park.androiddockerclient.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.park.androiddockerclient.R;
import ru.mail.park.androiddockerclient.fragments.ContainersInspectFragment.OnListFragmentInteractionListener;


public class ContainersInspectRecyclerViewAdapter extends RecyclerView.Adapter<ContainersInspectRecyclerViewAdapter.ViewHolder> {

    private final List<DataNode> mValues;
    private final OnListFragmentInteractionListener mListener;

    public ContainersInspectRecyclerViewAdapter(List<DataNode> items,
                                                OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_containersinspect, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.bind(position, mValues.get(position));
        holder.setExpandListener(v -> mListener.onDataNodeClick(holder.mPosition, mValues));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.item_key)
        TextView mKey;

        @BindView(R.id.item_value)
        TextView mValue;

        @BindView(R.id.expand_button)
        ImageButton button;

        private DataNode mItem;
        private int mPosition;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        void bind(final int pos, DataNode dataNode) {
            mItem = dataNode;
            mPosition = pos;

            if (dataNode.getKey() != null) {
                mKey.setText(dataNode.getKey());
            } else {
                mKey.setText("...");
            }

            if (!dataNode.getExpandable()) {
                mValue.setText(mItem.getValue());
                button.setVisibility(View.GONE);
            } else {
                Boolean isExpanded = dataNode.getExpanded();
                if (isExpanded) {
                    button.setImageResource(R.drawable.expand_button_up);
                } else {
                    button.setImageResource(R.drawable.expand_button_down);
                }
            }
        }

        void setExpandListener(View.OnClickListener listener) {
            button.setOnClickListener(listener);
        }


    }

}
