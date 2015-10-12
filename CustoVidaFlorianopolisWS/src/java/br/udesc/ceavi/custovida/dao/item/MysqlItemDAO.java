package br.udesc.ceavi.custovida.dao.item;

import br.udesc.ceavi.custovida.dao.mysql.MysqlConnection;
import br.udesc.ceavi.custovida.model.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Heusser
 */
public class MysqlItemDAO implements ItemDAO {

    @Override
    public List<Item> seekAll() throws Exception {
        Connection con = MysqlConnection.getConnection();
        String select = "SELECT "
                + "i.itemid as id, "
                + "i.descricao as description, "
                + "CONCAT(g.identificador,s.identificador,c.identificador,p.identificador,i.identificador) as identifier "
                + "FROM "
                + "item as i INNER JOIN produto as p ON i.produtoid = p.produtoid "
                + "INNER JOIN classe as c ON p.classeid = c.classeid "
                + "INNER JOIN subgrupo as s ON c.subgrupoid = s.subgrupoid "
                + "INNER JOIN grupo as g ON s.grupoid = g.grupoid ";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(select);
        
        List<Item> list = new ArrayList<>();
        while(rs.next()){
            Item i = new Item();
            i.setId(rs.getInt("id"));
            i.setDescription(rs.getString("description"));
            i.setIdentifier(rs.getInt("identifier"));
            list.add(i);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

}
