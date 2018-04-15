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
import io.swagger.client.model.ContainerConfig;
import io.swagger.client.model.GraphDriverData;
import io.swagger.client.model.ImageMetadata;
import io.swagger.client.model.ImageRootFS;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Image
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-15T21:07:44.853+04:00")
public class Image {
  @SerializedName("Id")
  private String id = null;

  @SerializedName("RepoTags")
  private List<String> repoTags = null;

  @SerializedName("RepoDigests")
  private List<String> repoDigests = null;

  @SerializedName("Parent")
  private String parent = null;

  @SerializedName("Comment")
  private String comment = null;

  @SerializedName("Created")
  private String created = null;

  @SerializedName("Container")
  private String container = null;

  @SerializedName("ContainerConfig")
  private ContainerConfig containerConfig = null;

  @SerializedName("DockerVersion")
  private String dockerVersion = null;

  @SerializedName("Author")
  private String author = null;

  @SerializedName("Config")
  private ContainerConfig config = null;

  @SerializedName("Architecture")
  private String architecture = null;

  @SerializedName("Os")
  private String os = null;

  @SerializedName("OsVersion")
  private String osVersion = null;

  @SerializedName("Size")
  private Long size = null;

  @SerializedName("VirtualSize")
  private Long virtualSize = null;

  @SerializedName("GraphDriver")
  private GraphDriverData graphDriver = null;

  @SerializedName("RootFS")
  private ImageRootFS rootFS = null;

  @SerializedName("Metadata")
  private ImageMetadata metadata = null;

  public Image id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Image repoTags(List<String> repoTags) {
    this.repoTags = repoTags;
    return this;
  }

  public Image addRepoTagsItem(String repoTagsItem) {
    if (this.repoTags == null) {
      this.repoTags = new ArrayList<String>();
    }
    this.repoTags.add(repoTagsItem);
    return this;
  }

   /**
   * Get repoTags
   * @return repoTags
  **/
  @ApiModelProperty(value = "")
  public List<String> getRepoTags() {
    return repoTags;
  }

  public void setRepoTags(List<String> repoTags) {
    this.repoTags = repoTags;
  }

  public Image repoDigests(List<String> repoDigests) {
    this.repoDigests = repoDigests;
    return this;
  }

  public Image addRepoDigestsItem(String repoDigestsItem) {
    if (this.repoDigests == null) {
      this.repoDigests = new ArrayList<String>();
    }
    this.repoDigests.add(repoDigestsItem);
    return this;
  }

   /**
   * Get repoDigests
   * @return repoDigests
  **/
  @ApiModelProperty(value = "")
  public List<String> getRepoDigests() {
    return repoDigests;
  }

  public void setRepoDigests(List<String> repoDigests) {
    this.repoDigests = repoDigests;
  }

  public Image parent(String parent) {
    this.parent = parent;
    return this;
  }

   /**
   * Get parent
   * @return parent
  **/
  @ApiModelProperty(required = true, value = "")
  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public Image comment(String comment) {
    this.comment = comment;
    return this;
  }

   /**
   * Get comment
   * @return comment
  **/
  @ApiModelProperty(required = true, value = "")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Image created(String created) {
    this.created = created;
    return this;
  }

   /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Image container(String container) {
    this.container = container;
    return this;
  }

   /**
   * Get container
   * @return container
  **/
  @ApiModelProperty(required = true, value = "")
  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

  public Image containerConfig(ContainerConfig containerConfig) {
    this.containerConfig = containerConfig;
    return this;
  }

   /**
   * Get containerConfig
   * @return containerConfig
  **/
  @ApiModelProperty(value = "")
  public ContainerConfig getContainerConfig() {
    return containerConfig;
  }

  public void setContainerConfig(ContainerConfig containerConfig) {
    this.containerConfig = containerConfig;
  }

  public Image dockerVersion(String dockerVersion) {
    this.dockerVersion = dockerVersion;
    return this;
  }

   /**
   * Get dockerVersion
   * @return dockerVersion
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDockerVersion() {
    return dockerVersion;
  }

  public void setDockerVersion(String dockerVersion) {
    this.dockerVersion = dockerVersion;
  }

  public Image author(String author) {
    this.author = author;
    return this;
  }

   /**
   * Get author
   * @return author
  **/
  @ApiModelProperty(required = true, value = "")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Image config(ContainerConfig config) {
    this.config = config;
    return this;
  }

