package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Node;
import io.swagger.client.model.NodeSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface NodeApi {
  /**
   * Delete a node
   * 
   * @param id The ID or name of the node (required)
   * @param force Force remove a node from the swarm (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("nodes/{id}")
  Call<Void> nodeDelete(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("force") Boolean force
  );

  /**
   * Inspect a node
   * 
   * @param id The ID or name of the node (required)
   * @return Call&lt;Node&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("nodes/{id}")
  Call<Node> nodeInspect(
    @retrofit2.http.Path("id") String id
  );

  /**
   * List nodes
   * 
   * @param filters Filters to process on the nodes list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;id&#x3D;&lt;node id&gt;&#x60; - &#x60;label&#x3D;&lt;engine label&gt;&#x60; - &#x60;membership&#x3D;&#x60;(&#x60;accepted&#x60;|&#x60;pending&#x60;)&#x60; - &#x60;name&#x3D;&lt;node name&gt;&#x60; - &#x60;role&#x3D;&#x60;(&#x60;manager&#x60;|&#x60;worker&#x60;)&#x60;  (optional)
   * @return Call&lt;List&lt;Node&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("nodes")
  Call<List<Node>> nodeList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Update a node
   * 
   * @param id The ID of the node (required)
   * @param version The version number of the node object being updated. This is required to avoid conflicting writes. (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("nodes/{id}/update")
  Call<Void> nodeUpdate(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("version") Long version, @retrofit2.http.Body NodeSpec body
  );

}
