package br.udesc.ceavi.custovida.model;

import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.user.UserDAO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

    private int id;
    private String name;
    private String user;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Researcher{" + "id=" + id + ", name=" + name + ", user=" + user + ", password=" + password + '}';
    }
    
    
    public static List<User> seekAll() throws Exception{
        UserDAO dao = DAOFactory.getInstance().getUserDAO();
        return dao.seekResearchersValid();
    }
}
