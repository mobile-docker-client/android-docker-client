
# TaskSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**pluginSpec** | [**TaskSpecPluginSpec**](TaskSpecPluginSpec.md) |  |  [optional]
**containerSpec** | [**TaskSpecContainerSpec**](TaskSpecContainerSpec.md) |  |  [optional]
**resources** | [**TaskSpecResources**](TaskSpecResources.md) |  |  [optional]
**restartPolicy** | [**TaskSpecRestartPolicy**](TaskSpecRestartPolicy.md) |  |  [optional]
**placement** | [**TaskSpecPlacement**](TaskSpecPlacement.md) |  |  [optional]
**forceUpdate** | **Integer** | A counter that triggers an update even if no relevant parameters have been changed. |  [optional]
**runtime** | **String** | Runtime is the type of runtime specified for the task executor. |  [optional]
**networks** | [**List&lt;TaskSpecNetworks&gt;**](TaskSpecNetworks.md) |  |  [optional]
**logDriver** | [**TaskSpecLogDriver**](TaskSpecLogDriver.md) |  |  [optional]



