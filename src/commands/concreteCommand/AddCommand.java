package commands.concreteCommand;

import commands.Command;
import allForDragons.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddCommand implements Command {

    Dragon dragon;

    @Override
    public void execute() throws InputMismatchException {
        int i=0;
        while(i==0) {
            try {
                Scanner sc = new Scanner(System.in);

                System.out.println("Введите имя дракона");
                String name = sc.nextLine();

                System.out.println("Введите координату X дракона");
                long x = sc.nextLong();
                System.out.println("Введите координату Y дракона");
                float y = sc.nextFloat();
                Coordinates coordinates = new Coordinates(x, y);

                System.out.println("Введите возраст дракона");
                Long age = sc.nextLong();

                System.out.println("Введите цвет дракона (Цифру или полное название) 1 - GREEN, 2 - ORANGE, 3 - BROWN");
                Color dragonColor = null;
                sc.nextLine();
                String color = sc.nextLine();
                if(!(color.equals("1")||color.equals("2")||color.equals("3")||color.equals("GREEN")||color.equals("ORANGE")||color.equals("BROWN")||color.isEmpty())){
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

                System.out.println("Введите тип дракона (Цифру или полное название) 1 - WATER, 2 - UNDERGROUND, 3 - FIRE");
                DragonType dragonType = DragonType.WATER;
                String type = sc.next();
                if(!(type.equals("1")||type.equals("2")||type.equals("3")||type.equals("WATER")||type.equals("UNDERGROUND")||type.equals("FIRE"))){
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

                System.out.println("Введите характер дракона (Цифру или полное название) 1 - CUNNING, 2 - WISE, 3 - CHAOTIC_EVIL, 4 - FICKLE");
                DragonCharacter dragonCharacter = DragonCharacter.FICKLE;
                String character = sc.next();
                if(!(character.equals("1")||character.equals("2")||character.equals("3")||character.equals("CUNNING")||character.equals("WISE")||character.equals("CHAOTIC_EVIL")||character.equals("FICKLE")||character.equals("4"))){
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

                System.out.println("Введите количество глаз дракона");
                double eyesCount = sc.nextDouble();
                DragonHead dragonHead = new DragonHead(eyesCount);

                this.dragon = new Dragon(name, coordinates, age, dragonColor, dragonType, dragonCharacter, dragonHead);
                i=1;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Неверный тип данных");
            }
        }
    }

    public Dragon dragon() {
        return dragon;
    }
}
