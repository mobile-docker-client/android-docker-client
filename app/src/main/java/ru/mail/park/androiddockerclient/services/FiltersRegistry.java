package ru.mail.park.androiddockerclient.services;

import com.google.common.base.Predicate;
import ru.mail.park.androiddockerclient.adapters.jsonView.DataNode;

import java.util.concurrent.ConcurrentHashMap;


public class FiltersRegistry {

    ConcurrentHashMap<String, Predicate<DataNode>> fitersRegistry = new ConcurrentHashMap<>();

    public Predicate<DataNode> getFilter(String tab) {
        return fitersRegistry.get(tab);
    }

    public void registerFilter(String tab, Predicate<DataNode> filter) {
        fitersRegistry.put(tab, filter);
    }


}
