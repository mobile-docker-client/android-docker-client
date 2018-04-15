
# ConfigSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | User-defined name of the config. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**data** | **String** | Base64-url-safe-encoded ([RFC 4648](https://tools.ietf.org/html/rfc4648#section-3.2)) config data.  |  [optional]
**templating** | [**Driver**](Driver.md) | Templating driver, if applicable  Templating controls whether and how to evaluate the config payload as a template. If no driver is set, no templating is used.  |  [optional]



