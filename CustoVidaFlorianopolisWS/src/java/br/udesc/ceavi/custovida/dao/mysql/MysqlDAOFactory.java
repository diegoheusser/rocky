package br.udesc.ceavi.custovida.dao.mysql;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.control.MysqlControlDAO;
import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.item.ItemDAO;
import br.udesc.ceavi.custovida.dao.item.MysqlItemDAO;
import br.udesc.ceavi.custovida.dao.search.MysqlSearchDAO;
import br.udesc.ceavi.custovida.dao.search.SearchDAO;
import br.udesc.ceavi.custovida.dao.user.MysqlUserDAO;
import br.udesc.ceavi.custovida.dao.user.UserDAO;
import br.udesc.ceavi.custovida.dao.source.MysqlSourceDAO;
import br.udesc.ceavi.custovida.dao.source.SourceDAO;

/**
 *
 * @author Diego Heusser
 */
public class MysqlDAOFactory extends DAOFactory {

    @Override
    public ControlDAO getControlDAO() {
        return new MysqlControlDAO();
    }

    @Override
    public UserDAO getUserDAO() {
        return new MysqlUserDAO();
    }

    @Override
    public ItemDAO getItemDAO() {
        return new MysqlItemDAO();
    }

    @Override
    public SourceDAO getSourceDAO() {
        return new MysqlSourceDAO();
    }

    @Override
    public SearchDAO getSearchDAO() {
        return new MysqlSearchDAO();
    }
    
}
