package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import allForDragons.HeadComparator;
import commands.Command;
import commands.Invoker;
import exceptions.InvalidCommandException;

import java.util.ArrayList;
import java.util.Collections;

public class MaxByHeadCommand implements Command {
    /**Метод, выводящий дракона с максимальным значением head*/
    private void maxByHeadPrinter() {
        ArrayList<Dragon> dragons = new ArrayList<>(DragonsCollection.getDragons());
        HeadComparator headComparator = new HeadComparator();
        Dragon dragon = Collections.max(dragons, headComparator);
        System.out.println(dragon);
    }
    @Override
    /**Метод, выполняющий команду с помощью maxByHeadPrinter
     * @see MaxByHeadCommand#maxByHeadPrinter() */
    public void execute() {
        try {
            if(Invoker.getSplit().length != 1){
                throw new InvalidCommandException();
            }
            if (DragonsCollection.getDragons().size() != 0) {
                maxByHeadPrinter();
            } else {
                System.out.println("Коллекция пуста");
            }
        }catch (InvalidCommandException e){System.out.println(e.getMessage());}
    }
    @Override
    public String description() {
        return "max_by_head : вывести любой объект из коллекции, значение поля head которого является максимальным";
    }
}
