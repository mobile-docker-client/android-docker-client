package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Node;
import io.swagger.client.model.NodeSpec;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NodeApi
 */
public class NodeApiTest {

    private NodeApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(NodeApi.class);
    }

    /**
     * Delete a node
     *
     * 
     */
    @Test
    public void nodeDeleteTest() {
        String id = null;
        Boolean force = null;
        // Void response = api.nodeDelete(id, force);

        // TODO: test validations
    }
    /**
     * Inspect a node
     *
     * 
     */
    @Test
    public void nodeInspectTest() {
        String id = null;
        // Node response = api.nodeInspect(id);

        // TODO: test validations
    }
    /**
     * List nodes
     *
     * 
     */
    @Test
    public void nodeListTest() {
        String filters = null;
        // List<Node> response = api.nodeList(filters);

        // TODO: test validations
    }
    /**
     * Update a node
     *
     * 
     */
    @Test
    public void nodeUpdateTest() {
        String id = null;
        Long version = null;
        NodeSpec body = null;
        // Void response = api.nodeUpdate(id, version, body);

        // TODO: test validations
    }
}
