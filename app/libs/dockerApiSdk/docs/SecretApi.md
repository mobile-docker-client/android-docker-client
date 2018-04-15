# SecretApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**secretCreate**](SecretApi.md#secretCreate) | **POST** secrets/create | Create a secret
[**secretDelete**](SecretApi.md#secretDelete) | **DELETE** secrets/{id} | Delete a secret
[**secretInspect**](SecretApi.md#secretInspect) | **GET** secrets/{id} | Inspect a secret
[**secretList**](SecretApi.md#secretList) | **GET** secrets | List secrets
[**secretUpdate**](SecretApi.md#secretUpdate) | **POST** secrets/{id}/update | Update a Secret


<a name="secretCreate"></a>
# **secretCreate**
> IdResponse secretCreate(body)

Create a secret

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecretApi;


SecretApi apiInstance = new SecretApi();
 body = new null(); //  | 
try {
    IdResponse result = apiInstance.secretCreate(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecretApi#secretCreate");
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

<a name="secretDelete"></a>
# **secretDelete**
> Void secretDelete(id)

Delete a secret

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecretApi;


SecretApi apiInstance = new SecretApi();
String id = "id_example"; // String | ID of the secret
try {
    Void result = apiInstance.secretDelete(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecretApi#secretDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the secret |

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="secretInspect"></a>
# **secretInspect**
> Secret secretInspect(id)

Inspect a secret

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecretApi;


SecretApi apiInstance = new SecretApi();
String id = "id_example"; // String | ID of the secret
try {
    Secret result = apiInstance.secretInspect(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecretApi#secretInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| ID of the secret |

### Return type

[**Secret**](Secret.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="secretList"></a>
# **secretList**
> List&lt;Secret&gt; secretList(filters)

List secrets

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecretApi;


SecretApi apiInstance = new SecretApi();
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the secrets list. Available filters:  - `id=<secret id>` - `label=<key> or label=<key>=value` - `name=<secret name>` - `names=<secret name>` 
try {
    List<Secret> result = apiInstance.secretList(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecretApi#secretList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the secrets list. Available filters:  - &#x60;id&#x3D;&lt;secret id&gt;&#x60; - &#x60;label&#x3D;&lt;key&gt; or label&#x3D;&lt;key&gt;&#x3D;value&#x60; - &#x60;name&#x3D;&lt;secret name&gt;&#x60; - &#x60;names&#x3D;&lt;secret name&gt;&#x60;  | [optional]

### Return type

[**List&lt;Secret&gt;**](Secret.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="secretUpdate"></a>
# **secretUpdate**
> Void secretUpdate(id, version, body)

Update a Secret

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.SecretApi;


SecretApi apiInstance = new SecretApi();
String id = "id_example"; // String | The ID or name of the secret
Long version = 789L; // Long | The version number of the secret object being updated. This is required to avoid conflicting writes.
SecretSpec body = new SecretSpec(); // SecretSpec | The spec of the secret to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [SecretInspect endpoint](#operation/SecretInspect) response values.
try {
    Void result = apiInstance.secretUpdate(id, version, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SecretApi#secretUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| The ID or name of the secret |
 **version** | **Long**| The version number of the secret object being updated. This is required to avoid conflicting writes. |
 **body** | [**SecretSpec**](SecretSpec.md)| The spec of the secret to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [SecretInspect endpoint](#operation/SecretInspect) response values. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

