/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

/**
 *
 * @author ehn19
 */
public class Neo4jConnector {

    private Driver driver = null;
    private final String uri = "bolt://localhost:7687";
    private final String username = "neo4j";
    private final String password = "1234";

    public Driver getDriver() {
        if(driver == null){
        this.driver = GraphDatabase.driver(uri, AuthTokens.basic(username, password));
        }
        return driver;
    }
}
