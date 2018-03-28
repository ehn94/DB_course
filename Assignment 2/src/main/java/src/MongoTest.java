package src;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ehn19
 */
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Sorts.orderBy;
import java.util.Arrays;
import org.bson.Document;

public class MongoTest {

    public static void main(String[] args) {

        //MongoClientURI connStr = new MongoClientURI("mongodb://admin:1234@ds129428.mlab.com:29428/twitter_assignment");
        MongoClientURI connStr = new MongoClientURI("mongodb://localhost:27017");
        MongoClient mongoClient = new MongoClient(connStr);
        MongoDatabase db = mongoClient.getDatabase("social_net");
        MongoCollection<Document> collection = db.getCollection("tweets");

        Long count = collection.count();
        //Opgave 1
        System.out.println("--------------------Ex1:--------------------");

        System.out.println("There are " + count + " documents in the database");
        //Opgave 2 
        System.out.println("--------------------Ex2:--------------------");
        System.out.println("The twitter users who link the most to other users are:");
        AggregateIterable<Document> output = collection.aggregate(Arrays.asList(Aggregates.match(regex("text", "([^\\w@/\\!?=&])@(\\w{1,15})\\b")),
                Aggregates.group("$user", Accumulators.sum("user", 1)), Aggregates.sort(orderBy(descending("user"))), limit(10)));
        int index3 = 1;
        for (Document dbObject : output) {
            System.out.println((index3++) + ". " + dbObject.get("_id") + " with " + dbObject.get("user") + " links");
        }

        //Opgave 3
        System.out.println("--------------------Ex3:--------------------");
        System.out.println("Most mentioned users are: NOT DONE");
        /*AggregateIterable<Document> mostMentioned = collection.aggregate(Arrays.asList(Aggregates.match(regex("text", "('(?=^|(?=[^a-zA-Z0-9-_\\.]))@([A-Za-z]+[A-Za-z0-9_]+)'")),
                Aggregates.group("$user", Accumulators.sum("text", 1)), Aggregates.sort(orderBy(descending("text"))), limit(10)));

        for (Document dbObject : mostMentioned) {
            System.out.println(dbObject.toJson());
        }*/

        //Opgave 4
        System.out.println("--------------------Ex4:--------------------");
        System.out.println("The 5 most active users are:");
        AggregateIterable<Document> mostActive = collection.aggregate(Arrays.asList(
                Aggregates.group("$user", Accumulators.sum("user", 1)), Aggregates.sort(orderBy(descending("user"))), limit(5)
        ));
        int index2 = 1;
        for (Document dbObject : mostActive) {
            System.out.println((index2++) + ". " + dbObject.get("_id") + " who wrote " + dbObject.get("user") + " tweets");
        }
        //Opgave 5
        AggregateIterable<Document> grumpy = collection.aggregate(Arrays.asList(match(eq("polarity", 0)), limit(5)));

        System.out.println(
                "--------------------Ex5:--------------------");
        System.out.println("The five most grumpy users are: ");
        int index1 = 1;
        for (Document gObject : grumpy) {
            System.out.println((index1++) + ". " + gObject.get("user"));
        }
        AggregateIterable<Document> positive = collection.aggregate(Arrays.asList(match(eq("polarity", 4)), limit(5)));

        System.out.println(
                "The five most positive users are: ");
        int index = 1;
        for (Document pObject : positive) {
            System.out.println((index++) + ". " + pObject.get("user"));
        }
    }
}
