
import dataAccess.MySQLConnector;
import dataAccess.MySQLDataAccess;
import dataAccess.Neo4JDataAccess;
import dataAccess.Neo4jConnector;
import helpers.MeasurementHelpers;
import helpers.Stopwatch;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ehn19
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Neo4jConnector neoCon = new Neo4jConnector();
        MySQLConnector sqlCon = new MySQLConnector();
        
        Neo4JDataAccess neoAccess = new Neo4JDataAccess();
        MySQLDataAccess sqlAccess = new MySQLDataAccess();
        
        MeasurementHelpers helper = new MeasurementHelpers();
        Stopwatch watch = new Stopwatch(); 

        HashMap<Integer, ArrayList<Double>> neo4jMap = new HashMap<>();
        HashMap<Integer, ArrayList<Double>> sqlMap = new HashMap<>();
        
        neo4jMap.put(1, new ArrayList<>());
        neo4jMap.put(2, new ArrayList<>());
        neo4jMap.put(3, new ArrayList<>());
        neo4jMap.put(4, new ArrayList<>());
        neo4jMap.put(5, new ArrayList<>());
        
        sqlMap.put(1, new ArrayList<>());
        sqlMap.put(2, new ArrayList<>());
        sqlMap.put(3, new ArrayList<>());
        sqlMap.put(4, new ArrayList<>());
        sqlMap.put(5, new ArrayList<>());

        helper.getRandom(neoCon.getDriver()).forEach((name) -> {
            try {
                neoAccess.getDepthOne((String) name, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthTwo((String) name, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthThree((String) name, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthFour((String) name, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthFive((String) name, neo4jMap, neoCon.getDriver());
                
                sqlAccess.getDepthOne((String) name, sqlMap, sqlCon.mySQLConnector());
                sqlAccess.getDepthTwo((String) name, sqlMap, sqlCon.mySQLConnector());
                sqlAccess.getDepthThree((String) name, sqlMap, sqlCon.mySQLConnector());    
                sqlAccess.getDepthFour((String) name, sqlMap, sqlCon.mySQLConnector());
                sqlAccess.getDepthFive((String) name, sqlMap, sqlCon.mySQLConnector());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
//        System.out.println("-------------- Neo4J --------------");
//        System.out.println("Depth 1: ");
//        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(1)));
//        System.out.println("Median: " + helper.getMedian(neo4jMap.get(1)));
//        System.out.println("Depth 2: ");
//        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(2)));
//        System.out.println("Median: " + helper.getMedian(neo4jMap.get(2)));
//        System.out.println("Depth 3: ");
//        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(3)));
//        System.out.println("Median: " + helper.getMedian(neo4jMap.get(3)));
//        System.out.println("Depth 4: ");
//        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(4)));
//        System.out.println("Median: " + helper.getMedian(neo4jMap.get(4)));
//        System.out.println("Depth 5: ");
//        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(5)));
//        System.out.println("Median: " + helper.getMedian(neo4jMap.get(5)));

        System.out.println("-------------- MySQL --------------");
        System.out.println("Depth 1: ");
        System.out.println("Avg: " + helper.getAverage(sqlMap.get(1)));
        System.out.println("Median: " + helper.getMedian(sqlMap.get(1)));
        System.out.println("Depth 2: ");
        System.out.println("Avg: " + helper.getAverage(sqlMap.get(2)));
        System.out.println("Median: " + helper.getMedian(sqlMap.get(2)));
        System.out.println("Depth 3: ");
        System.out.println("Avg: " + helper.getAverage(sqlMap.get(3)));
        System.out.println("Median: " + helper.getMedian(sqlMap.get(3)));
        System.out.println("Depth 4: ");
        System.out.println("Avg: " + helper.getAverage(sqlMap.get(4)));
        System.out.println("Median: " + helper.getMedian(sqlMap.get(4)));
        System.out.println("Depth 5: ");
        System.out.println("Avg: " + helper.getAverage(sqlMap.get(5)));
        System.out.println("Median: " + helper.getMedian(sqlMap.get(5)));

    }

}
