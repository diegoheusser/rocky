package br.udesc.ceavi.custovida.model;

import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.item.ItemDAO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

    private int id;
    private String description;
    private int identifier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    
    public static List<Item> seekAll() throws Exception {
        ItemDAO dao = DAOFactory.getInstance().getItemDAO();
        return dao.seekAll();
    }
}
