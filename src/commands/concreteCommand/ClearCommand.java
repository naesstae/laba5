package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        if (Executor.split.length == 1) {
            DragonsCollection.dragons.clear();
            System.out.println("Коллекция очищена");
        } else {
            System.out.println("Неверная команда");
        }
    }
}
