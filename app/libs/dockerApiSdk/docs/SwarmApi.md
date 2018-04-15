# SwarmApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**swarmInit**](SwarmApi.md#swarmInit) | **POST** swarm/init | Initialize a new swarm
[**swarmInspect**](SwarmApi.md#swarmInspect) | **GET** swarm | Inspect swarm
[**swarmJoin**](SwarmApi.md#swarmJoin) | **POST** swarm/join | Join an existing swarm
[**swarmLeave**](SwarmApi.md#swarmLeave) | **POST** swarm/leave | Leave a swarm
[**swarmUnlock**](SwarmApi.md#swarmUnlock) | **POST** swarm/unlock | Unlock a locked manager
[**swarmUnlockkey**](SwarmApi.md#swarmUnlockkey) | **GET** swarm/unlockkey | Get the unlock key
[**swarmUpdate**](SwarmApi.md#swarmUpdate) | **POST** swarm/update | Update a swarm


<a name="swarmInit"></a>
# **swarmInit**
> String swarmInit(body)

Initialize a new swarm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
Body1 body = new Body1(); // Body1 | 
try {
    String result = apiInstance.swarmInit(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmInit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Body1**](Body1.md)|  |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="swarmInspect"></a>
# **swarmInspect**
> Swarm swarmInspect()

Inspect swarm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
try {
    Swarm result = apiInstance.swarmInspect();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmInspect");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Swarm**](Swarm.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="swarmJoin"></a>
# **swarmJoin**
> Void swarmJoin(body)

Join an existing swarm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
Body2 body = new Body2(); // Body2 | 
try {
    Void result = apiInstance.swarmJoin(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmJoin");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Body2**](Body2.md)|  |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="swarmLeave"></a>
# **swarmLeave**
> Void swarmLeave(force)

Leave a swarm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
Boolean force = false; // Boolean | Force leave swarm, even if this is the last manager or that it will break the cluster.
try {
    Void result = apiInstance.swarmLeave(force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmLeave");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **force** | **Boolean**| Force leave swarm, even if this is the last manager or that it will break the cluster. | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="swarmUnlock"></a>
# **swarmUnlock**
> Void swarmUnlock(body)

Unlock a locked manager

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
Body3 body = new Body3(); // Body3 | 
try {
    Void result = apiInstance.swarmUnlock(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmUnlock");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Body3**](Body3.md)|  |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="swarmUnlockkey"></a>
# **swarmUnlockkey**
> UnlockKeyResponse swarmUnlockkey()

Get the unlock key

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
try {
    UnlockKeyResponse result = apiInstance.swarmUnlockkey();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmUnlockkey");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**UnlockKeyResponse**](UnlockKeyResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="swarmUpdate"></a>
# **swarmUpdate**
> Void swarmUpdate(body, version, rotateWorkerToken, rotateManagerToken, rotateManagerUnlockKey)

Update a swarm

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SwarmApi;


SwarmApi apiInstance = new SwarmApi();
SwarmSpec body = new SwarmSpec(); // SwarmSpec | 
Long version = 789L; // Long | The version number of the swarm object being updated. This is required to avoid conflicting writes.
Boolean rotateWorkerToken = false; // Boolean | Rotate the worker join token.
Boolean rotateManagerToken = false; // Boolean | Rotate the manager join token.
Boolean rotateManagerUnlockKey = false; // Boolean | Rotate the manager unlock key.
try {
    Void result = apiInstance.swarmUpdate(body, version, rotateWorkerToken, rotateManagerToken, rotateManagerUnlockKey);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SwarmApi#swarmUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**SwarmSpec**](SwarmSpec.md)|  |
 **version** | **Long**| The version number of the swarm object being updated. This is required to avoid conflicting writes. |
 **rotateWorkerToken** | **Boolean**| Rotate the worker join token. | [optional] [default to false]
 **rotateManagerToken** | **Boolean**| Rotate the manager join token. | [optional] [default to false]
 **rotateManagerUnlockKey** | **Boolean**| Rotate the manager unlock key. | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

