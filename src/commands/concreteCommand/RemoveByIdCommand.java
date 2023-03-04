package commands.concreteCommand;

import allForDragons.Dragon;
import allForDragons.DragonsCollection;
import commands.Command;
import commands.Invoker;
import exceptions.InvalidCommandException;

public class RemoveByIdCommand implements Command {
    /**Метод, удяляющий дракона по значению id
     * @param id айди дракона, которого надо удалить*/
    private void removerById(long id) {
        boolean dragonExist = false;
        for (Dragon dragon : DragonsCollection.getDragons()) {
            if (dragon.getId() == id) {
                DragonsCollection.getDragons().remove(dragon);
                System.out.println("Дракон успешно удалён");
                dragonExist = true;
            }
        }
        if (!dragonExist) {
            System.out.println("Такого дракона не существует");
        }
    }
    /**Выплняет команду с помощью removerById
     * @see RemoveByIdCommand#removerById(long) */
    @Override
    public void execute() {
        try {
            if(Invoker.getSplit().length != 2){
                throw new InvalidCommandException();
            }
            long id = Long.parseLong(Invoker.getSplit()[1]);
            if (!DragonsCollection.getDragons().isEmpty()) {
                removerById(id);
            } else {
                System.out.println("Коллекция пуста, такого дракона не существует");
            }
        }catch (InvalidCommandException e){System.out.println(e.getMessage());}
    }
    @Override
    public String description() {
        return "remove_by_id id : удалить элемент из коллекции по его id";
    }
}