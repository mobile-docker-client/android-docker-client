package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.Container;
import io.swagger.client.model.Container1;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Network;
import io.swagger.client.model.NetworkConfig;
import io.swagger.client.model.NetworkCreateResponse;
import io.swagger.client.model.NetworkPruneResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NetworkApi {
  /**
   * Connect a container to a network
   * 
   * @param id Network ID or name (required)
   * @param container  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("networks/{id}/connect")
  Call<Void> networkConnect(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body Container container
  );

  /**
   * Create a network
   * 
   * @param networkConfig Network configuration (required)
   * @return Call&lt;NetworkCreateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("networks/create")
  Call<NetworkCreateResponse> networkCreate(
    @retrofit2.http.Body NetworkConfig networkConfig
  );

  /**
   * Remove a network
   * 
   * @param id Network ID or name (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("networks/{id}")
  Call<Void> networkDelete(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Disconnect a container from a network
   * 
   * @param id Network ID or name (required)
   * @param container  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("networks/{id}/disconnect")
  Call<Void> networkDisconnect(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Body Container1 container
  );

  /**
   * Inspect a network
   * 
   * @param id Network ID or name (required)
   * @param verbose Detailed inspect output for troubleshooting (optional, default to false)
   * @param scope Filter the network by scope (swarm, global, or local) (optional)
   * @return Call&lt;Network&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("networks/{id}")
  Call<Network> networkInspect(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("verbose") Boolean verbose, @retrofit2.http.Query("scope") String scope
  );

  /**
   * List networks
   * Returns a list of networks. For details on the format, see [the network inspect endpoint](#operation/NetworkInspect).  Note that it uses a different, smaller representation of a network than inspecting a single network. For example, the list of containers attached to the network is not propagated in API versions 1.28 and up. 
   * @param filters JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the networks list. Available filters:  - &#x60;driver&#x3D;&lt;driver-name&gt;&#x60; Matches a network&#39;s driver. - &#x60;id&#x3D;&lt;network-id&gt;&#x60; Matches all or part of a network ID. - &#x60;label&#x3D;&lt;key&gt;&#x60; or &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60; of a network label. - &#x60;name&#x3D;&lt;network-name&gt;&#x60; Matches all or part of a network name. - &#x60;scope&#x3D;[\&quot;swarm\&quot;|\&quot;global\&quot;|\&quot;local\&quot;]&#x60; Filters networks by scope (&#x60;swarm&#x60;, &#x60;global&#x60;, or &#x60;local&#x60;). - &#x60;type&#x3D;[\&quot;custom\&quot;|\&quot;builtin\&quot;]&#x60; Filters networks by type. The &#x60;custom&#x60; keyword returns all user-defined networks.  (optional)
   * @return Call&lt;List&lt;Network&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("networks")
  Call<List<Network>> networkList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Delete unused networks
   * 
   * @param filters Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;until&#x3D;&lt;timestamp&gt;&#x60; Prune networks created before this timestamp. The &#x60;&lt;timestamp&gt;&#x60; can be Unix timestamps, date formatted timestamps, or Go duration strings (e.g. &#x60;10m&#x60;, &#x60;1h30m&#x60;) computed relative to the daemon machine’s time. - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune networks with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  (optional)
   * @return Call&lt;NetworkPruneResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("networks/prune")
  Call<NetworkPruneResponse> networkPrune(
    @retrofit2.http.Query("filters") String filters
  );

}
