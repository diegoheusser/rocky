package br.udesc.ceavi.custovida.dao.search;

import br.udesc.ceavi.custovida.model.Search;
import java.util.List;

/**
 *
 * @author diego
 */
public interface SearchDAO {

    public void save(Search s) throws Exception;
    
    public List<Search> seekLastSearchesOfTheSource(int sourceId, int week, int month, int year) throws Exception;
    
}
