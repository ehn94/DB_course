/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author ehn19
 */
public class MeasurementHelpers {
    public Double getAverage(ArrayList<Double> list){
        Double totalTime = 0.0;
        for(Double d : list){
            totalTime += d;
        }
        return totalTime/20;
    }
    
    public Double getMedian(ArrayList<Double> list){
        int middle = list.size()/2;
        middle = middle % 2 == 0? middle -1 : middle;
        return list.get(middle);
    }
    
    public List getRandom(Driver driver){
    List<String> names = new ArrayList<>();

        try (Session session = driver.session()) {
            StatementResult result = session.run(
                    "MATCH(a:Person) WITH a, rand() AS number RETURN a.name as name ORDER BY number LIMIT 20");
            
            while( result.hasNext() ) {
                Record record = result.next();
                names.add(record.get("name").asString());
            }
        }
        driver.close();
        return names;
    }
}
