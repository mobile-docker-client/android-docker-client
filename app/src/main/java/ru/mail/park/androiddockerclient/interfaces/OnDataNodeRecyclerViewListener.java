package ru.mail.park.androiddockerclient.interfaces;

import java.util.List;

import ru.mail.park.androiddockerclient.fragments.DataNode;

public interface OnDataNodeRecyclerViewListener {
    void onDataNodeClick(final int pos, List<DataNode> dataset);
}
