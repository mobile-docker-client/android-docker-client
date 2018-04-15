
# NodeSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Name for the node. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**role** | [**RoleEnum**](#RoleEnum) | Role of the node. |  [optional]
**availability** | [**AvailabilityEnum**](#AvailabilityEnum) | Availability of the node. |  [optional]


<a name="RoleEnum"></a>
## Enum: RoleEnum
Name | Value
---- | -----
WORKER | &quot;worker&quot;
MANAGER | &quot;manager&quot;


<a name="AvailabilityEnum"></a>
## Enum: AvailabilityEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
PAUSE | &quot;pause&quot;
DRAIN | &quot;drain&quot;



