package bean;

import dao.FakulteDao;
import dao.UniversiteDao;
import entity.Fakulte;
import entity.Universite;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FakulteController implements Serializable {

    private Fakulte fakulte;
    private FakulteDao fakulteDao;
    private List<Fakulte> fakulteList;

    private int selectedUniversite;
    private UniversiteDao universiteDao;
    private List<Universite> universiteList;

    
    
    public void create() {
        this.getFakulteDao().create(this.fakulte, selectedUniversite);

    }

    public void clearForm() {
        this.fakulte = new Fakulte();
    }
  
    public void update(){
        this.getFakulteDao().update(this.fakulte,selectedUniversite);
        
    }
     public void updateForm(Fakulte fakulte){
        this.fakulte=fakulte;
    }
    
    public void deleteConfirm(Fakulte fakulte){
        this.fakulte=fakulte;   
    }
 
      public void delete(Fakulte fakulte){
       this.getFakulteDao().delete(fakulte);
       
    }
    public void delete(){
       this.getFakulteDao().delete(this.fakulte);
       this.fakulte=new Fakulte();

    }
    
    public int getSelectedUniversite() {
        return selectedUniversite;
    }

    public void setSelectedUniversite(int selectedUniversite) {
        this.selectedUniversite = selectedUniversite;
    }

    public UniversiteDao getUniversiteDao() {
        if (this.universiteDao == null) {
            this.universiteDao = new UniversiteDao();
        }
        return universiteDao;
    }

    public List<Universite> getUniversiteList() {
        this.universiteList = this.getUniversiteDao().findAll();
        return universiteList;
    }

    public void setUniversiteList(List<Universite> universiteList) {
        this.universiteList = universiteList;
    }

    public Fakulte getFakulte() {
        if (this.fakulte == null) {
            this.fakulte = new Fakulte();
        }
        return fakulte;
    }
    

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }

    public FakulteDao getFakulteDao() {
        if (this.fakulteDao == null) {
            this.fakulteDao = new FakulteDao();
        }
        return fakulteDao;
    }

    public void setFakulteDao(FakulteDao fakulteDao) {
        this.fakulteDao = fakulteDao;
    }

    public List<Fakulte> getFakulteList() {
        this.fakulteList = this.getFakulteDao().findAll();
        return fakulteList;
    }

    public void setFakulteList(List<Fakulte> fakulteList) {
        this.fakulteList = fakulteList;
    }

}
