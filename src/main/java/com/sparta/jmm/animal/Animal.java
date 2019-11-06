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
        return "Species: " + animalClass.substring(animalClass.lastIndexOf('.')+1) +
                ", Gender: " + gender +
                ", Age: " + age + " months";
    }

    public void incrementAge(){
        age++;
    }

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
