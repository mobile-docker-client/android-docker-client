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
import io.swagger.client.model.ContainerSummary;
import io.swagger.client.model.ImageSummary;
import io.swagger.client.model.Volume;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SystemDataUsageResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class SystemDataUsageResponse {
  @SerializedName("LayersSize")
  private Long layersSize = null;

  @SerializedName("Images")
  private List<ImageSummary> images = null;

  @SerializedName("Containers")
  private List<ContainerSummary> containers = null;

  @SerializedName("Volumes")
  private List<Volume> volumes = null;

  public SystemDataUsageResponse layersSize(Long layersSize) {
    this.layersSize = layersSize;
    return this;
  }

   /**
   * Get layersSize
   * @return layersSize
  **/
  @ApiModelProperty(value = "")
  public Long getLayersSize() {
    return layersSize;
  }

  public void setLayersSize(Long layersSize) {
    this.layersSize = layersSize;
  }

  public SystemDataUsageResponse images(List<ImageSummary> images) {
    this.images = images;
    return this;
  }

  public SystemDataUsageResponse addImagesItem(ImageSummary imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<ImageSummary>();
    }
    this.images.add(imagesItem);
    return this;
  }

   /**
   * Get images
   * @return images
  **/
  @ApiModelProperty(value = "")
  public List<ImageSummary> getImages() {
    return images;
  }

  public void setImages(List<ImageSummary> images) {
    this.images = images;
  }

  public SystemDataUsageResponse containers(List<ContainerSummary> containers) {
    this.containers = containers;
    return this;
  }

  public SystemDataUsageResponse addContainersItem(ContainerSummary containersItem) {
    if (this.containers == null) {
      this.containers = new ArrayList<ContainerSummary>();
    }
    this.containers.add(containersItem);
    return this;
  }

   /**
   * Get containers
   * @return containers
  **/
  @ApiModelProperty(value = "")
  public List<ContainerSummary> getContainers() {
    return containers;
  }

  public void setContainers(List<ContainerSummary> containers) {
    this.containers = containers;
  }

  public SystemDataUsageResponse volumes(List<Volume> volumes) {
    this.volumes = volumes;
    return this;
  }

  public SystemDataUsageResponse addVolumesItem(Volume volumesItem) {
    if (this.volumes == null) {
      this.volumes = new ArrayList<Volume>();
    }
    this.volumes.add(volumesItem);
    return this;
  }

   /**
   * Get volumes
   * @return volumes
  **/
  @ApiModelProperty(value = "")
  public List<Volume> getVolumes() {
    return volumes;
  }

  public void setVolumes(List<Volume> volumes) {
    this.volumes = volumes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SystemDataUsageResponse systemDataUsageResponse = (SystemDataUsageResponse) o;
    return Objects.equals(this.layersSize, systemDataUsageResponse.layersSize) &&
        Objects.equals(this.images, systemDataUsageResponse.images) &&
        Objects.equals(this.containers, systemDataUsageResponse.containers) &&
        Objects.equals(this.volumes, systemDataUsageResponse.volumes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(layersSize, images, containers, volumes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SystemDataUsageResponse {\n");
    
    sb.append("    layersSize: ").append(toIndentedString(layersSize)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    containers: ").append(toIndentedString(containers)).append("\n");
    sb.append("    volumes: ").append(toIndentedString(volumes)).append("\n");
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

