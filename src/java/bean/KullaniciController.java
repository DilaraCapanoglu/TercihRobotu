package bean;
import dao.KullaniciDao;
import entity.Kullanici;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class KullaniciController implements Serializable{
    private Kullanici kullanici;
    private KullaniciDao kullaniciDao;
    private List<Kullanici> kullaniciList;

    public Kullanici getKullanici() {
if(this.kullanici==null)
    this.kullanici=new Kullanici();
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public KullaniciDao getKullaniciDao() {
        if(this.kullaniciDao==null)
            this.kullaniciDao=new KullaniciDao();
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public List<Kullanici> getKullaniciList() {
        this.kullaniciList=this.getKullaniciDao().findAll();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }
    public void create(){
        this.kullaniciDao.insert(this.kullanici);
    }
    public void clearForm(){
        this.kullanici=new Kullanici();
    }
    public void deleteConfirm(Kullanici kullanici){
        this.kullanici=kullanici;
    }
    public void updateForm(Kullanici kullanici){
        this.kullanici=kullanici;
    }
    public void update(){
        this.getKullaniciDao().update(this.kullanici);
    }
    public void delete(Kullanici kullanici){
        this.getKullaniciDao().delete(kullanici);
    }
    public void delete(){
        this.getKullaniciDao().delete(this.kullanici);
this.kullanici=new Kullanici();
    }
}
