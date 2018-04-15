# ConfigApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**configCreate**](ConfigApi.md#configCreate) | **POST** configs/create | Create a config
[**configDelete**](ConfigApi.md#configDelete) | **DELETE** configs/{id} | Delete a config
[**configInspect**](ConfigApi.md#configInspect) | **GET** configs/{id} | Inspect a config
[**configList**](ConfigApi.md#configList) | **GET** configs | List configs
[**configUpdate**](ConfigApi.md#configUpdate) | **POST** configs/{id}/update | Update a Config


<a name="configCreate"></a>
# **configCreate**
> IdResponse configCreate(body)

Create a config

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
 body = new null(); //  | 
try {
    IdResponse result = apiInstance.configCreate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [****](.md)|  | [optional]

### Return type

[**IdResponse**](IdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="configDelete"></a>
# **configDelete**
> Void configDelete(id)

Delete a config

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
String id = "id_example"; // String | ID of the config
try {
    Void result = apiInstance.configDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the config |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="configInspect"></a>
# **configInspect**
> Config configInspect(id)

Inspect a config

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
String id = "id_example"; // String | ID of the config
try {
    Config result = apiInstance.configInspect(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the config |

### Return type

[**Config**](Config.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="configList"></a>
# **configList**
> List&lt;Config&gt; configList(filters)

List configs

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the configs list. Available filters:  - `id=<config id>` - `label=<key> or label=<key>=value` - `name=<config name>` - `names=<config name>` 
try {
    List<Config> result = apiInstance.configList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the configs list. Available filters:  - &#x60;id&#x3D;&lt;config id&gt;&#x60; - &#x60;label&#x3D;&lt;key&gt; or label&#x3D;&lt;key&gt;&#x3D;value&#x60; - &#x60;name&#x3D;&lt;config name&gt;&#x60; - &#x60;names&#x3D;&lt;config name&gt;&#x60;  | [optional]

### Return type

[**List&lt;Config&gt;**](Config.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="configUpdate"></a>
# **configUpdate**
> Void configUpdate(id, version, body)

Update a Config

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ConfigApi;


ConfigApi apiInstance = new ConfigApi();
String id = "id_example"; // String | The ID or name of the config
Long version = 789L; // Long | The version number of the config object being updated. This is required to avoid conflicting writes.
ConfigSpec body = new ConfigSpec(); // ConfigSpec | The spec of the config to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [ConfigInspect endpoint](#operation/ConfigInspect) response values.
try {
    Void result = apiInstance.configUpdate(id, version, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ConfigApi#configUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID or name of the config |
 **version** | **Long**| The version number of the config object being updated. This is required to avoid conflicting writes. |
 **body** | [**ConfigSpec**](ConfigSpec.md)| The spec of the config to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [ConfigInspect endpoint](#operation/ConfigInspect) response values. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

