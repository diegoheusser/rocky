package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Control;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Diego Heusser
 */
@Path("/control")
public class ControlResource {

    @GET
    @Path("seekall/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Control> seekAll(@PathParam("userid") int userid) {

        List<Control> controls;
        try {
            controls = Control.seekControlsByResearcher(userid);
        } catch (Exception ex) {
            controls = new ArrayList<>();
        }

        return controls;
    }

}
