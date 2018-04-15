package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.ExecConfig;
import io.swagger.client.model.ExecInspectResponse;
import io.swagger.client.model.ExecStartConfig;
import io.swagger.client.model.IdResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ExecApi {
  /**
   * Create an exec instance
   * Run a command inside a running container.
   * @param execConfig Exec configuration (required)
   * @param id ID or name of container (required)
   * @return Call&lt;IdResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("containers/{id}/exec")
  Call<IdResponse> containerExec(
    @retrofit2.http.Body ExecConfig execConfig, @retrofit2.http.Path("id") String id
  );

  /**
   * Inspect an exec instance
   * Return low-level information about an exec instance.
   * @param id Exec instance ID (required)
   * @return Call&lt;ExecInspectResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("exec/{id}/json")
  Call<ExecInspectResponse> execInspect(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Resize an exec instance
   * Resize the TTY session used by an exec instance. This endpoint only works if &#x60;tty&#x60; was specified as part of creating and starting the exec instance.
   * @param id Exec instance ID (required)
   * @param h Height of the TTY session in characters (optional)
   * @param w Width of the TTY session in characters (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("exec/{id}/resize")
  Call<Void> execResize(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("h") Integer h, @retrofit2.http.Query("w") Integer w
  );

  /**
   * Start an exec instance
   * Starts a previously set up exec instance. If detach is true, this endpoint returns immediately after starting the command. Otherwise, it sets up an interactive session with the command.
   * @param id Exec instance ID (required)
   * @param execStartConfig  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("exec/{id}/start")
  Call<Void> execStart(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ExecStartConfig execStartConfig
  );

}
