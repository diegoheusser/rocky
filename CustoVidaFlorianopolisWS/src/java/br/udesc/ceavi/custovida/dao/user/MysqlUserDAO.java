package br.udesc.ceavi.custovida.dao.user;

import br.udesc.ceavi.custovida.dao.mysql.MysqlConnection;
import br.udesc.ceavi.custovida.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class MysqlUserDAO implements UserDAO {

    @Override
    public void update(User r) throws Exception {
        Connection con = MysqlConnection.getConnection();
        String update = "UPDATE usuario SET nick = ?, nomecompleto = ?, senha = ? WHERE usuarioid = ? ";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setString(1, r.getUser());
        pst.setString(2, r.getName());
        pst.setString(3, r.getPassword());
        pst.setInt(4, r.getId());
        pst.close();
        con.close();
    }

    @Override
    public List<User> seekResearchersValid() throws Exception {
        Connection con = MysqlConnection.getConnection();
        String select = "SELECT * FROM usuario WHERE tipousuarioid = 2 AND ativo = 1";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(select);
        List<User> researchers = new ArrayList<>();
        while(rs.next()){
           User r = new User();
           r.setId(rs.getInt("usuarioid"));
           r.setName(rs.getString("nomecompleto"));
           r.setPassword(rs.getString("senha"));
           r.setUser(rs.getString("nick"));
           researchers.add(r);
        }
        rs.close();
        st.close();
        con.close();
        return researchers;
    }
    
}
