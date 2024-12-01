package org.montyparadox.Simulation.Player;

import java.util.Random;

public class Player implements Chooser{
    private final Random random;

    public Player(){
        this.random = new Random();
    }

    @Override
    public int chooseDoor(int firstDoor, int lastDoor) {
        return random.nextInt(lastDoor) + firstDoor;
    }
}
