package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ExecutorLoop {

    public void executorLoop() throws Exception {
        ExecutorFactory executorFactory = new ExecutorFactory();

        // This line is hack to get valid instructions initially
        Executor executor = executorFactory.getExecutor(Instruction.SaveAndExit);
        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String instructionString = reader.readLine();

                Instruction instruction = Instruction.valueOf(instructionString.split(" ")[0]);
                List<Instruction> validInstructions = executor.getValidInstructions();
                if (!validInstructions.contains(instruction)) {
                    throw new Exception();
                }
                executor = executorFactory.getExecutor(instruction);

                if (executor.validateInstruction(instructionString)) {
                    executor.executeInstruction(instructionString);
                    //update valid instructions
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

}
