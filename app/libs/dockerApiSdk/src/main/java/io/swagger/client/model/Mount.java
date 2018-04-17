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
import io.swagger.client.model.MountBindOptions;
import io.swagger.client.model.MountTmpfsOptions;
import io.swagger.client.model.MountVolumeOptions;
import java.io.IOException;

/**
 * Mount
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class Mount {
  @SerializedName("Target")
  private String target = null;

  @SerializedName("Source")
  private String source = null;

  /**
   * The mount type. Available types:  - &#x60;bind&#x60; Mounts a file or directory from the host into the container. Must exist prior to creating the container. - &#x60;volume&#x60; Creates a volume with the given name and options (or uses a pre-existing volume with the same name and options). These are **not** removed when the container is removed. - &#x60;tmpfs&#x60; Create a tmpfs with the given options. The mount source cannot be specified for tmpfs. 
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    BIND("bind"),
    
    VOLUME("volume"),
    
    TMPFS("tmpfs");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("Type")
  private TypeEnum type = null;

  @SerializedName("ReadOnly")
  private Boolean readOnly = null;

  @SerializedName("Consistency")
  private String consistency = null;

  @SerializedName("BindOptions")
  private MountBindOptions bindOptions = null;

  @SerializedName("VolumeOptions")
  private MountVolumeOptions volumeOptions = null;

  @SerializedName("TmpfsOptions")
  private MountTmpfsOptions tmpfsOptions = null;

  public Mount target(String target) {
    this.target = target;
    return this;
  }

   /**
   * Container path.
   * @return target
  **/
  @ApiModelProperty(value = "Container path.")
  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public Mount source(String source) {
    this.source = source;
    return this;
  }

   /**
   * Mount source (e.g. a volume name, a host path).
   * @return source
  **/
  @ApiModelProperty(value = "Mount source (e.g. a volume name, a host path).")
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public Mount type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The mount type. Available types:  - &#x60;bind&#x60; Mounts a file or directory from the host into the container. Must exist prior to creating the container. - &#x60;volume&#x60; Creates a volume with the given name and options (or uses a pre-existing volume with the same name and options). These are **not** removed when the container is removed. - &#x60;tmpfs&#x60; Create a tmpfs with the given options. The mount source cannot be specified for tmpfs. 
   * @return type
  **/
  @ApiModelProperty(value = "The mount type. Available types:  - `bind` Mounts a file or directory from the host into the container. Must exist prior to creating the container. - `volume` Creates a volume with the given name and options (or uses a pre-existing volume with the same name and options). These are **not** removed when the container is removed. - `tmpfs` Create a tmpfs with the given options. The mount source cannot be specified for tmpfs. ")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Mount readOnly(Boolean readOnly) {
    this.readOnly = readOnly;
    return this;
  }

   /**
   * Whether the mount should be read-only.
   * @return readOnly
  **/
  @ApiModelProperty(value = "Whether the mount should be read-only.")
  public Boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  public Mount consistency(String consistency) {
    this.consistency = consistency;
    return this;
  }

   /**
   * The consistency requirement for the mount: &#x60;default&#x60;, &#x60;consistent&#x60;, &#x60;cached&#x60;, or &#x60;delegated&#x60;.
   * @return consistency
  **/
  @ApiModelProperty(value = "The consistency requirement for the mount: `default`, `consistent`, `cached`, or `delegated`.")
  public String getConsistency() {
    return consistency;
  }

  public void setConsistency(String consistency) {
    this.consistency = consistency;
  }

  public Mount bindOptions(MountBindOptions bindOptions) {
    this.bindOptions = bindOptions;
    return this;
  }

   /**
   * Get bindOptions
   * @return bindOptions
  **/
  @ApiModelProperty(value = "")
  public MountBindOptions getBindOptions() {
    return bindOptions;
  }

  public void setBindOptions(MountBindOptions bindOptions) {
    this.bindOptions = bindOptions;
  }

  public Mount volumeOptions(MountVolumeOptions volumeOptions) {
    this.volumeOptions = volumeOptions;
    return this;
  }

   /**
   * Get volumeOptions
   * @return volumeOptions
  **/
  @ApiModelProperty(value = "")
  public MountVolumeOptions getVolumeOptions() {
    return volumeOptions;
  }

  public void setVolumeOptions(MountVolumeOptions volumeOptions) {
    this.volumeOptions = volumeOptions;
  }

  public Mount tmpfsOptions(MountTmpfsOptions tmpfsOptions) {
    this.tmpfsOptions = tmpfsOptions;
    return this;
  }

   /**
   * Get tmpfsOptions
   * @return tmpfsOptions
  **/
  @ApiModelProperty(value = "")
  public MountTmpfsOptions getTmpfsOptions() {
    return tmpfsOptions;
  }

  public void setTmpfsOptions(MountTmpfsOptions tmpfsOptions) {
    this.tmpfsOptions = tmpfsOptions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Mount mount = (Mount) o;
    return Objects.equals(this.target, mount.target) &&
        Objects.equals(this.source, mount.source) &&
        Objects.equals(this.type, mount.type) &&
        Objects.equals(this.readOnly, mount.readOnly) &&
        Objects.equals(this.consistency, mount.consistency) &&
        Objects.equals(this.bindOptions, mount.bindOptions) &&
        Objects.equals(this.volumeOptions, mount.volumeOptions) &&
        Objects.equals(this.tmpfsOptions, mount.tmpfsOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(target, source, type, readOnly, consistency, bindOptions, volumeOptions, tmpfsOptions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mount {\n");
    
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
    sb.append("    consistency: ").append(toIndentedString(consistency)).append("\n");
    sb.append("    bindOptions: ").append(toIndentedString(bindOptions)).append("\n");
    sb.append("    volumeOptions: ").append(toIndentedString(volumeOptions)).append("\n");
    sb.append("    tmpfsOptions: ").append(toIndentedString(tmpfsOptions)).append("\n");
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

