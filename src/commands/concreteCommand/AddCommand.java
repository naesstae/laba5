package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import commands.Executor;
import exceptions.IllegalValueOfXException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCommand implements Command {

    @Override
    public void execute() throws InputMismatchException {
        if (Executor.split.length == 1) {
            int i = 1;
            Scanner sc = new Scanner(System.in);
            String name = "k";
            long x = 0;
            float y = 0;
            Color dragonColor = null;
            Long age = Long.valueOf(0);
            DragonType dragonType = DragonType.WATER;
            DragonCharacter dragonCharacter = DragonCharacter.FICKLE;
            Double eyesCount= Double.valueOf(0);
            while (i != 0) {
                try {
                    while (i==1) {
                        System.out.println("Введите имя дракона");
                        name = sc.nextLine();
                        if (!name.matches("^[a-zA-Z]*$")) {
                            throw new InputMismatchException();
                        }
                        i = 2;
                    }
                    while (i == 2) {
                        try {
                            System.out.println("Введите координату X дракона");
                            String s=sc.nextLine();
                            if(!s.matches("([-+]?\\d+)")){
                                throw new InputMismatchException();
                            }
                            x=Long.valueOf(s);
                            if (x > 610) {
                                throw new IllegalValueOfXException();
                            }
                            i = 3;
                        } catch (IllegalValueOfXException illegalValueOfXException) {
                            System.out.println(illegalValueOfXException.getMessage());
                        }
                    }
                    while (i == 3) {
                        System.out.println("Введите координату Y дракона");
                        String s=sc.nextLine();
                        try {
                            Double.parseDouble(s);
                        }catch (NumberFormatException ex){
                            throw new InputMismatchException();
                        }
                        y=Float.valueOf(s);
                        i = 4;
                    }
                    Coordinates coordinates = new Coordinates(x, y);
                    while (i == 4) {
                        System.out.println("Введите возраст дракона");
                        String s=sc.nextLine();
                        if(!s.matches("([-+]?\\d+)")){
                            throw new InputMismatchException();
                        }
                        age=Long.valueOf(s);
                        i = 5;
                    }
                    while (i==5) {
                        System.out.println("Введите цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
                        String color = sc.nextLine();
                        if (!(color.equals("1") || color.equals("2") || color.equals("3") || color.equals("GREEN") || color.equals("ORANGE") || color.equals("BROWN") || color.isEmpty())) {
                            throw new InputMismatchException();
                        }
                        switch (color) {
                            case "1", "GREEN":
                                dragonColor = Color.GREEN;
                            case "2", "ORANGE":
                                dragonColor = Color.ORANGE;
                            case "3", "BROWN":
                                dragonColor = Color.BROWN;
                        }
                        i=6;
                    }
                    while (i==6) {
                        System.out.println("Введите тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
                        String type = sc.nextLine();
                        if (!(type.equals("1") || type.equals("2") || type.equals("3") || type.equals("WATER") || type.equals("UNDERGROUND") || type.equals("FIRE"))) {
                            throw new InputMismatchException();
                        }
                        switch (type) {
                            case "1", "WATER":
                                dragonType = DragonType.WATER;
                            case "2", "UNDERGROUND":
                                dragonType = DragonType.UNDERGROUND;
                            case "3", "FIRE":
                                dragonType = DragonType.FIRE;
                        }
                        i=7;
                    }
                    while (i==7) {
                        System.out.println("Введите характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
                        String character = sc.nextLine();
                        if (!(character.equals("1") || character.equals("2") || character.equals("3") || character.equals("CUNNING") || character.equals("WISE") || character.equals("CHAOTIC_EVIL") || character.equals("FICKLE") || character.equals("4"))) {
                            throw new InputMismatchException();
                        }
                        switch (character) {
                            case "1", "CUNNING":
                                dragonCharacter = DragonCharacter.CUNNING;
                            case "2", "WISE":
                                dragonCharacter = DragonCharacter.WISE;
                            case "3", "CHAOTIC_EVIL":
                                dragonCharacter = DragonCharacter.CHAOTIC_EVIL;
                            case "4", "FICKLE":
                                dragonCharacter = DragonCharacter.FICKLE;
                        }
                        i=8;
                    }
                    while (i==8) {
                        System.out.println("Введите количество глаз дракона");
                        String s=sc.nextLine();
                        try {
                            Double.parseDouble(s);
                        }catch (NumberFormatException ex){
                            throw new InputMismatchException();
                        }
                        eyesCount=Double.valueOf(s);
                        i=9;
                    }
                    DragonHead dragonHead = new DragonHead(eyesCount);
                    DragonsCollection.dragons.add(new Dragon(name, coordinates, age, dragonColor, dragonType, dragonCharacter, dragonHead));
                    System.out.println("Новый элемент колекции добавлен");
                    i=0;
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Неверный тип данных");
                }
            }
        } else {
            System.out.println("Неверная команда");
        }
    }
}
