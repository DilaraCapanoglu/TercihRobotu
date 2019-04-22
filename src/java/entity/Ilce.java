package entity;

import java.util.Objects;

public class Ilce {

    private Long IlceId;
    private Sehir sehir;
    private String Adi;

    public void setIlceId(Long IlceId) {
        this.IlceId = IlceId;
    }

    public Sehir getSehir() {
        return sehir;
    }

    public void setSehir(Sehir sehir) {
        this.sehir = sehir;
    }

    public Long getIlceId() {
        return IlceId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

  
    
}
