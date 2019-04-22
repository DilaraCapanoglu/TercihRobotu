package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Sehir;
import java.sql.PreparedStatement;
import util.Connector;

public class SehirDao {

    private Connector connector;
    private Connection connection;

    public Sehir find(Long id) {
        Sehir sehir = null;
        try {
            //Statement st=this.getConnection().createStatement();
            PreparedStatement pst = this.getConnection().prepareStatement("select * from sehir where SehirId=?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            //  ResultSet rs=pst.executeQuery("select * from sehir where SehirId="+id);
            rs.next();

            sehir = new Sehir();
            sehir.setSehirId(rs.getLong("SehirId"));
            sehir.setAdi(rs.getString("Adi"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return sehir;
    }

    public List<Sehir> findAll() {

        List<Sehir> sehirList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from sehir");

            while (rs.next()) {
                Sehir tmp = new Sehir();
                tmp.setSehirId(rs.getLong("SehirId"));
                tmp.setAdi(rs.getString("Adi"));
                sehirList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SehirDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sehirList;
    }

    public void insert(Sehir sehir) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into sehir(Adi) values( '" + sehir.getAdi() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(SehirDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Sehir cat) {

        try {

            Statement st = this.getConnection().createStatement();
            String ilce = "delete from ilce where SehirId = " + cat.getSehirId();
            st.executeUpdate(ilce);

            String sql = " delete from  sehir where SehirId=" + cat.getSehirId();
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(SehirDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Sehir sehir) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update sehir set Adi='" + sehir.getAdi() + "' where SehirId= " + sehir.getSehirId());

        } catch (SQLException ex) {
            Logger.getLogger(SehirDao.class.getName()).log(Level.SEVERE, null, ex);

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
