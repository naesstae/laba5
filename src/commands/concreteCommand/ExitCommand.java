package commands.concreteCommand;

import commands.Command;
import commands.Executor;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        if (Executor.split.length == 1) {
            Executor.programRunning = 0;
        } else {
            System.out.println("Неверная команда");
        }
    }
}
