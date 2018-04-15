package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.Body1;
import io.swagger.client.model.Body2;
import io.swagger.client.model.Body3;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Swarm;
import io.swagger.client.model.SwarmSpec;
import io.swagger.client.model.UnlockKeyResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SwarmApi
 */
public class SwarmApiTest {

    private SwarmApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SwarmApi.class);
    }

    /**
     * Initialize a new swarm
     *
     * 
     */
    @Test
    public void swarmInitTest() {
        Body1 body = null;
        // String response = api.swarmInit(body);

        // TODO: test validations
    }
    /**
     * Inspect swarm
     *
     * 
     */
    @Test
    public void swarmInspectTest() {
        // Swarm response = api.swarmInspect();

        // TODO: test validations
    }
    /**
     * Join an existing swarm
     *
     * 
     */
    @Test
    public void swarmJoinTest() {
        Body2 body = null;
        // Void response = api.swarmJoin(body);

        // TODO: test validations
    }
    /**
     * Leave a swarm
     *
     * 
     */
    @Test
    public void swarmLeaveTest() {
        Boolean force = null;
        // Void response = api.swarmLeave(force);

        // TODO: test validations
    }
    /**
     * Unlock a locked manager
     *
     * 
     */
    @Test
    public void swarmUnlockTest() {
        Body3 body = null;
        // Void response = api.swarmUnlock(body);

        // TODO: test validations
    }
    /**
     * Get the unlock key
     *
     * 
     */
    @Test
    public void swarmUnlockkeyTest() {
        // UnlockKeyResponse response = api.swarmUnlockkey();

        // TODO: test validations
    }
    /**
     * Update a swarm
     *
     * 
     */
    @Test
    public void swarmUpdateTest() {
        SwarmSpec body = null;
        Long version = null;
        Boolean rotateWorkerToken = null;
        Boolean rotateManagerToken = null;
        Boolean rotateManagerUnlockKey = null;
        // Void response = api.swarmUpdate(body, version, rotateWorkerToken, rotateManagerToken, rotateManagerUnlockKey);

        // TODO: test validations
    }
}
