package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TaskApi
 */
public class TaskApiTest {

    private TaskApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(TaskApi.class);
    }

    /**
     * Inspect a task
     *
     * 
     */
    @Test
    public void taskInspectTest() {
        String id = null;
        // Task response = api.taskInspect(id);

        // TODO: test validations
    }
    /**
     * List tasks
     *
     * 
     */
    @Test
    public void taskListTest() {
        String filters = null;
        // List<Task> response = api.taskList(filters);

        // TODO: test validations
    }
}
