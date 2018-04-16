
# ContainerUpdateConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cpuShares** | **Integer** | An integer value representing this container&#39;s relative CPU weight versus other containers. |  [optional]
**memory** | **Long** | Memory limit in bytes. |  [optional]
**cgroupParent** | **String** | Path to &#x60;cgroups&#x60; under which the container&#39;s &#x60;cgroup&#x60; is created. If the path is not absolute, the path is considered to be relative to the &#x60;cgroups&#x60; path of the init process. Cgroups are created if they do not already exist. |  [optional]
**blkioWeight** | **Integer** | Block IO weight (relative weight). |  [optional]
**blkioWeightDevice** | [**List&lt;ResourcesBlkioWeightDevice&gt;**](ResourcesBlkioWeightDevice.md) | Block IO weight (relative device weight) in the form &#x60;[{\&quot;Path\&quot;: \&quot;device_path\&quot;, \&quot;Weight\&quot;: weight}]&#x60;.  |  [optional]
**blkioDeviceReadBps** | [**List&lt;ThrottleDevice&gt;**](ThrottleDevice.md) | Limit read rate (bytes per second) from a device, in the form &#x60;[{\&quot;Path\&quot;: \&quot;device_path\&quot;, \&quot;Rate\&quot;: rate}]&#x60;.  |  [optional]
**blkioDeviceWriteBps** | [**List&lt;ThrottleDevice&gt;**](ThrottleDevice.md) | Limit write rate (bytes per second) to a device, in the form &#x60;[{\&quot;Path\&quot;: \&quot;device_path\&quot;, \&quot;Rate\&quot;: rate}]&#x60;.  |  [optional]
**blkioDeviceReadIOps** | [**List&lt;ThrottleDevice&gt;**](ThrottleDevice.md) | Limit read rate (IO per second) from a device, in the form &#x60;[{\&quot;Path\&quot;: \&quot;device_path\&quot;, \&quot;Rate\&quot;: rate}]&#x60;.  |  [optional]
**blkioDeviceWriteIOps** | [**List&lt;ThrottleDevice&gt;**](ThrottleDevice.md) | Limit write rate (IO per second) to a device, in the form &#x60;[{\&quot;Path\&quot;: \&quot;device_path\&quot;, \&quot;Rate\&quot;: rate}]&#x60;.  |  [optional]
**cpuPeriod** | **Long** | The length of a CPU period in microseconds. |  [optional]
**cpuQuota** | **Long** | Microseconds of CPU time that the container can get in a CPU period. |  [optional]
**cpuRealtimePeriod** | **Long** | The length of a CPU real-time period in microseconds. Set to 0 to allocate no time allocated to real-time tasks. |  [optional]
**cpuRealtimeRuntime** | **Long** | The length of a CPU real-time runtime in microseconds. Set to 0 to allocate no time allocated to real-time tasks. |  [optional]
**cpusetCpus** | **String** | CPUs in which to allow execution (e.g., &#x60;0-3&#x60;, &#x60;0,1&#x60;) |  [optional]
**cpusetMems** | **String** | Memory nodes (MEMs) in which to allow execution (0-3, 0,1). Only effective on NUMA systems. |  [optional]
**devices** | [**List&lt;DeviceMapping&gt;**](DeviceMapping.md) | A list of devices to add to the container. |  [optional]
**deviceCgroupRules** | **List&lt;String&gt;** | a list of cgroup rules to apply to the container |  [optional]
**diskQuota** | **Long** | Disk limit (in bytes). |  [optional]
**kernelMemory** | **Long** | Kernel memory limit in bytes. |  [optional]
**memoryReservation** | **Long** | Memory soft limit in bytes. |  [optional]
**memorySwap** | **Long** | Total memory limit (memory + swap). Set as &#x60;-1&#x60; to enable unlimited swap. |  [optional]
**memorySwappiness** | **Long** | Tune a container&#39;s memory swappiness behavior. Accepts an integer between 0 and 100. |  [optional]
**nanoCPUs** | **Long** | CPU quota in units of 10&lt;sup&gt;-9&lt;/sup&gt; CPUs. |  [optional]
**oomKillDisable** | **Boolean** | Disable OOM Killer for the container. |  [optional]
**init** | **Boolean** | Run an init inside the container that forwards signals and reaps processes. This field is omitted if empty, and the default (as configured on the daemon) is used. |  [optional]
**pidsLimit** | **Long** | Tune a container&#39;s pids limit. Set -1 for unlimited. |  [optional]
**ulimits** | [**List&lt;ResourcesUlimits&gt;**](ResourcesUlimits.md) | A list of resource limits to set in the container. For example: &#x60;{\&quot;Name\&quot;: \&quot;nofile\&quot;, \&quot;Soft\&quot;: 1024, \&quot;Hard\&quot;: 2048}&#x60;\&quot;  |  [optional]
**cpuCount** | **Long** | The number of usable CPUs (Windows only).  On Windows Server containers, the processor resource controls are mutually exclusive. The order of precedence is &#x60;CPUCount&#x60; first, then &#x60;CPUShares&#x60;, and &#x60;CPUPercent&#x60; last.  |  [optional]
**cpuPercent** | **Long** | The usable percentage of the available CPUs (Windows only).  On Windows Server containers, the processor resource controls are mutually exclusive. The order of precedence is &#x60;CPUCount&#x60; first, then &#x60;CPUShares&#x60;, and &#x60;CPUPercent&#x60; last.  |  [optional]
**ioMaximumIOps** | **Long** | Maximum IOps for the container system drive (Windows only) |  [optional]
**ioMaximumBandwidth** | **Long** | Maximum IO in bytes per second for the container system drive (Windows only) |  [optional]
**restartPolicy** | [**RestartPolicy**](RestartPolicy.md) |  |  [optional]



