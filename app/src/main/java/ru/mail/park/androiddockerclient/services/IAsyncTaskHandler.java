package ru.mail.park.androiddockerclient.services;

import com.google.common.base.Function;

import retrofit2.Call;
import retrofit2.Response;

public interface IAsyncTaskHandler {

    <T> void asyncApiCall(final Call<T> task,
                          Function<T, Void> onSuccess,
                          Function<Response<T>, Void> onError);

    void executeInBackground(Runnable runnable);



}