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
import io.swagger.client.model.VolumeUsageData;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Volume
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class Volume {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Driver")
  private String driver = null;

  @SerializedName("Mountpoint")
  private String mountpoint = null;

  @SerializedName("CreatedAt")
  private String createdAt = null;

  @SerializedName("Status")
  private Map<String, Object> status = null;

  @SerializedName("Labels")
  private Map<String, String> labels = new HashMap<String, String>();

  /**
   * The level at which the volume exists. Either &#x60;global&#x60; for cluster-wide, or &#x60;local&#x60; for machine level.
   */
  @JsonAdapter(ScopeEnum.Adapter.class)
  public enum ScopeEnum {
    LOCAL("local"),
    
    GLOBAL("global");

    private String value;

    ScopeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ScopeEnum fromValue(String text) {
      for (ScopeEnum b : ScopeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ScopeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ScopeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ScopeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ScopeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("Scope")
  private ScopeEnum scope = ScopeEnum.LOCAL;

  @SerializedName("Options")
  private Map<String, String> options = new HashMap<String, String>();

  @SerializedName("UsageData")
  private VolumeUsageData usageData = null;

  public Volume name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the volume.
   * @return name
  **/
  @ApiModelProperty(required = true, value = "Name of the volume.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Volume driver(String driver) {
    this.driver = driver;
    return this;
  }

   /**
   * Name of the volume driver used by the volume.
   * @return driver
  **/
  @ApiModelProperty(required = true, value = "Name of the volume driver used by the volume.")
  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public Volume mountpoint(String mountpoint) {
    this.mountpoint = mountpoint;
    return this;
  }

   /**
   * Mount path of the volume on the host.
   * @return mountpoint
  **/
  @ApiModelProperty(required = true, value = "Mount path of the volume on the host.")
  public String getMountpoint() {
    return mountpoint;
  }

  public void setMountpoint(String mountpoint) {
    this.mountpoint = mountpoint;
  }

  public Volume createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Date/Time the volume was created.
   * @return createdAt
  **/
  @ApiModelProperty(value = "Date/Time the volume was created.")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Volume status(Map<String, Object> status) {
    this.status = status;
    return this;
  }

  public Volume putStatusItem(String key, Object statusItem) {
    if (this.status == null) {
      this.status = new HashMap<String, Object>();
    }
    this.status.put(key, statusItem);
    return this;
  }

   /**
   * Low-level details about the volume, provided by the volume driver. Details are returned as a map with key/value pairs: &#x60;{\&quot;key\&quot;:\&quot;value\&quot;,\&quot;key2\&quot;:\&quot;value2\&quot;}&#x60;.  The &#x60;Status&#x60; field is optional, and is omitted if the volume driver does not support this feature. 
   * @return status
  **/
  @ApiModelProperty(value = "Low-level details about the volume, provided by the volume driver. Details are returned as a map with key/value pairs: `{\"key\":\"value\",\"key2\":\"value2\"}`.  The `Status` field is optional, and is omitted if the volume driver does not support this feature. ")
  public Map<String, Object> getStatus() {
    return status;
  }

  public void setStatus(Map<String, Object> status) {
    this.status = status;
  }

  public Volume labels(Map<String, String> labels) {
    this.labels = labels;
    return this;
  }

  public Volume putLabelsItem(String key, String labelsItem) {
    this.labels.put(key, labelsItem);
    return this;
  }

   /**
   * User-defined key/value metadata.
   * @return labels
  **/
  @ApiModelProperty(required = true, value = "User-defined key/value metadata.")
  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels;
  }

  public Volume scope(ScopeEnum scope) {
    this.scope = scope;
    return this;
  }

   /**
   * The level at which the volume exists. Either &#x60;global&#x60; for cluster-wide, or &#x60;local&#x60; for machine level.
   * @return scope
  **/
  @ApiModelProperty(required = true, value = "The level at which the volume exists. Either `global` for cluster-wide, or `local` for machine level.")
  public ScopeEnum getScope() {
    return scope;
  }

  public void setScope(ScopeEnum scope) {
    this.scope = scope;
  }

  public Volume options(Map<String, String> options) {
    this.options = options;
    return this;
  }

  public Volume putOptionsItem(String key, String optionsItem) {
    this.options.put(key, optionsItem);
    return this;
  }

   /**
   * The driver specific options used when creating the volume.
   * @return options
  **/
  @ApiModelProperty(required = true, value = "The driver specific options used when creating the volume.")
  public Map<String, String> getOptions() {
    return options;
  }

  public void setOptions(Map<String, String> options) {
    this.options = options;
  }

  public Volume usageData(VolumeUsageData usageData) {
    this.usageData = usageData;
    return this;
  }

   /**
   * Get usageData
   * @return usageData
  **/
  @ApiModelProperty(value = "")
  public VolumeUsageData getUsageData() {
    return usageData;
  }

  public void setUsageData(VolumeUsageData usageData) {
    this.usageData = usageData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Volume volume = (Volume) o;
    return Objects.equals(this.name, volume.name) &&
        Objects.equals(this.driver, volume.driver) &&
        Objects.equals(this.mountpoint, volume.mountpoint) &&
        Objects.equals(this.createdAt, volume.createdAt) &&
        Objects.equals(this.status, volume.status) &&
        Objects.equals(this.labels, volume.labels) &&
        Objects.equals(this.scope, volume.scope) &&
        Objects.equals(this.options, volume.options) &&
        Objects.equals(this.usageData, volume.usageData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, driver, mountpoint, createdAt, status, labels, scope, options, usageData);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Volume {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    mountpoint: ").append(toIndentedString(mountpoint)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n");
    sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    usageData: ").append(toIndentedString(usageData)).append("\n");
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

