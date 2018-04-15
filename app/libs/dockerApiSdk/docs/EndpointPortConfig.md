
# EndpointPortConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** |  |  [optional]
**protocol** | [**ProtocolEnum**](#ProtocolEnum) |  |  [optional]
**targetPort** | **Integer** | The port inside the container. |  [optional]
**publishedPort** | **Integer** | The port on the swarm hosts. |  [optional]
**publishMode** | [**PublishModeEnum**](#PublishModeEnum) | The mode in which port is published.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  - \&quot;ingress\&quot; makes the target port accessible on on every node,   regardless of whether there is a task for the service running on   that node or not. - \&quot;host\&quot; bypasses the routing mesh and publish the port directly on   the swarm node where that service is running.  |  [optional]


<a name="ProtocolEnum"></a>
## Enum: ProtocolEnum
Name | Value
---- | -----
TCP | &quot;tcp&quot;
UDP | &quot;udp&quot;
SCTP | &quot;sctp&quot;


<a name="PublishModeEnum"></a>
## Enum: PublishModeEnum
Name | Value
---- | -----
INGRESS | &quot;ingress&quot;
HOST | &quot;host&quot;



