package org.montyparadox.Writer;

import org.montyparadox.Simulation.Result;

import java.util.HashMap;

public class Printer {
    public void printLogs(HashMap<Long, Result> logs){
        int numberWins = 0;
        int numberSteps = logs.size();

        for (Long step: logs.keySet()) {
            Result result = logs.get(step);

            System.out.printf(
                    "Step: %s, Result: %s\n",
                    step,
                    result
            );

            if (result == Result.win)
                numberWins++;
        }

        System.out.print("\n" + getSimulationResult(numberWins, numberSteps) + "\n");
    }

    public void printOnlyStatistics(HashMap<Long, Result> logs){
        int numberWins = 0;
        int numberSteps = logs.size();

        for (Long step: logs.keySet()) {
            if (logs.get(step) == Result.win)
                numberWins++;
        }

        System.out.print(getSimulationResult(numberWins, numberSteps));
    }

    private String getSimulationResult(int numberWins, int numberSteps){
        return String.format(
                "Number steps: %s \nWins: %s \nLosses: %s \nSuccess rate: %s\n",
                numberSteps,
                numberWins,
                numberSteps - numberWins,
                (double) numberWins / numberSteps
        );
    }
}
