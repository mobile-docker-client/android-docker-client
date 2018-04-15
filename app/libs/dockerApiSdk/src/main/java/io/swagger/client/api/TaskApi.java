package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TaskApi {
  /**
   * Inspect a task
   * 
   * @param id ID of the task (required)
   * @return Call&lt;Task&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("tasks/{id}")
  Call<Task> taskInspect(
    @retrofit2.http.Path("id") String id
  );

  /**
   * List tasks
   * 
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the tasks list. Available filters:  - &#x60;desired-state&#x3D;(running | shutdown | accepted)&#x60; - &#x60;id&#x3D;&lt;task id&gt;&#x60; - &#x60;label&#x3D;key&#x60; or &#x60;label&#x3D;\&quot;key&#x3D;value\&quot;&#x60; - &#x60;name&#x3D;&lt;task name&gt;&#x60; - &#x60;node&#x3D;&lt;node id or name&gt;&#x60; - &#x60;service&#x3D;&lt;service name&gt;&#x60;  (optional)
   * @return Call&lt;List&lt;Task&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("tasks")
  Call<List<Task>> taskList(
    @retrofit2.http.Query("filters") String filters
  );

}
