# ContainerApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**containerArchive**](ContainerApi.md#containerArchive) | **GET** containers/{id}/archive | Get an archive of a filesystem resource in a container
[**containerArchiveInfo**](ContainerApi.md#containerArchiveInfo) | **HEAD** containers/{id}/archive | Get information about files in a container
[**containerAttach**](ContainerApi.md#containerAttach) | **POST** containers/{id}/attach | Attach to a container
[**containerAttachWebsocket**](ContainerApi.md#containerAttachWebsocket) | **GET** containers/{id}/attach/ws | Attach to a container via a websocket
[**containerChanges**](ContainerApi.md#containerChanges) | **GET** containers/{id}/changes | Get changes on a container’s filesystem
[**containerCreate**](ContainerApi.md#containerCreate) | **POST** containers/create | Create a container
[**containerDelete**](ContainerApi.md#containerDelete) | **DELETE** containers/{id} | Remove a container
[**containerExport**](ContainerApi.md#containerExport) | **GET** containers/{id}/export | Export a container
[**containerInspect**](ContainerApi.md#containerInspect) | **GET** containers/{id}/json | Inspect a container
[**containerKill**](ContainerApi.md#containerKill) | **POST** containers/{id}/kill | Kill a container
[**containerList**](ContainerApi.md#containerList) | **GET** containers/json | List containers
[**containerLogs**](ContainerApi.md#containerLogs) | **GET** containers/{id}/logs | Get container logs
[**containerPause**](ContainerApi.md#containerPause) | **POST** containers/{id}/pause | Pause a container
[**containerPrune**](ContainerApi.md#containerPrune) | **POST** containers/prune | Delete stopped containers
[**containerRename**](ContainerApi.md#containerRename) | **POST** containers/{id}/rename | Rename a container
[**containerResize**](ContainerApi.md#containerResize) | **POST** containers/{id}/resize | Resize a container TTY
[**containerRestart**](ContainerApi.md#containerRestart) | **POST** containers/{id}/restart | Restart a container
[**containerStart**](ContainerApi.md#containerStart) | **POST** containers/{id}/start | Start a container
[**containerStats**](ContainerApi.md#containerStats) | **GET** containers/{id}/stats | Get container stats based on resource usage
[**containerStop**](ContainerApi.md#containerStop) | **POST** containers/{id}/stop | Stop a container
[**containerTop**](ContainerApi.md#containerTop) | **GET** containers/{id}/top | List processes running inside a container
[**containerUnpause**](ContainerApi.md#containerUnpause) | **POST** containers/{id}/unpause | Unpause a container
[**containerUpdate**](ContainerApi.md#containerUpdate) | **POST** containers/{id}/update | Update a container
[**containerWait**](ContainerApi.md#containerWait) | **POST** containers/{id}/wait | Wait for a container
[**putContainerArchive**](ContainerApi.md#putContainerArchive) | **PUT** containers/{id}/archive | Extract an archive of files or folders to a directory in a container


<a name="containerArchive"></a>
# **containerArchive**
> Void containerArchive(id, path)

Get an archive of a filesystem resource in a container

Get a tar archive of a resource in the filesystem of container id.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String path = "path_example"; // String | Resource in the container’s filesystem to archive.
try {
    Void result = apiInstance.containerArchive(id, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerArchive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **path** | **String**| Resource in the container’s filesystem to archive. |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/x-tar

<a name="containerArchiveInfo"></a>
# **containerArchiveInfo**
> Void containerArchiveInfo(id, path)

Get information about files in a container

A response header &#x60;X-Docker-Container-Path-Stat&#x60; is return containing a base64 - encoded JSON object with some filesystem header information about the path.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String path = "path_example"; // String | Resource in the container’s filesystem to archive.
try {
    Void result = apiInstance.containerArchiveInfo(id, path);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerArchiveInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **path** | **String**| Resource in the container’s filesystem to archive. |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerAttach"></a>
# **containerAttach**
> Void containerAttach(id, detachKeys, logs, stream, stdin, stdout, stderr)

Attach to a container

Attach to a container to read its output or send it input. You can attach to the same container multiple times and you can reattach to containers that have been detached.  Either the &#x60;stream&#x60; or &#x60;logs&#x60; parameter must be &#x60;true&#x60; for this endpoint to do anything.  See [the documentation for the &#x60;docker attach&#x60; command](https://docs.docker.com/engine/reference/commandline/attach/) for more details.  ### Hijacking  This endpoint hijacks the HTTP connection to transport &#x60;stdin&#x60;, &#x60;stdout&#x60;, and &#x60;stderr&#x60; on the same socket.  This is the response from the daemon for an attach request:  &#x60;&#x60;&#x60; HTTP/1.1 200 OK Content-Type: application/vnd.docker.raw-stream  [STREAM] &#x60;&#x60;&#x60;  After the headers and two new lines, the TCP connection can now be used for raw, bidirectional communication between the client and server.  To hint potential proxies about connection hijacking, the Docker client can also optionally send connection upgrade headers.  For example, the client sends this request to upgrade the connection:  &#x60;&#x60;&#x60; POST /containers/16253994b7c4/attach?stream&#x3D;1&amp;stdout&#x3D;1 HTTP/1.1 Upgrade: tcp Connection: Upgrade &#x60;&#x60;&#x60;  The Docker daemon will respond with a &#x60;101 UPGRADED&#x60; response, and will similarly follow with the raw stream:  &#x60;&#x60;&#x60; HTTP/1.1 101 UPGRADED Content-Type: application/vnd.docker.raw-stream Connection: Upgrade Upgrade: tcp  [STREAM] &#x60;&#x60;&#x60;  ### Stream format  When the TTY setting is disabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream over the hijacked connected is multiplexed to separate out &#x60;stdout&#x60; and &#x60;stderr&#x60;. The stream consists of a series of frames, each containing a header and a payload.  The header contains the information which the stream writes (&#x60;stdout&#x60; or &#x60;stderr&#x60;). It also contains the size of the associated frame encoded in the last four bytes (&#x60;uint32&#x60;).  It is encoded on the first eight bytes like this:  &#x60;&#x60;&#x60;go header :&#x3D; [8]byte{STREAM_TYPE, 0, 0, 0, SIZE1, SIZE2, SIZE3, SIZE4} &#x60;&#x60;&#x60;  &#x60;STREAM_TYPE&#x60; can be:  - 0: &#x60;stdin&#x60; (is written on &#x60;stdout&#x60;) - 1: &#x60;stdout&#x60; - 2: &#x60;stderr&#x60;  &#x60;SIZE1, SIZE2, SIZE3, SIZE4&#x60; are the four bytes of the &#x60;uint32&#x60; size encoded as big endian.  Following the header is the payload, which is the specified number of bytes of &#x60;STREAM_TYPE&#x60;.  The simplest way to implement this protocol is the following:  1. Read 8 bytes. 2. Choose &#x60;stdout&#x60; or &#x60;stderr&#x60; depending on the first byte. 3. Extract the frame size from the last four bytes. 4. Read the extracted size and output it on the correct output. 5. Goto 1.  ### Stream format when using a TTY  When the TTY setting is enabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream is not multiplexed. The data exchanged over the hijacked connection is simply the raw data from the process PTY and client&#39;s &#x60;stdin&#x60;. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String detachKeys = "detachKeys_example"; // String | Override the key sequence for detaching a container.Format is a single character `[a-Z]` or `ctrl-<value>` where `<value>` is one of: `a-z`, `@`, `^`, `[`, `,` or `_`.
Boolean logs = false; // Boolean | Replay previous logs from the container.  This is useful for attaching to a container that has started and you want to output everything since the container started.  If `stream` is also enabled, once all the previous output has been returned, it will seamlessly transition into streaming current output. 
Boolean stream = false; // Boolean | Stream attached streams from the time the request was made onwards
Boolean stdin = false; // Boolean | Attach to `stdin`
Boolean stdout = false; // Boolean | Attach to `stdout`
Boolean stderr = false; // Boolean | Attach to `stderr`
try {
    Void result = apiInstance.containerAttach(id, detachKeys, logs, stream, stdin, stdout, stderr);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerAttach");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **detachKeys** | **String**| Override the key sequence for detaching a container.Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60; or &#x60;_&#x60;. | [optional]
 **logs** | **Boolean**| Replay previous logs from the container.  This is useful for attaching to a container that has started and you want to output everything since the container started.  If &#x60;stream&#x60; is also enabled, once all the previous output has been returned, it will seamlessly transition into streaming current output.  | [optional] [default to false]
 **stream** | **Boolean**| Stream attached streams from the time the request was made onwards | [optional] [default to false]
 **stdin** | **Boolean**| Attach to &#x60;stdin&#x60; | [optional] [default to false]
 **stdout** | **Boolean**| Attach to &#x60;stdout&#x60; | [optional] [default to false]
 **stderr** | **Boolean**| Attach to &#x60;stderr&#x60; | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/vnd.docker.raw-stream

<a name="containerAttachWebsocket"></a>
# **containerAttachWebsocket**
> Void containerAttachWebsocket(id, detachKeys, logs, stream, stdin, stdout, stderr)

Attach to a container via a websocket

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String detachKeys = "detachKeys_example"; // String | Override the key sequence for detaching a container.Format is a single character `[a-Z]` or `ctrl-<value>` where `<value>` is one of: `a-z`, `@`, `^`, `[`, `,`, or `_`.
Boolean logs = false; // Boolean | Return logs
Boolean stream = false; // Boolean | Return stream
Boolean stdin = false; // Boolean | Attach to `stdin`
Boolean stdout = false; // Boolean | Attach to `stdout`
Boolean stderr = false; // Boolean | Attach to `stderr`
try {
    Void result = apiInstance.containerAttachWebsocket(id, detachKeys, logs, stream, stdin, stdout, stderr);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerAttachWebsocket");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **detachKeys** | **String**| Override the key sequence for detaching a container.Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60;, or &#x60;_&#x60;. | [optional]
 **logs** | **Boolean**| Return logs | [optional] [default to false]
 **stream** | **Boolean**| Return stream | [optional] [default to false]
 **stdin** | **Boolean**| Attach to &#x60;stdin&#x60; | [optional] [default to false]
 **stdout** | **Boolean**| Attach to &#x60;stdout&#x60; | [optional] [default to false]
 **stderr** | **Boolean**| Attach to &#x60;stderr&#x60; | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerChanges"></a>
# **containerChanges**
> List&lt;ContainerChangeResponseItem&gt; containerChanges(id)

Get changes on a container’s filesystem

Returns which files in a container&#39;s filesystem have been added, deleted, or modified. The &#x60;Kind&#x60; of modification can be one of:  - &#x60;0&#x60;: Modified - &#x60;1&#x60;: Added - &#x60;2&#x60;: Deleted 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
try {
    List<ContainerChangeResponseItem> result = apiInstance.containerChanges(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerChanges");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |

### Return type

[**List&lt;ContainerChangeResponseItem&gt;**](ContainerChangeResponseItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="containerCreate"></a>
# **containerCreate**
> ContainerCreateResponse containerCreate(body, name)

Create a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
ContainerInspectConfig body = new ContainerInspectConfig(); // ContainerInspectConfig | Container to create
String name = "name_example"; // String | Assign the specified name to the container. Must match `/?[a-zA-Z0-9_-]+`.
try {
    ContainerCreateResponse result = apiInstance.containerCreate(body, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ContainerInspectConfig**](ContainerInspectConfig.md)| Container to create |
 **name** | **String**| Assign the specified name to the container. Must match &#x60;/?[a-zA-Z0-9_-]+&#x60;. | [optional]

### Return type

[**ContainerCreateResponse**](ContainerCreateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/octet-stream
 - **Accept**: application/json

<a name="containerDelete"></a>
# **containerDelete**
> Void containerDelete(id, v, force, link)

Remove a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Boolean v = false; // Boolean | Remove the volumes associated with the container.
Boolean force = false; // Boolean | If the container is running, kill it before removing it.
Boolean link = false; // Boolean | Remove the specified link associated with the container.
try {
    Void result = apiInstance.containerDelete(id, v, force, link);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **v** | **Boolean**| Remove the volumes associated with the container. | [optional] [default to false]
 **force** | **Boolean**| If the container is running, kill it before removing it. | [optional] [default to false]
 **link** | **Boolean**| Remove the specified link associated with the container. | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerExport"></a>
# **containerExport**
> Void containerExport(id)

Export a container

Export the contents of a container as a tarball.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
try {
    Void result = apiInstance.containerExport(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerExport");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/octet-stream

<a name="containerInspect"></a>
# **containerInspect**
> ContainerInspectResponse containerInspect(id, size)

Inspect a container

Return low-level information about a container.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Boolean size = false; // Boolean | Return the size of container as fields `SizeRw` and `SizeRootFs`
try {
    ContainerInspectResponse result = apiInstance.containerInspect(id, size);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **size** | **Boolean**| Return the size of container as fields &#x60;SizeRw&#x60; and &#x60;SizeRootFs&#x60; | [optional] [default to false]

### Return type

[**ContainerInspectResponse**](ContainerInspectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="containerKill"></a>
# **containerKill**
> Void containerKill(id, signal)

Kill a container

Send a POSIX signal to a container, defaulting to killing to the container.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String signal = "SIGKILL"; // String | Signal to send to the container as an integer or string (e.g. `SIGINT`)
try {
    Void result = apiInstance.containerKill(id, signal);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerKill");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **signal** | **String**| Signal to send to the container as an integer or string (e.g. &#x60;SIGINT&#x60;) | [optional] [default to SIGKILL]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerList"></a>
# **containerList**
> ContainerSummary containerList(all, limit, size, filters)

List containers

Returns a list of containers. For details on the format, see [the inspect endpoint](#operation/ContainerInspect).  Note that it uses a different, smaller representation of a container than inspecting a single container. For example, the list of linked containers is not propagated . 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
Boolean all = false; // Boolean | Return all containers. By default, only running containers are shown
Integer limit = 56; // Integer | Return this number of most recently created containers, including non-running ones.
Boolean size = false; // Boolean | Return the size of container as fields `SizeRw` and `SizeRootFs`.
String filters = "filters_example"; // String | Filters to process on the container list, encoded as JSON (a `map[string][]string`). For example, `{\"status\": [\"paused\"]}` will only return paused containers. Available filters:  - `ancestor`=(`<image-name>[:<tag>]`, `<image id>`, or `<image@digest>`) - `before`=(`<container id>` or `<container name>`) - `expose`=(`<port>[/<proto>]`|`<startport-endport>/[<proto>]`) - `exited=<int>` containers with exit code of `<int>` - `health`=(`starting`|`healthy`|`unhealthy`|`none`) - `id=<ID>` a container's ID - `isolation=`(`default`|`process`|`hyperv`) (Windows daemon only) - `is-task=`(`true`|`false`) - `label=key` or `label=\"key=value\"` of a container label - `name=<name>` a container's name - `network`=(`<network id>` or `<network name>`) - `publish`=(`<port>[/<proto>]`|`<startport-endport>/[<proto>]`) - `since`=(`<container id>` or `<container name>`) - `status=`(`created`|`restarting`|`running`|`removing`|`paused`|`exited`|`dead`) - `volume`=(`<volume name>` or `<mount point destination>`) 
try {
    ContainerSummary result = apiInstance.containerList(all, limit, size, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **all** | **Boolean**| Return all containers. By default, only running containers are shown | [optional] [default to false]
 **limit** | **Integer**| Return this number of most recently created containers, including non-running ones. | [optional]
 **size** | **Boolean**| Return the size of container as fields &#x60;SizeRw&#x60; and &#x60;SizeRootFs&#x60;. | [optional] [default to false]
 **filters** | **String**| Filters to process on the container list, encoded as JSON (a &#x60;map[string][]string&#x60;). For example, &#x60;{\&quot;status\&quot;: [\&quot;paused\&quot;]}&#x60; will only return paused containers. Available filters:  - &#x60;ancestor&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;, &#x60;&lt;image id&gt;&#x60;, or &#x60;&lt;image@digest&gt;&#x60;) - &#x60;before&#x60;&#x3D;(&#x60;&lt;container id&gt;&#x60; or &#x60;&lt;container name&gt;&#x60;) - &#x60;expose&#x60;&#x3D;(&#x60;&lt;port&gt;[/&lt;proto&gt;]&#x60;|&#x60;&lt;startport-endport&gt;/[&lt;proto&gt;]&#x60;) - &#x60;exited&#x3D;&lt;int&gt;&#x60; containers with exit code of &#x60;&lt;int&gt;&#x60; - &#x60;health&#x60;&#x3D;(&#x60;starting&#x60;|&#x60;healthy&#x60;|&#x60;unhealthy&#x60;|&#x60;none&#x60;) - &#x60;id&#x3D;&lt;ID&gt;&#x60; a container&#39;s ID - &#x60;isolation&#x3D;&#x60;(&#x60;default&#x60;|&#x60;process&#x60;|&#x60;hyperv&#x60;) (Windows daemon only) - &#x60;is-task&#x3D;&#x60;(&#x60;true&#x60;|&#x60;false&#x60;) - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; of a container label - &#x60;name&#x3D;&lt;name&gt;&#x60; a container&#39;s name - &#x60;network&#x60;&#x3D;(&#x60;&lt;network id&gt;&#x60; or &#x60;&lt;network name&gt;&#x60;) - &#x60;publish&#x60;&#x3D;(&#x60;&lt;port&gt;[/&lt;proto&gt;]&#x60;|&#x60;&lt;startport-endport&gt;/[&lt;proto&gt;]&#x60;) - &#x60;since&#x60;&#x3D;(&#x60;&lt;container id&gt;&#x60; or &#x60;&lt;container name&gt;&#x60;) - &#x60;status&#x3D;&#x60;(&#x60;created&#x60;|&#x60;restarting&#x60;|&#x60;running&#x60;|&#x60;removing&#x60;|&#x60;paused&#x60;|&#x60;exited&#x60;|&#x60;dead&#x60;) - &#x60;volume&#x60;&#x3D;(&#x60;&lt;volume name&gt;&#x60; or &#x60;&lt;mount point destination&gt;&#x60;)  | [optional]

### Return type

[**ContainerSummary**](ContainerSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="containerLogs"></a>
# **containerLogs**
> String containerLogs(id, follow, stdout, stderr, since, until, timestamps, tail)

Get container logs

Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a container.  Note: This endpoint works only for containers with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging driver. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Boolean follow = false; // Boolean | Return the logs as a stream.  This will return a `101` HTTP response with a `Connection: upgrade` header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach). 
Boolean stdout = false; // Boolean | Return logs from `stdout`
Boolean stderr = false; // Boolean | Return logs from `stderr`
Integer since = 0; // Integer | Only return logs since this time, as a UNIX timestamp
Integer until = 0; // Integer | Only return logs before this time, as a UNIX timestamp
Boolean timestamps = false; // Boolean | Add timestamps to every log line
String tail = "all"; // String | Only return this number of log lines from the end of the logs. Specify as an integer or `all` to output all log lines.
try {
    String result = apiInstance.containerLogs(id, follow, stdout, stderr, since, until, timestamps, tail);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerLogs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **follow** | **Boolean**| Return the logs as a stream.  This will return a &#x60;101&#x60; HTTP response with a &#x60;Connection: upgrade&#x60; header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach).  | [optional] [default to false]
 **stdout** | **Boolean**| Return logs from &#x60;stdout&#x60; | [optional] [default to false]
 **stderr** | **Boolean**| Return logs from &#x60;stderr&#x60; | [optional] [default to false]
 **since** | **Integer**| Only return logs since this time, as a UNIX timestamp | [optional] [default to 0]
 **until** | **Integer**| Only return logs before this time, as a UNIX timestamp | [optional] [default to 0]
 **timestamps** | **Boolean**| Add timestamps to every log line | [optional] [default to false]
 **tail** | **String**| Only return this number of log lines from the end of the logs. Specify as an integer or &#x60;all&#x60; to output all log lines. | [optional] [default to all]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerPause"></a>
# **containerPause**
> Void containerPause(id)

Pause a container

Use the cgroups freezer to suspend all processes in a container.  Traditionally, when suspending a process the &#x60;SIGSTOP&#x60; signal is used, which is observable by the process being suspended. With the cgroups freezer the process is unaware, and unable to capture, that it is being suspended, and subsequently resumed. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
try {
    Void result = apiInstance.containerPause(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerPause");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerPrune"></a>
# **containerPrune**
> ContainerPruneResponse containerPrune(filters)

Delete stopped containers

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String filters = "filters_example"; // String | Filters to process on the prune list, encoded as JSON (a `map[string][]string`).  Available filters: - `until=<timestamp>` Prune containers created before this timestamp. The `<timestamp>` can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. `10m`, `1h30m`) computed relative to the daemon machine’s time. - `label` (`label=<key>`, `label=<key>=<value>`, `label!=<key>`, or `label!=<key>=<value>`) Prune containers with (or without, in case `label!=...` is used) the specified labels. 
try {
    ContainerPruneResponse result = apiInstance.containerPrune(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerPrune");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;until&#x3D;&lt;timestamp&gt;&#x60; Prune containers created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune containers with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  | [optional]

### Return type

[**ContainerPruneResponse**](ContainerPruneResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="containerRename"></a>
# **containerRename**
> Void containerRename(id, name)

Rename a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String name = "name_example"; // String | New name for the container
try {
    Void result = apiInstance.containerRename(id, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerRename");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **name** | **String**| New name for the container |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerResize"></a>
# **containerResize**
> Void containerResize(id, h, w)

Resize a container TTY

Resize the TTY for a container. You must restart the container for the resize to take effect.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Integer h = 56; // Integer | Height of the tty session in characters
Integer w = 56; // Integer | Width of the tty session in characters
try {
    Void result = apiInstance.containerResize(id, h, w);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerResize");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **h** | **Integer**| Height of the tty session in characters | [optional]
 **w** | **Integer**| Width of the tty session in characters | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: text/plain

<a name="containerRestart"></a>
# **containerRestart**
> Void containerRestart(id, t)

Restart a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Integer t = 56; // Integer | Number of seconds to wait before killing the container
try {
    Void result = apiInstance.containerRestart(id, t);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerRestart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **t** | **Integer**| Number of seconds to wait before killing the container | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerStart"></a>
# **containerStart**
> Void containerStart(id, detachKeys)

Start a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String detachKeys = "detachKeys_example"; // String | Override the key sequence for detaching a container. Format is a single character `[a-Z]` or `ctrl-<value>` where `<value>` is one of: `a-z`, `@`, `^`, `[`, `,` or `_`.
try {
    Void result = apiInstance.containerStart(id, detachKeys);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerStart");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **detachKeys** | **String**| Override the key sequence for detaching a container. Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60; or &#x60;_&#x60;. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerStats"></a>
# **containerStats**
> Object containerStats(id, stream)

Get container stats based on resource usage

This endpoint returns a live stream of a container’s resource usage statistics.  The &#x60;precpu_stats&#x60; is the CPU statistic of last read, which is used for calculating the CPU usage percentage. It is not the same as the &#x60;cpu_stats&#x60; field.  If either &#x60;precpu_stats.online_cpus&#x60; or &#x60;cpu_stats.online_cpus&#x60; is nil then for compatibility with older daemons the length of the corresponding &#x60;cpu_usage.percpu_usage&#x60; array should be used. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Boolean stream = true; // Boolean | Stream the output. If false, the stats will be output once and then it will disconnect.
try {
    Object result = apiInstance.containerStats(id, stream);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerStats");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **stream** | **Boolean**| Stream the output. If false, the stats will be output once and then it will disconnect. | [optional] [default to true]

### Return type

**Object**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="containerStop"></a>
# **containerStop**
> Void containerStop(id, t)

Stop a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
Integer t = 56; // Integer | Number of seconds to wait before killing the container
try {
    Void result = apiInstance.containerStop(id, t);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerStop");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **t** | **Integer**| Number of seconds to wait before killing the container | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerTop"></a>
# **containerTop**
> ContainerTopResponse containerTop(id, psArgs)

List processes running inside a container

On Unix systems, this is done by running the &#x60;ps&#x60; command. This endpoint is not supported on Windows.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String psArgs = "-ef"; // String | The arguments to pass to `ps`. For example, `aux`
try {
    ContainerTopResponse result = apiInstance.containerTop(id, psArgs);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerTop");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **psArgs** | **String**| The arguments to pass to &#x60;ps&#x60;. For example, &#x60;aux&#x60; | [optional] [default to -ef]

### Return type

[**ContainerTopResponse**](ContainerTopResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerUnpause"></a>
# **containerUnpause**
> Void containerUnpause(id)

Unpause a container

Resume a container which has been paused.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
try {
    Void result = apiInstance.containerUnpause(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerUnpause");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="containerUpdate"></a>
# **containerUpdate**
> ContainerUpdateResponse containerUpdate(id, update)

Update a container

Change various configuration options of a container without having to recreate it.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
ContainerUpdateConfig update = new ContainerUpdateConfig(); // ContainerUpdateConfig | 
try {
    ContainerUpdateResponse result = apiInstance.containerUpdate(id, update);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **update** | [**ContainerUpdateConfig**](ContainerUpdateConfig.md)|  |

### Return type

[**ContainerUpdateResponse**](ContainerUpdateResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="containerWait"></a>
# **containerWait**
> ContainerWaitResponse containerWait(id, condition)

Wait for a container

Block until a container stops, then returns the exit code.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String condition = "not-running"; // String | Wait until a container state reaches the given condition, either 'not-running' (default), 'next-exit', or 'removed'.
try {
    ContainerWaitResponse result = apiInstance.containerWait(id, condition);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#containerWait");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **condition** | **String**| Wait until a container state reaches the given condition, either &#39;not-running&#39; (default), &#39;next-exit&#39;, or &#39;removed&#39;. | [optional] [default to not-running]

### Return type

[**ContainerWaitResponse**](ContainerWaitResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="putContainerArchive"></a>
# **putContainerArchive**
> Void putContainerArchive(id, path, inputStream, noOverwriteDirNonDir)

Extract an archive of files or folders to a directory in a container

Upload a tar archive to be extracted to a path in the filesystem of container id.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ContainerApi;


ContainerApi apiInstance = new ContainerApi();
String id = "id_example"; // String | ID or name of the container
String path = "path_example"; // String | Path to a directory in the container to extract the archive’s contents into. 
String inputStream = "inputStream_example"; // String | The input stream must be a tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz.
String noOverwriteDirNonDir = "noOverwriteDirNonDir_example"; // String | If “1”, “true”, or “True” then it will be an error if unpacking the given content would cause an existing directory to be replaced with a non-directory and vice versa.
try {
    Void result = apiInstance.putContainerArchive(id, path, inputStream, noOverwriteDirNonDir);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainerApi#putContainerArchive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID or name of the container |
 **path** | **String**| Path to a directory in the container to extract the archive’s contents into.  |
 **inputStream** | **String**| The input stream must be a tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz. |
 **noOverwriteDirNonDir** | **String**| If “1”, “true”, or “True” then it will be an error if unpacking the given content would cause an existing directory to be replaced with a non-directory and vice versa. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-tar, application/octet-stream
 - **Accept**: application/json, text/plain

