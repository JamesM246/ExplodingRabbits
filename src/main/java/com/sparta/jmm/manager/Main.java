package com.sparta.jmm.manager;

import com.sparta.jmm.simulation.Simulation;

public class Main {
    public static void main(String[] args){
        Simulation simulation = new Simulation();
        try {
            simulation.simulation();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
