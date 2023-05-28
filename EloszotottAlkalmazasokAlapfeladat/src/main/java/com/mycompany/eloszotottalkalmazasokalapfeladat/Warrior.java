package com.mycompany.eloszotottalkalmazasokalapfeladat;

public class Warrior  extends Character {
    public Warrior(int position, int healthPoint, String name) {
        super(position, healthPoint, name);
    }

    public void fight(Character character, int attackPoint) throws NegativeHealthException {
        if (character.getHealthPoints() - attackPoint < 0) {
            throw new NegativeHealthException("Az életerő nem csökkenhet negatívra!");
        } else {
            character.decreaseHealth(attackPoint);

        }
    }
}
