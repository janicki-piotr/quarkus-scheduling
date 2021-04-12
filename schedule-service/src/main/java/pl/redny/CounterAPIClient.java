package pl.redny;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient
public interface CounterAPIClient {

    @POST
    @Path("/counter/{counterName}")
    void increaseCounter(@PathParam("counterName") String counterName);

}
