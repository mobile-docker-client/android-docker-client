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
import io.swagger.client.model.IPAM;
import io.swagger.client.model.NetworkContainer;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Network
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-15T21:07:44.853+04:00")
public class Network {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Id")
  private String id = null;

  @SerializedName("Created")
  private String created = null;

  @SerializedName("Scope")
  private String scope = null;

  @SerializedName("Driver")
  private String driver = null;

  @SerializedName("EnableIPv6")
  private Boolean enableIPv6 = null;

  @SerializedName("IPAM")
  private IPAM IPAM = null;

  @SerializedName("Internal")
  private Boolean internal = null;

  @SerializedName("Attachable")
  private Boolean attachable = null;

  @SerializedName("Ingress")
  private Boolean ingress = null;

  @SerializedName("Containers")
  private Map<String, NetworkContainer> containers = null;

  @SerializedName("Options")
  private Map<String, String> options = null;

  @SerializedName("Labels")
  private Map<String, String> labels = null;

  public Network name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Network id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Network created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(value = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Network scope(String scope) {
    this.scope = scope;
    return this;
  }

   /**
   * Get scope
   * @return scope
  **/
  @ApiModelProperty(value = "")
  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public Network driver(String driver) {
    this.driver = driver;
    return this;
  }

   /**
   * Get driver
   * @return driver
  **/
  @ApiModelProperty(value = "")
  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public Network enableIPv6(Boolean enableIPv6) {
    this.enableIPv6 = enableIPv6;
    return this;
  }

   /**
   * Get enableIPv6
   * @return enableIPv6
  **/
  @ApiModelProperty(value = "")
  public Boolean isEnableIPv6() {
    return enableIPv6;
  }

  public void setEnableIPv6(Boolean enableIPv6) {
    this.enableIPv6 = enableIPv6;
  }

  public Network IPAM(IPAM IPAM) {
    this.IPAM = IPAM;
    return this;
  }

   /**
   * Get IPAM
   * @return IPAM
  **/
  @ApiModelProperty(value = "")
  public IPAM getIPAM() {
    return IPAM;
  }

  public void setIPAM(IPAM IPAM) {
    this.IPAM = IPAM;
  }

  public Network internal(Boolean internal) {
    this.internal = internal;
    return this;
  }

   /**
   * Get internal
   * @return internal
  **/
  @ApiModelProperty(value = "")
  public Boolean isInternal() {
    return internal;
  }

  public void setInternal(Boolean internal) {
    this.internal = internal;
  }

  public Network attachable(Boolean attachable) {
    this.attachable = attachable;
    return this;
  }

   /**
   * Get attachable
   * @return attachable
  **/
  @ApiModelProperty(value = "")
  public Boolean isAttachable() {
    return attachable;
  }

  public void setAttachable(Boolean attachable) {
    this.attachable = attachable;
  }

  public Network ingress(Boolean ingress) {
    this.ingress = ingress;
    return this;
  }

   /**
   * Get ingress
   * @return ingress
  **/
  @ApiModelProperty(value = "")
  public Boolean isIngress() {
    return ingress;
  }

  public void setIngress(Boolean ingress) {
    this.ingress = ingress;
  }

  public Network containers(Map<String, NetworkContainer> containers) {
    this.containers = containers;
    return this;
  }

  public Network putContainersItem(String key, NetworkContainer containersItem) {
    if (this.containers == null) {
      this.containers = new HashMap<String, NetworkContainer>();
    }
    this.containers.put(key, containersItem);
    return this;
  }

   /**
   * Get containers
   * @return containers
  **/
  @ApiModelProperty(value = "")
  public Map<String, NetworkContainer> getContainers() {
    return containers;
  }

  public void setContainers(Map<String, NetworkContainer> containers) {
    this.containers = containers;
  }

  public Network options(Map<String, String> options) {
    this.options = options;
    return this;
  }

  public Network putOptionsItem(String key, String optionsItem) {
    if (this.options == null) {
      this.options = new HashMap<String, String>();
    }
    this.options.put(key, optionsItem);
    return this;
  }

   /**
   * Get options
   * @return options
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }

  public Network labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public Network putLabelsItem(String key, String labelsItem) {
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
  @ApiModelProperty(value = "")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Network network = (Network) o;
    return Objects.equals(this.name, network.name) &&
        Objects.equals(this.id, network.id) &&
        Objects.equals(this.created, network.created) &&
        Objects.equals(this.scope, network.scope) &&
        Objects.equals(this.driver, network.driver) &&
        Objects.equals(this.enableIPv6, network.enableIPv6) &&
        Objects.equals(this.IPAM, network.IPAM) &&
        Objects.equals(this.internal, network.internal) &&
        Objects.equals(this.attachable, network.attachable) &&
        Objects.equals(this.ingress, network.ingress) &&
        Objects.equals(this.containers, network.containers) &&
        Objects.equals(this.options, network.options) &&
        Objects.equals(this.labels, network.labels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, id, created, scope, driver, enableIPv6, IPAM, internal, attachable, ingress, containers, options, labels);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Network {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    enableIPv6: ").append(toIndentedString(enableIPv6)).append("\n");
    sb.append("    IPAM: ").append(toIndentedString(IPAM)).append("\n");
    sb.append("    internal: ").append(toIndentedString(internal)).append("\n");
    sb.append("    attachable: ").append(toIndentedString(attachable)).append("\n");
    sb.append("    ingress: ").append(toIndentedString(ingress)).append("\n");
    sb.append("    containers: ").append(toIndentedString(containers)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
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

