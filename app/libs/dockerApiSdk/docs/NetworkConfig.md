
# NetworkConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The network&#39;s name. | 
**checkDuplicate** | **Boolean** | Check for networks with duplicate names. Since Network is primarily keyed based on a random ID and not on the name, and network name is strictly a user-friendly alias to the network which is uniquely identified using ID, there is no guaranteed way to check for duplicates. CheckDuplicate is there to provide a best effort checking of any networks which has the same name but it is not guaranteed to catch all name collisions. |  [optional]
**driver** | **String** | Name of the network driver plugin to use. |  [optional]
**internal** | **Boolean** | Restrict external access to the network. |  [optional]
**attachable** | **Boolean** | Globally scoped network is manually attachable by regular containers from workers in swarm mode. |  [optional]
**ingress** | **Boolean** | Ingress network is the network which provides the routing-mesh in swarm mode. |  [optional]
**IPAM** | [**IPAM**](IPAM.md) | Optional custom IP scheme for the network. |  [optional]
**enableIPv6** | **Boolean** | Enable IPv6 on the network. |  [optional]
**options** | **Map&lt;String, String&gt;** | Network specific options to be used by the drivers. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]



