package com.sparta.jmm.simulation;

import com.sparta.jmm.animal.*;
import com.sparta.jmm.display.Display;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {
    private ArrayList<Rabbit> rabbitList = new ArrayList<>();
    private ArrayList<Fox> foxList = new ArrayList<>();
    ArrayList<Rabbit> newRabbits;
    ArrayList<Rabbit> deadRabbits;
    ArrayList<Rabbit> eatenRabbits;
    ArrayList<Fox> newFoxes;
    ArrayList<Fox> deadFoxes;
    private Random random = new Random();
    private int month = 0;
    private final int SIM_DURATION = 60;
    private final int RABBIT_POP_CAP = 2_000_000;
    private int rabbitMalePop = 1;
    private int rabbitFemalePop = 1;
    private int foxMalePop = 1;
    private int foxFemalePop = 1;

    public Simulation(){
        rabbitList.add(new Rabbit(Gender.MALE));
        rabbitList.add(new Rabbit(Gender.FEMALE));
        foxList.add(new Fox(Gender.MALE));
        foxList.add(new Fox(Gender.FEMALE));
    }

    public void simulation() throws InterruptedException {
        for(int i = 0; i< SIM_DURATION; i++){
            Thread.sleep(500);
            nextMonth();
            display();
        }
    }

    public void display(){
        Display.printMonth(month);
        Display.printRabbitInfo(rabbitMalePop, rabbitFemalePop, newRabbits.size(), deadRabbits.size(), eatenRabbits.size());
        Display.printFoxInfo(foxMalePop, foxFemalePop, newFoxes.size(), deadFoxes.size());
    }

    public void nextMonth(){
        month++;
        newRabbits = new ArrayList<>();
        deadRabbits = new ArrayList<>();
        eatenRabbits = new ArrayList<>();
        newFoxes = new ArrayList<>();
        deadFoxes = new ArrayList<>();

        for(Fox fox : foxList){
            fox.incrementAge();
            if(fox.getAge() == fox.getMaxAge()) deadFoxes.add(fox);
            else if(fox.isMature()){
                if(fox.getGender() == Gender.FEMALE && foxMalePop > 0){
                    if(fox.getAge() == fox.getMaturityAge() || fox.getMonthsSinceBreeding() == 12) {
                        for (int i = 0; i < random.nextInt(fox.getMaxChildren()) + 1; i++) newFoxes.add(new Fox());
                        fox.resetMonthsSinceBreeding();
                    }
                    else fox.incrementMonthsSinceBreeding();
                }
                for(int i=0;i<random.nextInt(fox.getMaxHunger()+1);i++){
                    eatenRabbits.add(rabbitList.get(random.nextInt(rabbitList.size())));
                }
            }
        }
        rabbitList.removeAll(eatenRabbits);

        for(Rabbit rabbit : rabbitList){
            rabbit.incrementAge();
            if(rabbit.getAge() == rabbit.getMaxAge()) deadRabbits.add(rabbit);
            else if(rabbitList.size() < RABBIT_POP_CAP && rabbit.getGender() == Gender.FEMALE && rabbit.isMature() && rabbitMalePop > 0){
                for(int i=0;i<random.nextInt(rabbit.getMaxChildren())+1;i++) newRabbits.add(new Rabbit());
            }
        }

        for(Fox deadFox : deadFoxes){
            if (deadFox.getGender() == Gender.MALE) foxMalePop--;
            else foxFemalePop--;
            rabbitList.remove(deadFox);
        }

        for(Rabbit deadRabbit : deadRabbits){
            if (deadRabbit.getGender() == Gender.MALE) rabbitMalePop--;
            else rabbitFemalePop--;
            rabbitList.remove(deadRabbits);
        }

        for(Fox newFox : newFoxes) {
            if (newFox.getGender() == Gender.MALE) foxMalePop++;
            else foxFemalePop++;
            foxList.add(newFox);
        }
        for(Rabbit newRabbit : newRabbits) {
            if (newRabbit.getGender() == Gender.MALE) rabbitMalePop++;
            else rabbitFemalePop++;
            rabbitList.add(newRabbit);
        }
    }
}
