package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;
import exceptions.InvalidCommandException;

public class CountByHeadCommand implements Command {
    /**Метод, выводящий количество драконов с заданным количеством глаз*/
    private void getCountOfDragons() {
        double eyesCount = Double.parseDouble(Invoker.getSplit()[1]);
        int countByHead = 0;
        for (Dragon dragon : DragonsCollection.getDragons()) {
            if (dragon.getHead().getEyesCount() == eyesCount) {
                countByHead += 1;
            }
        }
        System.out.println("Количество драконов с заданным количеством глаз: " + countByHead);
    }
    /**Метод, выводящий количество элементов, значение поля head которых равно заданному с помощью getCountOfDragons
     * @see CountByHeadCommand#getCountOfDragons() */
    @Override
    public void execute() {
        try {
            if(Invoker.getSplit().length != 2){
                throw new InvalidCommandException();
            }
            if (DragonsCollection.getDragons().isEmpty()) {
                System.out.println("Коллекция пуста");
            } else {
                getCountOfDragons();
            }
        }catch (InvalidCommandException e){System.out.println(e.getMessage());}
    }
    @Override
    public String description() {
        return "count_by_head head : вывести количество элементов, значение поля head которых равно заданному";
    }
}
