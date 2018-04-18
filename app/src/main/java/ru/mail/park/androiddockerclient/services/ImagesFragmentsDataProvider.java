package ru.mail.park.androiddockerclient.services;

import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.orhanobut.logger.Logger;

import java.util.List;
import java.util.concurrent.ExecutionException;

import io.swagger.client.api.ImageApi;
import io.swagger.client.model.Image;
import io.swagger.client.model.ImageSummary;
import retrofit2.Call;
import retrofit2.Response;

public class ImagesFragmentsDataProvider {
    private ImageApi service;

    private Cache<String, Image> mInspectCache;
    private Cache<String, List<ImageSummary>> mSummaryCache;


    private IAsyncTaskHandler mAsyncRequestHandler;

    public ImagesFragmentsDataProvider(ImageApi containerApi,
                                       IAsyncTaskHandler asyncRequestHandler,
                                       Cache<String, Image> loadingCache,
                                       Cache<String, List<ImageSummary>> summaryCache) {
        service = containerApi;
        this.mAsyncRequestHandler = asyncRequestHandler;
        mInspectCache = loadingCache;
        mSummaryCache = summaryCache;
    }

    public void imageInspect(final String name,
                             final Function<Image, Void> onSuccess,
                             final Function<Response<Image>, Void> onError) {
        //TODO: add hostname to key
        mAsyncRequestHandler.executeInBackground(() -> {
            try {
                Image inspectData = mInspectCache.get(name, () -> {
                    final Call<Image> request = service.imageInspect(name);

                    Response<Image> response = request.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        onError.apply(response);
                        throw new RuntimeException("fail on image inspect call");
                    }
                });
                onSuccess.apply(inspectData);
            } catch (ExecutionException | RuntimeException e) {
                Logger.e(e.getCause(), e.getMessage());
            }
        });

    }

    public void imagesSummary(Boolean all, Integer limit, Boolean digests,
                                  final Function<List<ImageSummary>, Void> onSuccess,
                                  final Function<Response<List<ImageSummary>>, Object> onError) {

        //TODO: add hostname to key

        mAsyncRequestHandler.executeInBackground(() -> {
            final String key = all.toString() + limit.toString() + digests.toString();
            try {
                List<ImageSummary> inspectData = mSummaryCache.get(key, () -> {
                    final Call<List<ImageSummary>> request = service.imageList(all, "", digests);

                    Response<List<ImageSummary>> response = request.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        onError.apply(response);
                        throw new RuntimeException("fail on image summary call");
                    }
                });
                onSuccess.apply(inspectData);
            } catch (ExecutionException | RuntimeException e) {
                Logger.e(e.getCause(), e.getMessage());

            }
        });
    }
}
