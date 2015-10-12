package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Source;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Diego Heusser
 */
@Path("/source")
public class SourceReseource {

    @GET
    @Path("seekall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Source> seekAll() {
        List<Source> list;
        try {
            list = Source.seekAll();
        } catch (Exception ex) {
            list = new ArrayList<>();
        }

        return list;
    }

}
