package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.BuildPruneResponse;
import io.swagger.client.model.ContainerConfig;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.HistoryResponseItem;
import io.swagger.client.model.IdResponse;
import io.swagger.client.model.Image;
import io.swagger.client.model.ImageDeleteResponseItem;
import io.swagger.client.model.ImagePruneResponse;
import io.swagger.client.model.ImageSearchResponseItem;
import io.swagger.client.model.ImageSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ImageApi {
  /**
   * Delete builder cache
   * 
   * @return Call&lt;BuildPruneResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("build/prune")
  Call<BuildPruneResponse> buildPrune();
    

  /**
   * Build an image
   * Build an image from a tar archive with a &#x60;Dockerfile&#x60; in it.  The &#x60;Dockerfile&#x60; specifies how the image is built from the tar archive. It is typically in the archive&#39;s root, but can be at a different path or have a different name by specifying the &#x60;dockerfile&#x60; parameter. [See the &#x60;Dockerfile&#x60; reference for more information](https://docs.docker.com/engine/reference/builder/).  The Docker daemon performs a preliminary validation of the &#x60;Dockerfile&#x60; before starting the build, and returns an error if the syntax is incorrect. After that, each instruction is run one-by-one until the ID of the new image is output.  The build is canceled if the client drops the connection by quitting or being killed. 
   * @param inputStream A tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz. (optional)
   * @param dockerfile Path within the build context to the &#x60;Dockerfile&#x60;. This is ignored if &#x60;remote&#x60; is specified and points to an external &#x60;Dockerfile&#x60;. (optional, default to Dockerfile)
   * @param t A name and optional tag to apply to the image in the &#x60;name:tag&#x60; format. If you omit the tag the default &#x60;latest&#x60; value is assumed. You can provide several &#x60;t&#x60; parameters. (optional)
   * @param extrahosts Extra hosts to add to /etc/hosts (optional)
   * @param remote A Git repository URI or HTTP/HTTPS context URI. If the URI points to a single text file, the file’s contents are placed into a file called &#x60;Dockerfile&#x60; and the image is built from that file. If the URI points to a tarball, the file is downloaded by the daemon and the contents therein used as the context for the build. If the URI points to a tarball and the &#x60;dockerfile&#x60; parameter is also specified, there must be a file with the corresponding path inside the tarball. (optional)
   * @param q Suppress verbose build output. (optional, default to false)
   * @param nocache Do not use the cache when building the image. (optional, default to false)
   * @param cachefrom JSON array of images used for build cache resolution. (optional)
   * @param pull Attempt to pull the image even if an older image exists locally. (optional)
   * @param rm Remove intermediate containers after a successful build. (optional, default to true)
   * @param forcerm Always remove intermediate containers, even upon failure. (optional, default to false)
   * @param memory Set memory limit for build. (optional)
   * @param memswap Total memory (memory + swap). Set as &#x60;-1&#x60; to disable swap. (optional)
   * @param cpushares CPU shares (relative weight). (optional)
   * @param cpusetcpus CPUs in which to allow execution (e.g., &#x60;0-3&#x60;, &#x60;0,1&#x60;). (optional)
   * @param cpuperiod The length of a CPU period in microseconds. (optional)
   * @param cpuquota Microseconds of CPU time that the container can get in a CPU period. (optional)
   * @param buildargs JSON map of string pairs for build-time variables. Users pass these values at build-time. Docker uses the buildargs as the environment context for commands run via the &#x60;Dockerfile&#x60; RUN instruction, or for variable expansion in other &#x60;Dockerfile&#x60; instructions. This is not meant for passing secret values.  For example, the build arg &#x60;FOO&#x3D;bar&#x60; would become &#x60;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60; in JSON. This would result in the the query parameter &#x60;buildargs&#x3D;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60;. Note that &#x60;{\&quot;FOO\&quot;:\&quot;bar\&quot;}&#x60; should be URI component encoded.  [Read more about the buildargs instruction.](https://docs.docker.com/engine/reference/builder/#arg)  (optional)
   * @param shmsize Size of &#x60;/dev/shm&#x60; in bytes. The size must be greater than 0. If omitted the system uses 64MB. (optional)
   * @param squash Squash the resulting images layers into a single layer. *(Experimental release only.)* (optional)
   * @param labels Arbitrary key/value labels to set on the image, as a JSON map of string pairs. (optional)
   * @param networkmode Sets the networking mode for the run commands during build. Supported standard values are: &#x60;bridge&#x60;, &#x60;host&#x60;, &#x60;none&#x60;, and &#x60;container:&lt;name|id&gt;&#x60;. Any other value is taken as a custom network&#39;s name to which this container should connect to. (optional)
   * @param contentType  (optional, default to application/x-tar)
   * @param xRegistryConfig This is a base64-encoded JSON object with auth configurations for multiple registries that a build may refer to.  The key is a registry URL, and the value is an auth configuration object, [as described in the authentication section](#section/Authentication). For example:  &#x60;&#x60;&#x60; {   \&quot;docker.example.com\&quot;: {     \&quot;username\&quot;: \&quot;janedoe\&quot;,     \&quot;password\&quot;: \&quot;hunter2\&quot;   },   \&quot;https://index.docker.io/v1/\&quot;: {     \&quot;username\&quot;: \&quot;mobydock\&quot;,     \&quot;password\&quot;: \&quot;conta1n3rize14\&quot;   } } &#x60;&#x60;&#x60;  Only the registry domain name (and port if not the default 443) are required. However, for legacy reasons, the Docker Hub registry must be specified with both a &#x60;https://&#x60; prefix and a &#x60;/v1/&#x60; suffix even though Docker will prefer to use the v2 registry API.  (optional)
   * @param platform Platform in the format os[/arch[/variant]] (optional, default to )
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/octet-stream"
  })
  @POST("build")
  Call<Void> imageBuild(
    @retrofit2.http.Body byte[] inputStream, @retrofit2.http.Query("dockerfile") String dockerfile, @retrofit2.http.Query("t") String t, @retrofit2.http.Query("extrahosts") String extrahosts, @retrofit2.http.Query("remote") String remote, @retrofit2.http.Query("q") Boolean q, @retrofit2.http.Query("nocache") Boolean nocache, @retrofit2.http.Query("cachefrom") String cachefrom, @retrofit2.http.Query("pull") String pull, @retrofit2.http.Query("rm") Boolean rm, @retrofit2.http.Query("forcerm") Boolean forcerm, @retrofit2.http.Query("memory") Integer memory, @retrofit2.http.Query("memswap") Integer memswap, @retrofit2.http.Query("cpushares") Integer cpushares, @retrofit2.http.Query("cpusetcpus") String cpusetcpus, @retrofit2.http.Query("cpuperiod") Integer cpuperiod, @retrofit2.http.Query("cpuquota") Integer cpuquota, @retrofit2.http.Query("buildargs") String buildargs, @retrofit2.http.Query("shmsize") Integer shmsize, @retrofit2.http.Query("squash") Boolean squash, @retrofit2.http.Query("labels") String labels, @retrofit2.http.Query("networkmode") String networkmode, @retrofit2.http.Header("Content-type") String contentType, @retrofit2.http.Header("X-Registry-Config") String xRegistryConfig, @retrofit2.http.Query("platform") String platform
  );

  /**
   * Create a new image from a container
   * 
   * @param containerConfig The container configuration (optional)
   * @param container The ID or name of the container to commit (optional)
   * @param repo Repository name for the created image (optional)
   * @param tag Tag name for the create image (optional)
   * @param comment Commit message (optional)
   * @param author Author of the image (e.g., &#x60;John Hannibal Smith &lt;hannibal@a-team.com&gt;&#x60;) (optional)
   * @param pause Whether to pause the container before committing (optional, default to true)
   * @param changes &#x60;Dockerfile&#x60; instructions to apply while committing (optional)
   * @return Call&lt;IdResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("commit")
  Call<IdResponse> imageCommit(
    @retrofit2.http.Body ContainerConfig containerConfig, @retrofit2.http.Query("container") String container, @retrofit2.http.Query("repo") String repo, @retrofit2.http.Query("tag") String tag, @retrofit2.http.Query("comment") String comment, @retrofit2.http.Query("author") String author, @retrofit2.http.Query("pause") Boolean pause, @retrofit2.http.Query("changes") String changes
  );

  /**
   * Create an image
   * Create an image by either pulling it from a registry or importing it.
   * @param fromImage Name of the image to pull. The name may include a tag or digest. This parameter may only be used when pulling an image. The pull is cancelled if the HTTP connection is closed. (optional)
   * @param fromSrc Source to import. The value may be a URL from which the image can be retrieved or &#x60;-&#x60; to read the image from the request body. This parameter may only be used when importing an image. (optional)
   * @param repo Repository name given to an image when it is imported. The repo may include a tag. This parameter may only be used when importing an image. (optional)
   * @param tag Tag or digest. If empty when pulling an image, this causes all tags for the given image to be pulled. (optional)
   * @param inputImage Image content if the value &#x60;-&#x60; has been specified in fromSrc query parameter (optional)
   * @param xRegistryAuth A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication) (optional)
   * @param platform Platform in the format os[/arch[/variant]] (optional, default to )
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:text/plain"
  })
  @POST("images/create")
  Call<Void> imageCreate(
    @retrofit2.http.Query("fromImage") String fromImage, @retrofit2.http.Query("fromSrc") String fromSrc, @retrofit2.http.Query("repo") String repo, @retrofit2.http.Query("tag") String tag, @retrofit2.http.Body String inputImage, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth, @retrofit2.http.Query("platform") String platform
  );

  /**
   * Remove an image
   * Remove an image, along with any untagged parent images that were referenced by that image.  Images can&#39;t be removed if they have descendant images, are being used by a running container or are being used by a build. 
   * @param name Image name or ID (required)
   * @param force Remove the image even if it is being used by stopped containers or has other tags (optional, default to false)
   * @param noprune Do not delete untagged parent images (optional, default to false)
   * @return Call&lt;List&lt;ImageDeleteResponseItem&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("images/{name}")
  Call<List<ImageDeleteResponseItem>> imageDelete(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("force") Boolean force, @retrofit2.http.Query("noprune") Boolean noprune
  );

  /**
   * Export an image
   * Get a tarball containing all images and metadata for a repository.  If &#x60;name&#x60; is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned. If &#x60;name&#x60; is an image ID, similarly only that image (and its parents) are returned, but with the exclusion of the &#x60;repositories&#x60; file in the tarball, as there were no image names referenced.  ### Image tarball format  An image tarball contains one directory per image layer (named using its long ID), each containing these files:  - &#x60;VERSION&#x60;: currently &#x60;1.0&#x60; - the file format version - &#x60;json&#x60;: detailed layer information, similar to &#x60;docker inspect layer_id&#x60; - &#x60;layer.tar&#x60;: A tarfile containing the filesystem changes in this layer  The &#x60;layer.tar&#x60; file contains &#x60;aufs&#x60; style &#x60;.wh..wh.aufs&#x60; files and directories for storing attribute changes and deletions.  If the tarball defines a repository, the tarball should also include a &#x60;repositories&#x60; file at the root that contains a list of repository and tag names mapped to layer IDs.  &#x60;&#x60;&#x60;json {   \&quot;hello-world\&quot;: {     \&quot;latest\&quot;: \&quot;565a9d68a73f6706862bfe8409a7f659776d4d60a8d096eb4a3cbce6999cc2a1\&quot;   } } &#x60;&#x60;&#x60; 
   * @param name Image name or ID (required)
   * @return Call&lt;byte[]&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/{name}/get")
  Call<byte[]> imageGet(
    @retrofit2.http.Path("name") String name
  );

  /**
   * Export several images
   * Get a tarball containing all images and metadata for several image repositories.  For each value of the &#x60;names&#x60; parameter: if it is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned; if it is an image ID, similarly only that image (and its parents) are returned and there would be no names referenced in the &#39;repositories&#39; file for this image ID.  For details on the format, see [the export image endpoint](#operation/ImageGet). 
   * @param names Image names to filter by (optional)
   * @return Call&lt;byte[]&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/get")
  Call<byte[]> imageGetAll(
    @retrofit2.http.Query("names") CSVParams names
  );

  /**
   * Get the history of an image
   * Return parent layers of an image.
   * @param name Image name or ID (required)
   * @return Call&lt;List&lt;HistoryResponseItem&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/{name}/history")
  Call<List<HistoryResponseItem>> imageHistory(
    @retrofit2.http.Path("name") String name
  );

  /**
   * Inspect an image
   * Return low-level information about an image.
   * @param name Image name or id (required)
   * @return Call&lt;Image&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/{name}/json")
  Call<Image> imageInspect(
    @retrofit2.http.Path("name") String name
  );

  /**
   * List Images
   * Returns a list of images on the server. Note that it uses a different, smaller representation of an image than inspecting a single image.
   * @param all Show all images. Only images from a final layer (no children) are shown by default. (optional, default to false)
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the images list. Available filters:  - &#x60;before&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;,  &#x60;&lt;image id&gt;&#x60; or &#x60;&lt;image@digest&gt;&#x60;) - &#x60;dangling&#x3D;true&#x60; - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; of an image label - &#x60;reference&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;) - &#x60;since&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;,  &#x60;&lt;image id&gt;&#x60; or &#x60;&lt;image@digest&gt;&#x60;)  (optional)
   * @param digests Show digest information as a &#x60;RepoDigests&#x60; field on each image. (optional, default to false)
   * @return Call&lt;List&lt;ImageSummary&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/json")
  Call<List<ImageSummary>> imageList(
    @retrofit2.http.Query("all") Boolean all, @retrofit2.http.Query("filters") String filters, @retrofit2.http.Query("digests") Boolean digests
  );

  /**
   * Import images
   * Load a set of images and tags into a repository.  For details on the format, see [the export image endpoint](#operation/ImageGet). 
   * @param imagesTarball Tar archive containing images (optional)
   * @param quiet Suppress progress details during load. (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/x-tar"
  })
  @POST("images/load")
  Call<Void> imageLoad(
    @retrofit2.http.Body byte[] imagesTarball, @retrofit2.http.Query("quiet") Boolean quiet
  );

  /**
   * Delete unused images
   * 
   * @param filters Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;). Available filters:  - &#x60;dangling&#x3D;&lt;boolean&gt;&#x60; When set to &#x60;true&#x60; (or &#x60;1&#x60;), prune only    unused *and* untagged images. When set to &#x60;false&#x60;    (or &#x60;0&#x60;), all unused images are pruned. - &#x60;until&#x3D;&lt;string&gt;&#x60; Prune images created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune images with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  (optional)
   * @return Call&lt;ImagePruneResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("images/prune")
  Call<ImagePruneResponse> imagePrune(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Push an image
   * Push an image to a registry.  If you wish to push an image on to a private registry, that image must already have a tag which references the registry. For example, &#x60;registry.example.com/myimage:latest&#x60;.  The push is cancelled if the HTTP connection is closed. 
   * @param name Image name or ID. (required)
   * @param xRegistryAuth A base64-encoded auth configuration. [See the authentication section for details.](#section/Authentication) (required)
   * @param tag The tag to associate with the image on the registry. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/octet-stream"
  })
  @POST("images/{name}/push")
  Call<Void> imagePush(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth, @retrofit2.http.Query("tag") String tag
  );

  /**
   * Search images
   * Search for an image on Docker Hub.
   * @param term Term to search (required)
   * @param limit Maximum number of results to return (optional)
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the images list. Available filters:  - &#x60;is-automated&#x3D;(true|false)&#x60; - &#x60;is-official&#x3D;(true|false)&#x60; - &#x60;stars&#x3D;&lt;number&gt;&#x60; Matches images that has at least &#39;number&#39; stars.  (optional)
   * @return Call&lt;List&lt;ImageSearchResponseItem&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("images/search")
  Call<List<ImageSearchResponseItem>> imageSearch(
    @retrofit2.http.Query("term") String term, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("filters") String filters
  );

  /**
   * Tag an image
   * Tag an image so that it becomes part of a repository.
   * @param name Image name or ID to tag. (required)
   * @param repo The repository to tag in. For example, &#x60;someuser/someimage&#x60;. (optional)
   * @param tag The name of the new tag. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("images/{name}/tag")
  Call<Void> imageTag(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("repo") String repo, @retrofit2.http.Query("tag") String tag
  );

}
