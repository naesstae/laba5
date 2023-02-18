import commands.concreteCommand.AddCommand;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddCommand a= new AddCommand();
        a.execute();
    }
}