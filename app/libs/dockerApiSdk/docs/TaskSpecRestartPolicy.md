
# TaskSpecRestartPolicy

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**condition** | [**ConditionEnum**](#ConditionEnum) | Condition for restart. |  [optional]
**delay** | **Long** | Delay between restart attempts. |  [optional]
**maxAttempts** | **Long** | Maximum attempts to restart a given container before giving up (default value is 0, which is ignored). |  [optional]
**window** | **Long** | Windows is the time window used to evaluate the restart policy (default value is 0, which is unbounded). |  [optional]


<a name="ConditionEnum"></a>
## Enum: ConditionEnum
Name | Value
---- | -----
NONE | &quot;none&quot;
ON_FAILURE | &quot;on-failure&quot;
ANY | &quot;any&quot;



