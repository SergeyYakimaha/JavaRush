package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private final static Map<Operation, Command> allKnownCommandsMap = new HashMap<>();

    private CommandExecutor() {

    }

    static {
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    public static final void execute(Operation operation) {
        if (allKnownCommandsMap.containsKey(operation))
            allKnownCommandsMap.get(operation).execute();
    }
}
