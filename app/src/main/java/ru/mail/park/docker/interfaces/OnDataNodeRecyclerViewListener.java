package ru.mail.park.docker.interfaces;

import ru.mail.park.docker.adapters.jsonView.DataNode;

public interface OnDataNodeRecyclerViewListener {
    Iterable<DataNode> onDataNodeClick(final int pos, Iterable<DataNode> dataset);
}
