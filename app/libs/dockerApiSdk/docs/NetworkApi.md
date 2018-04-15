# NetworkApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**networkConnect**](NetworkApi.md#networkConnect) | **POST** networks/{id}/connect | Connect a container to a network
[**networkCreate**](NetworkApi.md#networkCreate) | **POST** networks/create | Create a network
[**networkDelete**](NetworkApi.md#networkDelete) | **DELETE** networks/{id} | Remove a network
[**networkDisconnect**](NetworkApi.md#networkDisconnect) | **POST** networks/{id}/disconnect | Disconnect a container from a network
[**networkInspect**](NetworkApi.md#networkInspect) | **GET** networks/{id} | Inspect a network
[**networkList**](NetworkApi.md#networkList) | **GET** networks | List networks
[**networkPrune**](NetworkApi.md#networkPrune) | **POST** networks/prune | Delete unused networks


<a name="networkConnect"></a>
# **networkConnect**
> Void networkConnect(id, container)

Connect a container to a network

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String id = "id_example"; // String | Network ID or name
Container container = new Container(); // Container | 
try {
    Void result = apiInstance.networkConnect(id, container);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkConnect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Network ID or name |
 **container** | [**Container**](Container.md)|  |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="networkCreate"></a>
# **networkCreate**
> NetworkCreateResponse networkCreate(networkConfig)

Create a network

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
NetworkConfig networkConfig = new NetworkConfig(); // NetworkConfig | Network configuration
try {
    NetworkCreateResponse result = apiInstance.networkCreate(networkConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **networkConfig** | [**NetworkConfig**](NetworkConfig.md)| Network configuration |

### Return type

[**NetworkCreateResponse**](NetworkCreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="networkDelete"></a>
# **networkDelete**
> Void networkDelete(id)

Remove a network

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String id = "id_example"; // String | Network ID or name
try {
    Void result = apiInstance.networkDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Network ID or name |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="networkDisconnect"></a>
# **networkDisconnect**
> Void networkDisconnect(id, container)

Disconnect a container from a network

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String id = "id_example"; // String | Network ID or name
Container1 container = new Container1(); // Container1 | 
try {
    Void result = apiInstance.networkDisconnect(id, container);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkDisconnect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Network ID or name |
 **container** | [**Container1**](Container1.md)|  |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="networkInspect"></a>
# **networkInspect**
> Network networkInspect(id, verbose, scope)

Inspect a network

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String id = "id_example"; // String | Network ID or name
Boolean verbose = false; // Boolean | Detailed inspect output for troubleshooting
String scope = "scope_example"; // String | Filter the network by scope (swarm, global, or local)
try {
    Network result = apiInstance.networkInspect(id, verbose, scope);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Network ID or name |
 **verbose** | **Boolean**| Detailed inspect output for troubleshooting | [optional] [default to false]
 **scope** | **String**| Filter the network by scope (swarm, global, or local) | [optional]

### Return type

[**Network**](Network.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="networkList"></a>
# **networkList**
> List&lt;Network&gt; networkList(filters)

List networks

Returns a list of networks. For details on the format, see [the network inspect endpoint](#operation/NetworkInspect).  Note that it uses a different, smaller representation of a network than inspecting a single network. For example, the list of containers attached to the network is not propagated in API versions 1.28 and up. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String filters = "filters_example"; // String | JSON encoded value of the filters (a `map[string][]string`) to process on the networks list. Available filters:  - `driver=<driver-name>` Matches a network's driver. - `id=<network-id>` Matches all or part of a network ID. - `label=<key>` or `label=<key>=<value>` of a network label. - `name=<network-name>` Matches all or part of a network name. - `scope=[\"swarm\"|\"global\"|\"local\"]` Filters networks by scope (`swarm`, `global`, or `local`). - `type=[\"custom\"|\"builtin\"]` Filters networks by type. The `custom` keyword returns all user-defined networks. 
try {
    List<Network> result = apiInstance.networkList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the networks list. Available filters:  - &#x60;driver&#x3D;&lt;driver-name&gt;&#x60; Matches a network&#39;s driver. - &#x60;id&#x3D;&lt;network-id&gt;&#x60; Matches all or part of a network ID. - &#x60;label&#x3D;&lt;key&gt;&#x60; or &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60; of a network label. - &#x60;name&#x3D;&lt;network-name&gt;&#x60; Matches all or part of a network name. - &#x60;scope&#x3D;[\&quot;swarm\&quot;|\&quot;global\&quot;|\&quot;local\&quot;]&#x60; Filters networks by scope (&#x60;swarm&#x60;, &#x60;global&#x60;, or &#x60;local&#x60;). - &#x60;type&#x3D;[\&quot;custom\&quot;|\&quot;builtin\&quot;]&#x60; Filters networks by type. The &#x60;custom&#x60; keyword returns all user-defined networks.  | [optional]

### Return type

[**List&lt;Network&gt;**](Network.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="networkPrune"></a>
# **networkPrune**
> NetworkPruneResponse networkPrune(filters)

Delete unused networks

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.NetworkApi;


NetworkApi apiInstance = new NetworkApi();
String filters = "filters_example"; // String | Filters to process on the prune list, encoded as JSON (a `map[string][]string`).  Available filters: - `until=<timestamp>` Prune networks created before this timestamp. The `<timestamp>` can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. `10m`, `1h30m`) computed relative to the daemon machine’s time. - `label` (`label=<key>`, `label=<key>=<value>`, `label!=<key>`, or `label!=<key>=<value>`) Prune networks with (or without, in case `label!=...` is used) the specified labels. 
try {
    NetworkPruneResponse result = apiInstance.networkPrune(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NetworkApi#networkPrune");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;until&#x3D;&lt;timestamp&gt;&#x60; Prune networks created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune networks with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  | [optional]

### Return type

[**NetworkPruneResponse**](NetworkPruneResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

