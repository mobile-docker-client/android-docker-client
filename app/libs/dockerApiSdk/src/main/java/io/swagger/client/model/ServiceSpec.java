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
import io.swagger.client.model.EndpointSpec;
import io.swagger.client.model.ServiceSpecMode;
import io.swagger.client.model.ServiceSpecRollbackConfig;
import io.swagger.client.model.ServiceSpecUpdateConfig;
import io.swagger.client.model.TaskSpec;
import io.swagger.client.model.TaskSpecNetworks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User modifiable configuration for a service.
 */
@ApiModel(description = "User modifiable configuration for a service.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class ServiceSpec {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Labels")
  private Map<String, String> labels = null;

  @SerializedName("TaskTemplate")
  private TaskSpec taskTemplate = null;

  @SerializedName("Mode")
  private ServiceSpecMode mode = null;

  @SerializedName("UpdateConfig")
  private ServiceSpecUpdateConfig updateConfig = null;

  @SerializedName("RollbackConfig")
  private ServiceSpecRollbackConfig rollbackConfig = null;

  @SerializedName("Networks")
  private List<TaskSpecNetworks> networks = null;

  @SerializedName("EndpointSpec")
  private EndpointSpec endpointSpec = null;

  public ServiceSpec name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the service.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the service.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ServiceSpec labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public ServiceSpec putLabelsItem(String key, String labelsItem) {
    if (this.labels == null) {
      this.labels = new HashMap<String, String>();
    }
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * User-defined key/value metadata.
   * @return labels
  **/
  @ApiModelProperty(value = "User-defined key/value metadata.")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public ServiceSpec taskTemplate(TaskSpec taskTemplate) {
    this.taskTemplate = taskTemplate;
    return this;
  }

   /**
   * Get taskTemplate
   * @return taskTemplate
  **/
  @ApiModelProperty(value = "")
  public TaskSpec getTaskTemplate() {
    return taskTemplate;
  }

  public void setTaskTemplate(TaskSpec taskTemplate) {
    this.taskTemplate = taskTemplate;
  }

  public ServiceSpec mode(ServiceSpecMode mode) {
    this.mode = mode;
    return this;
  }

   /**
   * Get mode
   * @return mode
  **/
  @ApiModelProperty(value = "")
  public ServiceSpecMode getMode() {
    return mode;
  }

  public void setMode(ServiceSpecMode mode) {
    this.mode = mode;
  }

  public ServiceSpec updateConfig(ServiceSpecUpdateConfig updateConfig) {
    this.updateConfig = updateConfig;
    return this;
  }

   /**
   * Get updateConfig
   * @return updateConfig
  **/
  @ApiModelProperty(value = "")
  public ServiceSpecUpdateConfig getUpdateConfig() {
    return updateConfig;
  }

  public void setUpdateConfig(ServiceSpecUpdateConfig updateConfig) {
    this.updateConfig = updateConfig;
  }

  public ServiceSpec rollbackConfig(ServiceSpecRollbackConfig rollbackConfig) {
    this.rollbackConfig = rollbackConfig;
    return this;
  }

   /**
   * Get rollbackConfig
   * @return rollbackConfig
  **/
  @ApiModelProperty(value = "")
  public ServiceSpecRollbackConfig getRollbackConfig() {
    return rollbackConfig;
  }

  public void setRollbackConfig(ServiceSpecRollbackConfig rollbackConfig) {
    this.rollbackConfig = rollbackConfig;
  }

  public ServiceSpec networks(List<TaskSpecNetworks> networks) {
    this.networks = networks;
    return this;
  }

  public ServiceSpec addNetworksItem(TaskSpecNetworks networksItem) {
    if (this.networks == null) {
      this.networks = new ArrayList<TaskSpecNetworks>();
    }
    this.networks.add(networksItem);
    return this;
  }

   /**
   * Array of network names or IDs to attach the service to.
   * @return networks
  **/
  @ApiModelProperty(value = "Array of network names or IDs to attach the service to.")
  public List<TaskSpecNetworks> getNetworks() {
    return networks;
  }

  public void setNetworks(List<TaskSpecNetworks> networks) {
    this.networks = networks;
  }

  public ServiceSpec endpointSpec(EndpointSpec endpointSpec) {
    this.endpointSpec = endpointSpec;
    return this;
  }

   /**
   * Get endpointSpec
   * @return endpointSpec
  **/
  @ApiModelProperty(value = "")
  public EndpointSpec getEndpointSpec() {
    return endpointSpec;
  }

  public void setEndpointSpec(EndpointSpec endpointSpec) {
    this.endpointSpec = endpointSpec;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ServiceSpec serviceSpec = (ServiceSpec) o;
    return Objects.equals(this.name, serviceSpec.name) &&
        Objects.equals(this.labels, serviceSpec.labels) &&
        Objects.equals(this.taskTemplate, serviceSpec.taskTemplate) &&
        Objects.equals(this.mode, serviceSpec.mode) &&
        Objects.equals(this.updateConfig, serviceSpec.updateConfig) &&
        Objects.equals(this.rollbackConfig, serviceSpec.rollbackConfig) &&
        Objects.equals(this.networks, serviceSpec.networks) &&
        Objects.equals(this.endpointSpec, serviceSpec.endpointSpec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, labels, taskTemplate, mode, updateConfig, rollbackConfig, networks, endpointSpec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceSpec {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    taskTemplate: ").append(toIndentedString(taskTemplate)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    updateConfig: ").append(toIndentedString(updateConfig)).append("\n");
    sb.append("    rollbackConfig: ").append(toIndentedString(rollbackConfig)).append("\n");
    sb.append("    networks: ").append(toIndentedString(networks)).append("\n");
    sb.append("    endpointSpec: ").append(toIndentedString(endpointSpec)).append("\n");
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

