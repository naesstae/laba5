package commands.concreteCommand;

import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

public class InfoCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 1) {
            String type = DragonsCollection.dragons.getClass().getTypeName();
            String[] typeArray = type.split(".util.");
            type = typeArray[1];
            System.out.println("Тип коллекции: " + type + "\n" +
                    "Дата инициализации: " + DragonsCollection.dateOfInitialization + "\n" +
                    "Количество элементов: " + DragonsCollection.dragons.size());
        } else {
            System.out.println("Неверная команда");
        }
    }
}
