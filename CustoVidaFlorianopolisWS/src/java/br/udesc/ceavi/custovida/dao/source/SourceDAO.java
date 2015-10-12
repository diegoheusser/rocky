
package br.udesc.ceavi.custovida.dao.source;

import br.udesc.ceavi.custovida.model.Source;
import java.util.List;

/**
 *
 * @author Diego Heusser
 */
public interface SourceDAO {
    
    List<Source> seekAll() throws Exception;
    
}
