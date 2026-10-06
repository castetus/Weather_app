import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double lat;
        double lon;
        int limit;
        Scanner scanner = new Scanner(System.in);

        ConsoleReader consoleReader = new ConsoleReader(scanner);

        lat = consoleReader.readCoordinate("широту", -90, 90);
        lon = consoleReader.readCoordinate("долготу", -180, 180);
        limit = consoleReader.readLimit();


    }
}