package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.IdResponse;
import io.swagger.client.model.Secret;
import io.swagger.client.model.SecretSpec;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SecretApi
 */
public class SecretApiTest {

    private SecretApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SecretApi.class);
    }

    /**
     * Create a secret
     *
     * 
     */
    @Test
    public void secretCreateTest() {
         body = null;
        // IdResponse response = api.secretCreate(body);

        // TODO: test validations
    }
    /**
     * Delete a secret
     *
     * 
     */
    @Test
    public void secretDeleteTest() {
        String id = null;
        // Void response = api.secretDelete(id);

        // TODO: test validations
    }
    /**
     * Inspect a secret
     *
     * 
     */
    @Test
    public void secretInspectTest() {
        String id = null;
        // Secret response = api.secretInspect(id);

        // TODO: test validations
    }
    /**
     * List secrets
     *
     * 
     */
    @Test
    public void secretListTest() {
        String filters = null;
        // List<Secret> response = api.secretList(filters);

        // TODO: test validations
    }
    /**
     * Update a Secret
     *
     * 
     */
    @Test
    public void secretUpdateTest() {
        String id = null;
        Long version = null;
        SecretSpec body = null;
        // Void response = api.secretUpdate(id, version, body);

        // TODO: test validations
    }
}
