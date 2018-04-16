package ru.mail.park.androiddockerclient.fragments;


import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataNode implements Parcelable {
    private Boolean isExpandable;
    private Boolean isExpanded;

    private String key;
    private String value;


    private List<DataNode> childes;


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

    protected DataNode(Parcel in) {
        byte tmpIsExpandable = in.readByte();
        isExpandable = tmpIsExpandable == 0 ? null : tmpIsExpandable == 1;
        byte tmpIsExpanded = in.readByte();
        isExpanded = tmpIsExpanded == 0 ? null : tmpIsExpanded == 1;
        key = in.readString();
        value = in.readString();
        childes = in.createTypedArrayList(DataNode.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (isExpandable == null ? 0 : isExpandable ? 1 : 2));
        dest.writeByte((byte) (isExpanded == null ? 0 : isExpanded ? 1 : 2));
        dest.writeString(key);
        dest.writeString(value);
        dest.writeTypedList(childes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataNode> CREATOR = new Creator<DataNode>() {
        @Override
        public DataNode createFromParcel(Parcel in) {
            return new DataNode(in);
        }

        @Override
        public DataNode[] newArray(int size) {
            return new DataNode[size];
        }
    };

    public Boolean getExpandable() {
        return isExpandable;
    }

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

}
