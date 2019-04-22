package bean;

import dao.SorguDao;
import entity.Sorgu;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class SorguController implements Serializable {

    private Sorgu sorgu;
    private SorguDao sorguDao;
    private List<Sorgu> sorguList;

    public void create() {
        this.getSorguDao().insert(this.sorgu);
    }

    public void delete(Sorgu sorgu) {
        this.getSorguDao().delete(sorgu);
    }

    public void delete() {
        this.getSorguDao().delete(this.sorgu);
        this.sorgu = new Sorgu();

    }

    public void clearForm() {
        this.sorgu = new Sorgu();
    }

    public void deleteConfirm(Sorgu sorgu) {
        this.sorgu = sorgu;

    }

    public void updateForm(Sorgu sorgu) {
        this.sorgu = sorgu;

    }

    public void update() {
        this.getSorguDao().update(this.sorgu);

    }

    public Sorgu getSorgu() {
        if (this.sorgu == null) {
            this.sorgu = new Sorgu();
        }
        return sorgu;
    }

    public void setSorgu(Sorgu sorgu) {
        this.sorgu = sorgu;
    }

    public SorguDao getSorguDao() {
        if (this.sorguDao == null) {
            this.sorguDao = new SorguDao();
        }
        return sorguDao;
    }

    public void setSorguDao(SorguDao sorguDao) {
        this.sorguDao = sorguDao;
    }

    public List<Sorgu> getSorguList() {
        this.sorguList = this.getSorguDao().findAll();
        return sorguList;
    }

    public void setSorguList(List<Sorgu> sorguList) {
        this.sorguList = sorguList;
    }

}
