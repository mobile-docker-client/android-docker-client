package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DefaultApi {
  /**
   * Get task logs
   * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a task.  **Note**: This endpoint works only for services with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging drivers. 
   * @param id ID of the task (required)
   * @param details Show task context and extra details provided to logs. (optional, default to false)
   * @param follow Return the logs as a stream.  This will return a &#x60;101&#x60; HTTP response with a &#x60;Connection: upgrade&#x60; header, then hijack the HTTP connection to send raw output. For more information about hijacking and the stream format, [see the documentation for the attach endpoint](#operation/ContainerAttach).  (optional, default to false)
   * @param stdout Return logs from &#x60;stdout&#x60; (optional, default to false)
   * @param stderr Return logs from &#x60;stderr&#x60; (optional, default to false)
   * @param since Only return logs since this time, as a UNIX timestamp (optional, default to 0)
   * @param timestamps Add timestamps to every log line (optional, default to false)
   * @param tail Only return this number of log lines from the end of the logs. Specify as an integer or &#x60;all&#x60; to output all log lines. (optional, default to all)
   * @return Call&lt;String&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("tasks/{id}/logs")
  Call<String> taskLogs(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("details") Boolean details, @retrofit2.http.Query("follow") Boolean follow, @retrofit2.http.Query("stdout") Boolean stdout, @retrofit2.http.Query("stderr") Boolean stderr, @retrofit2.http.Query("since") Integer since, @retrofit2.http.Query("timestamps") Boolean timestamps, @retrofit2.http.Query("tail") String tail
  );

}
