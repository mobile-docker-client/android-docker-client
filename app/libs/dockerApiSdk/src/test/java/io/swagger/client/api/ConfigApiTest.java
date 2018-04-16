package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.Config;
import io.swagger.client.model.ConfigSpec;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.IdResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ConfigApi
 */
public class ConfigApiTest {

    private ConfigApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ConfigApi.class);
    }

    /**
     * Create a config
     *
     * 
     */
    @Test
    public void configCreateTest() {
        ConfigSpec body = null;
        // IdResponse response = api.configCreate(body);

        // TODO: test validations
    }
    /**
     * Delete a config
     *
     * 
     */
    @Test
    public void configDeleteTest() {
        String id = null;
        // Void response = api.configDelete(id);

        // TODO: test validations
    }
    /**
     * Inspect a config
     *
     * 
     */
    @Test
    public void configInspectTest() {
        String id = null;
        // Config response = api.configInspect(id);

        // TODO: test validations
    }
    /**
     * List configs
     *
     * 
     */
    @Test
    public void configListTest() {
        String filters = null;
        // List<Config> response = api.configList(filters);

        // TODO: test validations
    }
    /**
     * Update a Config
     *
     * 
     */
    @Test
    public void configUpdateTest() {
        String id = null;
        Long version = null;
        ConfigSpec body = null;
        // Void response = api.configUpdate(id, version, body);

        // TODO: test validations
    }
}
