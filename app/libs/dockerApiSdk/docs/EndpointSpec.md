
# EndpointSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**mode** | [**ModeEnum**](#ModeEnum) | The mode of resolution to use for internal load balancing between tasks. |  [optional]
**ports** | [**List&lt;EndpointPortConfig&gt;**](EndpointPortConfig.md) | List of exposed ports that this service is accessible on from the outside. Ports can only be provided if &#x60;vip&#x60; resolution mode is used. |  [optional]


<a name="ModeEnum"></a>
## Enum: ModeEnum
Name | Value
---- | -----
VIP | &quot;vip&quot;
DNSRR | &quot;dnsrr&quot;



