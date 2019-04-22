package entity;
public class Fakulte {

    private Long FakulteId;
    private String Adi;

    private Universite universite;

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    
    public Long getFakulteId() {
        return FakulteId;
    }

    public void setFakulteId(Long FakulteId) {
        this.FakulteId = FakulteId;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }
    
}
