package ru.mail.park.androiddockerclient.interfaces;

import ru.mail.park.androiddockerclient.fragments.DataNode;

public interface OnDataNodeRecyclerViewListener {
    Iterable<DataNode> onDataNodeClick(final int pos, Iterable<DataNode> dataset);
}
