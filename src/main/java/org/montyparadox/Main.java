package org.montyparadox;

import org.montyparadox.Settings.Settings;
import org.montyparadox.Simulation.Player.Chooser;
import org.montyparadox.Simulation.Player.Player;
import org.montyparadox.Simulation.Room;
import org.montyparadox.Simulation.Simulation;
import org.montyparadox.Writer.Logger;
import org.montyparadox.Writer.Printer;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Random random = new Random();

        Chooser player = new Player();
        Room room = new Room();

        Printer printer = new Printer();
        Logger logger = new Logger();

        for (int i = 0; i < Settings.NUMBER_STEPS; i ++){
            room.setFirstDoorNumber(1);
            room.setLastDoorNumber(Settings.NUMBER_DOORS);
            room.setWinningDoorNumber(random.nextInt(Settings.NUMBER_DOORS) + 1);

            logger.addStep(simulation.run(room, player));
        }

        if (Settings.SHOW_ONLY_STATISTICS){
            printer.printOnlyStatistics(logger.getLogs());

        } else{
            printer.printLogs(logger.getLogs());
        }
    }
}