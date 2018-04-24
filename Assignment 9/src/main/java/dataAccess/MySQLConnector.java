/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ehn19
 */
public class MySQLConnector {

    private Connection con = null;
    private final String url = "jdbc:mysql://localhost:3306/neo4jex?autoReconnect=true&useSSL=false";
    private final String username = "root";
    private final String password = "1234";
    
    public Connection mySQLConnector() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
