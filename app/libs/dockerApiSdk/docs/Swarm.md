
# Swarm

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ID** | **String** | The ID of the swarm. |  [optional]
**version** | [**ObjectVersion**](ObjectVersion.md) |  |  [optional]
**createdAt** | **String** | Date and time at which the swarm was initialised in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds.  |  [optional]
**updatedAt** | **String** | Date and time at which the swarm was last updated in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds.  |  [optional]
**spec** | [**SwarmSpec**](SwarmSpec.md) |  |  [optional]
**tlSInfo** | [**TLSInfo**](TLSInfo.md) |  |  [optional]
**rootRotationInProgress** | **Boolean** | Whether there is currently a root CA rotation in progress for the swarm |  [optional]
**joinTokens** | [**JoinTokens**](JoinTokens.md) |  |  [optional]



