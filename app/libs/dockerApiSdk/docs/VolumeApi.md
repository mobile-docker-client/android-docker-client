# VolumeApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**volumeCreate**](VolumeApi.md#volumeCreate) | **POST** volumes/create | Create a volume
[**volumeDelete**](VolumeApi.md#volumeDelete) | **DELETE** volumes/{name} | Remove a volume
[**volumeInspect**](VolumeApi.md#volumeInspect) | **GET** volumes/{name} | Inspect a volume
[**volumeList**](VolumeApi.md#volumeList) | **GET** volumes | List volumes
[**volumePrune**](VolumeApi.md#volumePrune) | **POST** volumes/prune | Delete unused volumes


<a name="volumeCreate"></a>
# **volumeCreate**
> Volume volumeCreate(volumeConfig)

Create a volume

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VolumeApi;


VolumeApi apiInstance = new VolumeApi();
VolumeConfig volumeConfig = new VolumeConfig(); // VolumeConfig | Volume configuration
try {
    Volume result = apiInstance.volumeCreate(volumeConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VolumeApi#volumeCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **volumeConfig** | [**VolumeConfig**](VolumeConfig.md)| Volume configuration |

### Return type

[**Volume**](Volume.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="volumeDelete"></a>
# **volumeDelete**
> Void volumeDelete(name, force)

Remove a volume

Instruct the driver to remove the volume.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VolumeApi;


VolumeApi apiInstance = new VolumeApi();
String name = "name_example"; // String | Volume name or ID
Boolean force = false; // Boolean | Force the removal of the volume
try {
    Void result = apiInstance.volumeDelete(name, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VolumeApi#volumeDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Volume name or ID |
 **force** | **Boolean**| Force the removal of the volume | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="volumeInspect"></a>
# **volumeInspect**
> Volume volumeInspect(name)

Inspect a volume

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VolumeApi;


VolumeApi apiInstance = new VolumeApi();
String name = "name_example"; // String | Volume name or ID
try {
    Volume result = apiInstance.volumeInspect(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VolumeApi#volumeInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Volume name or ID |

### Return type

[**Volume**](Volume.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="volumeList"></a>
# **volumeList**
> VolumeListResponse volumeList(filters)

List volumes

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VolumeApi;


VolumeApi apiInstance = new VolumeApi();
String filters = "filters_example"; // String | JSON encoded value of the filters (a `map[string][]string`) to process on the volumes list. Available filters:  - `dangling=<boolean>` When set to `true` (or `1`), returns all    volumes that are not in use by a container. When set to `false`    (or `0`), only volumes that are in use by one or more    containers are returned. - `driver=<volume-driver-name>` Matches volumes based on their driver. - `label=<key>` or `label=<key>:<value>` Matches volumes based on    the presence of a `label` alone or a `label` and a value. - `name=<volume-name>` Matches all or part of a volume name. 
try {
    VolumeListResponse result = apiInstance.volumeList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VolumeApi#volumeList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the volumes list. Available filters:  - &#x60;dangling&#x3D;&lt;boolean&gt;&#x60; When set to &#x60;true&#x60; (or &#x60;1&#x60;), returns all    volumes that are not in use by a container. When set to &#x60;false&#x60;    (or &#x60;0&#x60;), only volumes that are in use by one or more    containers are returned. - &#x60;driver&#x3D;&lt;volume-driver-name&gt;&#x60; Matches volumes based on their driver. - &#x60;label&#x3D;&lt;key&gt;&#x60; or &#x60;label&#x3D;&lt;key&gt;:&lt;value&gt;&#x60; Matches volumes based on    the presence of a &#x60;label&#x60; alone or a &#x60;label&#x60; and a value. - &#x60;name&#x3D;&lt;volume-name&gt;&#x60; Matches all or part of a volume name.  | [optional]

### Return type

[**VolumeListResponse**](VolumeListResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="volumePrune"></a>
# **volumePrune**
> VolumePruneResponse volumePrune(filters)

Delete unused volumes

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.VolumeApi;


VolumeApi apiInstance = new VolumeApi();
String filters = "filters_example"; // String | Filters to process on the prune list, encoded as JSON (a `map[string][]string`).  Available filters: - `label` (`label=<key>`, `label=<key>=<value>`, `label!=<key>`, or `label!=<key>=<value>`) Prune volumes with (or without, in case `label!=...` is used) the specified labels. 
try {
    VolumePruneResponse result = apiInstance.volumePrune(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling VolumeApi#volumePrune");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune volumes with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  | [optional]

### Return type

[**VolumePruneResponse**](VolumePruneResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

