package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Invoker;
import exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.Collections;

public class AddIfMinCommand implements Command {
    /**Метод, проверяющий, что дракон наименьший элемент в коллекции (по возрасту)
     * @see DragonAdder#dragonAdder()*/
    @Override
    public void execute() {
        try {
            if (Invoker.getSplit().length != 1) {
                throw new InvalidCommandException();
            }
            ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
            Dragon dragon = DragonAdder.dragonAdder();
            if (dragons.size() == 0) {
                DragonsCollection.getDragons().add(dragon);
                System.out.println("Новый элемент коллекции добавлен");
            } else {
                Collections.sort(dragons);
                if (dragon.getAge() < dragons.get(0).getAge()) {
                    DragonsCollection.getDragons().add(dragon);
                    System.out.println("Новый элемент коллекции добавлен");
                } else {
                    System.out.println("Новый элемент не добавлен, так как возраст заданного дракона слишком большой");
                }
            }
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String description() {
        return "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции";
    }
}
