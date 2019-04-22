package bean;
import dao.GrupDao;
import entity.Grup;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class GrupController implements Serializable{
    private Grup grup;
    private GrupDao grupDao;
    private List<Grup> grupList;

    public Grup getGrup() {
        if(this.grup==null)
            this.grup=new Grup();
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    public GrupDao getGrupDao() {
   if(this.grupDao==null)
       this.grupDao=new GrupDao();
        return grupDao;
    }

    public void setGrupDao(GrupDao grupDao) {
        this.grupDao = grupDao;
    }

    public List<Grup> getGrupList() {
      this.grupList=this.getGrupDao().findAll();
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
    }
    public void clearForm(){
        this.grup=new Grup();
    }
    public void deleteConfirm(Grup grup){
        this.grup=grup;
    }
    public void create(){
        this.getGrupDao().create(this.grup);
    } 
    public void updateForm(Grup grup){
        this.grup=grup;
    }
    public void update(){
        this.getGrupDao().update(this.grup);
    }
    public void delete(Grup grup){
        this.getGrupDao().delete(this.grup);
    }
    public void delete(){
        this.getGrupDao().delete(this.grup);
        this.grup=new Grup();
    }
}
