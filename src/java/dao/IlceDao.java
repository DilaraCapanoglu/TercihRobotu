package dao;

import entity.Ilce;

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
import java.sql.PreparedStatement;
public class IlceDao {

    private Connector connector;
    private Connection connection;

    private SehirDao sehirDao;

    public Ilce find(Long id) {
        Ilce ilce = null;
        try {
           // Statement st = this.getConnection().createStatement();
            PreparedStatement pst=this.getConnection().prepareStatement("select * from ilce where IlceId=?");
            pst.setLong(1, id);
           // ResultSet rs = pst.executeQuery("select * from ilce where IlceId=" + id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            ilce = new Ilce();
            ilce.setIlceId(rs.getLong("IlceId"));
            ilce.setAdi(rs.getString("Adi"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return ilce;
    }

    public List<Ilce> findAll() {
        List<Ilce> ilceList = new ArrayList<>();

        try {
         //   Statement st = this.getConnection().createStatement();
          
             PreparedStatement pst=this.getConnection().prepareStatement("select * from ilce order by IlceId");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Ilce tmp = new Ilce();
                tmp.setIlceId(rs.getLong("IlceId"));
                tmp.setAdi(rs.getString("Adi"));

                tmp.setSehir(this.getSehirDao().find(rs.getLong("SehirId")));

                ilceList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IlceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ilceList;
    }

    public void delete(Ilce ilce) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from ilce where IlceId=" + ilce.getIlceId());

        } catch (SQLException ex) {
            Logger.getLogger(IlceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Ilce ilce,int selectedSehir) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update ilce set SehirId=" +selectedSehir+",Adi='" + ilce.getAdi() +
                    "' where IlceId= " + ilce.getIlceId());

        } catch (SQLException ex) {
            Logger.getLogger(IlceDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void create(Ilce ilce, int selectedSehir) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into ilce(Adi,SehirId) values('" + ilce.getAdi() + "'," + selectedSehir + ")",Statement.RETURN_GENERATED_KEYS);

            Integer ilceId = null;
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                    ilceId=rs.getInt(1);
            }
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public SehirDao getSehirDao() {
        if (this.sehirDao == null) {
            this.sehirDao = new SehirDao();
        }
        return sehirDao;
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
