package dao;

import entity.Bolum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Connector;

public class BolumDao {

    private Connection connection;
    private Connector connector;
    private FakulteDao fakulteDao;

    public FakulteDao getFakulteDao() {
        if (this.fakulteDao == null) {
            this.fakulteDao = new FakulteDao();
        }
        return fakulteDao;
    }

    public void setFakulteDao(FakulteDao fakulteDao) {
        this.fakulteDao = fakulteDao;
    }

    public List<Bolum> findAll() {
        List<Bolum> bolumList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery(" SELECT * FROM bolum ");
            while (rs.next()) {
                Bolum tmp = new Bolum();
                tmp.setBolumId(rs.getLong("BolumId"));
                tmp.setTabanPuani(rs.getFloat("TabanPuani"));
                tmp.setTavanPuani(rs.getFloat("TavanPuani"));
                tmp.setBasariSirasi(rs.getInt("BasariSirasi"));
                tmp.setKontenjan(rs.getInt("Kontenjan"));
                tmp.setAdi(rs.getString("Adi"));

                tmp.setFakulte(this.getFakulteDao().find(rs.getLong("FakulteId")));
                bolumList.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BolumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bolumList;
    }

    public void update(Bolum bolum, int selectedFakulte) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update bolum set Adi='" + bolum.getAdi()
                    + "' , TabanPuani=" + bolum.getTabanPuani()
                    + ", TavanPuani=" + bolum.getTavanPuani()
                    + ", Kontenjan=" + bolum.getKontenjan()
                    + ", BasariSirasi=" + bolum.getBasariSirasi()
                    + ",FakulteId=" + selectedFakulte
                    + " where BolumId= " + bolum.getBolumId());

        } catch (SQLException ex) {
            Logger.getLogger(BolumDao.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void delete(Bolum bolum) {

        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from bolum where BolumId=" + bolum.getBolumId());

        } catch (SQLException ex) {
            Logger.getLogger(BolumDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(Bolum bolum, int selectedFakulte) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("insert into bolum(Adi,TabanPuani,TavanPuani,Kontenjan,BasariSirasi,FakulteId)"
                    + " values('" + bolum.getAdi()
                    + "'," + bolum.getTabanPuani()
                    + "," + bolum.getTavanPuani()
                    + "," + bolum.getKontenjan()
                    + "," + bolum.getBasariSirasi()
                    + "," + selectedFakulte
                    + ")", Statement.RETURN_GENERATED_KEYS);

            Integer bolumId = null;
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                bolumId = rs.getInt(1);
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
