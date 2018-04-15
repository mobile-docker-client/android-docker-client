package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.AuthConfig;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.SystemAuthResponse;
import io.swagger.client.model.SystemDataUsageResponse;
import io.swagger.client.model.SystemEventsResponse;
import io.swagger.client.model.SystemInfo;
import io.swagger.client.model.SystemVersionResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SystemApi {
  /**
   * Check auth configuration
   * Validate credentials for a registry and, if available, get an identity token for accessing the registry without password.
   * @param authConfig Authentication to check (optional)
   * @return Call&lt;SystemAuthResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("auth")
  Call<SystemAuthResponse> systemAuth(
    @retrofit2.http.Body AuthConfig authConfig
  );

  /**
   * Get data usage information
   * 
   * @return Call&lt;SystemDataUsageResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("system/df")
  Call<SystemDataUsageResponse> systemDataUsage();
    

  /**
   * Monitor events
   * Stream real-time events from the server.  Various objects within Docker report events when something happens to them.  Containers report these events: &#x60;attach&#x60;, &#x60;commit&#x60;, &#x60;copy&#x60;, &#x60;create&#x60;, &#x60;destroy&#x60;, &#x60;detach&#x60;, &#x60;die&#x60;, &#x60;exec_create&#x60;, &#x60;exec_detach&#x60;, &#x60;exec_start&#x60;, &#x60;exec_die&#x60;, &#x60;export&#x60;, &#x60;health_status&#x60;, &#x60;kill&#x60;, &#x60;oom&#x60;, &#x60;pause&#x60;, &#x60;rename&#x60;, &#x60;resize&#x60;, &#x60;restart&#x60;, &#x60;start&#x60;, &#x60;stop&#x60;, &#x60;top&#x60;, &#x60;unpause&#x60;, and &#x60;update&#x60;  Images report these events: &#x60;delete&#x60;, &#x60;import&#x60;, &#x60;load&#x60;, &#x60;pull&#x60;, &#x60;push&#x60;, &#x60;save&#x60;, &#x60;tag&#x60;, and &#x60;untag&#x60;  Volumes report these events: &#x60;create&#x60;, &#x60;mount&#x60;, &#x60;unmount&#x60;, and &#x60;destroy&#x60;  Networks report these events: &#x60;create&#x60;, &#x60;connect&#x60;, &#x60;disconnect&#x60;, &#x60;destroy&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  The Docker daemon reports these events: &#x60;reload&#x60;  Services report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Nodes report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Secrets report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Configs report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60; 
   * @param since Show events created since this timestamp then stream new events. (optional)
   * @param until Show events created until this timestamp then stop streaming. (optional)
   * @param filters A JSON encoded value of filters (a &#x60;map[string][]string&#x60;) to process on the event list. Available filters:  - &#x60;config&#x3D;&lt;string&gt;&#x60; config name or ID - &#x60;container&#x3D;&lt;string&gt;&#x60; container name or ID - &#x60;daemon&#x3D;&lt;string&gt;&#x60; daemon name or ID - &#x60;event&#x3D;&lt;string&gt;&#x60; event type - &#x60;image&#x3D;&lt;string&gt;&#x60; image name or ID - &#x60;label&#x3D;&lt;string&gt;&#x60; image or container label - &#x60;network&#x3D;&lt;string&gt;&#x60; network name or ID - &#x60;node&#x3D;&lt;string&gt;&#x60; node ID - &#x60;plugin&#x60;&#x3D;&lt;string&gt; plugin name or ID - &#x60;scope&#x60;&#x3D;&lt;string&gt; local or swarm - &#x60;secret&#x3D;&lt;string&gt;&#x60; secret name or ID - &#x60;service&#x3D;&lt;string&gt;&#x60; service name or ID - &#x60;type&#x3D;&lt;string&gt;&#x60; object to filter by, one of &#x60;container&#x60;, &#x60;image&#x60;, &#x60;volume&#x60;, &#x60;network&#x60;, &#x60;daemon&#x60;, &#x60;plugin&#x60;, &#x60;node&#x60;, &#x60;service&#x60;, &#x60;secret&#x60; or &#x60;config&#x60; - &#x60;volume&#x3D;&lt;string&gt;&#x60; volume name  (optional)
   * @return Call&lt;SystemEventsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("events")
  Call<SystemEventsResponse> systemEvents(
    @retrofit2.http.Query("since") String since, @retrofit2.http.Query("until") String until, @retrofit2.http.Query("filters") String filters
  );

  /**
   * Get system information
   * 
   * @return Call&lt;SystemInfo&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("info")
  Call<SystemInfo> systemInfo();
    

  /**
   * Ping
   * This is a dummy endpoint you can use to test if the server is accessible.
   * @return Call&lt;String&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("_ping")
  Call<String> systemPing();
    

  /**
   * Get version
   * Returns the version of Docker that is running and various information about the system that Docker is running on.
   * @return Call&lt;SystemVersionResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("version")
  Call<SystemVersionResponse> systemVersion();
    

}
