
# SecretSpec

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | User-defined name of the secret. |  [optional]
**labels** | **Map&lt;String, String&gt;** | User-defined key/value metadata. |  [optional]
**data** | **String** | Base64-url-safe-encoded ([RFC 4648](https://tools.ietf.org/html/rfc4648#section-3.2)) data to store as secret.  This field is only used to _create_ a secret, and is not returned by other endpoints.  |  [optional]
**driver** | [**Driver**](Driver.md) | Name of the secrets driver used to fetch the secret&#39;s value from an external secret store |  [optional]
**templating** | [**Driver**](Driver.md) | Templating driver, if applicable  Templating controls whether and how to evaluate the config payload as a template. If no driver is set, no templating is used.  |  [optional]



