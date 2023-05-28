package com.mycompany.eloszotottalkalmazasokalapfeladat;

import java.util.Random;

public class Character {
    private int healthPoints;
    private int position;
    private String name;
    private int randomD6;
    private int randomNextPosition;

    public Character(int position, int healthPoint, String name) {
        this.position = position;
        this.healthPoints = healthPoint;
        this.name = name; 
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
    
    public void decreaseHealth(int amount) {
        if (healthPoints - amount < 0) {
            throw new NegativeHealthException("Az életerő nem csökkenhet negatívra!");
        }
        healthPoints -= amount;
    }

    public void move() {
        Random random = new Random();
        this.randomNextPosition = random.nextInt(3);
        position = this.randomNextPosition;
    }

    @Override
    public String toString() {
        return this.getName() + ":" + this.getHealthPoints();
    }
}
