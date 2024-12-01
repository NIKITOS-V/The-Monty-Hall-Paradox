package org.montyparadox.Simulation;

import org.montyparadox.Settings.Settings;
import org.montyparadox.Simulation.Player.Chooser;

public class Simulation {
    public Result run(Room room, Chooser chooser){
        int numberSelectedDoor = chooser.chooseDoor(
                room.getFirstDoorNumber(),
                room.getLastDoorNumber()
        );

        boolean guessed = numberSelectedDoor == room.getWinningDoorNumber();

        if (Settings.ALWAYS_CHANGE_CHOICE){

           if (guessed)
               return Result.lose;

           return Result.win;
        }

        if (guessed)
            return Result.win;

        return Result.lose;
    }
}
