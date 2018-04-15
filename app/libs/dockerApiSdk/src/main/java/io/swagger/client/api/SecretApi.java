package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.IdResponse;
import io.swagger.client.model.Secret;
import io.swagger.client.model.SecretSpec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SecretApi {
  /**
   * Create a secret
   * 
   * @param body  (optional)
   * @return Call&lt;IdResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("secrets/create")
  Call<IdResponse> secretCreate(
    @retrofit2.http.Body  body
  );

  /**
   * Delete a secret
   * 
   * @param id ID of the secret (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("secrets/{id}")
  Call<Void> secretDelete(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Inspect a secret
   * 
   * @param id ID of the secret (required)
   * @return Call&lt;Secret&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("secrets/{id}")
  Call<Secret> secretInspect(
    @retrofit2.http.Path("id") String id
  );

  /**
   * List secrets
   * 
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the secrets list. Available filters:  - &#x60;id&#x3D;&lt;secret id&gt;&#x60; - &#x60;label&#x3D;&lt;key&gt; or label&#x3D;&lt;key&gt;&#x3D;value&#x60; - &#x60;name&#x3D;&lt;secret name&gt;&#x60; - &#x60;names&#x3D;&lt;secret name&gt;&#x60;  (optional)
   * @return Call&lt;List&lt;Secret&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("secrets")
  Call<List<Secret>> secretList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Update a Secret
   * 
   * @param id The ID or name of the secret (required)
   * @param version The version number of the secret object being updated. This is required to avoid conflicting writes. (required)
   * @param body The spec of the secret to update. Currently, only the Labels field can be updated. All other fields must remain unchanged from the [SecretInspect endpoint](#operation/SecretInspect) response values. (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("secrets/{id}/update")
  Call<Void> secretUpdate(
    @retrofit2.http.Path("id") String id, @retrofit2.http.Query("version") Long version, @retrofit2.http.Body SecretSpec body
  );

}