   /**
   * Get config
   * @return config
  **/
  @ApiModelProperty(value = "")
  public ContainerConfig getConfig() {
    return config;
  }

  public void setConfig(ContainerConfig config) {
    this.config = config;
  }

  public Image architecture(String architecture) {
    this.architecture = architecture;
    return this;
  }

   /**
   * Get architecture
   * @return architecture
  **/
  @ApiModelProperty(required = true, value = "")
  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public Image os(String os) {
    this.os = os;
    return this;
  }

   /**
   * Get os
   * @return os
  **/
  @ApiModelProperty(required = true, value = "")
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public Image osVersion(String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

   /**
   * Get osVersion
   * @return osVersion
  **/
  @ApiModelProperty(value = "")
  public String getOsVersion() {
    return osVersion;
  }

  public void setOsVersion(String osVersion) {
    this.osVersion = osVersion;
  }

  public Image size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * Get size
   * @return size
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public Image virtualSize(Long virtualSize) {
    this.virtualSize = virtualSize;
    return this;
  }

   /**
   * Get virtualSize
   * @return virtualSize
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getVirtualSize() {
    return virtualSize;
  }

  public void setVirtualSize(Long virtualSize) {
    this.virtualSize = virtualSize;
  }

  public Image graphDriver(GraphDriverData graphDriver) {
    this.graphDriver = graphDriver;
    return this;
  }

   /**
   * Get graphDriver
   * @return graphDriver
  **/
  @ApiModelProperty(required = true, value = "")
  public GraphDriverData getGraphDriver() {
    return graphDriver;
  }

  public void setGraphDriver(GraphDriverData graphDriver) {
    this.graphDriver = graphDriver;
  }

  public Image rootFS(ImageRootFS rootFS) {
    this.rootFS = rootFS;
    return this;
  }

   /**
   * Get rootFS
   * @return rootFS
  **/
  @ApiModelProperty(required = true, value = "")
  public ImageRootFS getRootFS() {
    return rootFS;
  }

  public void setRootFS(ImageRootFS rootFS) {
    this.rootFS = rootFS;
  }

  public Image metadata(ImageMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  public ImageMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(ImageMetadata metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Image image = (Image) o;
    return Objects.equals(this.id, image.id) &&
        Objects.equals(this.repoTags, image.repoTags) &&
        Objects.equals(this.repoDigests, image.repoDigests) &&
        Objects.equals(this.parent, image.parent) &&
        Objects.equals(this.comment, image.comment) &&
        Objects.equals(this.created, image.created) &&
        Objects.equals(this.container, image.container) &&
        Objects.equals(this.containerConfig, image.containerConfig) &&
        Objects.equals(this.dockerVersion, image.dockerVersion) &&
        Objects.equals(this.author, image.author) &&
        Objects.equals(this.config, image.config) &&
        Objects.equals(this.architecture, image.architecture) &&
        Objects.equals(this.os, image.os) &&
        Objects.equals(this.osVersion, image.osVersion) &&
        Objects.equals(this.size, image.size) &&
        Objects.equals(this.virtualSize, image.virtualSize) &&
        Objects.equals(this.graphDriver, image.graphDriver) &&
        Objects.equals(this.rootFS, image.rootFS) &&
        Objects.equals(this.metadata, image.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, repoTags, repoDigests, parent, comment, created, container, containerConfig, dockerVersion, author, config, architecture, os, osVersion, size, virtualSize, graphDriver, rootFS, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    repoTags: ").append(toIndentedString(repoTags)).append("\n");
    sb.append("    repoDigests: ").append(toIndentedString(repoDigests)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    container: ").append(toIndentedString(container)).append("\n");
    sb.append("    containerConfig: ").append(toIndentedString(containerConfig)).append("\n");
    sb.append("    dockerVersion: ").append(toIndentedString(dockerVersion)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    architecture: ").append(toIndentedString(architecture)).append("\n");
    sb.append("    os: ").append(toIndentedString(os)).append("\n");
    sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    virtualSize: ").append(toIndentedString(virtualSize)).append("\n");
    sb.append("    graphDriver: ").append(toIndentedString(graphDriver)).append("\n");
    sb.append("    rootFS: ").append(toIndentedString(rootFS)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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

