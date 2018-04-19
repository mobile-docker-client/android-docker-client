package ru.mail.park.docker.services;

import com.google.common.base.Predicate;

import java.util.concurrent.ConcurrentHashMap;

import ru.mail.park.docker.adapters.jsonView.DataNode;

@SuppressWarnings("Guava")
public class FiltersRegistry {

    private final ConcurrentHashMap<String, Predicate<DataNode>> filtersRegistry = new ConcurrentHashMap<>();

    public Predicate<DataNode> getFilter(String tab) {
        return filtersRegistry.get(tab);
    }

    public void registerFilter(String tab, Predicate<DataNode> filter) {
        filtersRegistry.put(tab, filter);
    }
}
