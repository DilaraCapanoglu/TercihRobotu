package dao;

import entity.Grup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

public class GrupDao {

    private Connection connection;
    private Connector connector;

     private KullaniciDao kullaniciDao;

    public KullaniciDao getKullaniciDao() {
        if(this.kullaniciDao==null)
            this.kullaniciDao=new KullaniciDao();
        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }
    public List<Grup> findAll() {
        List<Grup> grupList = new ArrayList<>();

        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(" SELECT * FROM grup ");
            while (rs.next()) {
                Grup tmp = new Grup();
                tmp.setGrupId(rs.getLong("GrupId"));
                tmp.setAdi(rs.getString("Adi"));
tmp.setKullaniciGrup(this.getKullaniciDao().getGrupKullanici(tmp.getGrupId()));
                grupList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return grupList;
    }

    public void delete(Grup grup) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from grup where GrupId=" + grup.getGrupId());

        } catch (SQLException ex) {
            Logger.getLogger(GrupDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Grup grup) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update grup set Adi='" + grup.getAdi() + "' "
                    + " where GrupId= " + grup.getGrupId());

        } catch (SQLException ex) {
            Logger.getLogger(GrupDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void create(Grup grup) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into grup(Adi) values('" + grup.getAdi() + "')", Statement.RETURN_GENERATED_KEYS);

            Integer grupId = null;
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                grupId = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
