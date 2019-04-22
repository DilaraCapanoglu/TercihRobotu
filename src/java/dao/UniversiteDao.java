package dao;

import entity.Universite;
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

public class UniversiteDao {

    private Connector connector;
    private Connection connection;

   public Universite find(Long id) {
        Universite universite = null;
        try {
           // Statement st = this.getConnection().createStatement();
            PreparedStatement pst=this.getConnection().prepareStatement("select * from universite where UniversiteId=?");
            pst.setLong(1, id);
            ResultSet rs=pst.executeQuery();
        //    ResultSet rs = st.executeQuery("select * from universite where UniversiteId=" + id);
            rs.next();

            universite = new Universite();
            universite.setUniversiteId(rs.getLong("UniversiteId"));
            universite.setAdi(rs.getString("Adi"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return universite;
    }

    public List<Universite> findAll() {
        List<Universite> universiteList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from universite");
            while (rs.next()) {
                Universite temp = new Universite();
                temp.setUniversiteId(rs.getLong("UniversiteId"));
                temp.setAdi(rs.getString("Adi"));
                universiteList.add(temp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UniversiteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return universiteList;
    }

    public void insert(Universite universite) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into universite(UniversiteId,Adi) values( "
                    + universite.getUniversiteId() + ",'"
                    + universite.getAdi() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(UniversiteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Universite universite) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from universite where UniversiteId=" + universite.getUniversiteId());

        } catch (SQLException ex) {
            Logger.getLogger(UniversiteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Universite universite) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update universite set Adi='" + universite.getAdi() + "' where UniversiteId= " + universite.getUniversiteId());

        } catch (SQLException ex) {
            Logger.getLogger(UniversiteDao.class.getName()).log(Level.SEVERE, null, ex);

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
