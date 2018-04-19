package ru.mail.park.docker.services;

import com.google.common.base.Function;

import retrofit2.Call;
import retrofit2.Response;

public interface IAsyncTaskHandler {

    @SuppressWarnings("unused")
    <T> void asyncApiCall(final Call<T> task,
                          Function<T, Void> onSuccess,
                          Function<Response<T>, Void> onError);

    void executeInBackground(Runnable runnable);
}