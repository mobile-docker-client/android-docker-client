/*
 * Docker Engine API
 * The Engine API is an HTTP API served by Docker Engine. It is the API the Docker client uses to communicate with the Engine, so everything the Docker client can do can be done with the API.  Most of the client's commands map directly to API endpoints (e.g. `docker ps` is `GET /containers/json`). The notable exception is running containers, which consists of several API calls.  # Errors  The API uses standard HTTP status codes to indicate the success or failure of the API call. The body of the response will be JSON in the following format:  ``` {   \"message\": \"page not found\" } ```  # Versioning  The API is usually changed in each release, so API calls are versioned to ensure that clients don't break. To lock to a specific version of the API, you prefix the URL with its version, for example, call `/v1.30/info` to use the v1.30 version of the `/info` endpoint. If the API version specified in the URL is not supported by the daemon, a HTTP `400 Bad Request` error message is returned.  If you omit the version-prefix, the current version of the API (v1.37) is used. For example, calling `/info` is the same as calling `/v1.36/info`. Using the API without a version-prefix is deprecated and will be removed in a future release.  Engine releases in the near future should support this version of the API, so your client will continue to work even if it is talking to a newer Engine.  The API uses an open schema model, which means server may add extra properties to responses. Likewise, the server will ignore any extra query parameters and request body properties. When you write clients, you need to ignore additional properties in responses to ensure they do not break when talking to newer daemons.   # Authentication  Authentication for registries is handled client side. The client has to send authentication details to various endpoints that need to communicate with registries, such as `POST /images/(name)/push`. These are sent as `X-Registry-Auth` header as a Base64 encoded (JSON) string with the following structure:  ``` {   \"username\": \"string\",   \"password\": \"string\",   \"email\": \"string\",   \"serveraddress\": \"string\" } ```  The `serveraddress` is a domain/IP without a protocol. Throughout this structure, double quotes are required.  If you have already got an identity token from the [`/auth` endpoint](#operation/SystemAuth), you can just pass this instead of credentials:  ``` {   \"identitytoken\": \"9cbaf023786cd7...\" } ``` 
 *
 * OpenAPI spec version: 1.37
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.EngineDescriptionPlugins;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EngineDescription provides information about an engine.
 */
@ApiModel(description = "EngineDescription provides information about an engine.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class EngineDescription {
  @SerializedName("EngineVersion")
  private String engineVersion = null;

  @SerializedName("Labels")
  private Map<String, String> labels = null;

  @SerializedName("Plugins")
  private List<EngineDescriptionPlugins> plugins = null;

  public EngineDescription engineVersion(String engineVersion) {
    this.engineVersion = engineVersion;
    return this;
  }

   /**
   * Get engineVersion
   * @return engineVersion
  **/
  @ApiModelProperty(example = "17.06.0", value = "")
  public String getEngineVersion() {
    return engineVersion;
  }

  public void setEngineVersion(String engineVersion) {
    this.engineVersion = engineVersion;
  }

  public EngineDescription labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public EngineDescription putLabelsItem(String key, String labelsItem) {
    if (this.labels == null) {
      this.labels = new HashMap<String, String>();
    }
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * Get labels
   * @return labels
  **/
  @ApiModelProperty(example = "{\"foo\":\"bar\"}", value = "")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public EngineDescription plugins(List<EngineDescriptionPlugins> plugins) {
    this.plugins = plugins;
    return this;
  }

  public EngineDescription addPluginsItem(EngineDescriptionPlugins pluginsItem) {
    if (this.plugins == null) {
      this.plugins = new ArrayList<EngineDescriptionPlugins>();
    }
    this.plugins.add(pluginsItem);
    return this;
  }

   /**
   * Get plugins
   * @return plugins
  **/
  @ApiModelProperty(example = "[{\"Type\":\"Log\",\"Name\":\"awslogs\"},{\"Type\":\"Log\",\"Name\":\"fluentd\"},{\"Type\":\"Log\",\"Name\":\"gcplogs\"},{\"Type\":\"Log\",\"Name\":\"gelf\"},{\"Type\":\"Log\",\"Name\":\"journald\"},{\"Type\":\"Log\",\"Name\":\"json-file\"},{\"Type\":\"Log\",\"Name\":\"logentries\"},{\"Type\":\"Log\",\"Name\":\"splunk\"},{\"Type\":\"Log\",\"Name\":\"syslog\"},{\"Type\":\"Network\",\"Name\":\"bridge\"},{\"Type\":\"Network\",\"Name\":\"host\"},{\"Type\":\"Network\",\"Name\":\"ipvlan\"},{\"Type\":\"Network\",\"Name\":\"macvlan\"},{\"Type\":\"Network\",\"Name\":\"null\"},{\"Type\":\"Network\",\"Name\":\"overlay\"},{\"Type\":\"Volume\",\"Name\":\"local\"},{\"Type\":\"Volume\",\"Name\":\"localhost:5000/vieux/sshfs:latest\"},{\"Type\":\"Volume\",\"Name\":\"vieux/sshfs:latest\"}]", value = "")
  public List<EngineDescriptionPlugins> getPlugins() {
    return plugins;
  }

  public void setPlugins(List<EngineDescriptionPlugins> plugins) {
    this.plugins = plugins;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EngineDescription engineDescription = (EngineDescription) o;
    return Objects.equals(this.engineVersion, engineDescription.engineVersion) &&
        Objects.equals(this.labels, engineDescription.labels) &&
        Objects.equals(this.plugins, engineDescription.plugins);
  }

  @Override
  public int hashCode() {
    return Objects.hash(engineVersion, labels, plugins);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EngineDescription {\n");
    
    sb.append("    engineVersion: ").append(toIndentedString(engineVersion)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    plugins: ").append(toIndentedString(plugins)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

