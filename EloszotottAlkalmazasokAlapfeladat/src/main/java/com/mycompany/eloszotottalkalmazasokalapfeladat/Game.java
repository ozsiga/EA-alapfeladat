package com.mycompany.eloszotottalkalmazasokalapfeladat;

import java.util.Random;

public class Game {
    private Character warrior;
    private Character wizard;
    private final Random ran = new Random();
    private static final String POSITION_PLACEHOLDER = "_";
    private static final String FIGHT_PLACEHOLDER = "X";
    private static final String FIGHT = "Harc: ";
    private static final String ARROW = "--> ";
    private static final String COMMA = ",";
    private static final int NUMBER_OF_GAME_TILES = 3;
    private static final int WARRIOR_STARTING_POSITION = 0;
    private static final int MAGE_STARTING_POSITION = 2;

    public Game() {
        warrior = new Character(true, "H");
        wizard = new Character(false, "V");
    }
    
    private int diceRoll() {
        return ran.nextInt(6) + 1;
    }
    
    public void playGame() {
        while (warrior.getHealthPoints() > 0 && wizard.getHealthPoints() > 0) {
            playRound();
        }

        if (warrior.getHealthPoints() <= 0) {
            System.out.println("WIN --> V");
        } else {
            System.out.println("WIN --> H");
        }
    }

    public void playRound() {
        warrior.move();
        wizard.move();
        if (wizard.getPosition() == warrior.getPosition()) {
            warrior.setHealthPoints(warrior.getHealthPoints() - diceRoll());
            if (wizard.getHealthPoints() > 0) {
                wizard.setHealthPoints(wizard.getHealthPoints() - diceRoll());
            }
            printActualState(true);
        } else printActualState(false);
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
