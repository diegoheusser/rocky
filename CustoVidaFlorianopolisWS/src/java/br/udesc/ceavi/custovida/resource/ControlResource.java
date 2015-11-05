package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Control;
import br.udesc.ceavi.custovida.model.Search;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    
    @POST
    @Path("update")
    public Response update(Control control){
        try {
            control.update();
            return  Response.status(200).entity(control.toString()).build();
        } catch (Exception ex) {
            Logger.getLogger(ControlResource.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.toString()).build();
        }
    } 

}
