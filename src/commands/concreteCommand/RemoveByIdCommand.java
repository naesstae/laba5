package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

public class RemoveByIdCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);

            if (DragonsCollection.dragons.size() != 0) {
                for (Dragon dragon : DragonsCollection.dragons) {
                    if (dragon.getId() == id) {
                        DragonsCollection.dragons.remove(dragon);
                        System.out.println("Дракон успешно удалён");
                    } else {
                        System.out.println("Такого дракона не существует");
                    }
                }
            } else {
                System.out.println("Такого дракона не существует");
            }

        } else {
            System.out.println("Неверная команда");
        }
    }
}