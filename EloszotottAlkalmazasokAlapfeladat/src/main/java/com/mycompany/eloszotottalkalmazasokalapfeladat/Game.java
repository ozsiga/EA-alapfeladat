package com.mycompany.eloszotottalkalmazasokalapfeladat;

import java.util.Random;

public class Game {
    private final Random ran = new Random();
    private static final String POSITION_PLACEHOLDER = "_";
    private static final String FIGHT_PLACEHOLDER = "X";
    private static final String FIGHT = "Harc: ";
    private static final String ARROW = "--> ";
    private static final String COMMA = ",";
    private static final int NUMBER_OF_GAME_TILES = 3;
    private static final int WARRIOR_STARTING_POSITION = 0;
    private static final int MAGE_STARTING_POSITION = 2;
    private final Wizard wizard;
    private final Warrior warrior;
    
    public Game() {
       this.warrior = new Warrior(WARRIOR_STARTING_POSITION, initHealth(), "H");
       this.wizard = new Wizard(MAGE_STARTING_POSITION, initHealth(), "V");
       printActualState(false);
    }
    
    private int diceRoll() {
        return ran.nextInt(6) + 1;
    }
    private int initHealth() {
        return diceRoll() + 3;
    }
    private int nextPosition() {
        return ran.nextInt(3);
    }
    public void playGame() {
        while (warrior.getHealthPoints() > 0 && wizard.getHealthPoints() > 0) {
            playRound();
        }

        if (warrior.getHealthPoints() == 0) {
            System.out.println("WIN --> V");
        } else {
            System.out.println("WIN --> H");
        }
    }
    public void playRound() {
        wizard.setPosition(nextPosition());
        warrior.setPosition(nextPosition());
        
        if (wizard.getPosition() == warrior.getPosition()) {
                warrior.fight(wizard, diceRoll());
                wizard.fight(warrior, diceRoll());
                printActualState(true);

        } else {
            printActualState(false);
        }
    }
    private void printActualState(boolean hasFight) {
        StringBuilder actualState = new StringBuilder();
        if (hasFight) {
            for (int i = 0; i < NUMBER_OF_GAME_TILES; i++) {
                if (wizard.getPosition() == i){
                    actualState.append(FIGHT_PLACEHOLDER);
                } else actualState.append(POSITION_PLACEHOLDER);
            }
            actualState.append(ARROW);
            actualState.append(FIGHT);
        } else {
            for (int i = 0; i < NUMBER_OF_GAME_TILES; i++) {
                if (wizard.getPosition() == i) {
                    actualState.append(wizard.getName());
                } else if (warrior.getPosition() == i) {
                    actualState.append(warrior.getName());
                } else actualState.append(POSITION_PLACEHOLDER);
            }
            actualState.append(ARROW);
        }
        actualState.append(warrior);
        actualState.append(COMMA);
        actualState.append(wizard);
        System.out.println(actualState);
    }
}
