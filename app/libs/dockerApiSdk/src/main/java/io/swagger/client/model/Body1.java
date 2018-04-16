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
import io.swagger.client.model.SwarmSpec;
import java.io.IOException;

/**
 * Body1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T23:55:34.685+04:00")
public class Body1 {
  @SerializedName("ListenAddr")
  private String listenAddr = null;

  @SerializedName("AdvertiseAddr")
  private String advertiseAddr = null;

  @SerializedName("DataPathAddr")
  private String dataPathAddr = null;

  @SerializedName("ForceNewCluster")
  private Boolean forceNewCluster = null;

  @SerializedName("Spec")
  private SwarmSpec spec = null;

  public Body1 listenAddr(String listenAddr) {
    this.listenAddr = listenAddr;
    return this;
  }

   /**
   * Listen address used for inter-manager communication, as well as determining the networking interface used for the VXLAN Tunnel Endpoint (VTEP). This can either be an address/port combination in the form &#x60;192.168.1.1:4567&#x60;, or an interface followed by a port number, like &#x60;eth0:4567&#x60;. If the port number is omitted, the default swarm listening port is used.
   * @return listenAddr
  **/
  @ApiModelProperty(value = "Listen address used for inter-manager communication, as well as determining the networking interface used for the VXLAN Tunnel Endpoint (VTEP). This can either be an address/port combination in the form `192.168.1.1:4567`, or an interface followed by a port number, like `eth0:4567`. If the port number is omitted, the default swarm listening port is used.")
  public String getListenAddr() {
    return listenAddr;
  }

  public void setListenAddr(String listenAddr) {
    this.listenAddr = listenAddr;
  }

  public Body1 advertiseAddr(String advertiseAddr) {
    this.advertiseAddr = advertiseAddr;
    return this;
  }

   /**
   * Externally reachable address advertised to other nodes. This can either be an address/port combination in the form &#x60;192.168.1.1:4567&#x60;, or an interface followed by a port number, like &#x60;eth0:4567&#x60;. If the port number is omitted, the port number from the listen address is used. If &#x60;AdvertiseAddr&#x60; is not specified, it will be automatically detected when possible.
   * @return advertiseAddr
  **/
  @ApiModelProperty(value = "Externally reachable address advertised to other nodes. This can either be an address/port combination in the form `192.168.1.1:4567`, or an interface followed by a port number, like `eth0:4567`. If the port number is omitted, the port number from the listen address is used. If `AdvertiseAddr` is not specified, it will be automatically detected when possible.")
  public String getAdvertiseAddr() {
    return advertiseAddr;
  }

  public void setAdvertiseAddr(String advertiseAddr) {
    this.advertiseAddr = advertiseAddr;
  }

  public Body1 dataPathAddr(String dataPathAddr) {
    this.dataPathAddr = dataPathAddr;
    return this;
  }

   /**
   * Address or interface to use for data path traffic (format: &#x60;&lt;ip|interface&gt;&#x60;), for example,  &#x60;192.168.1.1&#x60;, or an interface, like &#x60;eth0&#x60;. If &#x60;DataPathAddr&#x60; is unspecified, the same address as &#x60;AdvertiseAddr&#x60; is used.  The &#x60;DataPathAddr&#x60; specifies the address that global scope network drivers will publish towards other nodes in order to reach the containers running on this node. Using this parameter it is possible to separate the container data traffic from the management traffic of the cluster. 
   * @return dataPathAddr
  **/
  @ApiModelProperty(value = "Address or interface to use for data path traffic (format: `<ip|interface>`), for example,  `192.168.1.1`, or an interface, like `eth0`. If `DataPathAddr` is unspecified, the same address as `AdvertiseAddr` is used.  The `DataPathAddr` specifies the address that global scope network drivers will publish towards other nodes in order to reach the containers running on this node. Using this parameter it is possible to separate the container data traffic from the management traffic of the cluster. ")
  public String getDataPathAddr() {
    return dataPathAddr;
  }

  public void setDataPathAddr(String dataPathAddr) {
    this.dataPathAddr = dataPathAddr;
  }

  public Body1 forceNewCluster(Boolean forceNewCluster) {
    this.forceNewCluster = forceNewCluster;
    return this;
  }

   /**
   * Force creation of a new swarm.
   * @return forceNewCluster
  **/
  @ApiModelProperty(value = "Force creation of a new swarm.")
  public Boolean isForceNewCluster() {
    return forceNewCluster;
  }

  public void setForceNewCluster(Boolean forceNewCluster) {
    this.forceNewCluster = forceNewCluster;
  }

  public Body1 spec(SwarmSpec spec) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body1 body1 = (Body1) o;
    return Objects.equals(this.listenAddr, body1.listenAddr) &&
        Objects.equals(this.advertiseAddr, body1.advertiseAddr) &&
        Objects.equals(this.dataPathAddr, body1.dataPathAddr) &&
        Objects.equals(this.forceNewCluster, body1.forceNewCluster) &&
        Objects.equals(this.spec, body1.spec);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listenAddr, advertiseAddr, dataPathAddr, forceNewCluster, spec);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body1 {\n");
    
    sb.append("    listenAddr: ").append(toIndentedString(listenAddr)).append("\n");
    sb.append("    advertiseAddr: ").append(toIndentedString(advertiseAddr)).append("\n");
    sb.append("    dataPathAddr: ").append(toIndentedString(dataPathAddr)).append("\n");
    sb.append("    forceNewCluster: ").append(toIndentedString(forceNewCluster)).append("\n");
    sb.append("    spec: ").append(toIndentedString(spec)).append("\n");
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

