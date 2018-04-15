# NodeApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**nodeDelete**](NodeApi.md#nodeDelete) | **DELETE** nodes/{id} | Delete a node
[**nodeInspect**](NodeApi.md#nodeInspect) | **GET** nodes/{id} | Inspect a node
[**nodeList**](NodeApi.md#nodeList) | **GET** nodes | List nodes
[**nodeUpdate**](NodeApi.md#nodeUpdate) | **POST** nodes/{id}/update | Update a node


<a name="nodeDelete"></a>
# **nodeDelete**
> Void nodeDelete(id, force)

Delete a node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NodeApi;


NodeApi apiInstance = new NodeApi();
String id = "id_example"; // String | The ID or name of the node
Boolean force = false; // Boolean | Force remove a node from the swarm
try {
    Void result = apiInstance.nodeDelete(id, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NodeApi#nodeDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID or name of the node |
 **force** | **Boolean**| Force remove a node from the swarm | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="nodeInspect"></a>
# **nodeInspect**
> Node nodeInspect(id)

Inspect a node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NodeApi;


NodeApi apiInstance = new NodeApi();
String id = "id_example"; // String | The ID or name of the node
try {
    Node result = apiInstance.nodeInspect(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NodeApi#nodeInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID or name of the node |

### Return type

[**Node**](Node.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="nodeList"></a>
# **nodeList**
> List&lt;Node&gt; nodeList(filters)

List nodes

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NodeApi;


NodeApi apiInstance = new NodeApi();
String filters = "filters_example"; // String | Filters to process on the nodes list, encoded as JSON (a `map[string][]string`).  Available filters: - `id=<node id>` - `label=<engine label>` - `membership=`(`accepted`|`pending`)` - `name=<node name>` - `role=`(`manager`|`worker`)` 
try {
    List<Node> result = apiInstance.nodeList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NodeApi#nodeList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| Filters to process on the nodes list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;id&#x3D;&lt;node id&gt;&#x60; - &#x60;label&#x3D;&lt;engine label&gt;&#x60; - &#x60;membership&#x3D;&#x60;(&#x60;accepted&#x60;|&#x60;pending&#x60;)&#x60; - &#x60;name&#x3D;&lt;node name&gt;&#x60; - &#x60;role&#x3D;&#x60;(&#x60;manager&#x60;|&#x60;worker&#x60;)&#x60;  | [optional]

### Return type

[**List&lt;Node&gt;**](Node.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="nodeUpdate"></a>
# **nodeUpdate**
> Void nodeUpdate(id, version, body)

Update a node

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NodeApi;


NodeApi apiInstance = new NodeApi();
String id = "id_example"; // String | The ID of the node
Long version = 789L; // Long | The version number of the node object being updated. This is required to avoid conflicting writes.
NodeSpec body = new NodeSpec(); // NodeSpec | 
try {
    Void result = apiInstance.nodeUpdate(id, version, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NodeApi#nodeUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID of the node |
 **version** | **Long**| The version number of the node object being updated. This is required to avoid conflicting writes. |
 **body** | [**NodeSpec**](NodeSpec.md)|  | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

