package entity;

public class Dosya {

    private Long DosyaId;
    private String DosyaAdi;
    private Universite universite;

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public Long getDosyaId() {
        return DosyaId;
    }

    public void setDosyaId(Long DosyaId) {
        this.DosyaId = DosyaId;
    }

    public String getDosyaAdi() {
        return DosyaAdi;
    }

    public void setDosyaAdi(String DosyaAdi) {
        this.DosyaAdi = DosyaAdi;
    }

}
