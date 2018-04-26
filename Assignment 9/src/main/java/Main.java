
import dataAccess.MySQLConnector;
import dataAccess.MySQLDataAccess;
import dataAccess.Neo4JDataAccess;
import dataAccess.Neo4jConnector;
import helpers.MeasurementHelpers;
import java.util.ArrayList;
import java.util.HashMap;

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

        helper.getRandom(neoCon.getDriver()).forEach((id) -> {
            try {
                System.out.println("Name: " + id);
                neoAccess.getDepthOne((String) id, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthTwo((String) id, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthThree((String) id, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthFour((String) id, neo4jMap, neoCon.getDriver());
                neoAccess.getDepthFive((String) id, neo4jMap, neoCon.getDriver());
//                
//                sqlAccess.getDepthOne((String) name, sqlMap, sqlCon.mySQLConnector());
//                sqlAccess.getDepthTwo((String) name, sqlMap, sqlCon.mySQLConnector());
//                sqlAccess.getDepthThree((String) name, sqlMap, sqlCon.mySQLConnector());    
//                sqlAccess.getDepthFour((String) name, sqlMap, sqlCon.mySQLConnector());
//                sqlAccess.getDepthFive((String) name, sqlMap, sqlCon.mySQLConnector());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
        System.out.println("-------------- Neo4J --------------");
        System.out.println("Depth 1: ");
        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(1)));
        System.out.println("Median: " + helper.getMedian(neo4jMap.get(1)));
        System.out.println("Depth 2: ");
        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(2)));
        System.out.println("Median: " + helper.getMedian(neo4jMap.get(2)));
        System.out.println("Depth 3: ");
        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(3)));
        System.out.println("Median: " + helper.getMedian(neo4jMap.get(3)));
        System.out.println("Depth 4: ");
        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(4)));
        System.out.println("Median: " + helper.getMedian(neo4jMap.get(4)));
        System.out.println("Depth 5: ");
        System.out.println("Avg: " + helper.getAverage(neo4jMap.get(5)));
        System.out.println("Median: " + helper.getMedian(neo4jMap.get(5)));

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
