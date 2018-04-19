package ru.mail.park.docker.services;


import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.orhanobut.logger.Logger;

import java.util.concurrent.ExecutionException;

import io.swagger.client.api.ContainerApi;
import io.swagger.client.model.ContainerInspectResponse;
import io.swagger.client.model.ContainerSummary;
import retrofit2.Call;
import retrofit2.Response;

@SuppressWarnings("Guava")
public class ContainersFragmentsDataProvider {

    private final ContainerApi service;
    private final Cache<String, ContainerInspectResponse> mInspectCache;
    private final Cache<String, ContainerSummary> mSummaryCache;
    private final IAsyncTaskHandler mAsyncRequestHandler;

    public ContainersFragmentsDataProvider(ContainerApi containerApi,
                                           IAsyncTaskHandler asyncRequestHandler,
                                           Cache<String, ContainerInspectResponse> loadingCache,
                                           Cache<String, ContainerSummary> summaryCache) {
        service = containerApi;
        this.mAsyncRequestHandler = asyncRequestHandler;
        mInspectCache = loadingCache;
        mSummaryCache = summaryCache;
    }

    public void containerInspect(final String id, final Boolean size,
                                 final Function<ContainerInspectResponse, Void> onSuccess,
                                 final Function<Response<ContainerInspectResponse>, Void> onError) {

        //TODO: add hostname to key
        mAsyncRequestHandler.executeInBackground(() -> {
            final String key = id + size.toString();
            try {
                ContainerInspectResponse inspectData = mInspectCache.get(key, () -> {
                    final Call<ContainerInspectResponse> request = service.containerInspect(id, size);

                    Response<ContainerInspectResponse> response = request.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        onError.apply(response);
                        throw new RuntimeException("fail to container inspect call");
                    }
                });
                onSuccess.apply(inspectData);
            } catch (ExecutionException | RuntimeException e) {
                Logger.e(e.getCause(), e.getMessage());

            }
        });

    }

    @SuppressWarnings("unused")
    public void containersSummary(Boolean all, Integer limit, Boolean size,
                                  final Function<ContainerSummary, Void> onSuccess,
                                  final Function<Response<ContainerSummary>, Void> onError) {

        //TODO: add hostname to key

        mAsyncRequestHandler.executeInBackground(() -> {
            final String key = all.toString() + limit.toString() + size.toString();
            try {
                ContainerSummary inspectData = mSummaryCache.get(key, () -> {
                    final Call<ContainerSummary> request = service.containerList(all, limit, size, "");

                    Response<ContainerSummary> response = request.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        onError.apply(response);
                        throw new RuntimeException("fail to container summary call");
                    }
                });
                onSuccess.apply(inspectData);
            } catch (ExecutionException | RuntimeException e) {
                Logger.e(e.getCause(), e.getMessage());

            }
        });
    }


}
