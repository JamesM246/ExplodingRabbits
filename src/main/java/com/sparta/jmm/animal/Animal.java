package com.sparta.jmm.animal;

public class Animal {
    protected int age;
    protected Gender gender;
    protected int maturityAge;
    protected int maxAge;
    protected int maxChildren;

    @Override
    public String toString(){
        String animalClass = this.getClass().toString();
        return ", Gender: " + gender +
                ", Age: " + age + " months";
    }

    public void incrementAge(){
        age++;
    }

    public boolean isMature(){ return age >= maturityAge; }

    public int getAge(){
        return age;
    }

    public Gender getGender(){
        return gender;
    }

    public int getMaturityAge() {
        return maturityAge;
    }

    public int getMaxAge(){
        return maxAge;
    }

    public int getMaxChildren(){
        return maxChildren;
    }
}
