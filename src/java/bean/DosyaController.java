package bean;

import dao.DosyaDao;
import dao.UniversiteDao;
import entity.Dosya;
import entity.Universite;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DosyaController implements Serializable{

    private Dosya dosya;
    private List<Dosya> dosyaList;
    private DosyaDao dosyaDao;

    private int selectedUniversite;
    private UniversiteDao universiteDao;
    private List<Universite> universiteList;


    public void create(){
        this.getDosyaDao().create(this.dosya, selectedUniversite);
    }
public void clearForm(){
    this.dosya=new Dosya();
}    

public void deleteConfirm(Dosya dosya){
    this.dosya=dosya;
}
public void updateForm(Dosya dosya){
    this.dosya=dosya;
}
public void update(){
    this.getDosyaDao().update(this.dosya, selectedUniversite);
}
public void delete(Dosya dosya){
    this.getDosyaDao().delete(dosya);
}
public void delete(){
    this.getDosyaDao().delete(this.dosya);
    this.dosya=new Dosya();
}
    public int getSelectedUniversite() {
        return selectedUniversite;
    }

    public void setSelectedUniversite(int selectedUniversite) {
        this.selectedUniversite = selectedUniversite;
    }

    public UniversiteDao getUniversiteDao() {
        if (this.universiteDao == null) 
            this.universiteDao = new UniversiteDao();
        return universiteDao;
    }

    public void setUniversiteDao(UniversiteDao universiteDao) {
        this.universiteDao = universiteDao;
    }

    public List<Universite> getUniversiteList() {
        this.universiteList = this.getUniversiteDao().findAll();
        return universiteList;

    }
   

    public void setUniversiteList(List<Universite> universiteList) {
        this.universiteList = universiteList;
    }

    public Dosya getDosya() {
        if (this.dosya == null) {
            this.dosya = new Dosya();
        }

        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public List<Dosya> getDosyaList() {
        this.dosyaList = this.getDosyaDao().findAll();
        return dosyaList;
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public DosyaDao getDosyaDao() {
        if (this.dosyaDao == null) {
            this.dosyaDao = new DosyaDao();
        }
        return dosyaDao;
    }

    public void setDosyaDao(DosyaDao dosyaDao) {
        this.dosyaDao = dosyaDao;
    }

}
