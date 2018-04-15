
# ContainerInspectResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the container |  [optional]
**created** | **String** | The time the container was created |  [optional]
**path** | **String** | The path to the command being run |  [optional]
**args** | **List&lt;String&gt;** | The arguments to the command being run |  [optional]
**state** | [**ContainerInspectResponseState**](ContainerInspectResponseState.md) |  |  [optional]
**image** | **String** | The container&#39;s image |  [optional]
**resolvConfPath** | **String** |  |  [optional]
**hostnamePath** | **String** |  |  [optional]
**hostsPath** | **String** |  |  [optional]
**logPath** | **String** |  |  [optional]
**node** | **Object** | TODO |  [optional]
**name** | **String** |  |  [optional]
**restartCount** | **Integer** |  |  [optional]
**driver** | **String** |  |  [optional]
**mountLabel** | **String** |  |  [optional]
**processLabel** | **String** |  |  [optional]
**appArmorProfile** | **String** |  |  [optional]
**execIDs** | **String** |  |  [optional]
**hostConfig** | [**HostConfig**](HostConfig.md) |  |  [optional]
**graphDriver** | [**GraphDriverData**](GraphDriverData.md) |  |  [optional]
**sizeRw** | **Long** | The size of files that have been created or changed by this container. |  [optional]
**sizeRootFs** | **Long** | The total size of all the files in this container. |  [optional]
**mounts** | [**List&lt;MountPoint&gt;**](MountPoint.md) |  |  [optional]
**config** | [**ContainerConfig**](ContainerConfig.md) |  |  [optional]
**networkSettings** | [**NetworkSettings**](NetworkSettings.md) |  |  [optional]



