/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

/**
 *
 * @author ehn19
 */
public class Stopwatch {

    private long start;

    public void start(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long current = System.currentTimeMillis();
        return (current - start) /1000.0;
    }
    public void reset(){
        start = System.currentTimeMillis();
    }
}
