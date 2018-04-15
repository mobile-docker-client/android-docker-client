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

public interface SessionExperimentalApi {
  /**
   * Initialize interactive session
   * Start a new interactive session with a server. Session allows server to call back to the client for advanced capabilities.  &gt; **Note**: This endpoint is *experimental* and only available if the daemon is started with experimental &gt; features enabled. The specifications for this endpoint may still change in a future version of the API.  ### Hijacking  This endpoint hijacks the HTTP connection to HTTP2 transport that allows the client to expose gPRC services on that connection.  For example, the client sends this request to upgrade the connection:  &#x60;&#x60;&#x60; POST /session HTTP/1.1 Upgrade: h2c Connection: Upgrade &#x60;&#x60;&#x60;  The Docker daemon will respond with a &#x60;101 UPGRADED&#x60; response follow with the raw stream:  &#x60;&#x60;&#x60; HTTP/1.1 101 UPGRADED Connection: Upgrade Upgrade: h2c &#x60;&#x60;&#x60; 
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("session")
  Call<Void> session();
    

}
