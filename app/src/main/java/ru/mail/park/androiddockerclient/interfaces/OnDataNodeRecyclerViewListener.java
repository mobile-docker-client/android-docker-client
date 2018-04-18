package ru.mail.park.androiddockerclient.interfaces;

import ru.mail.park.androiddockerclient.adapters.jsonView.DataNode;

public interface OnDataNodeRecyclerViewListener {
    Iterable<DataNode> onDataNodeClick(final int pos, Iterable<DataNode> dataset);
}
