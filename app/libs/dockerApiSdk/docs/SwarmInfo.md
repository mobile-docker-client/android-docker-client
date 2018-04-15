
# SwarmInfo

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nodeID** | **String** | Unique identifier of for this node in the swarm. |  [optional]
**nodeAddr** | **String** | IP address at which this node can be reached by other nodes in the swarm.  |  [optional]
**localNodeState** | [**LocalNodeState**](LocalNodeState.md) |  |  [optional]
**controlAvailable** | **Boolean** |  |  [optional]
**error** | **String** |  |  [optional]
**remoteManagers** | [**List&lt;PeerNode&gt;**](PeerNode.md) | List of ID&#39;s and addresses of other managers in the swarm.  |  [optional]
**nodes** | **Integer** | Total number of nodes in the swarm. |  [optional]
**managers** | **Integer** | Total number of managers in the swarm. |  [optional]
**cluster** | [**ClusterInfo**](ClusterInfo.md) |  |  [optional]



