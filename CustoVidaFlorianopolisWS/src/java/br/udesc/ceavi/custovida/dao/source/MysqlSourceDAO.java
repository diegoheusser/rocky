package br.udesc.ceavi.custovida.dao.source;

import br.udesc.ceavi.custovida.dao.mysql.MysqlConnection;
import br.udesc.ceavi.custovida.model.Control;
import br.udesc.ceavi.custovida.model.Search;
import br.udesc.ceavi.custovida.model.Source;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import static org.omg.IOP.IORHelper.insert;

/**
 *
 * @author Diego Heusser
 */
public class MysqlSourceDAO implements SourceDAO {

    @Override
    public List<Source> seekAll() throws Exception {
        Connection con = MysqlConnection.getConnection();
        String select = "SELECT * FROM fonte";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(select);

        List<Source> list = new ArrayList<>();

        while (rs.next()) {
            Source s = new Source();
            s.setId(rs.getInt("fonteid"));
            s.setDescription(rs.getString("descricao"));
            s.setLocalization(rs.getString("localizacao"));
            list.add(s);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }

    

}
