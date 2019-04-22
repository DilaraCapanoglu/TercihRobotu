package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

public class KullaniciDao {

    private Connection connection;
    private Connector connector;
   
    
    public List<Kullanici> findAll() {
        List<Kullanici> kullaniciList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici");

            while (rs.next()) {

                Kullanici tmp = new Kullanici();
                tmp.setKullaniciAdi(rs.getString("KullaniciAdi"));
                tmp.setParola(rs.getString("Parola"));
                tmp.setEmail(rs.getString("Email"));

                kullaniciList.add(tmp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kullaniciList;
    }
 public Kullanici find(Long id) {
        Kullanici kullanici = null;
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanici where KullaniciId=" + id);
            rs.next();

            kullanici = new Kullanici();
            kullanici.setKullaniciId(rs.getLong("KullaniciId"));
            kullanici.setKullaniciAdi(rs.getString("KullaniciAdi"));
            kullanici.setEmail(rs.getString("Email"));
            kullanici.setParola(rs.getString("Parola"));
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return kullanici ;
    }
    
    public void delete(Kullanici kullanici) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from kullanici where KullaniciId=" + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   /* public void create(Kullanici kullanici) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into kullanici(KullaniciAdi,Email,Parola) values('"
                    + kullanici.getKullaniciAdi()
                    + "','" + kullanici.getEmail()
                    + "','" + kullanici.getParola() + "' )", Statement.RETURN_GENERATED_KEYS);

            Integer kullaniciId = null;
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                kullaniciId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    public void insert(Kullanici kullanici) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into kullanici(KullaniciAdi,Email,Parola) values('"
                     + kullanici.getKullaniciAdi()
                    + "','" + kullanici.getEmail()
                    + "','" + kullanici.getParola() + "' )");

        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void update(Kullanici kullanici) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update kullanici set KullaniciAdi='" + kullanici.getKullaniciAdi()+
                    "', Parola='"+kullanici.getParola()+
                    "',Email='"+kullanici.getEmail()
                    + "' where KullaniciId= " + kullanici.getKullaniciId());

        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
      public List<Kullanici> getGrupKullanici(Long grupId) {
        List<Kullanici> grupKullanici = new ArrayList<>();

        try {
   
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kullanicigrup where GrupId=" + grupId);
            while(rs.next()){
                grupKullanici.add(this.find(rs.getLong("KullaniciId")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return grupKullanici;
    }
    
    
    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }
}
