package entity;

import java.util.List;

public class Grup {

    private Long GrupId;
    private String Adi;
    private Kullanici kullanici;

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    private List<Kullanici> kullaniciGrup;

    public List<Kullanici> getKullaniciGrup() {
        return kullaniciGrup;
    }

    public void setKullaniciGrup(List<Kullanici> kullaniciGrup) {
        this.kullaniciGrup = kullaniciGrup;
    }

    public Long getGrupId() {
        return GrupId;
    }

    public void setGrupId(Long GrupId) {
        this.GrupId = GrupId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

}
