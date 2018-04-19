package ru.mail.park.docker.adapters.jsonView;


import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataNode {
    private Boolean isExpandable;
    private Boolean isExpanded;

    private String key;
    private String value;

    private final List<DataNode> childes;

    public DataNode(Boolean isExpandable,
                    Boolean isExpanded,
                    String key,
                    String value,
                    List<DataNode> childes) {
        this.isExpandable = isExpandable;
        this.isExpanded = isExpanded;
        this.key = key;
        this.value = value;
        this.childes = childes;
    }


    public Boolean getExpandable() {
        return isExpandable;
    }

    @SuppressWarnings("unused")
    public void setExpandable(Boolean expandable) {
        isExpandable = expandable;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    @Nullable
    public String getKey() {
        return key;
    }

    @SuppressWarnings("unused")
    public void setKey(String key) {
        this.key = key;
    }

    @Nullable
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<DataNode> getChildes() {
        if (childes == null) {
            return new ArrayList<>();
        }
        return childes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataNode)) return false;
        DataNode dataNode = (DataNode) o;
        return Objects.equals(getKey(), dataNode.getKey()) &&
                Objects.equals(getValue(), dataNode.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getKey(), getValue());
    }
}
