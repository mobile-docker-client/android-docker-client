package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Volume;
import io.swagger.client.model.VolumeConfig;
import io.swagger.client.model.VolumeListResponse;
import io.swagger.client.model.VolumePruneResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for VolumeApi
 */
public class VolumeApiTest {

    private VolumeApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(VolumeApi.class);
    }

    /**
     * Create a volume
     *
     * 
     */
    @Test
    public void volumeCreateTest() {
        VolumeConfig volumeConfig = null;
        // Volume response = api.volumeCreate(volumeConfig);

        // TODO: test validations
    }
    /**
     * Remove a volume
     *
     * Instruct the driver to remove the volume.
     */
    @Test
    public void volumeDeleteTest() {
        String name = null;
        Boolean force = null;
        // Void response = api.volumeDelete(name, force);

        // TODO: test validations
    }
    /**
     * Inspect a volume
     *
     * 
     */
    @Test
    public void volumeInspectTest() {
        String name = null;
        // Volume response = api.volumeInspect(name);

        // TODO: test validations
    }
    /**
     * List volumes
     *
     * 
     */
    @Test
    public void volumeListTest() {
        String filters = null;
        // VolumeListResponse response = api.volumeList(filters);

        // TODO: test validations
    }
    /**
     * Delete unused volumes
     *
     * 
     */
    @Test
    public void volumePruneTest() {
        String filters = null;
        // VolumePruneResponse response = api.volumePrune(filters);

        // TODO: test validations
    }
}
