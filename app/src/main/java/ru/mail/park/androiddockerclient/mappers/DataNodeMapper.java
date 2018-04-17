package ru.mail.park.androiddockerclient.mappers;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.mail.park.androiddockerclient.fragments.DataNode;

public class DataNodeMapper implements IDataNodeMapper {

    private Gson gson;

    public DataNodeMapper(Gson gson) {
        this.gson = gson;
    }

    public DataNode entryToDataNode(Map.Entry<String, JsonElement> element) {
        String key = element.getKey();
        JsonElement value = element.getValue();
        return jsonElemToDataNode(key, value);

    }

    public DataNode jsonElemToDataNode(String key, JsonElement elem) {
        if (elem.isJsonPrimitive()) {
            return new DataNode(false,
                    false,
                    key,
                    elem.toString(),
                    null);
        } else if (elem.isJsonObject()) {
            return new DataNode(true,
                    false,
                    key,
                    null,
                    mapToDataNodes(elem.getAsJsonObject()));
        } else if (elem.isJsonArray()) {
            JsonArray array = elem.getAsJsonArray();
            List<DataNode> arrayNodes = new ArrayList<>();
            for (JsonElement arrayEntry : array) {
                arrayNodes.add(jsonElemToDataNode(null, arrayEntry));
            }
            return new DataNode(false,
                    false,
                    key,
                    null,
                    arrayNodes);
        } else {
            return new DataNode(false, false, null, null, null);
        }
    }

    public <V> ArrayList<DataNode> mapToDataNodes(V source, Class clazz) {
        ArrayList<DataNode> result = new ArrayList<>();
        JsonObject rawJson = gson.toJsonTree(source, clazz).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : rawJson.entrySet()) {
            result.add(entryToDataNode(entry));
        }
        return result;
    }

    public <V> List<DataNode> mapToDataNodes(V source) {

        List<DataNode> result = new ArrayList<>();
        JsonObject rawJson = gson.toJsonTree(source).getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : rawJson.entrySet()) {
            result.add(entryToDataNode(entry));
        }

        return result;
    }

}
