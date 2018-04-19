package ru.mail.park.docker.filters;

import android.support.annotation.NonNull;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import java.util.Set;

import ru.mail.park.docker.adapters.jsonView.DataNode;

public class DataNodeKeyFilter implements Predicate<DataNode> {

    private final Set<String> mAllowedKeys;

    public DataNodeKeyFilter(String... allowedKeys) {
        mAllowedKeys = Sets.newHashSet(allowedKeys);
    }

    @Override
    public boolean apply(@NonNull DataNode input) {
        String key = input.getKey();
        return key != null && mAllowedKeys.contains(key);
    }
}
