package br.udesc.ceavi.custovida.dao.item;

import br.udesc.ceavi.custovida.model.Item;
import java.util.List;

/**
 *
 * @author Diego Heusser
 */
public interface ItemDAO {
    
    List<Item> seekAll() throws Exception ;
    
}
