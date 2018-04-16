package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Service;
import io.swagger.client.model.ServiceCreateResponse;
import io.swagger.client.model.ServiceSpec;
import io.swagger.client.model.ServiceUpdateResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ServiceApi {
  /**
   * Create a service
   * 
   * @param body  (required)
   * @param xRegistryAuth A base64-encoded auth configuration for pulling from private registries. [See the authentication section for details.](#section/Authentication) (optional)
   * @return Call&lt;ServiceCreateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("services/create")
  Call<ServiceCreateResponse> serviceCreate(
    @retrofit2.http.Body ServiceSpec body, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth
  );

  /**
   * Delete a service
   * 
   * @param id ID or name of service. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("services/{id}")
  Call<Void> serviceDelete(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Inspect a service
   * 
   * @param id ID or name of service. (required)
   * @param insertDefaults Fill empty fields with default values. (optional, default to false)
   * @return Call&lt;Service&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("services/{id}")
  Call<Service> serviceInspect(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("insertDefaults") Boolean insertDefaults
  );

  /**
   * List services
   * 
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the services list. Available filters:  - &#x60;id&#x3D;&lt;service id&gt;&#x60; - &#x60;label&#x3D;&lt;service label&gt;&#x60; - &#x60;mode&#x3D;[\&quot;replicated\&quot;|\&quot;global\&quot;]&#x60; - &#x60;name&#x3D;&lt;service name&gt;&#x60;  (optional)
   * @return Call&lt;List&lt;Service&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("services")
  Call<List<Service>> serviceList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Get service logs
   * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a service.  **Note**: This endpoint works only for services with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging drivers. 
   * @param id ID or name of the service (required)
   * @param details Show service context and extra details provided to logs. (optional, default to false)
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
  @GET("services/{id}/logs")
  Call<String> serviceLogs(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("details") Boolean details, @retrofit2.http.Query("follow") Boolean follow, @retrofit2.http.Query("stdout") Boolean stdout, @retrofit2.http.Query("stderr") Boolean stderr, @retrofit2.http.Query("since") Integer since, @retrofit2.http.Query("timestamps") Boolean timestamps, @retrofit2.http.Query("tail") String tail
  );

  /**
   * Update a service
   * 
   * @param id ID or name of service. (required)
   * @param body  (required)
   * @param version The version number of the service object being updated. This is required to avoid conflicting writes. (required)
   * @param registryAuthFrom If the X-Registry-Auth header is not specified, this parameter indicates where to find registry authorization credentials. The valid values are &#x60;spec&#x60; and &#x60;previous-spec&#x60;. (optional, default to spec)
   * @param rollback Set to this parameter to &#x60;previous&#x60; to cause a server-side rollback to the previous service spec. The supplied spec will be ignored in this case. (optional)
   * @param xRegistryAuth A base64-encoded auth configuration for pulling from private registries. [See the authentication section for details.](#section/Authentication) (optional)
   * @return Call&lt;ServiceUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("services/{id}/update")
  Call<ServiceUpdateResponse> serviceUpdate(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body ServiceSpec body, @retrofit2.http.Query("version") Integer version, @retrofit2.http.Query("registryAuthFrom") String registryAuthFrom, @retrofit2.http.Query("rollback") String rollback, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth
  );

}
