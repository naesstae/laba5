package commands.concreteCommand;

import commands.Command;
import commands.Invoker;
import exceptions.InvalidCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    /**Метод, считывающий и выполняющий команды из файла*/
    private void executorFromFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext()) {
            Invoker.setSplit(scanner.nextLine().split(" "));
            try {
                if (!(Invoker.getSplit().length == 2 & Invoker.getSplit()[0].equals("execute_script"))) {
                    Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
                } else {
                    try {
                        if(new File(file).getAbsolutePath().equals(new File(Invoker.getSplit()[1]).getAbsolutePath())){
                            throw new InvalidCommandException();
                        }
                        Invoker.getCommandHashMap().get(Invoker.getSplit()[0]).execute();
                    }catch (InvalidCommandException e){System.out.println(e.getMessage());}
                }
            } catch (NullPointerException ignored) {}
        }
        scanner.close();
    }
    /**Метод, проверяющий файл иисполняющий скрипт из файла с помощью executorFromFile
     * @see ExecuteScriptCommand#executorFromFile(String) */
    @Override
    public void execute() {
        try {
            if(Invoker.getSplit().length != 2){
                throw new InvalidCommandException();
            }
            String file = Invoker.getSplit()[1];
            try {
                if (new File(file).exists() & new File(file).canRead()) {
                    executorFromFile(file);
                } else {
                    System.out.println("Нет доступа к файлу");
                }
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("Файл не найден");
            }
        }catch (InvalidCommandException e){System.out.println(e.getMessage());}
    }
    @Override
    public String description() {
        return "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит";
    }
}
