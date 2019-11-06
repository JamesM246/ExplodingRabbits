package com.sparta.jmm.display;

import com.sparta.jmm.animal.Animal;

import java.util.ArrayList;

public class Display {

    public static void printMonthInfo(int month, ArrayList<Animal> animalList){
        System.out.println("Month " + month + ":");
        for(Animal animal : animalList){
            System.out.println(animal.toString());
        }
        System.out.println("__________________________________________________________________________________________");
    }
}
