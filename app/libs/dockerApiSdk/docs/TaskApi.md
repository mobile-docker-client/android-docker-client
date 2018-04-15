# TaskApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**taskInspect**](TaskApi.md#taskInspect) | **GET** tasks/{id} | Inspect a task
[**taskList**](TaskApi.md#taskList) | **GET** tasks | List tasks


<a name="taskInspect"></a>
# **taskInspect**
> Task taskInspect(id)

Inspect a task

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskApi;


TaskApi apiInstance = new TaskApi();
String id = "id_example"; // String | ID of the task
try {
    Task result = apiInstance.taskInspect(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskApi#taskInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the task |

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="taskList"></a>
# **taskList**
> List&lt;Task&gt; taskList(filters)

List tasks

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TaskApi;


TaskApi apiInstance = new TaskApi();
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the tasks list. Available filters:  - `desired-state=(running | shutdown | accepted)` - `id=<task id>` - `label=key` or `label=\"key=value\"` - `name=<task name>` - `node=<node id or name>` - `service=<service name>` 
try {
    List<Task> result = apiInstance.taskList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TaskApi#taskList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the tasks list. Available filters:  - &#x60;desired-state&#x3D;(running | shutdown | accepted)&#x60; - &#x60;id&#x3D;&lt;task id&gt;&#x60; - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; - &#x60;name&#x3D;&lt;task name&gt;&#x60; - &#x60;node&#x3D;&lt;node id or name&gt;&#x60; - &#x60;service&#x3D;&lt;service name&gt;&#x60;  | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

