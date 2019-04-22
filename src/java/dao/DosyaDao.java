package dao;

import entity.Dosya;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

public class DosyaDao {

    private Connector connector;
    private Connection connection;

    private UniversiteDao universiteDao;

    public List<Dosya> findAll() {
        List<Dosya> dosyaList = new ArrayList<>();
        try {
          
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from dosya");
           
            while (rs.next()) {
                Dosya tmp = new Dosya();
                tmp.setDosyaAdi(rs.getString("DosyaAdi"));
                tmp.setDosyaId(rs.getLong("DosyaId"));
                tmp.setUniversite(this.getUniversiteDao().find(rs.getLong("UniversiteId")));
                dosyaList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DosyaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dosyaList;
    }

    public void delete(Dosya dosya) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from dosya where DosyaId=" + dosya.getDosyaId());
        } catch (SQLException ex) {
            Logger.getLogger(IlceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Dosya dosya, int selectedUniversite) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update dosya set DosyaAdi='" + dosya.getDosyaAdi()
                    + "',UniversiteId=" + selectedUniversite + " where DosyaId=" + dosya.getDosyaId());
        } catch (SQLException ex) {
            Logger.getLogger(DosyaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void create(Dosya dosya, int selectedUniversite) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into dosya(DosyaAdi,UniversiteId) values('" + dosya.getDosyaAdi() + "'," + selectedUniversite + ")", Statement.RETURN_GENERATED_KEYS);

            Integer dosyaId = null;
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                dosyaId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public UniversiteDao getUniversiteDao() {
        if (this.universiteDao == null) {
            this.universiteDao = new UniversiteDao();
        }
        return universiteDao;
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
