
# ContainerSummaryInner

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of this container |  [optional]
**names** | **List&lt;String&gt;** | The names that this container has been given |  [optional]
**image** | **String** | The name of the image used when creating this container |  [optional]
**imageID** | **String** | The ID of the image that this container was created from |  [optional]
**command** | **String** | Command to run when starting the container |  [optional]
**created** | **Long** | When the container was created |  [optional]
**ports** | [**List&lt;Port&gt;**](Port.md) | The ports exposed by this container |  [optional]
**sizeRw** | **Long** | The size of files that have been created or changed by this container |  [optional]
**sizeRootFs** | **Long** | The total size of all the files in this container |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**state** | **String** | The state of this container (e.g. &#x60;Exited&#x60;) |  [optional]
**status** | **String** | Additional human-readable status of this container (e.g. &#x60;Exit 0&#x60;) |  [optional]
**hostConfig** | [**ContainerSummaryInnerHostConfig**](ContainerSummaryInnerHostConfig.md) |  |  [optional]
**networkSettings** | [**ContainerSummaryInnerNetworkSettings**](ContainerSummaryInnerNetworkSettings.md) |  |  [optional]
**mounts** | [**List&lt;Mount&gt;**](Mount.md) |  |  [optional]



