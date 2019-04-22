package dao;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Sorgu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

public class SorguDao {
  private Connector connector;
    private Connection connection;
    
        public List<Sorgu> findAll() {
        List<Sorgu> sorguList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from sorgu");
            while (rs.next()) {
                Sorgu temp = new Sorgu();
                temp.setSorguId(rs.getLong("SorguId"));
                temp.setTabanPuani(rs.getFloat("TabanPuani"));   
                temp.setTavanPuani(rs.getFloat("TavanPuani"));
                sorguList.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SorguDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sorguList;
    }

    public void insert(Sorgu sorgu) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into sorgu(TabanPuani,TavanPuani) values( "
                    + sorgu.getTabanPuani() + ","
                    + sorgu.getTavanPuani() + ")");

        } catch (SQLException ex) {
            Logger.getLogger(SorguDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Sorgu sorgu) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from sorgu where SorguId=" + sorgu.getSorguId());

        } catch (SQLException ex) {
            Logger.getLogger(SorguDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Sorgu sorgu) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update sorgu set TabanPuani=" + sorgu.getTabanPuani() +", TavanPuani="+sorgu.getTavanPuani()+
                    " where SorguId= " + sorgu.getSorguId());

        } catch (SQLException ex) {
            Logger.getLogger(SorguDao.class.getName()).log(Level.SEVERE, null, ex);

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
