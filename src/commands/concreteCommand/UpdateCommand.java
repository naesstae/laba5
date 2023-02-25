package commands.concreteCommand;

import allForDragons.*;
import commands.Command;
import commands.Executor;
import exceptions.IllegalValueOfXException;
import java.util.Scanner;

public class UpdateCommand implements Command {
    @Override
    public void execute() {

        if (Executor.split.length == 2) {

            long id = Long.parseLong(Executor.split[1]);

            if (DragonsCollection.dragons.size() != 0) {
                for (Dragon dragon : DragonsCollection.dragons) {
                    if (dragon.getId() == id) {

                        Scanner scanner = new Scanner(System.in);
                        int i = 0;
                        String s = "";
                        while (i == 0) {
                            System.out.println("""
                                    Выберите параметр дракона, который хотите изменить:
                                    Имя - введите  1
                                    Возраст - введите 2
                                    Тип - введите 3
                                    Цвет - введите 4
                                    Характер - введите 5
                                    Количество глаз - введите 6
                                    Координаты - введите 7""");
                            s = scanner.nextLine();
                            i = 1;
                        }
                        if (!s.equals("1") && !s.equals("2") && !s.equals("3") && !s.equals("4") && !s.equals("5") && !s.equals("6") && !s.equals("7")) {
                            System.out.println("Неверная команда");
                        }
                        switch (s) {
                            case "1" -> {
                                while (i == 1) {
                                    System.out.println("Введите имя дракона");
                                    String name = scanner.nextLine();
                                    if (name.matches("^[a-zA-Z]*$")) {
                                        dragon.setName(name);
                                        i = 2;
                                    } else {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "2" -> {
                                int k = 0;
                                while (k == 0) {
                                    System.out.println("Введите новый возраст дракона");
                                    String string = scanner.nextLine();
                                    if (string.matches("([-+]?\\d+)")) {
                                        long age = Long.parseLong(string);
                                        dragon.setAge(age);
                                        k = 1;
                                    } else {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "3" -> {
                                int h = 0;
                                while (h == 0) {
                                    System.out.println("Введите новый тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
                                    String type = scanner.nextLine();
                                    if (type.equals("1") || type.equals("2") || type.equals("3") || type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("FIRE")) {
                                        switch (type) {
                                            case "1", "WATER" -> dragon.setType(DragonType.WATER);
                                            case "2", "UNDERGROUND" -> dragon.setType(DragonType.UNDERGROUND);
                                            case "3", "FIRE" -> dragon.setType(DragonType.FIRE);
                                        }
                                        h = 1;
                                    } else {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "4" -> {
                                int l = 0;
                                while (l == 0) {
                                    System.out.println("Введите новый цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
                                    String color = scanner.nextLine();
                                    if (color.equals("1") || color.equals("2") || color.equals("3") || color.equals("GREEN") || color.equals("ORANGE") || color.equals("BROWN") || color.isEmpty()) {
                                        switch (color) {
                                            case "1", "GREEN" -> dragon.setColor(Color.GREEN);
                                            case "2", "ORANGE" -> dragon.setColor(Color.ORANGE);
                                            case "3", "BROWN" -> dragon.setColor(Color.BROWN);
                                            case "" -> dragon.setColor(null);
                                        }
                                        l = 1;
                                    } else {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "5" -> {
                                int m = 0;
                                while (m == 0) {
                                    System.out.println("Введите новый характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
                                    String character = scanner.nextLine();
                                    if (character.equals("1") || character.equals("2") || character.equals("3") || character.equals("CUNNING") || character.equals("WISE") || character.equals("CHAOTIC_EVIL") || character.equals("FICKLE") || character.equals("4")) {
                                        switch (character) {
                                            case "1", "CUNNING" -> dragon.setCharacter(DragonCharacter.CUNNING);
                                            case "2", "WISE" -> dragon.setCharacter(DragonCharacter.WISE);
                                            case "3", "CHAOTIC_EVIL" ->
                                                    dragon.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                                            case "4", "FICKLE" -> dragon.setCharacter(DragonCharacter.FICKLE);
                                        }
                                        m = 1;
                                    } else {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "6" -> {
                                int n = 0;
                                while (n == 0) {
                                    System.out.println("Введите новое количество глаз дракона");
                                    String string = scanner.nextLine();
                                    try {
                                        dragon.setHead(new DragonHead(Double.parseDouble(string)));
                                        n = 1;
                                    } catch (NumberFormatException numberFormatException) {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                            }
                            case "7" -> {
                                long x = 0;
                                int q = 0;
                                while (q == 0) {
                                    System.out.println("Введите новую координату X дракона");
                                    String xString = scanner.nextLine();
                                    try {
                                        if (xString.matches("([-+]?\\d+)")) {
                                            x = Long.parseLong(xString);
                                            if (x > 610) {
                                                throw new IllegalValueOfXException();
                                            } else {
                                                q = 1;
                                            }
                                        } else {
                                            System.out.println("Неверный тип данных");
                                        }
                                    } catch (IllegalValueOfXException illegalValueOfXException) {
                                        System.out.println(illegalValueOfXException.getMessage());
                                    }
                                }
                                float y = 0;
                                while (q == 1) {
                                    System.out.println("Введите новую координату Y дракона");
                                    String yString = scanner.nextLine();
                                    try {
                                        y = Float.parseFloat(yString);
                                        q = 2;
                                    } catch (NumberFormatException numberFormatException) {
                                        System.out.println("Неверный тип данных");
                                    }
                                }
                                Coordinates coordinates = new Coordinates(x, y);
                                dragon.setCoordinates(coordinates);
                            }
                        }
                        System.out.println("Параметр дракона успешно изменён");
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
