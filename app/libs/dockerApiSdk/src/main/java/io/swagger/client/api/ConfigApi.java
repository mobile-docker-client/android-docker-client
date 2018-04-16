package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.Config;
import io.swagger.client.model.ConfigSpec;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.IdResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConfigApi {
  /**
   * Create a config
   * 
   * @param body  (optional)
   * @return Call&lt;IdResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("configs/create")
  Call<IdResponse> configCreate(
    @retrofit2.http.Body ConfigSpec body
  );

  /**
   * Delete a config
   * 
   * @param id ID of the config (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("configs/{id}")
  Call<Void> configDelete(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Inspect a config
   * 
   * @param id ID of the config (required)
   * @return Call&lt;Config&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("configs/{id}")
  Call<Config> configInspect(
    @retrofit2.http.Path("id") String id
  );

  /**
   * List configs
   * 
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the configs list. Available filters:  - &#x60;id&#x3D;&lt;config id&gt;&#x60; - &#x60;label&#x3D;&lt;key&gt; or label&#x3D;&lt;key&gt;&#x3D;value&#x60; - &#x60;name&#x3D;&lt;config name&gt;&#x60; - &#x60;names&#x3D;&lt;config name&gt;&#x60;  (optional)
   * @return Call&lt;List&lt;Config&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("configs")
  Call<List<Config>> configList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Update a Config
   * 
   * @param id The ID or name of the config (required)
   * @param version The version number of the config object being updated. This is required to avoid conflicting writes. (required)
   * @param body The spec of the config to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [ConfigInspect endpoint](#operation/ConfigInspect) response values. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("configs/{id}/update")
  Call<Void> configUpdate(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("version") Long version, @retrofit2.http.Body ConfigSpec body
  );

}
