/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * an}d open the template in the editor.
 */
package Conexion;


import java.sql.DriverManager;
import java.sql.SQLException;
import sun.rmi.runtime.Log;

/**
 *
 * @author marti
 */
public class Connection {

    Connection conn;

    public Connection(String script) throws ClassNotFoundException {
        this.conn = null;
        switch (script) {
            case "Star":
                Start();
                break;
            case "Info":
                break;
            case "Close":
                Close();
                break;
            default:
                break;
        }
    }

    private Connection Start() throws ClassNotFoundException {
        
        try {

            //Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = (Connection) DriverManager.getConnection("jdbc:sqlserver://SC-DESKTOP:1433;"
                                                        + "databaseName=Biblioteca;"
                                                        + "user=sa;password=sysserver");

        } catch (SQLException se) {

        }

        return conn;
    }

    private Connection Close() {
        return conn.Close();
    }

}
