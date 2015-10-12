package br.udesc.ceavi.custovida.dao.control;

import br.udesc.ceavi.custovida.model.Control;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public interface ControlDAO {
    
    public List<Control> seekControlsByResearcher(int researcherId) throws Exception;
    
    public void update(Date deliveryDate, int controlId) throws Exception;
    
}
