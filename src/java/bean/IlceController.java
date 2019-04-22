package bean;

import dao.IlceDao;
import dao.SehirDao;
import entity.Ilce;
import entity.Sehir;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class IlceController implements Serializable{
    
    private Ilce ilce;
    private List<Ilce> ilceList;
    private IlceDao ilceDao;

    private int selectedSehir;
private SehirDao sehirDao;
private List<Sehir> sehirList;

    public List<Sehir> getSehirList() {
        this.sehirList=this.getSehirDao().findAll();
        return sehirList;
    }

    public void setSehirList(List<Sehir> sehirList) {
        this.sehirList = sehirList;
    }

    public SehirDao getSehirDao() {
        if(this.sehirDao==null)
            this.sehirDao=new SehirDao();
        return sehirDao;
    }

    public int getSelectedSehir() {
        return selectedSehir;
    }

    public void setSelectedSehir(int selectedSehir) {
        this.selectedSehir = selectedSehir;
    }
      public void create(){
      this.getIlceDao().create(this.ilce,selectedSehir);
      }

    public void clearForm(){
        this.ilce=new Ilce();   
    }
    public void deleteConfirm(Ilce ilce){
        this.ilce=ilce;   
    }
 
    public void updateForm(Ilce ilce){
        this.ilce=ilce;
    }
    
    public void update(){
        this.getIlceDao().update(this.ilce,selectedSehir);
        
    }
    
    public void delete(Ilce ilce){
       this.getIlceDao().delete(ilce);
       
    }
    public void delete(){
       this.getIlceDao().delete(this.ilce);
       this.ilce=new Ilce();

    }
    public Ilce getIlce() {
        if(this.ilce==null)
            this.ilce=new Ilce();
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    public List<Ilce> getIlceList() {
           this.ilceList=this.getIlceDao().findAll();
        return ilceList;
    }

    public void setIlceList(List<Ilce> ilceList) {
        this.ilceList = ilceList;
    }

    public IlceDao getIlceDao() {
           if(this.ilceDao==null){
            this.ilceDao=new IlceDao();
        }
        return ilceDao;
    }

    public void setIlceDao(IlceDao ilceDao) {
        this.ilceDao = ilceDao;
    }

    
}
