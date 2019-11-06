package com.sparta.jmm.simulation;

import com.sparta.jmm.animal.*;
import com.sparta.jmm.display.Display;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Animal> animalList = new ArrayList<>();
    private int month = 0;

    public void simulation() throws InterruptedException {
        simulationSetup();
        Display.printMonthInfo(month,animalList);
        for(int i=0;i<12;i++){
            Thread.sleep(1000);
            nextMonth();
            Display.printMonthInfo(month,animalList);
        }
    }

    public void simulationSetup(){
        animalList.add(new Rabbit(Gender.MALE));
        animalList.add(new Rabbit(Gender.FEMALE));
    }

    public void nextMonth(){
        month++;
        for(Animal animal : animalList){
            animal.incrementAge();
        }
    }
}
