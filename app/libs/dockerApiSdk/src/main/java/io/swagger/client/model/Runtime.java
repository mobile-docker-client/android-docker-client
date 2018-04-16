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
 * Runtime describes an [OCI compliant](https://github.com/opencontainers/runtime-spec) runtime.  The runtime is invoked by the daemon via the &#x60;containerd&#x60; daemon. OCI runtimes act as an interface to the Linux kernel namespaces, cgroups, and SELinux. 
 */
@ApiModel(description = "Runtime describes an [OCI compliant](https://github.com/opencontainers/runtime-spec) runtime.  The runtime is invoked by the daemon via the `containerd` daemon. OCI runtimes act as an interface to the Linux kernel namespaces, cgroups, and SELinux. ")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T04:24:49.247+04:00")
public class Runtime {
  @SerializedName("path")
  private String path = null;

  @SerializedName("runtimeArgs")
  private List<String> runtimeArgs = null;

  public Runtime path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Name and, optional, path, of the OCI executable binary.  If the path is omitted, the daemon searches the host&#39;s &#x60;$PATH&#x60; for the binary and uses the first result. 
   * @return path
  **/
  @ApiModelProperty(example = "/usr/local/bin/my-oci-runtime", value = "Name and, optional, path, of the OCI executable binary.  If the path is omitted, the daemon searches the host's `$PATH` for the binary and uses the first result. ")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Runtime runtimeArgs(List<String> runtimeArgs) {
    this.runtimeArgs = runtimeArgs;
    return this;
  }

  public Runtime addRuntimeArgsItem(String runtimeArgsItem) {
    if (this.runtimeArgs == null) {
      this.runtimeArgs = new ArrayList<String>();
    }
    this.runtimeArgs.add(runtimeArgsItem);
    return this;
  }

   /**
   * List of command-line arguments to pass to the runtime when invoked. 
   * @return runtimeArgs
  **/
  @ApiModelProperty(example = "[\"--debug\",\"--systemd-cgroup=false\"]", value = "List of command-line arguments to pass to the runtime when invoked. ")
  public List<String> getRuntimeArgs() {
    return runtimeArgs;
  }

  public void setRuntimeArgs(List<String> runtimeArgs) {
    this.runtimeArgs = runtimeArgs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Runtime runtime = (Runtime) o;
    return Objects.equals(this.path, runtime.path) &&
        Objects.equals(this.runtimeArgs, runtime.runtimeArgs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(path, runtimeArgs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Runtime {\n");
    
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    runtimeArgs: ").append(toIndentedString(runtimeArgs)).append("\n");
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

