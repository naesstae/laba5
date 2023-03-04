package allForDragons;

import exceptions.IllegalValueOfXException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DragonAdder {
    /**Метод для создания дракона с помощью консоли
     * @return Dragon*/
    public static Dragon dragonAdder() {
        Scanner sc = new Scanner(System.in);
        String name = "k";
        long x = 0;
        float y = 0;
        Color dragonColor = null;
        long age = Long.parseLong("0");
        DragonType dragonType = DragonType.WATER;
        DragonCharacter dragonCharacter = DragonCharacter.FICKLE;
        double eyesCount = Double.parseDouble("0");
        int i = 1;
        while (i != 0) {
            try {
                while (i == 1) {
                    System.out.println("Введите имя дракона");
                    name = sc.nextLine();
                    if (name.trim().isEmpty()) {
                        throw new InputMismatchException();
                    }
                    ++i;
                }
                while (i == 2) {
                    try {
                        System.out.println("Введите координату X дракона");
                        String s = sc.nextLine();
                        if(!s.matches("([-+]?\\d+)")){
                            throw new InputMismatchException();
                        }
                        x = Long.parseLong(s);
                        if (x > 610) {
                            throw new IllegalValueOfXException();
                        }
                        ++i;
                    } catch (IllegalValueOfXException illegalValueOfXException) {
                        System.out.println(illegalValueOfXException.getMessage());
                    }
                }
                while (i == 3) {
                    System.out.println("Введите координату Y дракона");
                    String s = sc.nextLine();
                    try {
                        Double.parseDouble(s);
                    } catch (NumberFormatException ex){
                        throw new InputMismatchException();
                    }
                    y = Float.parseFloat(s);
                    ++i;
                }
                while (i == 4) {
                    System.out.println("Введите возраст дракона");
                    String s = sc.nextLine();
                    if(!s.matches("([-+]?\\d+)")){
                        throw new InputMismatchException();
                    }
                    age = Long.parseLong(s);
                    ++i;
                }
                while (i == 5) {
                    System.out.println("Введите цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
                    String color = sc.nextLine();
                    if (!(color.equals("1")||color.equals("2")||color.equals("3")||color.equals("GREEN")||color.equals("ORANGE")||color.equals("BROWN")||color.isEmpty())) {
                        throw new InputMismatchException();
                    }
                    switch (color) {
                        case "1", "GREEN" -> dragonColor = Color.GREEN;
                        case "2", "ORANGE" -> dragonColor = Color.ORANGE;
                        case "3", "BROWN" -> dragonColor = Color.BROWN;
                    }
                    ++i;
                }
                while (i == 6) {
                    System.out.println("Введите тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
                    String type = sc.nextLine();
                    if (!(type.equals("1")||type.equals("2")||type.equals("3")||type.equals("WATER")||type.equals("UNDERGROUND")||type.equals("FIRE"))) {
                        throw new InputMismatchException();
                    }
                    switch (type) {
                        case "1", "WATER" -> dragonType = DragonType.WATER;
                        case "2", "UNDERGROUND" -> dragonType = DragonType.UNDERGROUND;
                        case "3", "FIRE" -> dragonType = DragonType.FIRE;
                    }
                    ++i;
                }
                while (i == 7) {
                    System.out.println("Введите характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
                    String character = sc.nextLine();
                    if (!(character.equals("1")||character.equals("2")||character.equals("3")||character.equals("CUNNING")||character.equals("WISE")||character.equals("CHAOTIC_EVIL")||character.equals("FICKLE")||character.equals("4"))) {
                        throw new InputMismatchException();
                    }
                    switch (character) {
                        case "1", "CUNNING" -> dragonCharacter = DragonCharacter.CUNNING;
                        case "2", "WISE" -> dragonCharacter = DragonCharacter.WISE;
                        case "3", "CHAOTIC_EVIL" -> dragonCharacter = DragonCharacter.CHAOTIC_EVIL;
                        case "4", "FICKLE" -> dragonCharacter = DragonCharacter.FICKLE;
                    }
                    ++i;
                }
                while (i == 8) {
                    System.out.println("Введите количество глаз дракона");
                    String s = sc.nextLine();
                    try {
                        Double.parseDouble(s);
                    } catch (NumberFormatException numberFormatException){
                        throw new InputMismatchException();
                    }
                    eyesCount = Double.parseDouble(s);
                    ++i;
                }
                i = 0;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Неверный тип данных");
            }
        }
        return new Dragon(name, new Coordinates(x, y), age, dragonColor, dragonType, dragonCharacter, new DragonHead(eyesCount));
    }
}
