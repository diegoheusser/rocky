package br.udesc.ceavi.custovida.model;

import br.udesc.ceavi.custovida.dao.control.ControlDAO;
import br.udesc.ceavi.custovida.dao.core.DAOFactory;
import br.udesc.ceavi.custovida.dao.search.SearchDAO;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Control {

    private int id;
    private Date emissionDate;
    private Date deliveryDate;
    private int status;
    private int year;
    private int month;
    private int week;
    private Source source;
    private User user;
    private List<Search> searches;
    
    private static int getPreviousWeek(Control c){
        if(c.getWeek() == 1){
            return 4;
        } else {
            return c.getWeek() - 1;
        }
    }
    
    private static int getPreviousMonth(Control c){
        if(c.getWeek() == 1){
            if(c.getMonth() == 1){
                return 12;
            } else {
                return c.getMonth() - 1;
            }
        } else {
            return c.getMonth();
        }
    }
    
    private static int getPreviousYear(Control c){
        if(c.getMonth() == 1 && c.getWeek() == 1){
            return c.getYear()-1;
        } else {
            return c.getYear();
        }
    }

    public static List<Control> seekControlsByResearcher(int researcherId) throws Exception {
        ControlDAO dao = DAOFactory.getInstance().getControlDAO();
        List<Control> list = dao.seekControlsByResearcher(researcherId);
        SearchDAO searchDAO = null;
        if (list != null) {
            if (!list.isEmpty()) {
                searchDAO = DAOFactory.getInstance().getSearchDAO();
            }
            for (int i = 0; i < list.size(); i++) {
                List<Search> searches
                        = searchDAO.seekLastSearchesOfTheSource(
                                list.get(i).getSource().getId(),
                                getPreviousWeek(list.get(i)),
                                getPreviousMonth(list.get(i)),
                                getPreviousYear(list.get(i))
                        );
                list.get(i).setSearches(searches);
            }
        }
        return list;
    }

    public void update() throws Exception {
        SearchDAO sdao = DAOFactory.getInstance().getSearchDAO();
        sdao.save(this);
        ControlDAO dao = DAOFactory.getInstance().getControlDAO();
        dao.update(deliveryDate, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Search> getSearches() {
        return searches;
    }

    public void setSearches(List<Search> searches) {
        this.searches = searches;
    }

}
