package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Volume;
import io.swagger.client.model.VolumeConfig;
import io.swagger.client.model.VolumeListResponse;
import io.swagger.client.model.VolumePruneResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface VolumeApi {
  /**
   * Create a volume
   * 
   * @param volumeConfig Volume configuration (required)
   * @return Call&lt;Volume&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("volumes/create")
  Call<Volume> volumeCreate(
    @retrofit2.http.Body VolumeConfig volumeConfig
  );

  /**
   * Remove a volume
   * Instruct the driver to remove the volume.
   * @param name Volume name or ID (required)
   * @param force Force the removal of the volume (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("volumes/{name}")
  Call<Void> volumeDelete(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("force") Boolean force
  );

  /**
   * Inspect a volume
   * 
   * @param name Volume name or ID (required)
   * @return Call&lt;Volume&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("volumes/{name}")
  Call<Volume> volumeInspect(
    @retrofit2.http.Path("name") String name
  );

  /**
   * List volumes
   * 
   * @param filters JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the volumes list. Available filters:  - &#x60;dangling&#x3D;&lt;boolean&gt;&#x60; When set to &#x60;true&#x60; (or &#x60;1&#x60;), returns all    volumes that are not in use by a container. When set to &#x60;false&#x60;    (or &#x60;0&#x60;), only volumes that are in use by one or more    containers are returned. - &#x60;driver&#x3D;&lt;volume-driver-name&gt;&#x60; Matches volumes based on their driver. - &#x60;label&#x3D;&lt;key&gt;&#x60; or &#x60;label&#x3D;&lt;key&gt;:&lt;value&gt;&#x60; Matches volumes based on    the presence of a &#x60;label&#x60; alone or a &#x60;label&#x60; and a value. - &#x60;name&#x3D;&lt;volume-name&gt;&#x60; Matches all or part of a volume name.  (optional)
   * @return Call&lt;VolumeListResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("volumes")
  Call<VolumeListResponse> volumeList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Delete unused volumes
   * 
   * @param filters Filters to process on the prune list, encoded as JSON (a &#x60;map[string][]string&#x60;).  Available filters: - &#x60;label&#x60; (&#x60;label&#x3D;&lt;key&gt;&#x60;, &#x60;label&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;, &#x60;label!&#x3D;&lt;key&gt;&#x60;, or &#x60;label!&#x3D;&lt;key&gt;&#x3D;&lt;value&gt;&#x60;) Prune volumes with (or without, in case &#x60;label!&#x3D;...&#x60; is used) the specified labels.  (optional)
   * @return Call&lt;VolumePruneResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("volumes/prune")
  Call<VolumePruneResponse> volumePrune(
    @retrofit2.http.Query("filters") String filters
  );

}
