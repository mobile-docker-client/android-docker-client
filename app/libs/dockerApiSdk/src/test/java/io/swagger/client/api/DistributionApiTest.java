package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.DistributionInspectResponse;
import io.swagger.client.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DistributionApi
 */
public class DistributionApiTest {

    private DistributionApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DistributionApi.class);
    }

    /**
     * Get image information from the registry
     *
     * Return image digest and platform information by contacting the registry.
     */
    @Test
    public void distributionInspectTest() {
        String name = null;
        // DistributionInspectResponse response = api.distributionInspect(name);

        // TODO: test validations
    }
}
