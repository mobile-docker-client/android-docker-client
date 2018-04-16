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
 * A test to perform to check that the container is healthy.
 */
@ApiModel(description = "A test to perform to check that the container is healthy.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T04:24:49.247+04:00")
public class HealthConfig {
  @SerializedName("Test")
  private List<String> test = null;

  @SerializedName("Interval")
  private Integer interval = null;

  @SerializedName("Timeout")
  private Integer timeout = null;

  @SerializedName("Retries")
  private Integer retries = null;

  @SerializedName("StartPeriod")
  private Integer startPeriod = null;

  public HealthConfig test(List<String> test) {
    this.test = test;
    return this;
  }

  public HealthConfig addTestItem(String testItem) {
    if (this.test == null) {
      this.test = new ArrayList<String>();
    }
    this.test.add(testItem);
    return this;
  }

   /**
   * The test to perform. Possible values are:  - &#x60;[]&#x60; inherit healthcheck from image or parent image - &#x60;[\&quot;NONE\&quot;]&#x60; disable healthcheck - &#x60;[\&quot;CMD\&quot;, args...]&#x60; exec arguments directly - &#x60;[\&quot;CMD-SHELL\&quot;, command]&#x60; run command with system&#39;s default shell 
   * @return test
  **/
  @ApiModelProperty(value = "The test to perform. Possible values are:  - `[]` inherit healthcheck from image or parent image - `[\"NONE\"]` disable healthcheck - `[\"CMD\", args...]` exec arguments directly - `[\"CMD-SHELL\", command]` run command with system's default shell ")
  public List<String> getTest() {
    return test;
  }

  public void setTest(List<String> test) {
    this.test = test;
  }

  public HealthConfig interval(Integer interval) {
    this.interval = interval;
    return this;
  }

   /**
   * The time to wait between checks in nanoseconds. It should be 0 or at least 1000000 (1 ms). 0 means inherit.
   * @return interval
  **/
  @ApiModelProperty(value = "The time to wait between checks in nanoseconds. It should be 0 or at least 1000000 (1 ms). 0 means inherit.")
  public Integer getInterval() {
    return interval;
  }

  public void setInterval(Integer interval) {
    this.interval = interval;
  }

  public HealthConfig timeout(Integer timeout) {
    this.timeout = timeout;
    return this;
  }

   /**
   * The time to wait before considering the check to have hung. It should be 0 or at least 1000000 (1 ms). 0 means inherit.
   * @return timeout
  **/
  @ApiModelProperty(value = "The time to wait before considering the check to have hung. It should be 0 or at least 1000000 (1 ms). 0 means inherit.")
  public Integer getTimeout() {
    return timeout;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public HealthConfig retries(Integer retries) {
    this.retries = retries;
    return this;
  }

   /**
   * The number of consecutive failures needed to consider a container as unhealthy. 0 means inherit.
   * @return retries
  **/
  @ApiModelProperty(value = "The number of consecutive failures needed to consider a container as unhealthy. 0 means inherit.")
  public Integer getRetries() {
    return retries;
  }

  public void setRetries(Integer retries) {
    this.retries = retries;
  }

  public HealthConfig startPeriod(Integer startPeriod) {
    this.startPeriod = startPeriod;
    return this;
  }

   /**
   * Start period for the container to initialize before starting health-retries countdown in nanoseconds. It should be 0 or at least 1000000 (1 ms). 0 means inherit.
   * @return startPeriod
  **/
  @ApiModelProperty(value = "Start period for the container to initialize before starting health-retries countdown in nanoseconds. It should be 0 or at least 1000000 (1 ms). 0 means inherit.")
  public Integer getStartPeriod() {
    return startPeriod;
  }

  public void setStartPeriod(Integer startPeriod) {
    this.startPeriod = startPeriod;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HealthConfig healthConfig = (HealthConfig) o;
    return Objects.equals(this.test, healthConfig.test) &&
        Objects.equals(this.interval, healthConfig.interval) &&
        Objects.equals(this.timeout, healthConfig.timeout) &&
        Objects.equals(this.retries, healthConfig.retries) &&
        Objects.equals(this.startPeriod, healthConfig.startPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(test, interval, timeout, retries, startPeriod);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HealthConfig {\n");
    
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
    sb.append("    interval: ").append(toIndentedString(interval)).append("\n");
    sb.append("    timeout: ").append(toIndentedString(timeout)).append("\n");
    sb.append("    retries: ").append(toIndentedString(retries)).append("\n");
    sb.append("    startPeriod: ").append(toIndentedString(startPeriod)).append("\n");
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

