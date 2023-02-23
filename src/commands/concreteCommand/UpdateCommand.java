package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Executor;
import exceptions.IllegalValueOfXException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);

            if (DragonsCollection.dragons.size() != 0) {
                for (Dragon dragon : DragonsCollection.dragons) {
                    if (dragon.getId() == id) {

                        //boolean i = true;
                        //while (i) {
                        Scanner scanner = new Scanner(System.in);
                        int i = 1;
                        while (i != 0) {
                            try {
                                String s = "";
                                while (i == 1) {
                                    System.out.println("Выберите параметр дракона, который хотите изменить:\n" +
                                            "Имя - введите  1\n" +
                                            "Возраст - введите 2\n" +
                                            "Тип - введите 3\n" +
                                            "Цвет - введите 4\n" +
                                            "Характер - введите 5\n" +
                                            "Количество глаз - введите 6\n" +
                                            "Координаты - введите 7");
                                    s = scanner.nextLine();
                                    i = 2;
                                }
                                if(!s.equals("1") && !s.equals("2") && !s.equals("3") && !s.equals("4") && !s.equals("5")&& !s.equals("6")&& !s.equals("7")){
                                    i = 1;
                                    throw new InputMismatchException();
                                }
                                switch (s) {

                                    case "1":
                                        System.out.println("Введите новое имя дракона");
                                        String name = scanner.nextLine();
                                        if (!name.matches("^[a-zA-Z]*$")) {
                                            throw new InputMismatchException();
                                        }
                                        dragon.setName(name);
                                        break;
                                    case "2":
                                        System.out.println("Введите новый возраст дракона");
                                        String str = scanner.nextLine();
                                        if (!str.matches("([-+]?\\d+)")) {
                                            throw new InputMismatchException();
                                        }
                                        dragon.setAge(Long.valueOf(str));
                                        break;
                                    case "3":
                                        System.out.println("Введите новый тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
                                        String type = scanner.nextLine();
                                        if (!(type.equals("1") || type.equals("2") || type.equals("3") || type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("FIRE"))) {
                                            throw new InputMismatchException();
                                        }
                                        switch (type) {
                                            case "1", "WATER":
                                                dragon.setType(DragonType.WATER);
                                            case "2", "UNDERGROUND":
                                                dragon.setType(DragonType.UNDERGROUND);
                                            case "3", "FIRE":
                                                dragon.setType(DragonType.FIRE);
                                        }
                                        break;
                                    case "4":
                                        System.out.println("Введите новый цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
                                        String color = scanner.nextLine();
                                        if (!(color.equals("1") || color.equals("2") || color.equals("3") || color.equals("GREEN") || color.equals("ORANGE") || color.equals("BROWN") || color.isEmpty())) {
                                            throw new InputMismatchException();
                                        }
                                        switch (color) {
                                            case "1", "GREEN":
                                                dragon.setColor(Color.GREEN);
                                            case "2", "ORANGE":
                                                dragon.setColor(Color.ORANGE);
                                            case "3", "BROWN":
                                                dragon.setColor(Color.BROWN);
                                        }
                                        break;
                                    case "5":
                                        System.out.println("Введите новый характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
                                        String character = scanner.nextLine();
                                        if (!(character.equals("1") || character.equals("2") || character.equals("3") || character.equals("CUNNING") || character.equals("WISE") || character.equals("CHAOTIC_EVIL") || character.equals("FICKLE") || character.equals("4"))) {
                                            throw new InputMismatchException();
                                        }
                                        switch (character) {
                                            case "1", "CUNNING":
                                                dragon.setCharacter(DragonCharacter.CUNNING);
                                            case "2", "WISE":
                                                dragon.setCharacter(DragonCharacter.WISE);
                                            case "3", "CHAOTIC_EVIL":
                                                dragon.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                                            case "4", "FICKLE":
                                                dragon.setCharacter(DragonCharacter.FICKLE);
                                        }
                                        break;
                                    case "6":
                                        System.out.println("Введите новое количество глаз дракона");
                                        str = scanner.nextLine();
                                        try {
                                            Double.parseDouble(str);
                                        } catch (NumberFormatException ex) {
                                            throw new InputMismatchException();
                                        }
                                        dragon.setHead(new DragonHead(Double.valueOf(str)));
                                        break;
                                    case "7":
                                        long x = 0;
                                        while (i == 2) {
                                            try {
                                                System.out.println("Введите новую координату X дракона");
                                                str = scanner.nextLine();
                                                if (!str.matches("([-+]?\\d+)")) {
                                                    throw new InputMismatchException();
                                                }
                                                x = Long.valueOf(str);
                                                if (x > 610) {
                                                    throw new IllegalValueOfXException();
                                                }
                                            } catch (IllegalValueOfXException illegalValueOfXException) {
                                                System.out.println(illegalValueOfXException.getMessage());
                                            }
                                            i = 3;
                                        }
                                        while (i == 3) {
                                            System.out.println("Введите новую координату Y дракона");
                                            str=scanner.nextLine();
                                            try {
                                                Double.parseDouble(str);
                                            }catch (NumberFormatException ex){
                                                throw new InputMismatchException();
                                            }
                                            float y=Float.valueOf(str);
                                            Coordinates coordinates = new Coordinates(x, y);
                                            dragon.setCoordinates(coordinates);
                                        }
                                        break;
                                }
                                System.out.println("Параметр дракона успешно изменён");
                                i=0;
                            } catch (InputMismatchException inputMismatchException) {
                                System.out.println("Неверный тип данных");
                            }
                        }
                    }
                    //i = false;
                    //}
                    else {
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
