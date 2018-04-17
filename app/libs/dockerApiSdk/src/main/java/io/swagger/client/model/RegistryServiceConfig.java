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
import io.swagger.client.model.IndexInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RegistryServiceConfig stores daemon registry services configuration. 
 */
@ApiModel(description = "RegistryServiceConfig stores daemon registry services configuration. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-17T00:16:49.279+04:00")
public class RegistryServiceConfig {
  @SerializedName("AllowNondistributableArtifactsCIDRs")
  private List<String> allowNondistributableArtifactsCIDRs = null;

  @SerializedName("AllowNondistributableArtifactsHostnames")
  private List<String> allowNondistributableArtifactsHostnames = null;

  @SerializedName("InsecureRegistryCIDRs")
  private List<String> insecureRegistryCIDRs = null;

  @SerializedName("IndexConfigs")
  private Map<String, IndexInfo> indexConfigs = null;

  @SerializedName("Mirrors")
  private List<String> mirrors = null;

  public RegistryServiceConfig allowNondistributableArtifactsCIDRs(List<String> allowNondistributableArtifactsCIDRs) {
    this.allowNondistributableArtifactsCIDRs = allowNondistributableArtifactsCIDRs;
    return this;
  }

  public RegistryServiceConfig addAllowNondistributableArtifactsCIDRsItem(String allowNondistributableArtifactsCIDRsItem) {
    if (this.allowNondistributableArtifactsCIDRs == null) {
      this.allowNondistributableArtifactsCIDRs = new ArrayList<String>();
    }
    this.allowNondistributableArtifactsCIDRs.add(allowNondistributableArtifactsCIDRsItem);
    return this;
  }

   /**
   * List of IP ranges to which nondistributable artifacts can be pushed, using the CIDR syntax [RFC 4632](https://tools.ietf.org/html/4632).  Some images (for example, Windows base images) contain artifacts whose distribution is restricted by license. When these images are pushed to a registry, restricted artifacts are not included.  This configuration override this behavior, and enables the daemon to push nondistributable artifacts to all registries whose resolved IP address is within the subnet described by the CIDR syntax.  This option is useful when pushing images containing nondistributable artifacts to a registry on an air-gapped network so hosts on that network can pull the images without connecting to another server.  &gt; **Warning**: Nondistributable artifacts typically have restrictions &gt; on how and where they can be distributed and shared. Only use this &gt; feature to push artifacts to private registries and ensure that you &gt; are in compliance with any terms that cover redistributing &gt; nondistributable artifacts. 
   * @return allowNondistributableArtifactsCIDRs
  **/
  @ApiModelProperty(example = "[\"::1/128\",\"127.0.0.0/8\"]", value = "List of IP ranges to which nondistributable artifacts can be pushed, using the CIDR syntax [RFC 4632](https://tools.ietf.org/html/4632).  Some images (for example, Windows base images) contain artifacts whose distribution is restricted by license. When these images are pushed to a registry, restricted artifacts are not included.  This configuration override this behavior, and enables the daemon to push nondistributable artifacts to all registries whose resolved IP address is within the subnet described by the CIDR syntax.  This option is useful when pushing images containing nondistributable artifacts to a registry on an air-gapped network so hosts on that network can pull the images without connecting to another server.  > **Warning**: Nondistributable artifacts typically have restrictions > on how and where they can be distributed and shared. Only use this > feature to push artifacts to private registries and ensure that you > are in compliance with any terms that cover redistributing > nondistributable artifacts. ")
  public List<String> getAllowNondistributableArtifactsCIDRs() {
    return allowNondistributableArtifactsCIDRs;
  }

  public void setAllowNondistributableArtifactsCIDRs(List<String> allowNondistributableArtifactsCIDRs) {
    this.allowNondistributableArtifactsCIDRs = allowNondistributableArtifactsCIDRs;
  }

  public RegistryServiceConfig allowNondistributableArtifactsHostnames(List<String> allowNondistributableArtifactsHostnames) {
    this.allowNondistributableArtifactsHostnames = allowNondistributableArtifactsHostnames;
    return this;
  }

  public RegistryServiceConfig addAllowNondistributableArtifactsHostnamesItem(String allowNondistributableArtifactsHostnamesItem) {
    if (this.allowNondistributableArtifactsHostnames == null) {
      this.allowNondistributableArtifactsHostnames = new ArrayList<String>();
    }
    this.allowNondistributableArtifactsHostnames.add(allowNondistributableArtifactsHostnamesItem);
    return this;
  }

