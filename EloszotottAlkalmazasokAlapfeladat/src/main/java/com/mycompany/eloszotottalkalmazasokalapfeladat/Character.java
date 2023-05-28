package com.mycompany.eloszotottalkalmazasokalapfeladat;

public class Character {
    private int healthPoints;
    private int position;
    private final String name;

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

    @Override
    public String toString() {
        return this.getName() + ":" + this.getHealthPoints();
    }
}
