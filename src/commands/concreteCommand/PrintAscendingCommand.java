package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Executor;

import java.util.ArrayList;
import java.util.Collections;

public class PrintAscendingCommand implements Command {
    @Override
    public void execute() {
        if (Executor.split.length == 1) {
            ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.dragons);
            if (dragons.size() == 0) {

                System.out.println("Коллекция пуста");

            } else {
                Collections.sort(dragons);
                for (Dragon dragon : dragons) {
                    System.out.println("Дракон " + dragon.getId() + "\n" +
                            "Имя: " + dragon.getName() + "\n" +
                            "Возраст: " + dragon.getAge() + "\n" +
                            "Тип: " + dragon.getType() + "\n" +
                            "Цвет: " + dragon.getColor() + "\n" +
                            "Характер: " + dragon.getCharacter() + "\n" +
                            "Количество глаз: " + dragon.getHead().getEyesCount() + "\n" +
                            "Координаты: (" + dragon.getCoordinates().getX() + "; " + dragon.getCoordinates().getY() + ")\n" +
                            "Дата и время создания: " + dragon.getCreationDate());
                }
            }

        } else {
            System.out.println("Неверная команда");
        }
    }
}

