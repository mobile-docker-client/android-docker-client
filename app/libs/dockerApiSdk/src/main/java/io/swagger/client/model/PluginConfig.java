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
import io.swagger.client.model.PluginConfigArgs;
import io.swagger.client.model.PluginConfigInterface;
import io.swagger.client.model.PluginConfigLinux;
import io.swagger.client.model.PluginConfigNetwork;
import io.swagger.client.model.PluginConfigRootfs;
import io.swagger.client.model.PluginConfigUser;
import io.swagger.client.model.PluginEnv;
import io.swagger.client.model.PluginMount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The config of a plugin.
 */
@ApiModel(description = "The config of a plugin.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-04-16T10:27:43.808+04:00")
public class PluginConfig {
  @SerializedName("DockerVersion")
  private String dockerVersion = null;

  @SerializedName("Description")
  private String description = null;

  @SerializedName("Documentation")
  private String documentation = null;

  @SerializedName("Interface")
  private PluginConfigInterface _interface = null;

  @SerializedName("Entrypoint")
  private List<String> entrypoint = new ArrayList<String>();

  @SerializedName("WorkDir")
  private String workDir = null;

  @SerializedName("User")
  private PluginConfigUser user = null;

  @SerializedName("Network")
  private PluginConfigNetwork network = null;

  @SerializedName("Linux")
  private PluginConfigLinux linux = null;

  @SerializedName("PropagatedMount")
  private String propagatedMount = null;

  @SerializedName("IpcHost")
  private Boolean ipcHost = null;

  @SerializedName("PidHost")
  private Boolean pidHost = null;

  @SerializedName("Mounts")
  private List<PluginMount> mounts = new ArrayList<PluginMount>();

  @SerializedName("Env")
  private List<PluginEnv> env = new ArrayList<PluginEnv>();

  @SerializedName("Args")
  private PluginConfigArgs args = null;

  @SerializedName("rootfs")
  private PluginConfigRootfs rootfs = null;

  public PluginConfig dockerVersion(String dockerVersion) {
    this.dockerVersion = dockerVersion;
    return this;
  }

   /**
   * Docker Version used to create the plugin
   * @return dockerVersion
  **/
  @ApiModelProperty(example = "17.06.0-ce", value = "Docker Version used to create the plugin")
  public String getDockerVersion() {
    return dockerVersion;
  }

  public void setDockerVersion(String dockerVersion) {
    this.dockerVersion = dockerVersion;
  }

