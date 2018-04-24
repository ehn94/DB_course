/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ehn19
 */
public class MySQLConnector {

    private Connection con = null;
    private final String url = "jdbc:mysql://localhost:3306/neo4jex?autoReconnect=true&useSSL=false";
    private final String username = "root";
    private final String password = "1234";
    
    public void mySQLConnector() throws SQLException{
        con = DriverManager.getConnection(url, username, password);
    }
}
