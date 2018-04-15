package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.Body1;
import io.swagger.client.model.Body2;
import io.swagger.client.model.Body3;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Swarm;
import io.swagger.client.model.SwarmSpec;
import io.swagger.client.model.UnlockKeyResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SwarmApi {
  /**
   * Initialize a new swarm
   * 
   * @param body  (required)
   * @return Call&lt;String&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("swarm/init")
  Call<String> swarmInit(
    @retrofit2.http.Body Body1 body
  );

  /**
   * Inspect swarm
   * 
   * @return Call&lt;Swarm&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("swarm")
  Call<Swarm> swarmInspect();
    

  /**
   * Join an existing swarm
   * 
   * @param body  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("swarm/join")
  Call<Void> swarmJoin(
    @retrofit2.http.Body Body2 body
  );

  /**
   * Leave a swarm
   * 
   * @param force Force leave swarm, even if this is the last manager or that it will break the cluster. (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("swarm/leave")
  Call<Void> swarmLeave(
    @retrofit2.http.Query("force") Boolean force
  );

  /**
   * Unlock a locked manager
   * 
   * @param body  (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("swarm/unlock")
  Call<Void> swarmUnlock(
    @retrofit2.http.Body Body3 body
  );

  /**
   * Get the unlock key
   * 
   * @return Call&lt;UnlockKeyResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("swarm/unlockkey")
  Call<UnlockKeyResponse> swarmUnlockkey();
    

  /**
   * Update a swarm
   * 
   * @param body  (required)
   * @param version The version number of the swarm object being updated. This is required to avoid conflicting writes. (required)
   * @param rotateWorkerToken Rotate the worker join token. (optional, default to false)
   * @param rotateManagerToken Rotate the manager join token. (optional, default to false)
   * @param rotateManagerUnlockKey Rotate the manager unlock key. (optional, default to false)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("swarm/update")
  Call<Void> swarmUpdate(
    @retrofit2.http.Body SwarmSpec body, @retrofit2.http.Query("version") Long version, @retrofit2.http.Query("rotateWorkerToken") Boolean rotateWorkerToken, @retrofit2.http.Query("rotateManagerToken") Boolean rotateManagerToken, @retrofit2.http.Query("rotateManagerUnlockKey") Boolean rotateManagerUnlockKey
  );

}
