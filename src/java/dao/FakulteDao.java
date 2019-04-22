package dao;

import entity.Fakulte;
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

public class FakulteDao {

    private Connection connection;
    private Connector connector;
    private UniversiteDao universiteDao;

    public UniversiteDao getUniversiteDao() {
        if (this.universiteDao == null) {
            this.universiteDao = new UniversiteDao();
        }
        return universiteDao;
    }

    public void setUniversiteDao(UniversiteDao universiteDao) {
        this.universiteDao = universiteDao;
    }

    public List<Fakulte> findAll() {

        List<Fakulte> fakulteList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from fakulte");

            while (rs.next()) {
                Fakulte tmp = new Fakulte();
                tmp.setFakulteId(rs.getLong("FakulteId"));
                tmp.setAdi(rs.getString("Adi"));

                tmp.setUniversite(this.getUniversiteDao().find(rs.getLong("UniversiteId")));

                fakulteList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FakulteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fakulteList;
    }

    public Fakulte find(Long id){
    Fakulte fakulte=null;
    try{
       // Statement st=this.getConnection().createStatement();
       // ResultSet rs=st.executeQuery("select * from fakulte where FakulteId="+id);
        PreparedStatement pst=this.getConnection().prepareStatement("select * from fakulte where FakulteId=?");
        pst.setLong(1, id);
        
       ResultSet rs=pst.executeQuery();
        
        rs.next();
        
        fakulte=new Fakulte();
        fakulte.setFakulteId(rs.getLong("FakulteId"));
        fakulte.setAdi(rs.getString("Adi"));
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
        return fakulte;
    }  
    
    public void delete(Fakulte fakulte) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from fakulte where FakulteId=" + fakulte.getFakulteId());

        } catch (SQLException ex) {
            Logger.getLogger(KullaniciDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(Fakulte fakulte, int selectedUniversite) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into fakulte(Adi,UniversiteId) values('"
                    + fakulte.getAdi()
                    + "'," + selectedUniversite
                    + ")", Statement.RETURN_GENERATED_KEYS);
            Integer fakulteId = null;

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                fakulteId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Fakulte fakulte, int selectedUniversite) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update fakulte set Adi='" + fakulte.getAdi() + "',UniversiteId=" + selectedUniversite
                    + " where FakulteId= " + fakulte.getFakulteId());

        } catch (SQLException ex) {
            Logger.getLogger(FakulteDao.class.getName()).log(Level.SEVERE, null, ex);

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
