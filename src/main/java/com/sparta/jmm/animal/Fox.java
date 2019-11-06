package com.sparta.jmm.animal;

import java.util.Random;

public class Fox extends Animal {

    private int monthsSinceGaveBirth;

    {
        maturityAge = 10;
        maxChildren = 10;
    }

    public Fox(){
        age = 0;
        gender = new Random().nextInt(2) == 0 ? Gender.MALE : Gender.FEMALE;
        monthsSinceGaveBirth = (gender == Gender.MALE) ? -1 : 0;
    }

    public Fox(Gender gender){
        age = 0;
        this.gender = gender;
    }

    public Fox(int age, Gender gender){
        this.age = age;
        this.gender = gender;
    }
}
