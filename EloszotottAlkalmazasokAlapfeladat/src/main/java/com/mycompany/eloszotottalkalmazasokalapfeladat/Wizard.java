package com.mycompany.eloszotottalkalmazasokalapfeladat;

public class Wizard  extends Character {
    public Wizard(int position, int healthPoint, String name) {
        super(position, healthPoint, name);
    }

    public void fight(Character character, int attackPoint) {
        character.decreaseHealth(attackPoint);
    }
}
