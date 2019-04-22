package entity;
public class Bolum {

  private Long BolumId;
    private float TabanPuani;
    private float TavanPuani;
    private int BasariSirasi;
    private int Kontenjan;
    private String Adi;
private Fakulte fakulte;

    public Long getBolumId() {
        return BolumId;
    }

    public void setBolumId(Long BolumId) {
        this.BolumId = BolumId;
    }

    public float getTabanPuani() {
        return TabanPuani;
    }

    public void setTabanPuani(float TabanPuani) {
        this.TabanPuani = TabanPuani;
    }

    public float getTavanPuani() {
        return TavanPuani;
    }

    public void setTavanPuani(float TavanPuani) {
        this.TavanPuani = TavanPuani;
    }

    public int getBasariSirasi() {
        return BasariSirasi;
    }

    public void setBasariSirasi(int BasariSirasi) {
        this.BasariSirasi = BasariSirasi;
    }

    public int getKontenjan() {
        return Kontenjan;
    }

    public void setKontenjan(int Kontenjan) {
        this.Kontenjan = Kontenjan;
    }

    public String getAdi() {
        return Adi;
    }

    public void setAdi(String Adi) {
        this.Adi = Adi;
    }

    public Fakulte getFakulte() {
        return fakulte;
    }

    public void setFakulte(Fakulte fakulte) {
        this.fakulte = fakulte;
    }
    
  
}
