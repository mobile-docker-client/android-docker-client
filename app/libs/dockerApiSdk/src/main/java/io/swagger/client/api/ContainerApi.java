package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ContainerChangeResponseItem;
import io.swagger.client.model.ContainerCreateResponse;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerPruneResponse;
import io.swagger.client.model.ContainerSummary;
import io.swagger.client.model.ContainerTopResponse;
import io.swagger.client.model.ContainerUpdateResponse;
import io.swagger.client.model.ContainerWaitResponse;
import io.swagger.client.model.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ContainerApi {
  /**
   * Get an archive of a filesystem resource in a container
   * Get a tar archive of a resource in the filesystem of container id.
   * @param id ID or name of the container (required)
   * @param path Resource in the container’s filesystem to archive. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/archive")
  Call<Void> containerArchive(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("path") String path
  );

  /**
   * Get information about files in a container
   * A response header &#x60;X-Docker-Container-Path-Stat&#x60; is return containing a base64 - encoded JSON object with some filesystem header information about the path.
   * @param id ID or name of the container (required)
   * @param path Resource in the container’s filesystem to archive. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @HEAD("containers/{id}/archive")
  Call<Void> containerArchiveInfo(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("path") String path
  );

  /**
   * Attach to a container
   * Attach to a container to read its output or send it input. You can attach to the same container multiple times and you can reattach to containers that have been detached.  Either the &#x60;stream&#x60; or &#x60;logs&#x60; parameter must be &#x60;true&#x60; for this endpoint to do anything.  See [the documentation for the &#x60;docker attach&#x60; command](https://docs.docker.com/engine/reference/commandline/attach/) for more details.  ### Hijacking  This endpoint hijacks the HTTP connection to transport &#x60;stdin&#x60;, &#x60;stdout&#x60;, and &#x60;stderr&#x60; on the same socket.  This is the response from the daemon for an attach request:  &#x60;&#x60;&#x60; HTTP/1.1 200 OK Content-Type: application/vnd.docker.raw-stream  [STREAM] &#x60;&#x60;&#x60;  After the headers and two new lines, the TCP connection can now be used for raw, bidirectional communication between the client and server.  To hint potential proxies about connection hijacking, the Docker client can also optionally send connection upgrade headers.  For example, the client sends this request to upgrade the connection:  &#x60;&#x60;&#x60; POST /containers/16253994b7c4/attach?stream&#x3D;1&amp;stdout&#x3D;1 HTTP/1.1 Upgrade: tcp Connection: Upgrade &#x60;&#x60;&#x60;  The Docker daemon will respond with a &#x60;101 UPGRADED&#x60; response, and will similarly follow with the raw stream:  &#x60;&#x60;&#x60; HTTP/1.1 101 UPGRADED Content-Type: application/vnd.docker.raw-stream Connection: Upgrade Upgrade: tcp  [STREAM] &#x60;&#x60;&#x60;  ### Stream format  When the TTY setting is disabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream over the hijacked connected is multiplexed to separate out &#x60;stdout&#x60; and &#x60;stderr&#x60;. The stream consists of a series of frames, each containing a header and a payload.  The header contains the information which the stream writes (&#x60;stdout&#x60; or &#x60;stderr&#x60;). It also contains the size of the associated frame encoded in the last four bytes (&#x60;uint32&#x60;).  It is encoded on the first eight bytes like this:  &#x60;&#x60;&#x60;go header :&#x3D; [8]byte{STREAM_TYPE, 0, 0, 0, SIZE1, SIZE2, SIZE3, SIZE4} &#x60;&#x60;&#x60;  &#x60;STREAM_TYPE&#x60; can be:  - 0: &#x60;stdin&#x60; (is written on &#x60;stdout&#x60;) - 1: &#x60;stdout&#x60; - 2: &#x60;stderr&#x60;  &#x60;SIZE1, SIZE2, SIZE3, SIZE4&#x60; are the four bytes of the &#x60;uint32&#x60; size encoded as big endian.  Following the header is the payload, which is the specified number of bytes of &#x60;STREAM_TYPE&#x60;.  The simplest way to implement this protocol is the following:  1. Read 8 bytes. 2. Choose &#x60;stdout&#x60; or &#x60;stderr&#x60; depending on the first byte. 3. Extract the frame size from the last four bytes. 4. Read the extracted size and output it on the correct output. 5. Goto 1.  ### Stream format when using a TTY  When the TTY setting is enabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream is not multiplexed. The data exchanged over the hijacked connection is simply the raw data from the process PTY and client&#39;s &#x60;stdin&#x60;. 
   * @param id ID or name of the container (required)
   * @param detachKeys Override the key sequence for detaching a container.Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60; or &#x60;_&#x60;. (optional)
   * @param logs Replay previous logs from the container.  This is useful for attaching to a container that has started and you want to output everything since the container started.  If &#x60;stream&#x60; is also enabled, once all the previous output has been returned, it will seamlessly transition into streaming current output.  (optional, default to false)
   * @param stream Stream attached streams from the time the request was made onwards (optional, default to false)
   * @param stdin Attach to &#x60;stdin&#x60; (optional, default to false)
   * @param stdout Attach to &#x60;stdout&#x60; (optional, default to false)
   * @param stderr Attach to &#x60;stderr&#x60; (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/attach")
  Call<Void> containerAttach(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("detachKeys") String detachKeys, @retrofit2.http.Query("logs") Boolean logs, @retrofit2.http.Query("stream") Boolean stream, @retrofit2.http.Query("stdin") Boolean stdin, @retrofit2.http.Query("stdout") Boolean stdout, @retrofit2.http.Query("stderr") Boolean stderr
  );

  /**
   * Attach to a container via a websocket
   * 
   * @param id ID or name of the container (required)
   * @param detachKeys Override the key sequence for detaching a container.Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60;, or &#x60;_&#x60;. (optional)
   * @param logs Return logs (optional, default to false)
   * @param stream Return stream (optional, default to false)
   * @param stdin Attach to &#x60;stdin&#x60; (optional, default to false)
   * @param stdout Attach to &#x60;stdout&#x60; (optional, default to false)
   * @param stderr Attach to &#x60;stderr&#x60; (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/attach/ws")
  Call<Void> containerAttachWebsocket(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("detachKeys") String detachKeys, @retrofit2.http.Query("logs") Boolean logs, @retrofit2.http.Query("stream") Boolean stream, @retrofit2.http.Query("stdin") Boolean stdin, @retrofit2.http.Query("stdout") Boolean stdout, @retrofit2.http.Query("stderr") Boolean stderr
  );

  /**
   * Get changes on a container’s filesystem
   * Returns which files in a container&#39;s filesystem have been added, deleted, or modified. The &#x60;Kind&#x60; of modification can be one of:  - &#x60;0&#x60;: Modified - &#x60;1&#x60;: Added - &#x60;2&#x60;: Deleted 
   * @param id ID or name of the container (required)
   * @return Call&lt;List&lt;ContainerChangeResponseItem&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/changes")
  Call<List<ContainerChangeResponseItem>> containerChanges(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Create a container
   * 
   * @param body Container to create (required)
   * @param name Assign the specified name to the container. Must match &#x60;/?[a-zA-Z0-9_-]+&#x60;. (optional)
   * @return Call&lt;ContainerCreateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/create")
  Call<ContainerCreateResponse> containerCreate(
    @retrofit2.http.Body  body, @retrofit2.http.Query("name") String name
  );

  /**
   * Remove a container
   * 
   * @param id ID or name of the container (required)
   * @param v Remove the volumes associated with the container. (optional, default to false)
   * @param force If the container is running, kill it before removing it. (optional, default to false)
   * @param link Remove the specified link associated with the container. (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("containers/{id}")
  Call<Void> containerDelete(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("v") Boolean v, @retrofit2.http.Query("force") Boolean force, @retrofit2.http.Query("link") Boolean link
  );

  /**
   * Export a container
   * Export the contents of a container as a tarball.
   * @param id ID or name of the container (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/export")
  Call<Void> containerExport(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Inspect a container
   * Return low-level information about a container.
   * @param id ID or name of the container (required)
   * @param size Return the size of container as fields &#x60;SizeRw&#x60; and &#x60;SizeRootFs&#x60; (optional, default to false)
   * @return Call&lt;ContainerInspectResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/json")
  Call<ContainerInspectResponse> containerInspect(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("size") Boolean size
  );

  /**
   * Kill a container
   * Send a POSIX signal to a container, defaulting to killing to the container.
   * @param id ID or name of the container (required)
   * @param signal Signal to send to the container as an integer or string (e.g. &#x60;SIGINT&#x60;) (optional, default to SIGKILL)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/kill")
  Call<Void> containerKill(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("signal") String signal
  );

  /**
   * List containers
   * Returns a list of containers. For details on the format, see [the inspect endpoint](#operation/ContainerInspect).  Note that it uses a different, smaller representation of a container than inspecting a single container. For example, the list of linked containers is not propagated . 
   * @param all Return all containers. By default, only running containers are shown (optional, default to false)
   * @param limit Return this number of most recently created containers, including non-running ones. (optional)
   * @param size Return the size of container as fields &#x60;SizeRw&#x60; and &#x60;SizeRootFs&#x60;. (optional, default to false)
   * @param filters Filters to process on the container list, encoded as JSON (a &#x60;map[string][]string&#x60;). For example, &#x60;{\&quot;status\&quot;: [\&quot;paused\&quot;]}&#x60; will only return paused containers. Available filters:  - &#x60;ancestor&#x60;&#x3D;(&#x60;&lt;image-name&gt;[:&lt;tag&gt;]&#x60;, &#x60;&lt;image id&gt;&#x60;, or &#x60;&lt;image@digest&gt;&#x60;) - &#x60;before&#x60;&#x3D;(&#x60;&lt;container id&gt;&#x60; or &#x60;&lt;container name&gt;&#x60;) - &#x60;expose&#x60;&#x3D;(&#x60;&lt;port&gt;[/&lt;proto&gt;]&#x60;|&#x60;&lt;startport-endport&gt;/[&lt;proto&gt;]&#x60;) - &#x60;exited&#x3D;&lt;int&gt;&#x60; containers with exit code of &#x60;&lt;int&gt;&#x60; - &#x60;health&#x60;&#x3D;(&#x60;starting&#x60;|&#x60;healthy&#x60;|&#x60;unhealthy&#x60;|&#x60;none&#x60;) - &#x60;id&#x3D;&lt;ID&gt;&#x60; a container&#39;s ID - &#x60;isolation&#x3D;&#x60;(&#x60;default&#x60;|&#x60;process&#x60;|&#x60;hyperv&#x60;) (Windows daemon only) - &#x60;is-task&#x3D;&#x60;(&#x60;true&#x60;|&#x60;false&#x60;) - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; of a container label - &#x60;name&#x3D;&lt;name&gt;&#x60; a container&#39;s name - &#x60;network&#x60;&#x3D;(&#x60;&lt;network id&gt;&#x60; or &#x60;&lt;network name&gt;&#x60;) - &#x60;publish&#x60;&#x3D;(&#x60;&lt;port&gt;[/&lt;proto&gt;]&#x60;|&#x60;&lt;startport-endport&gt;/[&lt;proto&gt;]&#x60;) - &#x60;since&#x60;&#x3D;(&#x60;&lt;container id&gt;&#x60; or &#x60;&lt;container name&gt;&#x60;) - &#x60;status&#x3D;&#x60;(&#x60;created&#x60;|&#x60;restarting&#x60;|&#x60;running&#x60;|&#x60;removing&#x60;|&#x60;paused&#x60;|&#x60;exited&#x60;|&#x60;dead&#x60;) - &#x60;volume&#x60;&#x3D;(&#x60;&lt;volume name&gt;&#x60; or &#x60;&lt;mount point destination&gt;&#x60;)  (optional)
   * @return Call&lt;ContainerSummary&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/json")
  Call<ContainerSummary> containerList(
    @retrofit2.http.Query("all") Boolean all, @retrofit2.http.Query("limit") Integer limit, @retrofit2.http.Query("size") Boolean size, @retrofit2.http.Query("filters") String filters
  );

  /**
   * Get container logs
   * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a container.  Note: This endpoint works only for containers with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging driver. 
   * @param id ID or name of the container (required)
   * @param follow Return the logs as a stream.  This will return a &#x60;101&#x60; HTTP response with a &#x60;Connection: upgrade&#x60; header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach).  (optional, default to false)
   * @param stdout Return logs from &#x60;stdout&#x60; (optional, default to false)
   * @param stderr Return logs from &#x60;stderr&#x60; (optional, default to false)
   * @param since Only return logs since this time, as a UNIX timestamp (optional, default to 0)
   * @param until Only return logs before this time, as a UNIX timestamp (optional, default to 0)
   * @param timestamps Add timestamps to every log line (optional, default to false)
   * @param tail Only return this number of log lines from the end of the logs. Specify as an integer or &#x60;all&#x60; to output all log lines. (optional, default to all)
   * @return Call&lt;String&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/logs")
  Call<String> containerLogs(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("follow") Boolean follow, @retrofit2.http.Query("stdout") Boolean stdout, @retrofit2.http.Query("stderr") Boolean stderr, @retrofit2.http.Query("since") Integer since, @retrofit2.http.Query("until") Integer until, @retrofit2.http.Query("timestamps") Boolean timestamps, @retrofit2.http.Query("tail") String tail
  );

  /**
   * Pause a container
   * Use the cgroups freezer to suspend all processes in a container.  Traditionally, when suspending a process the &#x60;SIGSTOP&#x60; signal is used, which is observable by the process being suspended. With the cgroups freezer the process is unaware, and unable to capture, that it is being suspended, and subsequently resumed. 
   * @param id ID or name of the container (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/pause")
  Call<Void> containerPause(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Delete stopped containers
   * 
   * @param filters Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;until&#x3D;&lt;timestamp&gt;&#x60; Prune containers created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune containers with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  (optional)
   * @return Call&lt;ContainerPruneResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/prune")
  Call<ContainerPruneResponse> containerPrune(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Rename a container
   * 
   * @param id ID or name of the container (required)
   * @param name New name for the container (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/rename")
  Call<Void> containerRename(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("name") String name
  );

  /**
   * Resize a container TTY
   * Resize the TTY for a container. You must restart the container for the resize to take effect.
   * @param id ID or name of the container (required)
   * @param h Height of the tty session in characters (optional)
   * @param w Width of the tty session in characters (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/octet-stream"
  })
  @POST("containers/{id}/resize")
  Call<Void> containerResize(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("h") Integer h, @retrofit2.http.Query("w") Integer w
  );

  /**
   * Restart a container
   * 
   * @param id ID or name of the container (required)
   * @param t Number of seconds to wait before killing the container (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/restart")
  Call<Void> containerRestart(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("t") Integer t
  );

  /**
   * Start a container
   * 
   * @param id ID or name of the container (required)
   * @param detachKeys Override the key sequence for detaching a container. Format is a single character &#x60;[a-Z]&#x60; or &#x60;ctrl-&lt;value&gt;&#x60; where &#x60;&lt;value&gt;&#x60; is one of: &#x60;a-z&#x60;, &#x60;@&#x60;, &#x60;^&#x60;, &#x60;[&#x60;, &#x60;,&#x60; or &#x60;_&#x60;. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/start")
  Call<Void> containerStart(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("detachKeys") String detachKeys
  );

  /**
   * Get container stats based on resource usage
   * This endpoint returns a live stream of a container’s resource usage statistics.  The &#x60;precpu_stats&#x60; is the CPU statistic of last read, which is used for calculating the CPU usage percentage. It is not the same as the &#x60;cpu_stats&#x60; field.  If either &#x60;precpu_stats.online_cpus&#x60; or &#x60;cpu_stats.online_cpus&#x60; is nil then for compatibility with older daemons the length of the corresponding &#x60;cpu_usage.percpu_usage&#x60; array should be used. 
   * @param id ID or name of the container (required)
   * @param stream Stream the output. If false, the stats will be output once and then it will disconnect. (optional, default to true)
   * @return Call&lt;Object&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/stats")
  Call<Object> containerStats(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("stream") Boolean stream
  );

  /**
   * Stop a container
   * 
   * @param id ID or name of the container (required)
   * @param t Number of seconds to wait before killing the container (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/stop")
  Call<Void> containerStop(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("t") Integer t
  );

  /**
   * List processes running inside a container
   * On Unix systems, this is done by running the &#x60;ps&#x60; command. This endpoint is not supported on Windows.
   * @param id ID or name of the container (required)
   * @param psArgs The arguments to pass to &#x60;ps&#x60;. For example, &#x60;aux&#x60; (optional, default to -ef)
   * @return Call&lt;ContainerTopResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("containers/{id}/top")
  Call<ContainerTopResponse> containerTop(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("ps_args") String psArgs
  );

  /**
   * Unpause a container
   * Resume a container which has been paused.
   * @param id ID or name of the container (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/unpause")
  Call<Void> containerUnpause(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Update a container
   * Change various configuration options of a container without having to recreate it.
   * @param id ID or name of the container (required)
   * @param update  (required)
   * @return Call&lt;ContainerUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/update")
  Call<ContainerUpdateResponse> containerUpdate(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body  update
  );

  /**
   * Wait for a container
   * Block until a container stops, then returns the exit code.
   * @param id ID or name of the container (required)
   * @param condition Wait until a container state reaches the given condition, either &#39;not-running&#39; (default), &#39;next-exit&#39;, or &#39;removed&#39;. (optional, default to not-running)
   * @return Call&lt;ContainerWaitResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/wait")
  Call<ContainerWaitResponse> containerWait(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("condition") String condition
  );

  /**
   * Extract an archive of files or folders to a directory in a container
   * Upload a tar archive to be extracted to a path in the filesystem of container id.
   * @param id ID or name of the container (required)
   * @param path Path to a directory in the container to extract the archive’s contents into.  (required)
   * @param inputStream The input stream must be a tar archive compressed with one of the following algorithms: identity (no compression), gzip, bzip2, xz. (required)
   * @param noOverwriteDirNonDir If “1”, “true”, or “True” then it will be an error if unpacking the given content would cause an existing directory to be replaced with a non-directory and vice versa. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/x-tar"
  })
  @PUT("containers/{id}/archive")
  Call<Void> putContainerArchive(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("path") String path, @retrofit2.http.Body String inputStream, @retrofit2.http.Query("noOverwriteDirNonDir") String noOverwriteDirNonDir
  );

}
