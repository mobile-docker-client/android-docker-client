
# ServiceSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Name of the service. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**taskTemplate** | [**TaskSpec**](TaskSpec.md) |  |  [optional]
**mode** | [**ServiceSpecMode**](ServiceSpecMode.md) |  |  [optional]
**updateConfig** | [**ServiceSpecUpdateConfig**](ServiceSpecUpdateConfig.md) |  |  [optional]
**rollbackConfig** | [**ServiceSpecRollbackConfig**](ServiceSpecRollbackConfig.md) |  |  [optional]
**networks** | [**List&lt;TaskSpecNetworks&gt;**](TaskSpecNetworks.md) | Array of network names or IDs to attach the service to. |  [optional]
**endpointSpec** | [**EndpointSpec**](EndpointSpec.md) |  |  [optional]



