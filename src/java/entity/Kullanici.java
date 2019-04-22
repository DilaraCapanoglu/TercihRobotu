package entity;
public class Kullanici {

    private Long KullaniciId;
    private String KullaniciAdi;
    private String Email;
    private String Parola;

    public Long getKullaniciId() {
        return KullaniciId;
    }

    public void setKullaniciId(Long KullaniciId) {
        this.KullaniciId = KullaniciId;
    }

    public String getKullaniciAdi() {
        return KullaniciAdi;
    }

    public void setKullaniciAdi(String KullaniciAdi) {
        this.KullaniciAdi = KullaniciAdi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getParola() {
        return Parola;
    }

    public void setParola(String Parola) {
        this.Parola = Parola;
    }
    
}
