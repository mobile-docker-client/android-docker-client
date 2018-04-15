package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Service;
import io.swagger.client.model.ServiceCreateResponse;
import io.swagger.client.model.ServiceUpdateResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ServiceApi
 */
public class ServiceApiTest {

    private ServiceApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ServiceApi.class);
    }

    /**
     * Create a service
     *
     * 
     */
    @Test
    public void serviceCreateTest() {
         body = null;
        String xRegistryAuth = null;
        // ServiceCreateResponse response = api.serviceCreate(body, xRegistryAuth);

        // TODO: test validations
    }
    /**
     * Delete a service
     *
     * 
     */
    @Test
    public void serviceDeleteTest() {
        String id = null;
        // Void response = api.serviceDelete(id);

        // TODO: test validations
    }
    /**
     * Inspect a service
     *
     * 
     */
    @Test
    public void serviceInspectTest() {
        String id = null;
        Boolean insertDefaults = null;
        // Service response = api.serviceInspect(id, insertDefaults);

        // TODO: test validations
    }
    /**
     * List services
     *
     * 
     */
    @Test
    public void serviceListTest() {
        String filters = null;
        // List<Service> response = api.serviceList(filters);

        // TODO: test validations
    }
    /**
     * Get service logs
     *
     * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a service.  **Note**: This endpoint works only for services with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging drivers. 
     */
    @Test
    public void serviceLogsTest() {
        String id = null;
        Boolean details = null;
        Boolean follow = null;
        Boolean stdout = null;
        Boolean stderr = null;
        Integer since = null;
        Boolean timestamps = null;
        String tail = null;
        // String response = api.serviceLogs(id, details, follow, stdout, stderr, since, timestamps, tail);

        // TODO: test validations
    }
    /**
     * Update a service
     *
     * 
     */
    @Test
    public void serviceUpdateTest() {
        String id = null;
         body = null;
        Integer version = null;
        String registryAuthFrom = null;
        String rollback = null;
        String xRegistryAuth = null;
        // ServiceUpdateResponse response = api.serviceUpdate(id, body, version, registryAuthFrom, rollback, xRegistryAuth);

        // TODO: test validations
    }
}
