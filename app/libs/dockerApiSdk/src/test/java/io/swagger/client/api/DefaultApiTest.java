package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DefaultApi
 */
public class DefaultApiTest {

    private DefaultApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(DefaultApi.class);
    }

    /**
     * Get task logs
     *
     * Get &#x60;stdout&#x60; and &#x60;stderr&#x60; logs from a task.  **Note**: This endpoint works only for services with the &#x60;json-file&#x60; or &#x60;journald&#x60; logging drivers. 
     */
    @Test
    public void taskLogsTest() {
        String id = null;
        Boolean details = null;
        Boolean follow = null;
        Boolean stdout = null;
        Boolean stderr = null;
        Integer since = null;
        Boolean timestamps = null;
        String tail = null;
        // String response = api.taskLogs(id, details, follow, stdout, stderr, since, timestamps, tail);

        // TODO: test validations
    }
}
