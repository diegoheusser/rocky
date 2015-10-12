package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author diego
 */
@Path("/researcher")
public class ResearcherResource {

    @GET
    @Path("seekall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> seekAll() {

        List<User> researchers;
        try {
            researchers = User.seekAll();
        } catch (Exception ex) {
            researchers = new ArrayList<>();
        }

        return researchers;
    }
}
