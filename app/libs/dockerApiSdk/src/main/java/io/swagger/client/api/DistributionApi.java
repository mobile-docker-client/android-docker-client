package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.DistributionInspectResponse;
import io.swagger.client.model.ErrorResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DistributionApi {
  /**
   * Get image information from the registry
   * Return image digest and platform information by contacting the registry.
   * @param name Image name or id (required)
   * @return Call&lt;DistributionInspectResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("distribution/{name}/json")
  Call<DistributionInspectResponse> distributionInspect(
    @retrofit2.http.Path("name") String name
  );

}
