package bean;

import dao.YetkiDao;
import entity.Yetki;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class YetkiController implements Serializable {

    private Yetki yetki;
    private YetkiDao yetkiDao;
    private List<Yetki> yetkiList;

    public Yetki getYetki() {
        if (this.yetki == null) {
            this.yetki = new Yetki();
        }
        return yetki;
    }

    public void setYetki(Yetki yetki) {
        this.yetki = yetki;
    }

    public YetkiDao getYetkiDao() {
        if (this.yetkiDao == null) {
            this.yetkiDao = new YetkiDao();
        }
        return yetkiDao;
    }

    public void setYetkiDao(YetkiDao yetkiDao) {
        this.yetkiDao = yetkiDao;
    }

    public List<Yetki> getYetkiList() {
        this.yetkiList = this.getYetkiDao().findAll();
        return yetkiList;
    }

    public void setYetkiList(List<Yetki> yetkiList) {
        this.yetkiList = yetkiList;
    }

    public void create() {
        this.getYetkiDao().insert(this.yetki);
    }

    public void delete(Yetki yetki) {
        this.getYetkiDao().delete(yetki);
    }

    public void delete() {
        this.getYetkiDao().delete(this.yetki);
        this.yetki = new Yetki();

    }

    public void clearForm() {
        this.yetki = new Yetki();
    }

    public void deleteConfirm(Yetki yetki) {
        this.yetki = yetki;

    }

    public void updateForm(Yetki yetki) {
        this.yetki = yetki;

    }

    public void update() {
        this.getYetkiDao().update(this.yetki);

    }
}