   /**
   * List of registry hostnames to which nondistributable artifacts can be pushed, using the format &#x60;&lt;hostname&gt;[:&lt;port&gt;]&#x60; or &#x60;&lt;IP address&gt;[:&lt;port&gt;]&#x60;.  Some images (for example, Windows base images) contain artifacts whose distribution is restricted by license. When these images are pushed to a registry, restricted artifacts are not included.  This configuration override this behavior for the specified registries.  This option is useful when pushing images containing nondistributable artifacts to a registry on an air-gapped network so hosts on that network can pull the images without connecting to another server.  &gt; **Warning**: Nondistributable artifacts typically have restrictions &gt; on how and where they can be distributed and shared. Only use this &gt; feature to push artifacts to private registries and ensure that you &gt; are in compliance with any terms that cover redistributing &gt; nondistributable artifacts. 
   * @return allowNondistributableArtifactsHostnames
  **/
  @ApiModelProperty(example = "[\"registry.internal.corp.example.com:3000\",\"[2001:db8:a0b:12f0::1]:443\"]", value = "List of registry hostnames to which nondistributable artifacts can be pushed, using the format `<hostname>[:<port>]` or `<IP address>[:<port>]`.  Some images (for example, Windows base images) contain artifacts whose distribution is restricted by license. When these images are pushed to a registry, restricted artifacts are not included.  This configuration override this behavior for the specified registries.  This option is useful when pushing images containing nondistributable artifacts to a registry on an air-gapped network so hosts on that network can pull the images without connecting to another server.  > **Warning**: Nondistributable artifacts typically have restrictions > on how and where they can be distributed and shared. Only use this > feature to push artifacts to private registries and ensure that you > are in compliance with any terms that cover redistributing > nondistributable artifacts. ")
  public List<String> getAllowNondistributableArtifactsHostnames() {
    return allowNondistributableArtifactsHostnames;
  }

  public void setAllowNondistributableArtifactsHostnames(List<String> allowNondistributableArtifactsHostnames) {
    this.allowNondistributableArtifactsHostnames = allowNondistributableArtifactsHostnames;
  }

  public RegistryServiceConfig insecureRegistryCIDRs(List<String> insecureRegistryCIDRs) {
    this.insecureRegistryCIDRs = insecureRegistryCIDRs;
    return this;
  }

  public RegistryServiceConfig addInsecureRegistryCIDRsItem(String insecureRegistryCIDRsItem) {
    if (this.insecureRegistryCIDRs == null) {
      this.insecureRegistryCIDRs = new ArrayList<String>();
    }
    this.insecureRegistryCIDRs.add(insecureRegistryCIDRsItem);
    return this;
  }

   /**
   * List of IP ranges of insecure registries, using the CIDR syntax ([RFC 4632](https://tools.ietf.org/html/4632)). Insecure registries accept un-encrypted (HTTP) and/or untrusted (HTTPS with certificates from unknown CAs) communication.  By default, local registries (&#x60;127.0.0.0/8&#x60;) are configured as insecure. All other registries are secure. Communicating with an insecure registry is not possible if the daemon assumes that registry is secure.  This configuration override this behavior, insecure communication with registries whose resolved IP address is within the subnet described by the CIDR syntax.  Registries can also be marked insecure by hostname. Those registries are listed under &#x60;IndexConfigs&#x60; and have their &#x60;Secure&#x60; field set to &#x60;false&#x60;.  &gt; **Warning**: Using this option can be useful when running a local &gt; registry, but introduces security vulnerabilities. This option &gt; should therefore ONLY be used for testing purposes. For increased &gt; security, users should add their CA to their system&#39;s list of trusted &gt; CAs instead of enabling this option. 
   * @return insecureRegistryCIDRs
  **/
  @ApiModelProperty(example = "[\"::1/128\",\"127.0.0.0/8\"]", value = "List of IP ranges of insecure registries, using the CIDR syntax ([RFC 4632](https://tools.ietf.org/html/4632)). Insecure registries accept un-encrypted (HTTP) and/or untrusted (HTTPS with certificates from unknown CAs) communication.  By default, local registries (`127.0.0.0/8`) are configured as insecure. All other registries are secure. Communicating with an insecure registry is not possible if the daemon assumes that registry is secure.  This configuration override this behavior, insecure communication with registries whose resolved IP address is within the subnet described by the CIDR syntax.  Registries can also be marked insecure by hostname. Those registries are listed under `IndexConfigs` and have their `Secure` field set to `false`.  > **Warning**: Using this option can be useful when running a local > registry, but introduces security vulnerabilities. This option > should therefore ONLY be used for testing purposes. For increased > security, users should add their CA to their system's list of trusted > CAs instead of enabling this option. ")
  public List<String> getInsecureRegistryCIDRs() {
    return insecureRegistryCIDRs;
  }

