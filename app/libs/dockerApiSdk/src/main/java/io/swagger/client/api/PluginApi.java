package io.swagger.client.api;

import io.swagger.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import io.swagger.client.model.Body;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Plugin;
import io.swagger.client.model.PluginPrivilegeItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface PluginApi {
  /**
   * Get plugin privileges
   * 
   * @param remote The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @return Call&lt;List&lt;PluginPrivilegeItem&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("plugins/privileges")
  Call<List<PluginPrivilegeItem>> getPluginPrivileges(
    @retrofit2.http.Query("remote") String remote
  );

  /**
   * Create a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @param tarContext Path to tar containing plugin rootfs and manifest (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/x-tar"
  })
  @POST("plugins/create")
  Call<Void> pluginCreate(
    @retrofit2.http.Query("name") String name, @retrofit2.http.Body byte[] tarContext
  );

  /**
   * Remove a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @param force Disable the plugin before removing. This may result in issues if the plugin is in use by a container. (optional, default to false)
   * @return Call&lt;Plugin&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @DELETE("plugins/{name}")
  Call<Plugin> pluginDelete(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("force") Boolean force
  );

  /**
   * Disable a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/{name}/disable")
  Call<Void> pluginDisable(
    @retrofit2.http.Path("name") String name
  );

  /**
   * Enable a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @param timeout Set the HTTP client timeout (in seconds) (optional, default to 0)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/{name}/enable")
  Call<Void> pluginEnable(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("timeout") Integer timeout
  );

  /**
   * Inspect a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @return Call&lt;Plugin&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("plugins/{name}/json")
  Call<Plugin> pluginInspect(
    @retrofit2.http.Path("name") String name
  );

  /**
   * List plugins
   * Returns information about installed plugins.
   * @param filters A JSON encoded value of the filters (a &#x60;map[string][]string&#x60;) to process on the plugin list. Available filters:  - &#x60;capability&#x3D;&lt;capability name&gt;&#x60; - &#x60;enable&#x3D;&lt;true&gt;|&lt;false&gt;&#x60;  (optional)
   * @return Call&lt;List&lt;Plugin&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("plugins")
  Call<List<Plugin>> pluginList(
    @retrofit2.http.Query("filters") String filters
  );

  /**
   * Install a plugin
   * Pulls and installs a plugin. After the plugin is installed, it can be enabled using the [&#x60;POST /plugins/{name}/enable&#x60; endpoint](#operation/PostPluginsEnable). 
   * @param remote Remote reference for plugin to install.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  (required)
   * @param name Local name for the pulled plugin.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  (optional)
   * @param xRegistryAuth A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication) (optional)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/pull")
  Call<Void> pluginPull(
    @retrofit2.http.Query("remote") String remote, @retrofit2.http.Query("name") String name, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth, @retrofit2.http.Body List<Body> body
  );

  /**
   * Push a plugin
   * Push a plugin to the registry. 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/{name}/push")
  Call<Void> pluginPush(
    @retrofit2.http.Path("name") String name
  );

  /**
   * Configure a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/{name}/set")
  Call<Void> pluginSet(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Body List<String> body
  );

  /**
   * Upgrade a plugin
   * 
   * @param name The name of the plugin. The &#x60;:latest&#x60; tag is optional, and is the default if omitted. (required)
   * @param remote Remote reference to upgrade to.  The &#x60;:latest&#x60; tag is optional, and is used as the default if omitted.  (required)
   * @param xRegistryAuth A base64-encoded auth configuration to use when pulling a plugin from a registry. [See the authentication section for details.](#section/Authentication) (optional)
   * @param body  (optional)
   * @return Call&lt;Void&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("plugins/{name}/upgrade")
  Call<Void> pluginUpgrade(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("remote") String remote, @retrofit2.http.Header("X-Registry-Auth") String xRegistryAuth, @retrofit2.http.Body List<Body> body
  );

}
