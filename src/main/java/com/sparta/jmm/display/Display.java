package com.sparta.jmm.display;

import com.sparta.jmm.animal.*;

import java.util.ArrayList;

public class Display {

    public static void printMonth(int month){
        System.out.println("__________________________________________________________________________________________");
        System.out.println("Month " + month + ":");
    }

    public static void printRabbitInfo(int malePop, int femalePop, int births, int deaths, int eaten){
        System.out.println("Rabbits: " + (malePop + femalePop) +
                ", males: " + malePop + ", females: " + femalePop);
        System.out.println("            births: " + births + ", deaths: " + (deaths + eaten) + " (" + eaten + " eaten)");

    }

    public static void printFoxInfo(int malePop, int femalePop, int births, int deaths){
        System.out.println("Foxes: " + (malePop + femalePop) +
                ", males: " + malePop + ", females: " + femalePop);
        System.out.println("            births: " + births + ", deaths: " + deaths);

    }
}
