package ru.mail.park.androiddockerclient.services;

import com.google.common.base.Predicate;
import ru.mail.park.androiddockerclient.fragments.DataNode;

import java.util.concurrent.ConcurrentHashMap;


public class TabDataFiltersProvider {

    ConcurrentHashMap<String, Predicate<DataNode>> fitersRegister;

    public Predicate<DataNode> getFilter(String tab) {
        return fitersRegister.get(tab);
    }

    public void registerFilter(String tab, Predicate<DataNode> filter) {
        fitersRegister.put(tab, filter);
    }

}