  public void setInsecureRegistryCIDRs(List<String> insecureRegistryCIDRs) {
    this.insecureRegistryCIDRs = insecureRegistryCIDRs;
  }

  public RegistryServiceConfig indexConfigs(Map<String, IndexInfo> indexConfigs) {
    this.indexConfigs = indexConfigs;
    return this;
  }

  public RegistryServiceConfig putIndexConfigsItem(String key, IndexInfo indexConfigsItem) {
    if (this.indexConfigs == null) {
      this.indexConfigs = new HashMap<String, IndexInfo>();
    }
    this.indexConfigs.put(key, indexConfigsItem);
    return this;
  }

   /**
   * Get indexConfigs
   * @return indexConfigs
  **/
  @ApiModelProperty(example = "{\"127.0.0.1:5000\":{\"Name\":\"127.0.0.1:5000\",\"Mirrors\":[],\"Secure\":false,\"Official\":false},\"[2001:db8:a0b:12f0::1]:80\":{\"Name\":\"[2001:db8:a0b:12f0::1]:80\",\"Mirrors\":[],\"Secure\":false,\"Official\":false},\"docker.io\":{\"Name\":\"docker.io\",\"Mirrors\":[\"https://hub-mirror.corp.example.com:5000/\"],\"Secure\":true,\"Official\":true},\"registry.internal.corp.example.com:3000\":{\"Name\":\"registry.internal.corp.example.com:3000\",\"Mirrors\":[],\"Secure\":false,\"Official\":false}}", value = "")
  public Map<String, IndexInfo> getIndexConfigs() {
    return indexConfigs;
  }

  public void setIndexConfigs(Map<String, IndexInfo> indexConfigs) {
    this.indexConfigs = indexConfigs;
  }

  public RegistryServiceConfig mirrors(List<String> mirrors) {
    this.mirrors = mirrors;
    return this;
  }

  public RegistryServiceConfig addMirrorsItem(String mirrorsItem) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList<String>();
    }
    this.mirrors.add(mirrorsItem);
    return this;
  }

   /**
   * List of registry URLs that act as a mirror for the official (&#x60;docker.io&#x60;) registry. 
   * @return mirrors
  **/
  @ApiModelProperty(example = "[\"https://hub-mirror.corp.example.com:5000/\",\"https://[2001:db8:a0b:12f0::1]/\"]", value = "List of registry URLs that act as a mirror for the official (`docker.io`) registry. ")
  public List<String> getMirrors() {
    return mirrors;
  }

  public void setMirrors(List<String> mirrors) {
    this.mirrors = mirrors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegistryServiceConfig registryServiceConfig = (RegistryServiceConfig) o;
    return Objects.equals(this.allowNondistributableArtifactsCIDRs, registryServiceConfig.allowNondistributableArtifactsCIDRs) &&
        Objects.equals(this.allowNondistributableArtifactsHostnames, registryServiceConfig.allowNondistributableArtifactsHostnames) &&
        Objects.equals(this.insecureRegistryCIDRs, registryServiceConfig.insecureRegistryCIDRs) &&
        Objects.equals(this.indexConfigs, registryServiceConfig.indexConfigs) &&
        Objects.equals(this.mirrors, registryServiceConfig.mirrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowNondistributableArtifactsCIDRs, allowNondistributableArtifactsHostnames, insecureRegistryCIDRs, indexConfigs, mirrors);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegistryServiceConfig {\n");
    
    sb.append("    allowNondistributableArtifactsCIDRs: ").append(toIndentedString(allowNondistributableArtifactsCIDRs)).append("\n");
    sb.append("    allowNondistributableArtifactsHostnames: ").append(toIndentedString(allowNondistributableArtifactsHostnames)).append("\n");
    sb.append("    insecureRegistryCIDRs: ").append(toIndentedString(insecureRegistryCIDRs)).append("\n");
    sb.append("    indexConfigs: ").append(toIndentedString(indexConfigs)).append("\n");
    sb.append("    mirrors: ").append(toIndentedString(mirrors)).append("\n");
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
