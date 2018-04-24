/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import helpers.Stopwatch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ehn19
 */
public class MySQLDataAccess {

    Stopwatch watch = new Stopwatch();

    public ResultSet getDepthOne(String name, HashMap<Integer, ArrayList<Double>> map, Connection con) throws Exception {
        Statement stmt = con.createStatement();
        String query = "SELECT count(*) FROM t_user a JOIN  "
                + "(select * FROM endorsement e JOIN t_user p ON e.source_node_id = p.id WHERE p.name='" + name + "')"
                + " b ON a.id=b.target_node_id;";
        watch.reset();
        watch.start();
        ResultSet res = stmt.executeQuery(query);
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(1);
        times.add(elapsed);
        return res;
    }

    public ResultSet getDepthTwo(String name, HashMap<Integer, ArrayList<Double>> map, Connection con) throws Exception {
        Statement stmt = con.createStatement();
        String query = "SELECT count(*) FROM t_user WHERE id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement e JOIN t_user p ON e.source_node_id = p.id "
                + "WHERE p.name = '" + name + "'));";
        watch.reset();
        watch.start();
        ResultSet res = stmt.executeQuery(query);
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(2);
        times.add(elapsed);
        return res;
    }

    public ResultSet getDepthThree(String name, HashMap<Integer, ArrayList<Double>> map, Connection con) throws Exception {
        Statement stmt = con.createStatement();
        String query = "SELECT count(*) FROM t_user WHERE id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement e JOIN t_user p ON e.source_node_id = p.id "
                + "WHERE p.name = '" + name + "')));";
        watch.reset();
        watch.start();
        ResultSet res = stmt.executeQuery(query);
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(3);
        times.add(elapsed);
        return res;
    }

    public ResultSet getDepthFour(String name, HashMap<Integer, ArrayList<Double>> map, Connection con) throws Exception {
        Statement stmt = con.createStatement();
        String query = "SELECT count(*) FROM t_user WHERE id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement e JOIN t_user p "
                + "ON e.source_node_id = p.id WHERE p.name = '" + name + "'))));";
        watch.reset();
        watch.start();
        ResultSet res = stmt.executeQuery(query);
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(4);
        times.add(elapsed);
        return res;
    }

    public ResultSet getDepthFive(String name, HashMap<Integer, ArrayList<Double>> map, Connection con) throws Exception {
        Statement stmt = con.createStatement();

        String query = "SELECT count(*) FROM t_user WHERE id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement WHERE source_node_id IN "
                + "(SELECT target_node_id FROM endorsement e JOIN t_user p "
                + "ON e.source_node_id = p.id WHERE p.name = '" + name + "')))));";
        watch.reset();
        watch.start();
        ResultSet res = stmt.executeQuery(query);
        double elapsed = watch.elapsedTime();
        ArrayList<Double> times = map.get(5);
        times.add(elapsed);
        return res;
    }
}
