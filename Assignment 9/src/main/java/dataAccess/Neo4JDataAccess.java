/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import helpers.Stopwatch;
import java.util.ArrayList;
import java.util.HashMap;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author ehn19
 */
public class Neo4JDataAccess {

    Stopwatch watch = new Stopwatch();

    public StatementResult getDepthOne(String name, HashMap<Integer, ArrayList<Double>> map, Driver driver) {
        StatementResult result;
        watch.reset();
        watch.start();
        try (Session session = driver.session()) {

            result = session.run(
                    "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES]->(p:Person)\n"
                    + "RETURN p");
        }
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(1);
        times.add(elapsed);
        return result;
    }

    public StatementResult getDepthTwo(String name, HashMap<Integer, ArrayList<Double>> map, Driver driver) {

        StatementResult result;
        watch.reset();
        watch.start();
        try (Session session = driver.session()) {

            result = session.run(
                    "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*2]->(p:Person)\n"
                    + "RETURN p");

        }
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(2);
        times.add(elapsed);
        return result;

    }

    public StatementResult getDepthThree(String name, HashMap<Integer, ArrayList<Double>> map, Driver driver) {

        StatementResult result;
        watch.reset();
        watch.start();
        try (Session session = driver.session()) {

            result = session.run(
                    "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*3]->(p:Person)\n"
                    + "RETURN p");

        }
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(3);
        times.add(elapsed);
        return result;

    }

    public StatementResult getDepthFour(String name, HashMap<Integer, ArrayList<Double>> map, Driver driver) {
        StatementResult result;
        watch.reset();
        watch.start();
        try (Session session = driver.session()) {

            result = session.run(
                    "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*4]->(p:Person)\n"
                    + "RETURN p");

        }
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(4);
        times.add(elapsed);
        return result;

    }

    public StatementResult getDepthFive(String name, HashMap<Integer, ArrayList<Double>> map, Driver driver) {
        StatementResult result;
        watch.reset();
        watch.start();
        try (Session session = driver.session()) {

            result = session.run(
                    "MATCH (:Person {name:\"" + name + "\"})-[:ENDORSES*5]->(p:Person)\n"
                    + "RETURN p");

        }
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(5);
        times.add(elapsed);
        return result;

    }

}
