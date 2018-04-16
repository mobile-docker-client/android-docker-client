package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ContainerChangeResponseItem;
import io.swagger.client.model.ContainerCreateResponse;
import io.swagger.client.model.ContainerInspectConfig;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerPruneResponse;
import io.swagger.client.model.ContainerSummary;
import io.swagger.client.model.ContainerTopResponse;
import io.swagger.client.model.ContainerUpdateConfig;
import io.swagger.client.model.ContainerUpdateResponse;
import io.swagger.client.model.ContainerWaitResponse;
import io.swagger.client.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ContainerApi
 */
public class ContainerApiTest {

    private ContainerApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ContainerApi.class);
    }

    /**
     * Get an archive of a filesystem resource in a container
     *
     * Get a tar archive of a resource in the filesystem of container id.
     */
    @Test
    public void containerArchiveTest() {
        String id = null;
        String path = null;
        // Void response = api.containerArchive(id, path);

        // TODO: test validations
    }
    /**
     * Get information about files in a container
     *
     * A response header &#x60;X-Docker-Container-Path-Stat&#x60; is return containing a base64 - encoded JSON object with some filesystem header information about the path.
     */
    @Test
    public void containerArchiveInfoTest() {
        String id = null;
        String path = null;
        // Void response = api.containerArchiveInfo(id, path);

        // TODO: test validations
    }
    /**
     * Attach to a container
     *
     * Attach to a container to read its output or send it input. You can attach to the same container multiple times and you can reattach to containers that have been detached.  Either the &#x60;stream&#x60; or &#x60;logs&#x60; parameter must be &#x60;true&#x60; for this endpoint to do anything.  See [the documentation for the &#x60;docker attach&#x60; command](https://docs.docker.com/engine/reference/commandline/attach/) for more details.  ### Hijacking  This endpoint hijacks the HTTP connection to transport &#x60;stdin&#x60;, &#x60;stdout&#x60;, and &#x60;stderr&#x60; on the same socket.  This is the response from the daemon for an attach request:  &#x60;&#x60;&#x60; HTTP/1.1 200 OK Content-Type: application/vnd.docker.raw-stream  [STREAM] &#x60;&#x60;&#x60;  After the headers and two new lines, the TCP connection can now be used for raw, bidirectional communication between the client and server.  To hint potential proxies about connection hijacking, the Docker client can also optionally send connection upgrade headers.  For example, the client sends this request to upgrade the connection:  &#x60;&#x60;&#x60; POST /containers/16253994b7c4/attach?stream&#x3D;1&amp;stdout&#x3D;1 HTTP/1.1 Upgrade: tcp Connection: Upgrade &#x60;&#x60;&#x60;  The Docker daemon will respond with a &#x60;101 UPGRADED&#x60; response, and will similarly follow with the raw stream:  &#x60;&#x60;&#x60; HTTP/1.1 101 UPGRADED Content-Type: application/vnd.docker.raw-stream Connection: Upgrade Upgrade: tcp  [STREAM] &#x60;&#x60;&#x60;  ### Stream format  When the TTY setting is disabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream over the hijacked connected is multiplexed to separate out &#x60;stdout&#x60; and &#x60;stderr&#x60;. The stream consists of a series of frames, each containing a header and a payload.  The header contains the information which the stream writes (&#x60;stdout&#x60; or &#x60;stderr&#x60;). It also contains the size of the associated frame encoded in the last four bytes (&#x60;uint32&#x60;).  It is encoded on the first eight bytes like this:  &#x60;&#x60;&#x60;go header :&#x3D; [8]byte{STREAM_TYPE, 0, 0, 0, SIZE1, SIZE2, SIZE3, SIZE4} &#x60;&#x60;&#x60;  &#x60;STREAM_TYPE&#x60; can be:  - 0: &#x60;stdin&#x60; (is written on &#x60;stdout&#x60;) - 1: &#x60;stdout&#x60; - 2: &#x60;stderr&#x60;  &#x60;SIZE1, SIZE2, SIZE3, SIZE4&#x60; are the four bytes of the &#x60;uint32&#x60; size encoded as big endian.  Following the header is the payload, which is the specified number of bytes of &#x60;STREAM_TYPE&#x60;.  The simplest way to implement this protocol is the following:  1. Read 8 bytes. 2. Choose &#x60;stdout&#x60; or &#x60;stderr&#x60; depending on the first byte. 3. Extract the frame size from the last four bytes. 4. Read the extracted size and output it on the correct output. 5. Goto 1.  ### Stream format when using a TTY  When the TTY setting is enabled in [&#x60;POST /containers/create&#x60;](#operation/ContainerCreate), the stream is not multiplexed. The data exchanged over the hijacked connection is simply the raw data from the process PTY and client&#39;s &#x60;stdin&#x60;. 
     */
    @Test
    public void containerAttachTest() {
        String id = null;
        String detachKeys = null;
        Boolean logs = null;
        Boolean stream = null;
        Boolean stdin = null;
        Boolean stdout = null;
        Boolean stderr = null;
        // Void response = api.containerAttach(id, detachKeys, logs, stream, stdin, stdout, stderr);

        // TODO: test validations
    }
    /**
     * Attach to a container via a websocket
     *
     * 
     */
    @Test
    public void containerAttachWebsocketTest() {
        String id = null;
        String detachKeys = null;
        Boolean logs = null;
        Boolean stream = null;
        Boolean stdin = null;
        Boolean stdout = null;
        Boolean stderr = null;
        // Void response = api.containerAttachWebsocket(id, detachKeys, logs, stream, stdin, stdout, stderr);

        // TODO: test validations
    }
    /**
     * Get changes on a container’s filesystem
     *
     * Returns which files in a container&#39;s filesystem have been added, deleted, or modified. The &#x60;Kind&#x60; of modification can be one of:  - &#x60;0&#x60;: Modified - &#x60;1&#x60;: Added - &#x60;2&#x60;: Deleted 
     */
    @Test
    public void containerChangesTest() {
        String id = null;
        // List<ContainerChangeResponseItem> response = api.containerChanges(id);

        // TODO: test validations
    }
    /**
     * Create a container
     *
     * 
     */
    @Test
    public void containerCreateTest() {
        ContainerInspectConfig body = null;
        String name = null;
        // ContainerCreateResponse response = api.containerCreate(body, name);

        // TODO: test validations
    }
    /**
     * Remove a container
     *
     * 
     */
    @Test
    public void containerDeleteTest() {
        String id = null;
        Boolean v = null;
        Boolean force = null;
        Boolean link = null;
        // Void response = api.containerDelete(id, v, force, link);

        // TODO: test validations
    }
    /**
     * Export a container
     *
     * Export the contents of a container as a tarball.
     */
    @Test
    public void containerExportTest() {
        String id = null;
        // Void response = api.containerExport(id);

        // TODO: test validations
    }
    /**
     * Inspect a container
     *
     * Return low-level information about a container.
     */
    @Test
    public void containerInspectTest() {
        String id = null;
        Boolean size = null;
        // ContainerInspectResponse response = api.containerInspect(id, size);

        // TODO: test validations
    }
    /**
     * Kill a container
     *
     * Send a POSIX signal to a container, defaulting to killing to the container.
     */
    @Test
    public void containerKillTest() {
        String id = null;
        String signal = null;
        // Void response = api.containerKill(id, signal);

        // TODO: test validations
    }
    /**
     * List containers
     *
     * Returns a list of containers. For details on the format, see [the inspect endpoint](#operation/ContainerInspect).  Note that it uses a different, smaller representation of a container than inspecting a single container. For example, the list of linked containers is not propagated . 
     */
    @Test
    public void containerListTest() {
        Boolean all = null;
        Integer limit = null;
        Boolean size = null;
        String filters = null;
        // ContainerSummary response = api.containerList(all, limit, size, filters);

        // TODO: test validations
    }
    /**
     * Get container logs
     *
     * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a container.  Note: This endpoint works only for containers with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging driver. 
     */
    @Test
    public void containerLogsTest() {
        String id = null;
        Boolean follow = null;
        Boolean stdout = null;
        Boolean stderr = null;
        Integer since = null;
        Integer until = null;
        Boolean timestamps = null;
        String tail = null;
        // String response = api.containerLogs(id, follow, stdout, stderr, since, until, timestamps, tail);

        // TODO: test validations
    }
    /**
     * Pause a container
     *
     * Use the cgroups freezer to suspend all processes in a container.  Traditionally, when suspending a process the &#x60;SIGSTOP&#x60; signal is used, which is observable by the process being suspended. With the cgroups freezer the process is unaware, and unable to capture, that it is being suspended, and subsequently resumed. 
     */
    @Test
    public void containerPauseTest() {
        String id = null;
        // Void response = api.containerPause(id);

        // TODO: test validations
    }
    /**
     * Delete stopped containers
     *
     * 
     */
    @Test
    public void containerPruneTest() {
        String filters = null;
        // ContainerPruneResponse response = api.containerPrune(filters);

        // TODO: test validations
    }
    /**
     * Rename a container
     *
     * 
     */
    @Test
    public void containerRenameTest() {
        String id = null;
        String name = null;
        // Void response = api.containerRename(id, name);

        // TODO: test validations
    }
    /**
     * Resize a container TTY
     *
     * Resize the TTY for a container. You must restart the container for the resize to take effect.
     */
    @Test
    public void containerResizeTest() {
        String id = null;
        Integer h = null;
        Integer w = null;
        // Void response = api.containerResize(id, h, w);

        // TODO: test validations
    }
    /**
     * Restart a container
     *
     * 
     */
    @Test
    public void containerRestartTest() {
        String id = null;
        Integer t = null;
        // Void response = api.containerRestart(id, t);

        // TODO: test validations
    }
    /**
     * Start a container
     *
     * 
     */
    @Test
    public void containerStartTest() {
        String id = null;
        String detachKeys = null;
        // Void response = api.containerStart(id, detachKeys);

        // TODO: test validations
    }
    /**
     * Get container stats based on resource usage
     *
     * This endpoint returns a live stream of a container’s resource usage statistics.  The &#x60;precpu_stats&#x60; is the CPU statistic of last read, which is used for calculating the CPU usage percentage. It is not the same as the &#x60;cpu_stats&#x60; field.  If either &#x60;precpu_stats.online_cpus&#x60; or &#x60;cpu_stats.online_cpus&#x60; is nil then for compatibility with older daemons the length of the corresponding &#x60;cpu_usage.percpu_usage&#x60; array should be used. 
     */
    @Test
    public void containerStatsTest() {
        String id = null;
        Boolean stream = null;
        // Object response = api.containerStats(id, stream);

        // TODO: test validations
    }
    /**
     * Stop a container
     *
     * 
     */
    @Test
    public void containerStopTest() {
        String id = null;
        Integer t = null;
        // Void response = api.containerStop(id, t);

        // TODO: test validations
    }
    /**
     * List processes running inside a container
     *
     * On Unix systems, this is done by running the &#x60;ps&#x60; command. This endpoint is not supported on Windows.
     */
    @Test
    public void containerTopTest() {
        String id = null;
        String psArgs = null;
        // ContainerTopResponse response = api.containerTop(id, psArgs);

        // TODO: test validations
    }
    /**
     * Unpause a container
     *
     * Resume a container which has been paused.
     */
    @Test
    public void containerUnpauseTest() {
        String id = null;
        // Void response = api.containerUnpause(id);

        // TODO: test validations
    }
    /**
     * Update a container
     *
     * Change various configuration options of a container without having to recreate it.
     */
    @Test
    public void containerUpdateTest() {
        String id = null;
        ContainerUpdateConfig update = null;
        // ContainerUpdateResponse response = api.containerUpdate(id, update);

        // TODO: test validations
    }
    /**
     * Wait for a container
     *
     * Block until a container stops, then returns the exit code.
     */
    @Test
    public void containerWaitTest() {
        String id = null;
        String condition = null;
        // ContainerWaitResponse response = api.containerWait(id, condition);

        // TODO: test validations
    }
    /**
     * Extract an archive of files or folders to a directory in a container
     *
     * Upload a tar archive to be extracted to a path in the filesystem of container id.
     */
    @Test
    public void putContainerArchiveTest() {
        String id = null;
        String path = null;
        String inputStream = null;
        String noOverwriteDirNonDir = null;
        // Void response = api.putContainerArchive(id, path, inputStream, noOverwriteDirNonDir);

        // TODO: test validations
    }
}
