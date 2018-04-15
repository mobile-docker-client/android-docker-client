# ExecApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**containerExec**](ExecApi.md#containerExec) | **POST** containers/{id}/exec | Create an exec instance
[**execInspect**](ExecApi.md#execInspect) | **GET** exec/{id}/json | Inspect an exec instance
[**execResize**](ExecApi.md#execResize) | **POST** exec/{id}/resize | Resize an exec instance
[**execStart**](ExecApi.md#execStart) | **POST** exec/{id}/start | Start an exec instance


<a name="containerExec"></a>
# **containerExec**
> IdResponse containerExec(execConfig, id)

Create an exec instance

Run a command inside a running container.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExecApi;


ExecApi apiInstance = new ExecApi();
ExecConfig execConfig = new ExecConfig(); // ExecConfig | Exec configuration
String id = "id_example"; // String | ID or name of container
try {
    IdResponse result = apiInstance.containerExec(execConfig, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExecApi#containerExec");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **execConfig** | [**ExecConfig**](ExecConfig.md)| Exec configuration |
 **id** | **String**| ID or name of container |

### Return type

[**IdResponse**](IdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="execInspect"></a>
# **execInspect**
> ExecInspectResponse execInspect(id)

Inspect an exec instance

Return low-level information about an exec instance.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExecApi;


ExecApi apiInstance = new ExecApi();
String id = "id_example"; // String | Exec instance ID
try {
    ExecInspectResponse result = apiInstance.execInspect(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExecApi#execInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Exec instance ID |

### Return type

[**ExecInspectResponse**](ExecInspectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="execResize"></a>
# **execResize**
> Void execResize(id, h, w)

Resize an exec instance

Resize the TTY session used by an exec instance. This endpoint only works if &#x60;tty&#x60; was specified as part of creating and starting the exec instance.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExecApi;


ExecApi apiInstance = new ExecApi();
String id = "id_example"; // String | Exec instance ID
Integer h = 56; // Integer | Height of the TTY session in characters
Integer w = 56; // Integer | Width of the TTY session in characters
try {
    Void result = apiInstance.execResize(id, h, w);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExecApi#execResize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Exec instance ID |
 **h** | **Integer**| Height of the TTY session in characters | [optional]
 **w** | **Integer**| Width of the TTY session in characters | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="execStart"></a>
# **execStart**
> Void execStart(id, execStartConfig)

Start an exec instance

Starts a previously set up exec instance. If detach is true, this endpoint returns immediately after starting the command. Otherwise, it sets up an interactive session with the command.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ExecApi;


ExecApi apiInstance = new ExecApi();
String id = "id_example"; // String | Exec instance ID
ExecStartConfig execStartConfig = new ExecStartConfig(); // ExecStartConfig | 
try {
    Void result = apiInstance.execStart(id, execStartConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ExecApi#execStart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Exec instance ID |
 **execStartConfig** | [**ExecStartConfig**](ExecStartConfig.md)|  | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/vnd.docker.raw-stream

