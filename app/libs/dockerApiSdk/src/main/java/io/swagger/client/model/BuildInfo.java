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
import io.swagger.client.model.ErrorDetail;
import io.swagger.client.model.ImageID;
import io.swagger.client.model.ProgressDetail;
import java.io.IOException;

/**
 * BuildInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class BuildInfo {
  @SerializedName("id")
  private String id = null;

  @SerializedName("stream")
  private String stream = null;

  @SerializedName("error")
  private String error = null;

  @SerializedName("errorDetail")
  private ErrorDetail errorDetail = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("progress")
  private String progress = null;

  @SerializedName("progressDetail")
  private ProgressDetail progressDetail = null;

  @SerializedName("aux")
  private ImageID aux = null;

  public BuildInfo id(String id) {
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

  public BuildInfo stream(String stream) {
    this.stream = stream;
    return this;
  }

   /**
   * Get stream
   * @return stream
  **/
  @ApiModelProperty(value = "")
  public String getStream() {
    return stream;
  }

  public void setStream(String stream) {
    this.stream = stream;
  }

  public BuildInfo error(String error) {
    this.error = error;
    return this;
  }

   /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(value = "")
  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public BuildInfo errorDetail(ErrorDetail errorDetail) {
    this.errorDetail = errorDetail;
    return this;
  }

   /**
   * Get errorDetail
   * @return errorDetail
  **/
  @ApiModelProperty(value = "")
  public ErrorDetail getErrorDetail() {
    return errorDetail;
  }

  public void setErrorDetail(ErrorDetail errorDetail) {
    this.errorDetail = errorDetail;
  }

  public BuildInfo status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BuildInfo progress(String progress) {
    this.progress = progress;
    return this;
  }

   /**
   * Get progress
   * @return progress
  **/
  @ApiModelProperty(value = "")
  public String getProgress() {
    return progress;
  }

  public void setProgress(String progress) {
    this.progress = progress;
  }

  public BuildInfo progressDetail(ProgressDetail progressDetail) {
    this.progressDetail = progressDetail;
    return this;
  }

   /**
   * Get progressDetail
   * @return progressDetail
  **/
  @ApiModelProperty(value = "")
  public ProgressDetail getProgressDetail() {
    return progressDetail;
  }

  public void setProgressDetail(ProgressDetail progressDetail) {
    this.progressDetail = progressDetail;
  }

  public BuildInfo aux(ImageID aux) {
    this.aux = aux;
    return this;
  }

   /**
   * Get aux
   * @return aux
  **/
  @ApiModelProperty(value = "")
  public ImageID getAux() {
    return aux;
  }

  public void setAux(ImageID aux) {
    this.aux = aux;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BuildInfo buildInfo = (BuildInfo) o;
    return Objects.equals(this.id, buildInfo.id) &&
        Objects.equals(this.stream, buildInfo.stream) &&
        Objects.equals(this.error, buildInfo.error) &&
        Objects.equals(this.errorDetail, buildInfo.errorDetail) &&
        Objects.equals(this.status, buildInfo.status) &&
        Objects.equals(this.progress, buildInfo.progress) &&
        Objects.equals(this.progressDetail, buildInfo.progressDetail) &&
        Objects.equals(this.aux, buildInfo.aux);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, stream, error, errorDetail, status, progress, progressDetail, aux);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BuildInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    stream: ").append(toIndentedString(stream)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorDetail: ").append(toIndentedString(errorDetail)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
    sb.append("    progressDetail: ").append(toIndentedString(progressDetail)).append("\n");
    sb.append("    aux: ").append(toIndentedString(aux)).append("\n");
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

