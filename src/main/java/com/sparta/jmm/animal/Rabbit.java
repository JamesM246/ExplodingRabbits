package com.sparta.jmm.animal;

import java.util.Random;

public class Rabbit extends Animal {

    {
        maturityAge = 3;
        maxAge = 24;
        maxChildren = 14;
    }

    public Rabbit(){
        age = 0;
        gender = new Random().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE;
    }

    public Rabbit(Gender gender){
        age = 0;
        this.gender = gender;
    }

    public Rabbit(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }
}
