
# TaskSpecPlacement

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**constraints** | **List&lt;String&gt;** | An array of constraints. |  [optional]
**preferences** | [**List&lt;TaskSpecPlacementPreferences&gt;**](TaskSpecPlacementPreferences.md) | Preferences provide a way to make the scheduler aware of factors such as topology. They are provided in order from highest to lowest precedence. |  [optional]
**platforms** | [**List&lt;Platform&gt;**](Platform.md) | Platforms stores all the platforms that the service&#39;s image can run on. This field is used in the platform filter for scheduling. If empty, then the platform filter is off, meaning there are no scheduling restrictions.  |  [optional]



