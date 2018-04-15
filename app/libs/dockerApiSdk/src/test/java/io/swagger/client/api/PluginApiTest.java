package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.Body;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Plugin;
import io.swagger.client.model.PluginPrivilegeItem;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PluginApi
 */
public class PluginApiTest {

    private PluginApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(PluginApi.class);
    }

    /**
     * Get plugin privileges
     *
     * 
     */
    @Test
    public void getPluginPrivilegesTest() {
        String remote = null;
        // List<PluginPrivilegeItem> response = api.getPluginPrivileges(remote);

        // TODO: test validations
    }
    /**
     * Create a plugin
     *
     * 
     */
    @Test
    public void pluginCreateTest() {
        String name = null;
        byte[] tarContext = null;
        // Void response = api.pluginCreate(name, tarContext);

        // TODO: test validations
    }
    /**
     * Remove a plugin
     *
     * 
     */
    @Test
    public void pluginDeleteTest() {
        String name = null;
        Boolean force = null;
        // Plugin response = api.pluginDelete(name, force);

        // TODO: test validations
    }
    /**
     * Disable a plugin
     *
     * 
     */
    @Test
    public void pluginDisableTest() {
        String name = null;
        // Void response = api.pluginDisable(name);

        // TODO: test validations
    }
    /**
     * Enable a plugin
     *
     * 
     */
    @Test
    public void pluginEnableTest() {
        String name = null;
        Integer timeout = null;
        // Void response = api.pluginEnable(name, timeout);

        // TODO: test validations
    }
    /**
     * Inspect a plugin
     *
     * 
     */
    @Test
    public void pluginInspectTest() {
        String name = null;
        // Plugin response = api.pluginInspect(name);

        // TODO: test validations
    }
    /**
     * List plugins
     *
     * Returns information about installed plugins.
     */
    @Test
    public void pluginListTest() {
        String filters = null;
        // List<Plugin> response = api.pluginList(filters);

        // TODO: test validations
    }
    /**
     * Install a plugin
     *
     * Pulls and installs a plugin. After the plugin is installed, it can be enabled using the [&#x60;POST /plugins/{name}/enable&#x60; endpoint](#operation/PostPluginsEnable). 
     */
    @Test
    public void pluginPullTest() {
        String remote = null;
        String name = null;
        String xRegistryAuth = null;
        List<Body> body = null;
        // Void response = api.pluginPull(remote, name, xRegistryAuth, body);

        // TODO: test validations
    }
    /**
     * Push a plugin
     *
     * Push a plugin to the registry. 
     */
    @Test
    public void pluginPushTest() {
        String name = null;
        // Void response = api.pluginPush(name);

        // TODO: test validations
    }
    /**
     * Configure a plugin
     *
     * 
     */
    @Test
    public void pluginSetTest() {
        String name = null;
        List<String> body = null;
        // Void response = api.pluginSet(name, body);

        // TODO: test validations
    }
    /**
     * Upgrade a plugin
     *
     * 
     */
    @Test
    public void pluginUpgradeTest() {
        String name = null;
        String remote = null;
        String xRegistryAuth = null;
        List<Body> body = null;
        // Void response = api.pluginUpgrade(name, remote, xRegistryAuth, body);

        // TODO: test validations
    }
}
