package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connector {

    public Connection connect() {
        String user = "root";
        String pass = "root";

        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/internetpro", user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());

            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }

}
