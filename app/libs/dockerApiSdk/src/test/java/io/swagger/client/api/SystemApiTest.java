package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.AuthConfig;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.SystemAuthResponse;
import io.swagger.client.model.SystemDataUsageResponse;
import io.swagger.client.model.SystemEventsResponse;
import io.swagger.client.model.SystemInfo;
import io.swagger.client.model.SystemVersionResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SystemApi
 */
public class SystemApiTest {

    private SystemApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SystemApi.class);
    }

    /**
     * Check auth configuration
     *
     * Validate credentials for a registry and, if available, get an identity token for accessing the registry without password.
     */
    @Test
    public void systemAuthTest() {
        AuthConfig authConfig = null;
        // SystemAuthResponse response = api.systemAuth(authConfig);

        // TODO: test validations
    }
    /**
     * Get data usage information
     *
     * 
     */
    @Test
    public void systemDataUsageTest() {
        // SystemDataUsageResponse response = api.systemDataUsage();

        // TODO: test validations
    }
    /**
     * Monitor events
     *
     * Stream real-time events from the server.  Various objects within Docker report events when something happens to them.  Containers report these events: &#x60;attach&#x60;, &#x60;commit&#x60;, &#x60;copy&#x60;, &#x60;create&#x60;, &#x60;destroy&#x60;, &#x60;detach&#x60;, &#x60;die&#x60;, &#x60;exec_create&#x60;, &#x60;exec_detach&#x60;, &#x60;exec_start&#x60;, &#x60;exec_die&#x60;, &#x60;export&#x60;, &#x60;health_status&#x60;, &#x60;kill&#x60;, &#x60;oom&#x60;, &#x60;pause&#x60;, &#x60;rename&#x60;, &#x60;resize&#x60;, &#x60;restart&#x60;, &#x60;start&#x60;, &#x60;stop&#x60;, &#x60;top&#x60;, &#x60;unpause&#x60;, and &#x60;update&#x60;  Images report these events: &#x60;delete&#x60;, &#x60;import&#x60;, &#x60;load&#x60;, &#x60;pull&#x60;, &#x60;push&#x60;, &#x60;save&#x60;, &#x60;tag&#x60;, and &#x60;untag&#x60;  Volumes report these events: &#x60;create&#x60;, &#x60;mount&#x60;, &#x60;unmount&#x60;, and &#x60;destroy&#x60;  Networks report these events: &#x60;create&#x60;, &#x60;connect&#x60;, &#x60;disconnect&#x60;, &#x60;destroy&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  The Docker daemon reports these events: &#x60;reload&#x60;  Services report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Nodes report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Secrets report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60;  Configs report these events: &#x60;create&#x60;, &#x60;update&#x60;, and &#x60;remove&#x60; 
     */
    @Test
    public void systemEventsTest() {
        String since = null;
        String until = null;
        String filters = null;
        // SystemEventsResponse response = api.systemEvents(since, until, filters);

        // TODO: test validations
    }
    /**
     * Get system information
     *
     * 
     */
    @Test
    public void systemInfoTest() {
        // SystemInfo response = api.systemInfo();

        // TODO: test validations
    }
    /**
     * Ping
     *
     * This is a dummy endpoint you can use to test if the server is accessible.
     */
    @Test
    public void systemPingTest() {
        // String response = api.systemPing();

        // TODO: test validations
    }
    /**
     * Get version
     *
     * Returns the version of Docker that is running and various information about the system that Docker is running on.
     */
    @Test
    public void systemVersionTest() {
        // SystemVersionResponse response = api.systemVersion();

        // TODO: test validations
    }
}
