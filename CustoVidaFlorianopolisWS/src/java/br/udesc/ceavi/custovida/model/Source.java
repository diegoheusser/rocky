package br.udesc.ceavi.custovida.model;

import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.source.SourceDAO;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Source {

    private int id;
    private String description;
    private String localization;

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

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }
    
    public static List<Source> seekAll() throws Exception {
        SourceDAO dao = DAOFactory.getInstance().getSourceDAO();
        return dao.seekAll();
    }
}
