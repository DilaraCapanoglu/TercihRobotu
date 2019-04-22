package bean;

import dao.BolumDao;
import dao.FakulteDao;
import entity.Bolum;
import entity.Fakulte;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class BolumController implements Serializable {

    private Bolum bolum;
    private BolumDao bolumDao;
    private List<Bolum> bolumList;

    private int selectedFakulte;
    private FakulteDao fakulteDao;
    private List<Fakulte> fakulteList;

    public int getSelectedFakulte() {
        return selectedFakulte;
    }

    public void setSelectedFakulte(int selectedFakulte) {
        this.selectedFakulte = selectedFakulte;
    }

    public FakulteDao getFakulteDao() {
        if(this.fakulteDao==null)
            this.fakulteDao=new FakulteDao();
        return fakulteDao;
    }

    public List<Fakulte> getFakulteList() {
        this.fakulteList=this.getFakulteDao().findAll();
        return fakulteList;
    }

    public void setFakulteList(List<Fakulte> fakulteList) {
        this.fakulteList = fakulteList;
    }
    
  
    public void clearForm() {
        this.bolum = new Bolum();
    }

    public void deleteConfirm(Bolum bolum) {
        this.bolum = bolum;

    }

    public void create() {
        this.getBolumDao().create(this.bolum,selectedFakulte);
    }

    public void updateForm(Bolum bolum) {
        this.bolum = bolum;

    }

    public void update() {
        this.getBolumDao().update(this.bolum,selectedFakulte);

    }

    public void delete(Bolum bolum) {
        this.getBolumDao().delete(bolum);

    }

    public void delete() {
        this.getBolumDao().delete(this.bolum);
        this.bolum = new Bolum();

    }

    public Bolum getBolum() {
        if (this.bolum == null) {
            this.bolum = new Bolum();
        }
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public BolumDao getBolumDao() {
        if (this.bolumDao == null) {
            this.bolumDao = new BolumDao();
        }
        return bolumDao;
    }

    public void setBolumDao(BolumDao bolumDao) {
        this.bolumDao = bolumDao;
    }

    public List<Bolum> getBolumList() {
        this.bolumList = this.getBolumDao().findAll();
        return bolumList;
    }

    public void setBolumList(List<Bolum> bolumList) {
        this.bolumList = bolumList;
    }
}
