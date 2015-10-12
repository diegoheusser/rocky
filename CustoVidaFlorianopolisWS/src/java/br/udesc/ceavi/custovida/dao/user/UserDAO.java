package br.udesc.ceavi.custovida.dao.user;

import br.udesc.ceavi.custovida.model.User;
import java.util.List;

/**
 *
 * @author diego
 */
public interface UserDAO {

    public void update(User r) throws Exception;
    
    public List<User> seekResearchersValid() throws Exception;
    
}
