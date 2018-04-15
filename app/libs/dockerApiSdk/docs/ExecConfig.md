
# ExecConfig

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**attachStdin** | **Boolean** | Attach to &#x60;stdin&#x60; of the exec command. |  [optional]
**attachStdout** | **Boolean** | Attach to &#x60;stdout&#x60; of the exec command. |  [optional]
**attachStderr** | **Boolean** | Attach to &#x60;stderr&#x60; of the exec command. |  [optional]
**detachKeys** | **String** | Override the key sequence for detaching a container. Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60; or &#x60;_&#x60;. |  [optional]
**tty** | **Boolean** | Allocate a pseudo-TTY. |  [optional]
**env** | **List&lt;String&gt;** | A list of environment variables in the form &#x60;[\&quot;VAR&#x3D;value\&quot;, ...]&#x60;. |  [optional]
**cmd** | **List&lt;String&gt;** | Command to run, as a string or array of strings. |  [optional]
**privileged** | **Boolean** | Runs the exec process with extended privileges. |  [optional]
**user** | **String** | The user, and optionally, group to run the exec process inside the container. Format is one of: &#x60;user&#x60;, &#x60;user:group&#x60;, &#x60;uid&#x60;, or &#x60;uid:gid&#x60;. |  [optional]
**workingDir** | **String** | The working directory for the exec process inside the container. |  [optional]



