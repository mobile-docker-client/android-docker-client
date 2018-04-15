# SessionExperimentalApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**session**](SessionExperimentalApi.md#session) | **POST** session | Initialize interactive session


<a name="session"></a>
# **session**
> Void session()

Initialize interactive session

Start a new interactive session with a server. Session allows server to call back to the client for advanced capabilities.  &gt; **Note**: This endpoint is *experimental* and only available if the daemon is started with experimental &gt; features enabled. The specifications for this endpoint may still change in a future version of the API.  ### Hijacking  This endpoint hijacks the HTTP connection to HTTP2 transport that allows the client to expose gPRC services on that connection.  For example, the client sends this request to upgrade the connection:  &#x60;&#x60;&#x60; POST /session HTTP/1.1 Upgrade: h2c Connection: Upgrade &#x60;&#x60;&#x60;  The Docker daemon will respond with a &#x60;101 UPGRADED&#x60; response follow with the raw stream:  &#x60;&#x60;&#x60; HTTP/1.1 101 UPGRADED Connection: Upgrade Upgrade: h2c &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SessionExperimentalApi;


SessionExperimentalApi apiInstance = new SessionExperimentalApi();
try {
    Void result = apiInstance.session();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SessionExperimentalApi#session");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/vnd.docker.raw-stream

