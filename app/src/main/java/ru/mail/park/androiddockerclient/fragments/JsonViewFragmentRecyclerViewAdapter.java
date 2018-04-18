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
import ru.mail.park.androiddockerclient.interfaces.OnDataNodeRecyclerViewListener;


public class JsonViewFragmentRecyclerViewAdapter extends RecyclerView.Adapter<JsonViewFragmentRecyclerViewAdapter.ViewHolder> {

    private final List<DataNode> mValues;
    private final OnDataNodeRecyclerViewListener mListener;

    public JsonViewFragmentRecyclerViewAdapter(List<DataNode> items,
                                               OnDataNodeRecyclerViewListener listener) {
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
        holder.bind(mValues.get(position));
        holder.setExpandListener(v -> mListener.onDataNodeClick(holder.getAdapterPosition(), mValues));
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


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        void bind(DataNode dataNode) {
            mItem = dataNode;

            if (dataNode.getKey() != null) {
                mKey.setText(dataNode.getKey());
            } else {
                mKey.setText("...");
            }

            if (!dataNode.getExpandable()) {
                mValue.setText(mItem.getValue());
                button.setVisibility(View.GONE);
            } else {
                mValue.setText(null);
                Boolean isExpanded = dataNode.getExpanded();
                if (isExpanded) {
                    button.setImageResource(R.drawable.expand_button_down);
                } else {
                    button.setImageResource(R.drawable.expand_button_up);
                }
                button.setVisibility(View.VISIBLE);
            }
        }

        void setExpandListener(View.OnClickListener listener) {
            button.setOnClickListener(listener);
        }


    }

}
