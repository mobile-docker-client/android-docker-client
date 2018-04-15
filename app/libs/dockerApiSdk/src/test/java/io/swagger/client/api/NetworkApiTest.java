package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.Container;
import io.swagger.client.model.Container1;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Network;
import io.swagger.client.model.NetworkConfig;
import io.swagger.client.model.NetworkCreateResponse;
import io.swagger.client.model.NetworkPruneResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for NetworkApi
 */
public class NetworkApiTest {

    private NetworkApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(NetworkApi.class);
    }

    /**
     * Connect a container to a network
     *
     * 
     */
    @Test
    public void networkConnectTest() {
        String id = null;
        Container container = null;
        // Void response = api.networkConnect(id, container);

        // TODO: test validations
    }
    /**
     * Create a network
     *
     * 
     */
    @Test
    public void networkCreateTest() {
        NetworkConfig networkConfig = null;
        // NetworkCreateResponse response = api.networkCreate(networkConfig);

        // TODO: test validations
    }
    /**
     * Remove a network
     *
     * 
     */
    @Test
    public void networkDeleteTest() {
        String id = null;
        // Void response = api.networkDelete(id);

        // TODO: test validations
    }
    /**
     * Disconnect a container from a network
     *
     * 
     */
    @Test
    public void networkDisconnectTest() {
        String id = null;
        Container1 container = null;
        // Void response = api.networkDisconnect(id, container);

        // TODO: test validations
    }
    /**
     * Inspect a network
     *
     * 
     */
    @Test
    public void networkInspectTest() {
        String id = null;
        Boolean verbose = null;
        String scope = null;
        // Network response = api.networkInspect(id, verbose, scope);

        // TODO: test validations
    }
    /**
     * List networks
     *
     * Returns a list of networks. For details on the format, see [the network inspect endpoint](#operation/NetworkInspect).  Note that it uses a different, smaller representation of a network than inspecting a single network. For example, the list of containers attached to the network is not propagated in API versions 1.28 and up. 
     */
    @Test
    public void networkListTest() {
        String filters = null;
        // List<Network> response = api.networkList(filters);

        // TODO: test validations
    }
    /**
     * Delete unused networks
     *
     * 
     */
    @Test
    public void networkPruneTest() {
        String filters = null;
        // NetworkPruneResponse response = api.networkPrune(filters);

        // TODO: test validations
    }
}
