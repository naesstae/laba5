
package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import commands.Invoker;
import exceptions.InvalidCommandException;

import java.util.InputMismatchException;

    public class AddCommand implements Command {
        /**Метод, добавляющий в коллекцию нового дракона с помощью метода dragonAdder
         * @see DragonAdder#dragonAdder() */
        @Override
        public void execute() throws InputMismatchException {
            try {
                if(Invoker.getSplit().length != 1){
                    throw new InvalidCommandException();
                }
                DragonsCollection.getDragons().add(DragonAdder.dragonAdder());
                System.out.println("Новый элемент коллекции добавлен");
            }catch (InvalidCommandException e){System.out.println(e.getMessage());}
        }
        @Override
        public String description() {
            return "add {element} : добавить новый элемент в коллекцию";
        }
    }

