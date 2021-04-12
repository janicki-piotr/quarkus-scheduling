package pl.redny;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path("/counter")
public class CounterResource {

    private final Map<String, Integer> storage = new HashMap<>();

    @POST
    @Path("/{data}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(final @PathParam("data") String data) {
        storage.put(data, storage.containsKey(data) ? storage.get(data) + 1 : 1);

        System.out.println(data + "=" + storage.get(data));

        return new Response(storage.get(data));
    }
}