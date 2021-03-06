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
import io.swagger.client.model.ManagerStatus;
import io.swagger.client.model.NodeDescription;
import io.swagger.client.model.NodeSpec;
import io.swagger.client.model.NodeStatus;
import io.swagger.client.model.ObjectVersion;
import java.io.IOException;

/**
 * Node
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class Node {
  @SerializedName("ID")
  private String ID = null;

  @SerializedName("Version")
  private ObjectVersion version = null;

  @SerializedName("CreatedAt")
  private String createdAt = null;

  @SerializedName("UpdatedAt")
  private String updatedAt = null;

  @SerializedName("Spec")
  private NodeSpec spec = null;

  @SerializedName("Description")
  private NodeDescription description = null;

  @SerializedName("Status")
  private NodeStatus status = null;

  @SerializedName("ManagerStatus")
  private ManagerStatus managerStatus = null;

  public Node ID(String ID) {
    this.ID = ID;
    return this;
  }

   /**
   * Get ID
   * @return ID
  **/
  @ApiModelProperty(example = "24ifsmvkjbyhk", value = "")
  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public Node version(ObjectVersion version) {
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

  public Node createdAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Date and time at which the node was added to the swarm in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. 
   * @return createdAt
  **/
  @ApiModelProperty(example = "2016-08-18T10:44:24.496525531Z", value = "Date and time at which the node was added to the swarm in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. ")
  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public Node updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Date and time at which the node was last updated in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. 
   * @return updatedAt
  **/
  @ApiModelProperty(example = "2017-08-09T07:09:37.632105588Z", value = "Date and time at which the node was last updated in [RFC 3339](https://www.ietf.org/rfc/rfc3339.txt) format with nano-seconds. ")
  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Node spec(NodeSpec spec) {
    this.spec = spec;
    return this;
  }

   /**
   * Get spec
   * @return spec
  **/
  @ApiModelProperty(value = "")
  public NodeSpec getSpec() {
    return spec;
  }

  public void setSpec(NodeSpec spec) {
    this.spec = spec;
  }

  public Node description(NodeDescription description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public NodeDescription getDescription() {
    return description;
  }

  public void setDescription(NodeDescription description) {
    this.description = description;
  }

  public Node status(NodeStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public NodeStatus getStatus() {
    return status;
  }

  public void setStatus(NodeStatus status) {
    this.status = status;
  }

  public Node managerStatus(ManagerStatus managerStatus) {
    this.managerStatus = managerStatus;
    return this;
  }

   /**
   * Get managerStatus
   * @return managerStatus
  **/
  @ApiModelProperty(value = "")
  public ManagerStatus getManagerStatus() {
    return managerStatus;
  }

  public void setManagerStatus(ManagerStatus managerStatus) {
    this.managerStatus = managerStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(this.ID, node.ID) &&
        Objects.equals(this.version, node.version) &&
        Objects.equals(this.createdAt, node.createdAt) &&
        Objects.equals(this.updatedAt, node.updatedAt) &&
        Objects.equals(this.spec, node.spec) &&
        Objects.equals(this.description, node.description) &&
        Objects.equals(this.status, node.status) &&
        Objects.equals(this.managerStatus, node.managerStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ID, version, createdAt, updatedAt, spec, description, status, managerStatus);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Node {\n");
    
    sb.append("    ID: ").append(toIndentedString(ID)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    managerStatus: ").append(toIndentedString(managerStatus)).append("\n");
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

