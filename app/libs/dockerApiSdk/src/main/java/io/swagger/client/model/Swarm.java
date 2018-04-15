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
import io.swagger.client.model.ClusterInfo;
import io.swagger.client.model.JoinTokens;
import io.swagger.client.model.ObjectVersion;
import io.swagger.client.model.SwarmSpec;
import io.swagger.client.model.TLSInfo;
import java.io.IOException;

/**
 * Swarm
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-15T21:07:44.853+04:00")
public class Swarm {
  @SerializedName("ID")
  private String ID = null;

  @SerializedName("Version")
  private ObjectVersion version = null;

  @SerializedName("CreatedAt")
  private String createdAt = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  @SerializedName("Spec")
  private SwarmSpec spec = null;

  @SerializedName("TLSInfo")
  private TLSInfo tlSInfo = null;

  @SerializedName("RootRotationInProgress")
  private Boolean rootRotationInProgress = null;

  @SerializedName("JoinTokens")
  private JoinTokens joinTokens = null;

  public Swarm ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * The ID of the swarm.
   * @return ID
  **/
  @ApiModelProperty(example = "abajmipo7b4xz5ip2nrla6b11", value = "The ID of the swarm.")
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public Swarm version(ObjectVersion version) {
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @ApiModelProperty(value = "")
  public ObjectVersion getVersion() {
    return version;
  }

  public void setVersion(ObjectVersion version) {
    this.version = version;
  }

  public Swarm createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Date and time at which the swarm was initialised in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. 
   * @return createdAt
  **/
  @ApiModelProperty(example = "2016-08-18T10:44:24.496525531Z", value = "Date and time at which the swarm was initialised in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. ")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Swarm updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Date and time at which the swarm was last updated in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. 
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2017-08-09T07:09:37.632105588Z", value = "Date and time at which the swarm was last updated in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. ")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Swarm spec(SwarmSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Get spec
   * @return spec
  **/
  @ApiModelProperty(value = "")
  public SwarmSpec getSpec() {
    return spec;
  }

  public void setSpec(SwarmSpec spec) {
    this.spec = spec;
  }

  public Swarm tlSInfo(TLSInfo tlSInfo) {
    this.tlSInfo = tlSInfo;
    return this;
  }

   /**
   * Get tlSInfo
   * @return tlSInfo
  **/
  @ApiModelProperty(value = "")
  public TLSInfo getTlSInfo() {
    return tlSInfo;
  }

  public void setTlSInfo(TLSInfo tlSInfo) {
    this.tlSInfo = tlSInfo;
  }

  public Swarm rootRotationInProgress(Boolean rootRotationInProgress) {
    this.rootRotationInProgress = rootRotationInProgress;
    return this;
  }

   /**
   * Whether there is currently a root CA rotation in progress for the swarm
   * @return rootRotationInProgress
  **/
  @ApiModelProperty(example = "false", value = "Whether there is currently a root CA rotation in progress for the swarm")
  public Boolean isRootRotationInProgress() {
    return rootRotationInProgress;
  }

  public void setRootRotationInProgress(Boolean rootRotationInProgress) {
    this.rootRotationInProgress = rootRotationInProgress;
  }

  public Swarm joinTokens(JoinTokens joinTokens) {
    this.joinTokens = joinTokens;
    return this;
  }

   /**
   * Get joinTokens
   * @return joinTokens
  **/
  @ApiModelProperty(value = "")
  public JoinTokens getJoinTokens() {
    return joinTokens;
  }

  public void setJoinTokens(JoinTokens joinTokens) {
    this.joinTokens = joinTokens;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Swarm swarm = (Swarm) o;
    return Objects.equals(this.ID, swarm.ID) &&
        Objects.equals(this.version, swarm.version) &&
        Objects.equals(this.createdAt, swarm.createdAt) &&
        Objects.equals(this.updatedAt, swarm.updatedAt) &&
        Objects.equals(this.spec, swarm.spec) &&
        Objects.equals(this.tlSInfo, swarm.tlSInfo) &&
        Objects.equals(this.rootRotationInProgress, swarm.rootRotationInProgress) &&
        Objects.equals(this.joinTokens, swarm.joinTokens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, version, createdAt, updatedAt, spec, tlSInfo, rootRotationInProgress, joinTokens);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Swarm {\n");
    
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
    sb.append("    tlSInfo: ").append(toIndentedString(tlSInfo)).append("\n");
    sb.append("    rootRotationInProgress: ").append(toIndentedString(rootRotationInProgress)).append("\n");
    sb.append("    joinTokens: ").append(toIndentedString(joinTokens)).append("\n");
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

