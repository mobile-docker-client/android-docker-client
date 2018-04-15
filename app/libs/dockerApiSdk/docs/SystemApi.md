# SystemApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**systemAuth**](SystemApi.md#systemAuth) | **POST** auth | Check auth configuration
[**systemDataUsage**](SystemApi.md#systemDataUsage) | **GET** system/df | Get data usage information
[**systemEvents**](SystemApi.md#systemEvents) | **GET** events | Monitor events
[**systemInfo**](SystemApi.md#systemInfo) | **GET** info | Get system information
[**systemPing**](SystemApi.md#systemPing) | **GET** _ping | Ping
[**systemVersion**](SystemApi.md#systemVersion) | **GET** version | Get version


<a name="systemAuth"></a>
# **systemAuth**
> SystemAuthResponse systemAuth(authConfig)

Check auth configuration

Validate credentials for a registry and, if available, get an identity token for accessing the registry without password.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
AuthConfig authConfig = new AuthConfig(); // AuthConfig | Authentication to check
try {
    SystemAuthResponse result = apiInstance.systemAuth(authConfig);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemAuth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authConfig** | [**AuthConfig**](AuthConfig.md)| Authentication to check | [optional]

### Return type

[**SystemAuthResponse**](SystemAuthResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="systemDataUsage"></a>
# **systemDataUsage**
> SystemDataUsageResponse systemDataUsage()

Get data usage information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
try {
    SystemDataUsageResponse result = apiInstance.systemDataUsage();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemDataUsage");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SystemDataUsageResponse**](SystemDataUsageResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="systemEvents"></a>
# **systemEvents**
> SystemEventsResponse systemEvents(since, until, filters)

Monitor events

Stream real-time events from the server.  Various objects within Docker report events when something happens to them.  Containers report these events: &#x60;attach&#x60;, &#x60;commit&#x60;, &#x60;copy&#x60;, &#x60;create&#x60;, &#x60;destroy&#x60;, &#x60;detach&#x60;, &#x60;die&#x60;, &#x60;exec_create&#x60;, &#x60;exec_detach&#x60;, &#x60;exec_start&#x60;, &#x60;exec_die&#x60;, &#x60;export&#x60;, &#x60;health_status&#x60;, &#x60;kill&#x60;, &#x60;oom&#x60;, &#x60;pause&#x60;, &#x60;rename&#x60;, &#x60;resize&#x60;, &#x60;restart&#x60;, &#x60;start&#x60;, &#x60;stop&#x60;, &#x60;top&#x60;, &#x60;unpause&#x60;, and &#x60;update&#x60;  Images report these events: &#x60;delete&#x60;, &#x60;import&#x60;, &#x60;load&#x60;, &#x60;pull&#x60;, &#x60;push&#x60;, &#x60;save&#x60;, &#x60;tag&#x60;, and &#x60;untag&#x60;  Volumes report these events: &#x60;create&#x60;, &#x60;mount&#x60;, &#x60;unmount&#x60;, and &#x60;destroy&#x60;  Networks report these events: &#x60;create&#x60;, &#x60;connect&#x60;, &#x60;disconnect&#x60;, &#x60;destroy&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  The Docker daemon reports these events: &#x60;reload&#x60;  Services report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Nodes report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Secrets report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Configs report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
String since = "since_example"; // String | Show events created since this timestamp then stream new events.
String until = "until_example"; // String | Show events created until this timestamp then stop streaming.
String filters = "filters_example"; // String | A JSON encoded value of filters (a `map[string][]string`) to process on the event list. Available filters:  - `config=<string>` config name or ID - `container=<string>` container name or ID - `daemon=<string>` daemon name or ID - `event=<string>` event type - `image=<string>` image name or ID - `label=<string>` image or container label - `network=<string>` network name or ID - `node=<string>` node ID - `plugin`=<string> plugin name or ID - `scope`=<string> local or swarm - `secret=<string>` secret name or ID - `service=<string>` service name or ID - `type=<string>` object to filter by, one of `container`, `image`, `volume`, `network`, `daemon`, `plugin`, `node`, `service`, `secret` or `config` - `volume=<string>` volume name 
try {
    SystemEventsResponse result = apiInstance.systemEvents(since, until, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemEvents");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **since** | **String**| Show events created since this timestamp then stream new events. | [optional]
 **until** | **String**| Show events created until this timestamp then stop streaming. | [optional]
 **filters** | **String**| A JSON encoded value of filters (a &#x60;map[string][]string&#x60;) to process on the event list. Available filters:  - &#x60;config&#x3D;&lt;string&gt;&#x60; config name or ID - &#x60;container&#x3D;&lt;string&gt;&#x60; container name or ID - &#x60;daemon&#x3D;&lt;string&gt;&#x60; daemon name or ID - &#x60;event&#x3D;&lt;string&gt;&#x60; event type - &#x60;image&#x3D;&lt;string&gt;&#x60; image name or ID - &#x60;label&#x3D;&lt;string&gt;&#x60; image or container label - &#x60;network&#x3D;&lt;string&gt;&#x60; network name or ID - &#x60;node&#x3D;&lt;string&gt;&#x60; node ID - &#x60;plugin&#x60;&#x3D;&lt;string&gt; plugin name or ID - &#x60;scope&#x60;&#x3D;&lt;string&gt; local or swarm - &#x60;secret&#x3D;&lt;string&gt;&#x60; secret name or ID - &#x60;service&#x3D;&lt;string&gt;&#x60; service name or ID - &#x60;type&#x3D;&lt;string&gt;&#x60; object to filter by, one of &#x60;container&#x60;, &#x60;image&#x60;, &#x60;volume&#x60;, &#x60;network&#x60;, &#x60;daemon&#x60;, &#x60;plugin&#x60;, &#x60;node&#x60;, &#x60;service&#x60;, &#x60;secret&#x60; or &#x60;config&#x60; - &#x60;volume&#x3D;&lt;string&gt;&#x60; volume name  | [optional]

### Return type

[**SystemEventsResponse**](SystemEventsResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="systemInfo"></a>
# **systemInfo**
> SystemInfo systemInfo()

Get system information

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
try {
    SystemInfo result = apiInstance.systemInfo();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SystemInfo**](SystemInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="systemPing"></a>
# **systemPing**
> String systemPing()

Ping

This is a dummy endpoint you can use to test if the server is accessible.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
try {
    String result = apiInstance.systemPing();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemPing");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: text/plain

<a name="systemVersion"></a>
# **systemVersion**
> SystemVersionResponse systemVersion()

Get version

Returns the version of Docker that is running and various information about the system that Docker is running on.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SystemApi;


SystemApi apiInstance = new SystemApi();
try {
    SystemVersionResponse result = apiInstance.systemVersion();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SystemApi#systemVersion");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SystemVersionResponse**](SystemVersionResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

