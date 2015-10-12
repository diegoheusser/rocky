package br.udesc.ceavi.custovida.dao.core;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.item.ItemDAO;
import br.udesc.ceavi.custovida.dao.mysql.MysqlDAOFactory;
import br.udesc.ceavi.custovida.dao.search.SearchDAO;
import br.udesc.ceavi.custovida.dao.user.UserDAO;
import br.udesc.ceavi.custovida.dao.source.SourceDAO;

/**
 *
 * @author Diego Heusser
 */
public abstract class DAOFactory {
    
    public static DAOFactory getInstance(){
        return new MysqlDAOFactory();
    }
    
    public abstract ControlDAO getControlDAO();
    public abstract UserDAO getUserDAO();
    public abstract ItemDAO getItemDAO();
    public abstract SourceDAO getSourceDAO();
    public abstract SearchDAO getSearchDAO();
    
    
}
