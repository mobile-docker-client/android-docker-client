package ru.mail.park.androiddockerclient.mappers;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.mail.park.androiddockerclient.fragments.DataNode;

public interface IDataNodeMapper {

    DataNode entryToDataNode(Map.Entry<String, JsonElement> element);

    DataNode jsonElemToDataNode(String key, JsonElement elem);

    <V> ArrayList<DataNode> mapToDataNodes(V source, Class clazz);

    <V> List<DataNode> mapToDataNodes(V source);
}
