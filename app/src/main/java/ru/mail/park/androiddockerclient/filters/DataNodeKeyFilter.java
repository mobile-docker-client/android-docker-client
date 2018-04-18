package ru.mail.park.androiddockerclient.filters;

import android.support.annotation.NonNull;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.Set;

import ru.mail.park.androiddockerclient.adapters.jsonView.DataNode;

public class DataNodeKeyFilter implements Predicate<DataNode> {

    private Set<String> mAllowedKeys;

    public DataNodeKeyFilter(String ... allowedKeys) {
        mAllowedKeys = Sets.newHashSet(allowedKeys);
    }

    @Override
    public boolean apply(@NonNull DataNode input) {
        String key = input.getKey();
        return key != null && mAllowedKeys.contains(key);
    }
}
