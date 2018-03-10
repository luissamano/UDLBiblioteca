/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * an}d open the template in the editor.
 */
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.rmi.runtime.Log;

/**
 *
 * @author marti
 */
public class Connec {

    Connection conn;
    String user = "root";
    String password = "";

    public Connection Connec () {
        this.conn = null;
        try {

            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?user=" + user + "&pasword=" + password);

        } catch (SQLException se) {

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connec.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }



}
