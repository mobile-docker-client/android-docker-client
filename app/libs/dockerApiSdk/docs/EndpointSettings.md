
# EndpointSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ipAMConfig** | [**EndpointIPAMConfig**](EndpointIPAMConfig.md) |  |  [optional]
**links** | **List&lt;String&gt;** |  |  [optional]
**aliases** | **List&lt;String&gt;** |  |  [optional]
**networkID** | **String** | Unique ID of the network.  |  [optional]
**endpointID** | **String** | Unique ID for the service endpoint in a Sandbox.  |  [optional]
**gateway** | **String** | Gateway address for this network.  |  [optional]
**ipAddress** | **String** | IPv4 address.  |  [optional]
**ipPrefixLen** | **Integer** | Mask length of the IPv4 address.  |  [optional]
**ipv6Gateway** | **String** | IPv6 gateway address.  |  [optional]
**globalIPv6Address** | **String** | Global IPv6 address.  |  [optional]
**globalIPv6PrefixLen** | **Long** | Mask length of the global IPv6 address.  |  [optional]
**macAddress** | **String** | MAC address for the endpoint on this network.  |  [optional]
**driverOpts** | **Map&lt;String, String&gt;** | DriverOpts is a mapping of driver options and values. These options are passed directly to the driver and are driver specific.  |  [optional]



