package bean;

import dao.SehirDao;
import entity.Sehir;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SehirController implements Serializable {
  private Sehir sehir;
    private SehirDao sehirDao;
    private List<Sehir> sehirList;

  
    
    
    public void create(){
       this.getSehirDao().insert(this.sehir);
       
    }
    
    public void clearForm(){
        this.sehir=new Sehir();   
    }
    public void deleteConfirm(Sehir sehir){
        this.sehir=sehir;
        
    }
   
    public void updateForm(Sehir sehir){
        this.sehir=sehir;
        
    }
    public void update(){
        this.getSehirDao().update(this.sehir);
        
    }
    
    public void delete(Sehir sehir){
       this.getSehirDao().delete(sehir);
       
    }
    public void delete(){
       this.getSehirDao().delete(this.sehir);
       this.sehir=new Sehir();

    }
  
    
    public Sehir getSehir() {
        if(this.sehir==null){
            this.sehir= new Sehir();
        }
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public SehirDao getSehirDao() {
        if(this.sehirDao==null){
            this.sehirDao=new SehirDao();
        }
        return sehirDao;
    }

    public void setSehirDao(SehirDao sehirDao) {
        this.sehirDao = sehirDao;
    }

    public List<Sehir> getSehirList() {
        this.sehirList=this.getSehirDao().findAll();
        return sehirList;
    }

    public void setSehirList(List<Sehir> sehirList) {
        this.sehirList = sehirList;
    }

  
}
