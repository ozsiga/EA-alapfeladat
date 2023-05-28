package com.mycompany.eloszotottalkalmazasokalapfeladat;

import java.util.Random;

public class Character {
    private int healthPoints;
    private int position;
    private String name;
    private boolean isWarrior;
    private int randomD6;
    private int randomNextPosition;

    public Character(boolean isWarrior, String name) {
        this.name = name;
        Random random = new Random();
        this.randomD6 = random.nextInt(5) + 1;
        this.healthPoints = this.randomD6 + 3; // d6+3 életerő
        
        if(isWarrior){
            this.position = 0; // Kezdetben az első mezőn áll a harcos
        } else {
           this.position = 2; // Kezdetben az utolsó mezőn áll a varázsló
        }
        this.isWarrior = isWarrior;  
    }
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    public String getName() {
        return name;
    }

    public void move() {
        Random random = new Random();
        this.randomNextPosition = random.nextInt(3);
        position = this.randomNextPosition;
    }
    public void attack(Character enemy) {
        Random random = new Random();
        this.randomD6 = random.nextInt(5) + 1;
        enemy.setHealthPoints(enemy.getHealthPoints() - this.randomD6);
    }
    
    @Override
    public String toString() {
        return this.getName() + ":" + this.getHealthPoints();
    }
}
