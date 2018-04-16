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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * EndpointIPAMConfig represents an endpoint&#39;s IPAM configuration. 
 */
@ApiModel(description = "EndpointIPAMConfig represents an endpoint's IPAM configuration. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class EndpointIPAMConfig {
  @SerializedName("IPv4Address")
  private String ipv4Address = null;

  @SerializedName("IPv6Address")
  private String ipv6Address = null;

  @SerializedName("LinkLocalIPs")
  private List<String> linkLocalIPs = null;

  public EndpointIPAMConfig ipv4Address(String ipv4Address) {
    this.ipv4Address = ipv4Address;
    return this;
  }

   /**
   * Get ipv4Address
   * @return ipv4Address
  **/
  @ApiModelProperty(example = "172.20.30.33", value = "")
  public String getIpv4Address() {
    return ipv4Address;
  }

  public void setIpv4Address(String ipv4Address) {
    this.ipv4Address = ipv4Address;
  }

  public EndpointIPAMConfig ipv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
    return this;
  }

   /**
   * Get ipv6Address
   * @return ipv6Address
  **/
  @ApiModelProperty(example = "2001:db8:abcd::3033", value = "")
  public String getIpv6Address() {
    return ipv6Address;
  }

  public void setIpv6Address(String ipv6Address) {
    this.ipv6Address = ipv6Address;
  }

  public EndpointIPAMConfig linkLocalIPs(List<String> linkLocalIPs) {
    this.linkLocalIPs = linkLocalIPs;
    return this;
  }

  public EndpointIPAMConfig addLinkLocalIPsItem(String linkLocalIPsItem) {
    if (this.linkLocalIPs == null) {
      this.linkLocalIPs = new ArrayList<String>();
    }
    this.linkLocalIPs.add(linkLocalIPsItem);
    return this;
  }

   /**
   * Get linkLocalIPs
   * @return linkLocalIPs
  **/
  @ApiModelProperty(example = "[\"169.254.34.68\",\"fe80::3468\"]", value = "")
  public List<String> getLinkLocalIPs() {
    return linkLocalIPs;
  }

  public void setLinkLocalIPs(List<String> linkLocalIPs) {
    this.linkLocalIPs = linkLocalIPs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndpointIPAMConfig endpointIPAMConfig = (EndpointIPAMConfig) o;
    return Objects.equals(this.ipv4Address, endpointIPAMConfig.ipv4Address) &&
        Objects.equals(this.ipv6Address, endpointIPAMConfig.ipv6Address) &&
        Objects.equals(this.linkLocalIPs, endpointIPAMConfig.linkLocalIPs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ipv4Address, ipv6Address, linkLocalIPs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndpointIPAMConfig {\n");
    
    sb.append("    ipv4Address: ").append(toIndentedString(ipv4Address)).append("\n");
    sb.append("    ipv6Address: ").append(toIndentedString(ipv6Address)).append("\n");
    sb.append("    linkLocalIPs: ").append(toIndentedString(linkLocalIPs)).append("\n");
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

