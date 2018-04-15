
# Volume

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Name of the volume. | 
**driver** | **String** | Name of the volume driver used by the volume. | 
**mountpoint** | **String** | Mount path of the volume on the host. | 
**createdAt** | **String** | Date/Time the volume was created. |  [optional]
**status** | **Map&lt;String, Object&gt;** | Low-level details about the volume, provided by the volume driver. Details are returned as a map with key/value pairs: &#x60;{\&quot;key\&quot;:\&quot;value\&quot;,\&quot;key2\&quot;:\&quot;value2\&quot;}&#x60;.  The &#x60;Status&#x60; field is optional, and is omitted if the volume driver does not support this feature.  |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. | 
**scope** | [**ScopeEnum**](#ScopeEnum) | The level at which the volume exists. Either &#x60;global&#x60; for cluster-wide, or &#x60;local&#x60; for machine level. | 
**options** | **Map&lt;String, String&gt;** | The driver specific options used when creating the volume. | 
**usageData** | [**VolumeUsageData**](VolumeUsageData.md) |  |  [optional]


<a name="ScopeEnum"></a>
## Enum: ScopeEnum
Name | Value
---- | -----
LOCAL | &quot;local&quot;
GLOBAL | &quot;global&quot;