  public PluginConfig description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(example = "A sample volume plugin for Docker", required = true, value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PluginConfig documentation(String documentation) {
    this.documentation = documentation;
    return this;
  }

   /**
   * Get documentation
   * @return documentation
  **/
  @ApiModelProperty(example = "https://docs.docker.com/engine/extend/plugins/", required = true, value = "")
  public String getDocumentation() {
    return documentation;
  }

  public void setDocumentation(String documentation) {
    this.documentation = documentation;
  }

  public PluginConfig _interface(PluginConfigInterface _interface) {
    this._interface = _interface;
    return this;
  }

   /**
   * Get _interface
   * @return _interface
  **/
  @ApiModelProperty(required = true, value = "")
  public PluginConfigInterface getInterface() {
    return _interface;
  }

  public void setInterface(PluginConfigInterface _interface) {
    this._interface = _interface;
  }

  public PluginConfig entrypoint(List<String> entrypoint) {
    this.entrypoint = entrypoint;
    return this;
  }

  public PluginConfig addEntrypointItem(String entrypointItem) {
    this.entrypoint.add(entrypointItem);
    return this;
  }

   /**
   * Get entrypoint
   * @return entrypoint
  **/
  @ApiModelProperty(example = "[\"/usr/bin/sample-volume-plugin\",\"/data\"]", required = true, value = "")
  public List<String> getEntrypoint() {
    return entrypoint;
  }

  public void setEntrypoint(List<String> entrypoint) {
    this.entrypoint = entrypoint;
  }

  public PluginConfig workDir(String workDir) {
    this.workDir = workDir;
    return this;
  }

   /**
   * Get workDir
   * @return workDir
  **/
  @ApiModelProperty(example = "/bin/", required = true, value = "")
  public String getWorkDir() {
    return workDir;
  }

  public void setWorkDir(String workDir) {
    this.workDir = workDir;
  }

  public PluginConfig user(PluginConfigUser user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public PluginConfigUser getUser() {
    return user;
  }

  public void setUser(PluginConfigUser user) {
    this.user = user;
  }

  public PluginConfig network(PluginConfigNetwork network) {
    this.network = network;
    return this;
  }

   /**
   * Get network
   * @return network
  **/
  @ApiModelProperty(required = true, value = "")
  public PluginConfigNetwork getNetwork() {
    return network;
  }

  public void setNetwork(PluginConfigNetwork network) {
    this.network = network;
  }

  public PluginConfig linux(PluginConfigLinux linux) {
    this.linux = linux;
    return this;
  }

   /**
   * Get linux
   * @return linux
  **/
  @ApiModelProperty(required = true, value = "")
  public PluginConfigLinux getLinux() {
    return linux;
  }

  public void setLinux(PluginConfigLinux linux) {
    this.linux = linux;
  }

  public PluginConfig propagatedMount(String propagatedMount) {
    this.propagatedMount = propagatedMount;
    return this;
  }

   /**
   * Get propagatedMount
   * @return propagatedMount
  **/
  @ApiModelProperty(example = "/mnt/volumes", required = true, value = "")
  public String getPropagatedMount() {
    return propagatedMount;
  }

  public void setPropagatedMount(String propagatedMount) {
    this.propagatedMount = propagatedMount;
  }

  public PluginConfig ipcHost(Boolean ipcHost) {
    this.ipcHost = ipcHost;
    return this;
  }

   /**
   * Get ipcHost
   * @return ipcHost
  **/
  @ApiModelProperty(example = "false", required = true, value = "")
  public Boolean isIpcHost() {
    return ipcHost;
  }

  public void setIpcHost(Boolean ipcHost) {
    this.ipcHost = ipcHost;
  }

  public PluginConfig pidHost(Boolean pidHost) {
    this.pidHost = pidHost;
    return this;
  }

   /**
   * Get pidHost
   * @return pidHost
  **/
  @ApiModelProperty(example = "false", required = true, value = "")
  public Boolean isPidHost() {
    return pidHost;
  }

  public void setPidHost(Boolean pidHost) {
    this.pidHost = pidHost;
  }

  public PluginConfig mounts(List<PluginMount> mounts) {
    this.mounts = mounts;
    return this;
  }

  public PluginConfig addMountsItem(PluginMount mountsItem) {
    this.mounts.add(mountsItem);
    return this;
  }

   /**
   * Get mounts
   * @return mounts
  **/
  @ApiModelProperty(required = true, value = "")
  public List<PluginMount> getMounts() {
    return mounts;
  }

  public void setMounts(List<PluginMount> mounts) {
    this.mounts = mounts;
  }

  public PluginConfig env(List<PluginEnv> env) {
    this.env = env;
    return this;
  }

  public PluginConfig addEnvItem(PluginEnv envItem) {
    this.env.add(envItem);
    return this;
  }

   /**
   * Get env
   * @return env
  **/
  @ApiModelProperty(example = "[{\"Name\":\"DEBUG\",\"Description\":\"If set, prints debug messages\",\"Settable\":null,\"Value\":\"0\"}]", required = true, value = "")
  public List<PluginEnv> getEnv() {
    return env;
  }

  public void setEnv(List<PluginEnv> env) {
    this.env = env;
  }

  public PluginConfig args(PluginConfigArgs args) {
    this.args = args;
    return this;
  }

   /**
   * Get args
   * @return args
  **/
  @ApiModelProperty(required = true, value = "")
  public PluginConfigArgs getArgs() {
    return args;
  }

  public void setArgs(PluginConfigArgs args) {
    this.args = args;
  }

  public PluginConfig rootfs(PluginConfigRootfs rootfs) {
    this.rootfs = rootfs;
    return this;
  }

   /**
   * Get rootfs
   * @return rootfs
  **/
  @ApiModelProperty(value = "")
  public PluginConfigRootfs getRootfs() {
    return rootfs;
  }

  public void setRootfs(PluginConfigRootfs rootfs) {
    this.rootfs = rootfs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PluginConfig pluginConfig = (PluginConfig) o;
    return Objects.equals(this.dockerVersion, pluginConfig.dockerVersion) &&
        Objects.equals(this.description, pluginConfig.description) &&
        Objects.equals(this.documentation, pluginConfig.documentation) &&
        Objects.equals(this._interface, pluginConfig._interface) &&
        Objects.equals(this.entrypoint, pluginConfig.entrypoint) &&
        Objects.equals(this.workDir, pluginConfig.workDir) &&
        Objects.equals(this.user, pluginConfig.user) &&
        Objects.equals(this.network, pluginConfig.network) &&
        Objects.equals(this.linux, pluginConfig.linux) &&
        Objects.equals(this.propagatedMount, pluginConfig.propagatedMount) &&
        Objects.equals(this.ipcHost, pluginConfig.ipcHost) &&
        Objects.equals(this.pidHost, pluginConfig.pidHost) &&
        Objects.equals(this.mounts, pluginConfig.mounts) &&
        Objects.equals(this.env, pluginConfig.env) &&
        Objects.equals(this.args, pluginConfig.args) &&
        Objects.equals(this.rootfs, pluginConfig.rootfs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dockerVersion, description, documentation, _interface, entrypoint, workDir, user, network, linux, propagatedMount, ipcHost, pidHost, mounts, env, args, rootfs);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PluginConfig {\n");
    
    sb.append("    dockerVersion: ").append(toIndentedString(dockerVersion)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    documentation: ").append(toIndentedString(documentation)).append("\n");
    sb.append("    _interface: ").append(toIndentedString(_interface)).append("\n");
    sb.append("    entrypoint: ").append(toIndentedString(entrypoint)).append("\n");
    sb.append("    workDir: ").append(toIndentedString(workDir)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    network: ").append(toIndentedString(network)).append("\n");
    sb.append("    linux: ").append(toIndentedString(linux)).append("\n");
    sb.append("    propagatedMount: ").append(toIndentedString(propagatedMount)).append("\n");
    sb.append("    ipcHost: ").append(toIndentedString(ipcHost)).append("\n");
    sb.append("    pidHost: ").append(toIndentedString(pidHost)).append("\n");
    sb.append("    mounts: ").append(toIndentedString(mounts)).append("\n");
    sb.append("    env: ").append(toIndentedString(env)).append("\n");
    sb.append("    args: ").append(toIndentedString(args)).append("\n");
    sb.append("    rootfs: ").append(toIndentedString(rootfs)).append("\n");
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

