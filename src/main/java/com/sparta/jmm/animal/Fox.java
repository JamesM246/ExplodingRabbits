package com.sparta.jmm.animal;

import java.util.Random;

public class Fox extends Animal {

    private int monthsSinceBreeding = 0;
    private final int breedingCooldown = 12;
    private final int maxHunger = 20;

    {
        maturityAge = 10;
        maxAge = 60;
        maxChildren = 10;
    }

    public Fox(){
        age = 0;
        gender = new Random().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE;
    }

    public Fox(Gender gender){
        age = 0;
        this.gender = gender;
    }

    public Fox(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }

    public int getMonthsSinceBreeding() {
        return monthsSinceBreeding;
    }

    public int getBreedingCooldown() {
        return breedingCooldown;
    }

    public void resetMonthsSinceBreeding(){
        monthsSinceBreeding = 0;
    }

    public void incrementMonthsSinceBreeding(){
        monthsSinceBreeding++;
    }

    public int getMaxHunger() {
        return maxHunger;
    }
}
