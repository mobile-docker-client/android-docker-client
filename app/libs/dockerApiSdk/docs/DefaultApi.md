# DefaultApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**taskLogs**](DefaultApi.md#taskLogs) | **GET** tasks/{id}/logs | Get task logs


<a name="taskLogs"></a>
# **taskLogs**
> String taskLogs(id, details, follow, stdout, stderr, since, timestamps, tail)

Get task logs

Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a task.  **Note**: This endpoint works only for services with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging drivers. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | ID of the task
Boolean details = false; // Boolean | Show task context and extra details provided to logs.
Boolean follow = false; // Boolean | Return the logs as a stream.  This will return a `101` HTTP response with a `Connection: upgrade` header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach). 
Boolean stdout = false; // Boolean | Return logs from `stdout`
Boolean stderr = false; // Boolean | Return logs from `stderr`
Integer since = 0; // Integer | Only return logs since this time, as a UNIX timestamp
Boolean timestamps = false; // Boolean | Add timestamps to every log line
String tail = "all"; // String | Only return this number of log lines from the end of the logs. Specify as an integer or `all` to output all log lines.
try {
    String result = apiInstance.taskLogs(id, details, follow, stdout, stderr, since, timestamps, tail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#taskLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the task |
 **details** | **Boolean**| Show task context and extra details provided to logs. | [optional] [default to false]
 **follow** | **Boolean**| Return the logs as a stream.  This will return a &#x60;101&#x60; HTTP response with a &#x60;Connection: upgrade&#x60; header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach).  | [optional] [default to false]
 **stdout** | **Boolean**| Return logs from &#x60;stdout&#x60; | [optional] [default to false]
 **stderr** | **Boolean**| Return logs from &#x60;stderr&#x60; | [optional] [default to false]
 **since** | **Integer**| Only return logs since this time, as a UNIX timestamp | [optional] [default to 0]
 **timestamps** | **Boolean**| Add timestamps to every log line | [optional] [default to false]
 **tail** | **String**| Only return this number of log lines from the end of the logs. Specify as an integer or &#x60;all&#x60; to output all log lines. | [optional] [default to all]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/vnd.docker.raw-stream, application/json

