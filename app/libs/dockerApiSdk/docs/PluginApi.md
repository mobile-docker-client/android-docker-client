# PluginApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getPluginPrivileges**](PluginApi.md#getPluginPrivileges) | **GET** plugins/privileges | Get plugin privileges
[**pluginCreate**](PluginApi.md#pluginCreate) | **POST** plugins/create | Create a plugin
[**pluginDelete**](PluginApi.md#pluginDelete) | **DELETE** plugins/{name} | Remove a plugin
[**pluginDisable**](PluginApi.md#pluginDisable) | **POST** plugins/{name}/disable | Disable a plugin
[**pluginEnable**](PluginApi.md#pluginEnable) | **POST** plugins/{name}/enable | Enable a plugin
[**pluginInspect**](PluginApi.md#pluginInspect) | **GET** plugins/{name}/json | Inspect a plugin
[**pluginList**](PluginApi.md#pluginList) | **GET** plugins | List plugins
[**pluginPull**](PluginApi.md#pluginPull) | **POST** plugins/pull | Install a plugin
[**pluginPush**](PluginApi.md#pluginPush) | **POST** plugins/{name}/push | Push a plugin
[**pluginSet**](PluginApi.md#pluginSet) | **POST** plugins/{name}/set | Configure a plugin
[**pluginUpgrade**](PluginApi.md#pluginUpgrade) | **POST** plugins/{name}/upgrade | Upgrade a plugin


<a name="getPluginPrivileges"></a>
# **getPluginPrivileges**
> List&lt;PluginPrivilegeItem&gt; getPluginPrivileges(remote)

Get plugin privileges

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String remote = "remote_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
try {
    List<PluginPrivilegeItem> result = apiInstance.getPluginPrivileges(remote);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#getPluginPrivileges");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **remote** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |

### Return type

[**List&lt;PluginPrivilegeItem&gt;**](PluginPrivilegeItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginCreate"></a>
# **pluginCreate**
> Void pluginCreate(name, tarContext)

Create a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
byte[] tarContext = BINARY_DATA_HERE; // byte[] | Path to tar containing plugin rootfs and manifest
try {
    Void result = apiInstance.pluginCreate(name, tarContext);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |
 **tarContext** | **byte[]**| Path to tar containing plugin rootfs and manifest | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-tar
 - **Accept**: application/json, text/plain

<a name="pluginDelete"></a>
# **pluginDelete**
> Plugin pluginDelete(name, force)

Remove a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
Boolean force = false; // Boolean | Disable the plugin before removing. This may result in issues if the plugin is in use by a container.
try {
    Plugin result = apiInstance.pluginDelete(name, force);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |
 **force** | **Boolean**| Disable the plugin before removing. This may result in issues if the plugin is in use by a container. | [optional] [default to false]

### Return type

[**Plugin**](Plugin.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginDisable"></a>
# **pluginDisable**
> Void pluginDisable(name)

Disable a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
try {
    Void result = apiInstance.pluginDisable(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginDisable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginEnable"></a>
# **pluginEnable**
> Void pluginEnable(name, timeout)

Enable a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
Integer timeout = 0; // Integer | Set the HTTP client timeout (in seconds)
try {
    Void result = apiInstance.pluginEnable(name, timeout);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginEnable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |
 **timeout** | **Integer**| Set the HTTP client timeout (in seconds) | [optional] [default to 0]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginInspect"></a>
# **pluginInspect**
> Plugin pluginInspect(name)

Inspect a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
try {
    Plugin result = apiInstance.pluginInspect(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |

### Return type

[**Plugin**](Plugin.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginList"></a>
# **pluginList**
> List&lt;Plugin&gt; pluginList(filters)

List plugins

Returns information about installed plugins.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the plugin list. Available filters:  - `capability=<capability name>` - `enable=<true>|<false>` 
try {
    List<Plugin> result = apiInstance.pluginList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the plugin list. Available filters:  - &#x60;capability&#x3D;&lt;capability name&gt;&#x60; - &#x60;enable&#x3D;&lt;true&gt;|&lt;false&gt;&#x60;  | [optional]

### Return type

[**List&lt;Plugin&gt;**](Plugin.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="pluginPull"></a>
# **pluginPull**
> Void pluginPull(remote, name, xRegistryAuth, body)

Install a plugin

Pulls and installs a plugin. After the plugin is installed, it can be enabled using the [&#x60;POST /plugins/{name}/enable&#x60; endpoint](#operation/PostPluginsEnable). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String remote = "remote_example"; // String | Remote reference for plugin to install.  The `:latest` tag is optional, and is used as the default if omitted. 
String name = "name_example"; // String | Local name for the pulled plugin.  The `:latest` tag is optional, and is used as the default if omitted. 
String xRegistryAuth = "xRegistryAuth_example"; // String | A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication)
List<Body> body = Arrays.asList(new Body()); // List<Body> | 
try {
    Void result = apiInstance.pluginPull(remote, name, xRegistryAuth, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginPull");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **remote** | **String**| Remote reference for plugin to install.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  |
 **name** | **String**| Local name for the pulled plugin.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  | [optional]
 **xRegistryAuth** | **String**| A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication) | [optional]
 **body** | [**List&lt;Body&gt;**](Body.md)|  | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="pluginPush"></a>
# **pluginPush**
> Void pluginPush(name)

Push a plugin

Push a plugin to the registry. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
try {
    Void result = apiInstance.pluginPush(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginPush");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

<a name="pluginSet"></a>
# **pluginSet**
> Void pluginSet(name, body)

Configure a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
List<String> body = Arrays.asList(new List<String>()); // List<String> | 
try {
    Void result = apiInstance.pluginSet(name, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginSet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |
 **body** | **List&lt;String&gt;**|  | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="pluginUpgrade"></a>
# **pluginUpgrade**
> Void pluginUpgrade(name, remote, xRegistryAuth, body)

Upgrade a plugin

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PluginApi;


PluginApi apiInstance = new PluginApi();
String name = "name_example"; // String | The name of the plugin. The `:latest` tag is optional, and is the default if omitted.
String remote = "remote_example"; // String | Remote reference to upgrade to.  The `:latest` tag is optional, and is used as the default if omitted. 
String xRegistryAuth = "xRegistryAuth_example"; // String | A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication)
List<Body> body = Arrays.asList(new Body()); // List<Body> | 
try {
    Void result = apiInstance.pluginUpgrade(name, remote, xRegistryAuth, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PluginApi#pluginUpgrade");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. |
 **remote** | **String**| Remote reference to upgrade to.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  |
 **xRegistryAuth** | **String**| A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication) | [optional]
 **body** | [**List&lt;Body&gt;**](Body.md)|  | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

