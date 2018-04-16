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
import java.util.Map;

/**
 * IPAM
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class IPAM {
  @SerializedName("Driver")
  private String driver = "default";

  @SerializedName("Config")
  private List<Map<String, String>> config = null;

  @SerializedName("Options")
  private List<Map<String, String>> options = null;

  public IPAM driver(String driver) {
    this.driver = driver;
    return this;
  }

   /**
   * Name of the IPAM driver to use.
   * @return driver
  **/
  @ApiModelProperty(value = "Name of the IPAM driver to use.")
  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public IPAM config(List<Map<String, String>> config) {
    this.config = config;
    return this;
  }

  public IPAM addConfigItem(Map<String, String> configItem) {
    if (this.config == null) {
      this.config = new ArrayList<Map<String, String>>();
    }
    this.config.add(configItem);
    return this;
  }

   /**
   * List of IPAM configuration options, specified as a map: &#x60;{\&quot;Subnet\&quot;: &lt;CIDR&gt;, \&quot;IPRange\&quot;: &lt;CIDR&gt;, \&quot;Gateway\&quot;: &lt;IP address&gt;, \&quot;AuxAddress\&quot;: &lt;device_name:IP address&gt;}&#x60;
   * @return config
  **/
  @ApiModelProperty(value = "List of IPAM configuration options, specified as a map: `{\"Subnet\": <CIDR>, \"IPRange\": <CIDR>, \"Gateway\": <IP address>, \"AuxAddress\": <device_name:IP address>}`")
  public List<Map<String, String>> getConfig() {
    return config;
  }

  public void setConfig(List<Map<String, String>> config) {
    this.config = config;
  }

  public IPAM options(List<Map<String, String>> options) {
    this.options = options;
    return this;
  }

  public IPAM addOptionsItem(Map<String, String> optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<Map<String, String>>();
    }
    this.options.add(optionsItem);
    return this;
  }

   /**
   * Driver-specific options, specified as a map.
   * @return options
  **/
  @ApiModelProperty(value = "Driver-specific options, specified as a map.")
  public List<Map<String, String>> getOptions() {
    return options;
  }

  public void setOptions(List<Map<String, String>> options) {
    this.options = options;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IPAM IPAM = (IPAM) o;
    return Objects.equals(this.driver, IPAM.driver) &&
        Objects.equals(this.config, IPAM.config) &&
        Objects.equals(this.options, IPAM.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driver, config, options);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IPAM {\n");
    
    sb.append("    driver: ").append(toIndentedString(driver)).append("\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

