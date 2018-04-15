
# NetworkSettings

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bridge** | **String** | Name of the network&#39;a bridge (for example, &#x60;docker0&#x60;). |  [optional]
**sandboxID** | **String** | SandboxID uniquely represents a container&#39;s network stack. |  [optional]
**hairpinMode** | **Boolean** | Indicates if hairpin NAT should be enabled on the virtual interface.  |  [optional]
**linkLocalIPv6Address** | **String** | IPv6 unicast address using the link-local prefix. |  [optional]
**linkLocalIPv6PrefixLen** | **Integer** | Prefix length of the IPv6 unicast address. |  [optional]
**ports** | [**PortMap**](PortMap.md) |  |  [optional]
**sandboxKey** | **String** | SandboxKey identifies the sandbox |  [optional]
**secondaryIPAddresses** | [**List&lt;Address&gt;**](Address.md) |  |  [optional]
**secondaryIPv6Addresses** | [**List&lt;Address&gt;**](Address.md) |  |  [optional]
**endpointID** | **String** | EndpointID uniquely represents a service endpoint in a Sandbox.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**gateway** | **String** | Gateway address for the default \&quot;bridge\&quot; network.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**globalIPv6Address** | **String** | Global IPv6 address for the default \&quot;bridge\&quot; network.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**globalIPv6PrefixLen** | **Integer** | Mask length of the global IPv6 address.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**ipAddress** | **String** | IPv4 address for the default \&quot;bridge\&quot; network.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**ipPrefixLen** | **Integer** | Mask length of the IPv4 address.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**ipv6Gateway** | **String** | IPv6 gateway address for this network.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**macAddress** | **String** | MAC address for the container on the default \&quot;bridge\&quot; network.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  &gt; **Deprecated**: This field is only propagated when attached to the &gt; default \&quot;bridge\&quot; network. Use the information from the \&quot;bridge\&quot; &gt; network inside the &#x60;Networks&#x60; map instead, which contains the same &gt; information. This field was deprecated in Docker 1.9 and is scheduled &gt; to be removed in Docker 17.12.0  |  [optional]
**networks** | [**Map&lt;String, EndpointSettings&gt;**](EndpointSettings.md) | Information about all networks that the container is connected to.  |  [optional]



