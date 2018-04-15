# DistributionApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**distributionInspect**](DistributionApi.md#distributionInspect) | **GET** distribution/{name}/json | Get image information from the registry


<a name="distributionInspect"></a>
# **distributionInspect**
> DistributionInspectResponse distributionInspect(name)

Get image information from the registry

Return image digest and platform information by contacting the registry.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DistributionApi;


DistributionApi apiInstance = new DistributionApi();
String name = "name_example"; // String | Image name or id
try {
    DistributionInspectResponse result = apiInstance.distributionInspect(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DistributionApi#distributionInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or id |

### Return type

[**DistributionInspectResponse**](DistributionInspectResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

