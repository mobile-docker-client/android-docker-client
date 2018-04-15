
# ServiceSpecUpdateConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**parallelism** | **Long** | Maximum number of tasks to be updated in one iteration (0 means unlimited parallelism). |  [optional]
**delay** | **Long** | Amount of time between updates, in nanoseconds. |  [optional]
**failureAction** | [**FailureActionEnum**](#FailureActionEnum) | Action to take if an updated task fails to run, or stops running during the update. |  [optional]
**monitor** | **Long** | Amount of time to monitor each updated task for failures, in nanoseconds. |  [optional]
**maxFailureRatio** | [**BigDecimal**](BigDecimal.md) | The fraction of tasks that may fail during an update before the failure action is invoked, specified as a floating point number between 0 and 1. |  [optional]
**order** | [**OrderEnum**](#OrderEnum) | The order of operations when rolling out an updated task. Either the old task is shut down before the new task is started, or the new task is started before the old task is shut down. |  [optional]


<a name="FailureActionEnum"></a>
## Enum: FailureActionEnum
Name | Value
---- | -----
CONTINUE | &quot;continue&quot;
PAUSE | &quot;pause&quot;
ROLLBACK | &quot;rollback&quot;


<a name="OrderEnum"></a>
## Enum: OrderEnum
Name | Value
---- | -----
STOP_FIRST | &quot;stop-first&quot;
START_FIRST | &quot;start-first&quot;



