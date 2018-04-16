
package ru.mail.park.androiddockerclient.services;



import com.google.common.base.Function;

import io.swagger.client.api.ContainerApi;
import io.swagger.client.model.ContainerInspectResponse;
import retrofit2.Call;
import retrofit2.Response;

public class ContainersService {

    private ContainerApi service;

    private IAsyncRequestHandler asyncRequestHandler;

    public ContainersService(ContainerApi containerApi,
                      IAsyncRequestHandler asyncRequestHandler) {
        service = containerApi;
        this.asyncRequestHandler = asyncRequestHandler;
    }


    public void containerInspect(final String id, final Boolean size,
                                 final Function<ContainerInspectResponse, Void> onSuccess,
                                 final Function<Response<ContainerInspectResponse>, Void> onError) {
        final Call<ContainerInspectResponse> request = service.containerInspect(id, size);
        asyncRequestHandler.asyncApiCall(request, onSuccess, onError);
    }


}
