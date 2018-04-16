package ru.mail.park.androiddockerclient.services;

import com.google.common.base.Function;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import retrofit2.Call;
import retrofit2.Response;

public class AsyncRequestHandler implements IAsyncRequestHandler{
    private ExecutorService executorService;

    public AsyncRequestHandler(ExecutorService executorService) {
        this.executorService = executorService;
    }


    public <T> void asyncApiCall(final Call<T> task,
                                 Function<T, Void> onSuccess,
                                 Function<Response<T>, Void> onError) {
        executorService.execute(() -> {
                    try {
                        Response<T> result = task.execute();
                        if (result.isSuccessful() && result.body() != null) {
                            onSuccess.apply(result.body());
                        } else {
                            onError.apply(result);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

}
