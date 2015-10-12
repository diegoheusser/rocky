package br.udesc.ceavi.custovida.resource;

import br.udesc.ceavi.custovida.model.Control;
import br.udesc.ceavi.custovida.model.Item;
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
@Path("/item")
public class ItemResource {

    @GET
    @Path("seekall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> seekAll() {
        List<Item> items;
        try {
            items = Item.seekAll();
        } catch (Exception ex) {
            items = new ArrayList<>();
        }

        return items;
    }

}
