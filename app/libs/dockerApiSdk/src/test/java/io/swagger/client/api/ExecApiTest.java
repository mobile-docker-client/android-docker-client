package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.ExecConfig;
import io.swagger.client.model.ExecInspectResponse;
import io.swagger.client.model.ExecStartConfig;
import io.swagger.client.model.IdResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ExecApi
 */
public class ExecApiTest {

    private ExecApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ExecApi.class);
    }

    /**
     * Create an exec instance
     *
     * Run a command inside a running container.
     */
    @Test
    public void containerExecTest() {
        ExecConfig execConfig = null;
        String id = null;
        // IdResponse response = api.containerExec(execConfig, id);

        // TODO: test validations
    }
    /**
     * Inspect an exec instance
     *
     * Return low-level information about an exec instance.
     */
    @Test
    public void execInspectTest() {
        String id = null;
        // ExecInspectResponse response = api.execInspect(id);

        // TODO: test validations
    }
    /**
     * Resize an exec instance
     *
     * Resize the TTY session used by an exec instance. This endpoint only works if &#x60;tty&#x60; was specified as part of creating and starting the exec instance.
     */
    @Test
    public void execResizeTest() {
        String id = null;
        Integer h = null;
        Integer w = null;
        // Void response = api.execResize(id, h, w);

        // TODO: test validations
    }
    /**
     * Start an exec instance
     *
     * Starts a previously set up exec instance. If detach is true, this endpoint returns immediately after starting the command. Otherwise, it sets up an interactive session with the command.
     */
    @Test
    public void execStartTest() {
        String id = null;
        ExecStartConfig execStartConfig = null;
        // Void response = api.execStart(id, execStartConfig);

        // TODO: test validations
    }
}
