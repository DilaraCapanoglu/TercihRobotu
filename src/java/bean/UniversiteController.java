package bean;

import dao.UniversiteDao;
import entity.Universite;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class UniversiteController implements Serializable {
   
    private Universite universite;
    private UniversiteDao universiteDao;
    private List<Universite> universiteList;

    public void create(){
         this.getUniversiteDao().insert(this.universite);
    }
    public void delete(Universite universite){
        this.getUniversiteDao().delete(universite);
    }
     public void delete(){
       this.getUniversiteDao().delete(this.universite);
       this.universite=new Universite();

    }
    public void clearForm(){
        this.universite=new Universite();   
    }
    public void deleteConfirm(Universite universite){
        this.universite=universite;
        
    }
    
    public void updateForm(Universite universite){
        this.universite=universite;
        
    }
    public void update(){
        this.getUniversiteDao().update(this.universite);
        
    }
 
    public Universite getUniversite() {
        if(this.universite==null){
            this.universite=new Universite();
        }
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public UniversiteDao getUniversiteDao() {
        if(this.universiteDao==null){
            this.universiteDao=new UniversiteDao();
        }
        return universiteDao;
    }

    public void setUniversiteDao(UniversiteDao universiteDao) {
        this.universiteDao = universiteDao;
    }

    public List<Universite> getUniversiteList() {
        this.universiteList=this.getUniversiteDao().findAll();
        return universiteList;
    }

    public void setUniversiteList(List<Universite> universiteList) {
        this.universiteList = universiteList;
    }
}
