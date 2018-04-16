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
 * IndexInfo contains information about a registry.
 */
@ApiModel(description = "IndexInfo contains information about a registry.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class IndexInfo {
  @SerializedName("Name")
  private String name = null;

  @SerializedName("Mirrors")
  private List<String> mirrors = null;

  @SerializedName("Secure")
  private Boolean secure = null;

  @SerializedName("Official")
  private Boolean official = null;

  public IndexInfo name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the registry, such as \&quot;docker.io\&quot;. 
   * @return name
  **/
  @ApiModelProperty(example = "docker.io", value = "Name of the registry, such as \"docker.io\". ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public IndexInfo mirrors(List<String> mirrors) {
    this.mirrors = mirrors;
    return this;
  }

  public IndexInfo addMirrorsItem(String mirrorsItem) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList<String>();
    }
    this.mirrors.add(mirrorsItem);
    return this;
  }

   /**
   * List of mirrors, expressed as URIs. 
   * @return mirrors
  **/
  @ApiModelProperty(example = "[\"https://hub-mirror.corp.example.com:5000/\",\"https://registry-2.docker.io/\",\"https://registry-3.docker.io/\"]", value = "List of mirrors, expressed as URIs. ")
  public List<String> getMirrors() {
    return mirrors;
  }

  public void setMirrors(List<String> mirrors) {
    this.mirrors = mirrors;
  }

  public IndexInfo secure(Boolean secure) {
    this.secure = secure;
    return this;
  }

   /**
   * Indicates if the the registry is part of the list of insecure registries.  If &#x60;false&#x60;, the registry is insecure. Insecure registries accept un-encrypted (HTTP) and/or untrusted (HTTPS with certificates from unknown CAs) communication.  &gt; **Warning**: Insecure registries can be useful when running a local &gt; registry. However, because its use creates security vulnerabilities &gt; it should ONLY be enabled for testing purposes. For increased &gt; security, users should add their CA to their system&#39;s list of &gt; trusted CAs instead of enabling this option. 
   * @return secure
  **/
  @ApiModelProperty(example = "true", value = "Indicates if the the registry is part of the list of insecure registries.  If `false`, the registry is insecure. Insecure registries accept un-encrypted (HTTP) and/or untrusted (HTTPS with certificates from unknown CAs) communication.  > **Warning**: Insecure registries can be useful when running a local > registry. However, because its use creates security vulnerabilities > it should ONLY be enabled for testing purposes. For increased > security, users should add their CA to their system's list of > trusted CAs instead of enabling this option. ")
  public Boolean isSecure() {
    return secure;
  }

  public void setSecure(Boolean secure) {
    this.secure = secure;
  }

  public IndexInfo official(Boolean official) {
    this.official = official;
    return this;
  }

   /**
   * Indicates whether this is an official registry (i.e., Docker Hub / docker.io) 
   * @return official
  **/
  @ApiModelProperty(example = "true", value = "Indicates whether this is an official registry (i.e., Docker Hub / docker.io) ")
  public Boolean isOfficial() {
    return official;
  }

  public void setOfficial(Boolean official) {
    this.official = official;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndexInfo indexInfo = (IndexInfo) o;
    return Objects.equals(this.name, indexInfo.name) &&
        Objects.equals(this.mirrors, indexInfo.mirrors) &&
        Objects.equals(this.secure, indexInfo.secure) &&
        Objects.equals(this.official, indexInfo.official);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, mirrors, secure, official);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IndexInfo {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    mirrors: ").append(toIndentedString(mirrors)).append("\n");
    sb.append("    secure: ").append(toIndentedString(secure)).append("\n");
    sb.append("    official: ").append(toIndentedString(official)).append("\n");
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

