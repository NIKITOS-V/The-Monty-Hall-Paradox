package org.montyparadox.Writer;

import lombok.Getter;
import org.montyparadox.Simulation.Result;

import java.util.HashMap;

public class Logger {
    private long step;

    @Getter
    private final HashMap<Long, Result> logs;

    public Logger(){
        this.logs = new HashMap<>();
        this.step = 1;
    }

    public void addStep(Result result){
        this.logs.put(step++, result);
    }
}
