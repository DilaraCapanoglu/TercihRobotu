package dao;
import java.util.logging.Level;
import java.util.logging.Logger;

import entity.Yetki;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

public class YetkiDao {
  private Connector connector;
    private Connection connection;
    
        public List<Yetki> findAll() {
        List<Yetki> yetkiList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from yetki");
            while (rs.next()) {
                Yetki temp = new Yetki();
                temp.setYetkiId(rs.getLong("YetkiId"));
                temp.setYetkiAdi(rs.getString("YetkiAdi"));   
            
                yetkiList.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(YetkiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return yetkiList;
    }

    public void insert(Yetki yetki) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into yetki(YetkiAdi) values( '"
                   
                    + yetki.getYetkiAdi()+ "')");

        } catch (SQLException ex) {
            Logger.getLogger(YetkiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Yetki yetki) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from yetki where YetkiId=" + yetki.getYetkiId());

        } catch (SQLException ex) {
            Logger.getLogger(YetkiDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Yetki yetki) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update yetki set YetkiAdi='" + yetki.getYetkiAdi() +
                    "' where YetkiId= " + yetki.getYetkiId());

        } catch (SQLException ex) {
            Logger.getLogger(YetkiDao.class.getName()).log(Level.SEVERE, null, ex);

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
