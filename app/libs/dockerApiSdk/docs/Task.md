
# Task

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ID** | **String** | The ID of the task. |  [optional]
**version** | [**ObjectVersion**](ObjectVersion.md) |  |  [optional]
**createdAt** | **String** |  |  [optional]
**updatedAt** | **String** |  |  [optional]
**name** | **String** | Name of the task. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**spec** | [**TaskSpec**](TaskSpec.md) |  |  [optional]
**serviceID** | **String** | The ID of the service this task is part of. |  [optional]
**slot** | **Integer** |  |  [optional]
**nodeID** | **String** | The ID of the node that this task is on. |  [optional]
**assignedGenericResources** | [**GenericResources**](GenericResources.md) |  |  [optional]
**status** | [**TaskStatus**](TaskStatus.md) |  |  [optional]
**desiredState** | [**TaskState**](TaskState.md) |  |  [optional]



