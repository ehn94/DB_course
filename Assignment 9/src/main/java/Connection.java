
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author ehn19
 */
public class Connection {

    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic("neo4j", "1234"));
        Session session = driver.session();

        // Run a query matching all nodes
        StatementResult result = session.run(
                "MATCH (s:Person)"
                + "RETURN s.name AS name, s.job AS job");

        while (result.hasNext()) {
            Record record = result.next();
            System.out.println(record.get("name").asString() + " -> "
                    + record.get("job").asString()); 
        }
        session.close();
        driver.close();
    }
}
