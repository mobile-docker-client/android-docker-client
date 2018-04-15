# ImageApi

All URIs are relative to *http://localhost/v1.37*

Method | HTTP request | Description
------------- | ------------- | -------------
[**buildPrune**](ImageApi.md#buildPrune) | **POST** build/prune | Delete builder cache
[**imageBuild**](ImageApi.md#imageBuild) | **POST** build | Build an image
[**imageCommit**](ImageApi.md#imageCommit) | **POST** commit | Create a new image from a container
[**imageCreate**](ImageApi.md#imageCreate) | **POST** images/create | Create an image
[**imageDelete**](ImageApi.md#imageDelete) | **DELETE** images/{name} | Remove an image
[**imageGet**](ImageApi.md#imageGet) | **GET** images/{name}/get | Export an image
[**imageGetAll**](ImageApi.md#imageGetAll) | **GET** images/get | Export several images
[**imageHistory**](ImageApi.md#imageHistory) | **GET** images/{name}/history | Get the history of an image
[**imageInspect**](ImageApi.md#imageInspect) | **GET** images/{name}/json | Inspect an image
[**imageList**](ImageApi.md#imageList) | **GET** images/json | List Images
[**imageLoad**](ImageApi.md#imageLoad) | **POST** images/load | Import images
[**imagePrune**](ImageApi.md#imagePrune) | **POST** images/prune | Delete unused images
[**imagePush**](ImageApi.md#imagePush) | **POST** images/{name}/push | Push an image
[**imageSearch**](ImageApi.md#imageSearch) | **GET** images/search | Search images
[**imageTag**](ImageApi.md#imageTag) | **POST** images/{name}/tag | Tag an image


<a name="buildPrune"></a>
# **buildPrune**
> BuildPruneResponse buildPrune()

Delete builder cache

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
try {
    BuildPruneResponse result = apiInstance.buildPrune();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#buildPrune");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**BuildPruneResponse**](BuildPruneResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageBuild"></a>
# **imageBuild**
> Void imageBuild(inputStream, dockerfile, t, extrahosts, remote, q, nocache, cachefrom, pull, rm, forcerm, memory, memswap, cpushares, cpusetcpus, cpuperiod, cpuquota, buildargs, shmsize, squash, labels, networkmode, contentType, xRegistryConfig, platform)

Build an image

Build an image from a tar archive with a &#x60;Dockerfile&#x60; in it.  The &#x60;Dockerfile&#x60; specifies how the image is built from the tar archive. It is typically in the archive&#39;s root, but can be at a different path or have a different name by specifying the &#x60;dockerfile&#x60; parameter. [See the &#x60;Dockerfile&#x60; reference for more information](https://docs.docker.com/engine/reference/builder/).  The Docker daemon performs a preliminary validation of the &#x60;Dockerfile&#x60; before starting the build, and returns an error if the syntax is incorrect. After that, each instruction is run one-by-one until the ID of the new image is output.  The build is canceled if the client drops the connection by quitting or being killed. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
byte[] inputStream = BINARY_DATA_HERE; // byte[] | A tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz.
String dockerfile = "Dockerfile"; // String | Path within the build context to the `Dockerfile`. This is ignored if `remote` is specified and points to an external `Dockerfile`.
String t = "t_example"; // String | A name and optional tag to apply to the image in the `name:tag` format. If you omit the tag the default `latest` value is assumed. You can provide several `t` parameters.
String extrahosts = "extrahosts_example"; // String | Extra hosts to add to /etc/hosts
String remote = "remote_example"; // String | A Git repository URI or HTTP/HTTPS context URI. If the URI points to a single text file, the file’s contents are placed into a file called `Dockerfile` and the image is built from that file. If the URI points to a tarball, the file is downloaded by the daemon and the contents therein used as the context for the build. If the URI points to a tarball and the `dockerfile` parameter is also specified, there must be a file with the corresponding path inside the tarball.
Boolean q = false; // Boolean | Suppress verbose build output.
Boolean nocache = false; // Boolean | Do not use the cache when building the image.
String cachefrom = "cachefrom_example"; // String | JSON array of images used for build cache resolution.
String pull = "pull_example"; // String | Attempt to pull the image even if an older image exists locally.
Boolean rm = true; // Boolean | Remove intermediate containers after a successful build.
Boolean forcerm = false; // Boolean | Always remove intermediate containers, even upon failure.
Integer memory = 56; // Integer | Set memory limit for build.
Integer memswap = 56; // Integer | Total memory (memory + swap). Set as `-1` to disable swap.
Integer cpushares = 56; // Integer | CPU shares (relative weight).
String cpusetcpus = "cpusetcpus_example"; // String | CPUs in which to allow execution (e.g., `0-3`, `0,1`).
Integer cpuperiod = 56; // Integer | The length of a CPU period in microseconds.
Integer cpuquota = 56; // Integer | Microseconds of CPU time that the container can get in a CPU period.
String buildargs = "buildargs_example"; // String | JSON map of string pairs for build-time variables. Users pass these values at build-time. Docker uses the buildargs as the environment context for commands run via the `Dockerfile` RUN instruction, or for variable expansion in other `Dockerfile` instructions. This is not meant for passing secret values.  For example, the build arg `FOO=bar` would become `{\"FOO\":\"bar\"}` in JSON. This would result in the the query parameter `buildargs={\"FOO\":\"bar\"}`. Note that `{\"FOO\":\"bar\"}` should be URI component encoded.  [Read more about the buildargs instruction.](https://docs.docker.com/engine/reference/builder/#arg) 
Integer shmsize = 56; // Integer | Size of `/dev/shm` in bytes. The size must be greater than 0. If omitted the system uses 64MB.
Boolean squash = true; // Boolean | Squash the resulting images layers into a single layer. *(Experimental release only.)*
String labels = "labels_example"; // String | Arbitrary key/value labels to set on the image, as a JSON map of string pairs.
String networkmode = "networkmode_example"; // String | Sets the networking mode for the run commands during build. Supported standard values are: `bridge`, `host`, `none`, and `container:<name|id>`. Any other value is taken as a custom network's name to which this container should connect to.
String contentType = "application/x-tar"; // String | 
String xRegistryConfig = "xRegistryConfig_example"; // String | This is a base64-encoded JSON object with auth configurations for multiple registries that a build may refer to.  The key is a registry URL, and the value is an auth configuration object, [as described in the authentication section](#section/Authentication). For example:  ``` {   \"docker.example.com\": {     \"username\": \"janedoe\",     \"password\": \"hunter2\"   },   \"https://index.docker.io/v1/\": {     \"username\": \"mobydock\",     \"password\": \"conta1n3rize14\"   } } ```  Only the registry domain name (and port if not the default 443) are required. However, for legacy reasons, the Docker Hub registry must be specified with both a `https://` prefix and a `/v1/` suffix even though Docker will prefer to use the v2 registry API. 
String platform = ""; // String | Platform in the format os[/arch[/variant]]
try {
    Void result = apiInstance.imageBuild(inputStream, dockerfile, t, extrahosts, remote, q, nocache, cachefrom, pull, rm, forcerm, memory, memswap, cpushares, cpusetcpus, cpuperiod, cpuquota, buildargs, shmsize, squash, labels, networkmode, contentType, xRegistryConfig, platform);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageBuild");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **inputStream** | **byte[]**| A tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz. | [optional]
 **dockerfile** | **String**| Path within the build context to the &#x60;Dockerfile&#x60;. This is ignored if &#x60;remote&#x60; is specified and points to an external &#x60;Dockerfile&#x60;. | [optional] [default to Dockerfile]
 **t** | **String**| A name and optional tag to apply to the image in the &#x60;name:tag&#x60; format. If you omit the tag the default &#x60;latest&#x60; value is assumed. You can provide several &#x60;t&#x60; parameters. | [optional]
 **extrahosts** | **String**| Extra hosts to add to /etc/hosts | [optional]
 **remote** | **String**| A Git repository URI or HTTP/HTTPS context URI. If the URI points to a single text file, the file’s contents are placed into a file called &#x60;Dockerfile&#x60; and the image is built from that file. If the URI points to a tarball, the file is downloaded by the daemon and the contents therein used as the context for the build. If the URI points to a tarball and the &#x60;dockerfile&#x60; parameter is also specified, there must be a file with the corresponding path inside the tarball. | [optional]
 **q** | **Boolean**| Suppress verbose build output. | [optional] [default to false]
 **nocache** | **Boolean**| Do not use the cache when building the image. | [optional] [default to false]
 **cachefrom** | **String**| JSON array of images used for build cache resolution. | [optional]
 **pull** | **String**| Attempt to pull the image even if an older image exists locally. | [optional]
 **rm** | **Boolean**| Remove intermediate containers after a successful build. | [optional] [default to true]
 **forcerm** | **Boolean**| Always remove intermediate containers, even upon failure. | [optional] [default to false]
 **memory** | **Integer**| Set memory limit for build. | [optional]
 **memswap** | **Integer**| Total memory (memory + swap). Set as &#x60;-1&#x60; to disable swap. | [optional]
 **cpushares** | **Integer**| CPU shares (relative weight). | [optional]
 **cpusetcpus** | **String**| CPUs in which to allow execution (e.g., &#x60;0-3&#x60;, &#x60;0,1&#x60;). | [optional]
 **cpuperiod** | **Integer**| The length of a CPU period in microseconds. | [optional]
 **cpuquota** | **Integer**| Microseconds of CPU time that the container can get in a CPU period. | [optional]
 **buildargs** | **String**| JSON map of string pairs for build-time variables. Users pass these values at build-time. Docker uses the buildargs as the environment context for commands run via the &#x60;Dockerfile&#x60; RUN instruction, or for variable expansion in other &#x60;Dockerfile&#x60; instructions. This is not meant for passing secret values.  For example, the build arg &#x60;FOO&#x3D;bar&#x60; would become &#x60;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60; in JSON. This would result in the the query parameter &#x60;buildargs&#x3D;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60;. Note that &#x60;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60; should be URI component encoded.  [Read more about the buildargs instruction.](https://docs.docker.com/engine/reference/builder/#arg)  | [optional]
 **shmsize** | **Integer**| Size of &#x60;/dev/shm&#x60; in bytes. The size must be greater than 0. If omitted the system uses 64MB. | [optional]
 **squash** | **Boolean**| Squash the resulting images layers into a single layer. *(Experimental release only.)* | [optional]
 **labels** | **String**| Arbitrary key/value labels to set on the image, as a JSON map of string pairs. | [optional]
 **networkmode** | **String**| Sets the networking mode for the run commands during build. Supported standard values are: &#x60;bridge&#x60;, &#x60;host&#x60;, &#x60;none&#x60;, and &#x60;container:&lt;name|id&gt;&#x60;. Any other value is taken as a custom network&#39;s name to which this container should connect to. | [optional]
 **contentType** | **String**|  | [optional] [default to application/x-tar] [enum: application/x-tar]
 **xRegistryConfig** | **String**| This is a base64-encoded JSON object with auth configurations for multiple registries that a build may refer to.  The key is a registry URL, and the value is an auth configuration object, [as described in the authentication section](#section/Authentication). For example:  &#x60;&#x60;&#x60; {   \&quot;docker.example.com\&quot;: {     \&quot;username\&quot;: \&quot;janedoe\&quot;,     \&quot;password\&quot;: \&quot;hunter2\&quot;   },   \&quot;https://index.docker.io/v1/\&quot;: {     \&quot;username\&quot;: \&quot;mobydock\&quot;,     \&quot;password\&quot;: \&quot;conta1n3rize14\&quot;   } } &#x60;&#x60;&#x60;  Only the registry domain name (and port if not the default 443) are required. However, for legacy reasons, the Docker Hub registry must be specified with both a &#x60;https://&#x60; prefix and a &#x60;/v1/&#x60; suffix even though Docker will prefer to use the v2 registry API.  | [optional]
 **platform** | **String**| Platform in the format os[/arch[/variant]] | [optional] [default to ]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json

<a name="imageCommit"></a>
# **imageCommit**
> IdResponse imageCommit(containerConfig, container, repo, tag, comment, author, pause, changes)

Create a new image from a container

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
ContainerConfig containerConfig = new ContainerConfig(); // ContainerConfig | The container configuration
String container = "container_example"; // String | The ID or name of the container to commit
String repo = "repo_example"; // String | Repository name for the created image
String tag = "tag_example"; // String | Tag name for the create image
String comment = "comment_example"; // String | Commit message
String author = "author_example"; // String | Author of the image (e.g., `John Hannibal Smith <hannibal@a-team.com>`)
Boolean pause = true; // Boolean | Whether to pause the container before committing
String changes = "changes_example"; // String | `Dockerfile` instructions to apply while committing
try {
    IdResponse result = apiInstance.imageCommit(containerConfig, container, repo, tag, comment, author, pause, changes);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageCommit");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **containerConfig** | [**ContainerConfig**](ContainerConfig.md)| The container configuration | [optional]
 **container** | **String**| The ID or name of the container to commit | [optional]
 **repo** | **String**| Repository name for the created image | [optional]
 **tag** | **String**| Tag name for the create image | [optional]
 **comment** | **String**| Commit message | [optional]
 **author** | **String**| Author of the image (e.g., &#x60;John Hannibal Smith &lt;hannibal@a-team.com&gt;&#x60;) | [optional]
 **pause** | **Boolean**| Whether to pause the container before committing | [optional] [default to true]
 **changes** | **String**| &#x60;Dockerfile&#x60; instructions to apply while committing | [optional]

### Return type

[**IdResponse**](IdResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="imageCreate"></a>
# **imageCreate**
> Void imageCreate(fromImage, fromSrc, repo, tag, inputImage, xRegistryAuth, platform)

Create an image

Create an image by either pulling it from a registry or importing it.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String fromImage = "fromImage_example"; // String | Name of the image to pull. The name may include a tag or digest. This parameter may only be used when pulling an image. The pull is cancelled if the HTTP connection is closed.
String fromSrc = "fromSrc_example"; // String | Source to import. The value may be a URL from which the image can be retrieved or `-` to read the image from the request body. This parameter may only be used when importing an image.
String repo = "repo_example"; // String | Repository name given to an image when it is imported. The repo may include a tag. This parameter may only be used when importing an image.
String tag = "tag_example"; // String | Tag or digest. If empty when pulling an image, this causes all tags for the given image to be pulled.
String inputImage = "inputImage_example"; // String | Image content if the value `-` has been specified in fromSrc query parameter
String xRegistryAuth = "xRegistryAuth_example"; // String | A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication)
String platform = ""; // String | Platform in the format os[/arch[/variant]]
try {
    Void result = apiInstance.imageCreate(fromImage, fromSrc, repo, tag, inputImage, xRegistryAuth, platform);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageCreate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **fromImage** | **String**| Name of the image to pull. The name may include a tag or digest. This parameter may only be used when pulling an image. The pull is cancelled if the HTTP connection is closed. | [optional]
 **fromSrc** | **String**| Source to import. The value may be a URL from which the image can be retrieved or &#x60;-&#x60; to read the image from the request body. This parameter may only be used when importing an image. | [optional]
 **repo** | **String**| Repository name given to an image when it is imported. The repo may include a tag. This parameter may only be used when importing an image. | [optional]
 **tag** | **String**| Tag or digest. If empty when pulling an image, this causes all tags for the given image to be pulled. | [optional]
 **inputImage** | **String**| Image content if the value &#x60;-&#x60; has been specified in fromSrc query parameter | [optional]
 **xRegistryAuth** | **String**| A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication) | [optional]
 **platform** | **String**| Platform in the format os[/arch[/variant]] | [optional] [default to ]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain, application/octet-stream
 - **Accept**: application/json

<a name="imageDelete"></a>
# **imageDelete**
> List&lt;ImageDeleteResponseItem&gt; imageDelete(name, force, noprune)

Remove an image

Remove an image, along with any untagged parent images that were referenced by that image.  Images can&#39;t be removed if they have descendant images, are being used by a running container or are being used by a build. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or ID
Boolean force = false; // Boolean | Remove the image even if it is being used by stopped containers or has other tags
Boolean noprune = false; // Boolean | Do not delete untagged parent images
try {
    List<ImageDeleteResponseItem> result = apiInstance.imageDelete(name, force, noprune);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageDelete");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or ID |
 **force** | **Boolean**| Remove the image even if it is being used by stopped containers or has other tags | [optional] [default to false]
 **noprune** | **Boolean**| Do not delete untagged parent images | [optional] [default to false]

### Return type

[**List&lt;ImageDeleteResponseItem&gt;**](ImageDeleteResponseItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageGet"></a>
# **imageGet**
> byte[] imageGet(name)

Export an image

Get a tarball containing all images and metadata for a repository.  If &#x60;name&#x60; is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned. If &#x60;name&#x60; is an image ID, similarly only that image (and its parents) are returned, but with the exclusion of the &#x60;repositories&#x60; file in the tarball, as there were no image names referenced.  ### Image tarball format  An image tarball contains one directory per image layer (named using its long ID), each containing these files:  - &#x60;VERSION&#x60;: currently &#x60;1.0&#x60; - the file format version - &#x60;json&#x60;: detailed layer information, similar to &#x60;docker inspect layer_id&#x60; - &#x60;layer.tar&#x60;: A tarfile containing the filesystem changes in this layer  The &#x60;layer.tar&#x60; file contains &#x60;aufs&#x60; style &#x60;.wh..wh.aufs&#x60; files and directories for storing attribute changes and deletions.  If the tarball defines a repository, the tarball should also include a &#x60;repositories&#x60; file at the root that contains a list of repository and tag names mapped to layer IDs.  &#x60;&#x60;&#x60;json {   \&quot;hello-world\&quot;: {     \&quot;latest\&quot;: \&quot;565a9d68a73f6706862bfe8409a7f659776d4d60a8d096eb4a3cbce6999cc2a1\&quot;   } } &#x60;&#x60;&#x60; 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or ID
try {
    byte[] result = apiInstance.imageGet(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or ID |

### Return type

**byte[]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/x-tar

<a name="imageGetAll"></a>
# **imageGetAll**
> byte[] imageGetAll(names)

Export several images

Get a tarball containing all images and metadata for several image repositories.  For each value of the &#x60;names&#x60; parameter: if it is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned; if it is an image ID, similarly only that image (and its parents) are returned and there would be no names referenced in the &#39;repositories&#39; file for this image ID.  For details on the format, see [the export image endpoint](#operation/ImageGet). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
List<String> names = Arrays.asList("names_example"); // List<String> | Image names to filter by
try {
    byte[] result = apiInstance.imageGetAll(names);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageGetAll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **names** | [**List&lt;String&gt;**](String.md)| Image names to filter by | [optional]

### Return type

**byte[]**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/x-tar

<a name="imageHistory"></a>
# **imageHistory**
> List&lt;HistoryResponseItem&gt; imageHistory(name)

Get the history of an image

Return parent layers of an image.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or ID
try {
    List<HistoryResponseItem> result = apiInstance.imageHistory(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageHistory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or ID |

### Return type

[**List&lt;HistoryResponseItem&gt;**](HistoryResponseItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageInspect"></a>
# **imageInspect**
> Image imageInspect(name)

Inspect an image

Return low-level information about an image.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or id
try {
    Image result = apiInstance.imageInspect(name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageInspect");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or id |

### Return type

[**Image**](Image.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageList"></a>
# **imageList**
> List&lt;ImageSummary&gt; imageList(all, filters, digests)

List Images

Returns a list of images on the server. Note that it uses a different, smaller representation of an image than inspecting a single image.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
Boolean all = false; // Boolean | Show all images. Only images from a final layer (no children) are shown by default.
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the images list. Available filters:  - `before`=(`<image-name>[:<tag>]`,  `<image id>` or `<image@digest>`) - `dangling=true` - `label=key` or `label=\"key=value\"` of an image label - `reference`=(`<image-name>[:<tag>]`) - `since`=(`<image-name>[:<tag>]`,  `<image id>` or `<image@digest>`) 
Boolean digests = false; // Boolean | Show digest information as a `RepoDigests` field on each image.
try {
    List<ImageSummary> result = apiInstance.imageList(all, filters, digests);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageList");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **all** | **Boolean**| Show all images. Only images from a final layer (no children) are shown by default. | [optional] [default to false]
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the images list. Available filters:  - &#x60;before&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;,  &#x60;&lt;image id&gt;&#x60; or &#x60;&lt;image@digest&gt;&#x60;) - &#x60;dangling&#x3D;true&#x60; - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; of an image label - &#x60;reference&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;) - &#x60;since&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;,  &#x60;&lt;image id&gt;&#x60; or &#x60;&lt;image@digest&gt;&#x60;)  | [optional]
 **digests** | **Boolean**| Show digest information as a &#x60;RepoDigests&#x60; field on each image. | [optional] [default to false]

### Return type

[**List&lt;ImageSummary&gt;**](ImageSummary.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageLoad"></a>
# **imageLoad**
> Void imageLoad(imagesTarball, quiet)

Import images

Load a set of images and tags into a repository.  For details on the format, see [the export image endpoint](#operation/ImageGet). 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
byte[] imagesTarball = BINARY_DATA_HERE; // byte[] | Tar archive containing images
Boolean quiet = false; // Boolean | Suppress progress details during load.
try {
    Void result = apiInstance.imageLoad(imagesTarball, quiet);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageLoad");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **imagesTarball** | **byte[]**| Tar archive containing images | [optional]
 **quiet** | **Boolean**| Suppress progress details during load. | [optional] [default to false]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-tar
 - **Accept**: application/json

<a name="imagePrune"></a>
# **imagePrune**
> ImagePruneResponse imagePrune(filters)

Delete unused images

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String filters = "filters_example"; // String | Filters to process on the prune list, encoded as JSON (a `map[string][]string`). Available filters:  - `dangling=<boolean>` When set to `true` (or `1`), prune only    unused *and* untagged images. When set to `false`    (or `0`), all unused images are pruned. - `until=<string>` Prune images created before this timestamp. The `<timestamp>` can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. `10m`, `1h30m`) computed relative to the daemon machine’s time. - `label` (`label=<key>`, `label=<key>=<value>`, `label!=<key>`, or `label!=<key>=<value>`) Prune images with (or without, in case `label!=...` is used) the specified labels. 
try {
    ImagePruneResponse result = apiInstance.imagePrune(filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imagePrune");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filters** | **String**| Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;). Available filters:  - &#x60;dangling&#x3D;&lt;boolean&gt;&#x60; When set to &#x60;true&#x60; (or &#x60;1&#x60;), prune only    unused *and* untagged images. When set to &#x60;false&#x60;    (or &#x60;0&#x60;), all unused images are pruned. - &#x60;until&#x3D;&lt;string&gt;&#x60; Prune images created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune images with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  | [optional]

### Return type

[**ImagePruneResponse**](ImagePruneResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imagePush"></a>
# **imagePush**
> Void imagePush(name, xRegistryAuth, tag)

Push an image

Push an image to a registry.  If you wish to push an image on to a private registry, that image must already have a tag which references the registry. For example, &#x60;registry.example.com/myimage:latest&#x60;.  The push is cancelled if the HTTP connection is closed. 

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or ID.
String xRegistryAuth = "xRegistryAuth_example"; // String | A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication)
String tag = "tag_example"; // String | The tag to associate with the image on the registry.
try {
    Void result = apiInstance.imagePush(name, xRegistryAuth, tag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imagePush");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or ID. |
 **xRegistryAuth** | **String**| A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication) |
 **tag** | **String**| The tag to associate with the image on the registry. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/octet-stream
 - **Accept**: application/json, text/plain

<a name="imageSearch"></a>
# **imageSearch**
> List&lt;ImageSearchResponseItem&gt; imageSearch(term, limit, filters)

Search images

Search for an image on Docker Hub.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String term = "term_example"; // String | Term to search
Integer limit = 56; // Integer | Maximum number of results to return
String filters = "filters_example"; // String | A JSON encoded value of the filters (a `map[string][]string`) to process on the images list. Available filters:  - `is-automated=(true|false)` - `is-official=(true|false)` - `stars=<number>` Matches images that has at least 'number' stars. 
try {
    List<ImageSearchResponseItem> result = apiInstance.imageSearch(term, limit, filters);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageSearch");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **term** | **String**| Term to search |
 **limit** | **Integer**| Maximum number of results to return | [optional]
 **filters** | **String**| A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the images list. Available filters:  - &#x60;is-automated&#x3D;(true|false)&#x60; - &#x60;is-official&#x3D;(true|false)&#x60; - &#x60;stars&#x3D;&lt;number&gt;&#x60; Matches images that has at least &#39;number&#39; stars.  | [optional]

### Return type

[**List&lt;ImageSearchResponseItem&gt;**](ImageSearchResponseItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json

<a name="imageTag"></a>
# **imageTag**
> Void imageTag(name, repo, tag)

Tag an image

Tag an image so that it becomes part of a repository.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ImageApi;


ImageApi apiInstance = new ImageApi();
String name = "name_example"; // String | Image name or ID to tag.
String repo = "repo_example"; // String | The repository to tag in. For example, `someuser/someimage`.
String tag = "tag_example"; // String | The name of the new tag.
try {
    Void result = apiInstance.imageTag(name, repo, tag);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ImageApi#imageTag");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**| Image name or ID to tag. |
 **repo** | **String**| The repository to tag in. For example, &#x60;someuser/someimage&#x60;. | [optional]
 **tag** | **String**| The name of the new tag. | [optional]

### Return type

[**Void**](.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, text/plain
 - **Accept**: application/json, text/plain

