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

/**
 * EndpointPortConfig
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T04:24:49.247+04:00")
public class EndpointPortConfig {
  @SerializedName("Name")
  private String name = null;

  /**
   * Gets or Sets protocol
   */
  @JsonAdapter(ProtocolEnum.Adapter.class)
  public enum ProtocolEnum {
    TCP("tcp"),
    
    UDP("udp"),
    
    SCTP("sctp");

    private String value;

    ProtocolEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ProtocolEnum fromValue(String text) {
      for (ProtocolEnum b : ProtocolEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ProtocolEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ProtocolEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ProtocolEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ProtocolEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("Protocol")
  private ProtocolEnum protocol = null;

  @SerializedName("TargetPort")
  private Integer targetPort = null;

  @SerializedName("PublishedPort")
  private Integer publishedPort = null;

  /**
   * The mode in which port is published.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  - \&quot;ingress\&quot; makes the target port accessible on on every node,   regardless of whether there is a task for the service running on   that node or not. - \&quot;host\&quot; bypasses the routing mesh and publish the port directly on   the swarm node where that service is running. 
   */
  @JsonAdapter(PublishModeEnum.Adapter.class)
  public enum PublishModeEnum {
    INGRESS("ingress"),
    
    HOST("host");

    private String value;

    PublishModeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PublishModeEnum fromValue(String text) {
      for (PublishModeEnum b : PublishModeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PublishModeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PublishModeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PublishModeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return PublishModeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("PublishMode")
  private PublishModeEnum publishMode = PublishModeEnum.INGRESS;

  public EndpointPortConfig name(String name) {
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

  public EndpointPortConfig protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

   /**
   * Get protocol
   * @return protocol
  **/
  @ApiModelProperty(value = "")
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public EndpointPortConfig targetPort(Integer targetPort) {
    this.targetPort = targetPort;
    return this;
  }

   /**
   * The port inside the container.
   * @return targetPort
  **/
  @ApiModelProperty(value = "The port inside the container.")
  public Integer getTargetPort() {
    return targetPort;
  }

  public void setTargetPort(Integer targetPort) {
    this.targetPort = targetPort;
  }

  public EndpointPortConfig publishedPort(Integer publishedPort) {
    this.publishedPort = publishedPort;
    return this;
  }

   /**
   * The port on the swarm hosts.
   * @return publishedPort
  **/
  @ApiModelProperty(value = "The port on the swarm hosts.")
  public Integer getPublishedPort() {
    return publishedPort;
  }

  public void setPublishedPort(Integer publishedPort) {
    this.publishedPort = publishedPort;
  }

  public EndpointPortConfig publishMode(PublishModeEnum publishMode) {
    this.publishMode = publishMode;
    return this;
  }

   /**
   * The mode in which port is published.  &lt;p&gt;&lt;br /&gt;&lt;/p&gt;  - \&quot;ingress\&quot; makes the target port accessible on on every node,   regardless of whether there is a task for the service running on   that node or not. - \&quot;host\&quot; bypasses the routing mesh and publish the port directly on   the swarm node where that service is running. 
   * @return publishMode
  **/
  @ApiModelProperty(example = "ingress", value = "The mode in which port is published.  <p><br /></p>  - \"ingress\" makes the target port accessible on on every node,   regardless of whether there is a task for the service running on   that node or not. - \"host\" bypasses the routing mesh and publish the port directly on   the swarm node where that service is running. ")
  public PublishModeEnum getPublishMode() {
    return publishMode;
  }

  public void setPublishMode(PublishModeEnum publishMode) {
    this.publishMode = publishMode;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndpointPortConfig endpointPortConfig = (EndpointPortConfig) o;
    return Objects.equals(this.name, endpointPortConfig.name) &&
        Objects.equals(this.protocol, endpointPortConfig.protocol) &&
        Objects.equals(this.targetPort, endpointPortConfig.targetPort) &&
        Objects.equals(this.publishedPort, endpointPortConfig.publishedPort) &&
        Objects.equals(this.publishMode, endpointPortConfig.publishMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, protocol, targetPort, publishedPort, publishMode);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndpointPortConfig {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    protocol: ").append(toIndentedString(protocol)).append("\n");
    sb.append("    targetPort: ").append(toIndentedString(targetPort)).append("\n");
    sb.append("    publishedPort: ").append(toIndentedString(publishedPort)).append("\n");
    sb.append("    publishMode: ").append(toIndentedString(publishMode)).append("\n");
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

