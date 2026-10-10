import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public double readCoordinate(
            String type,
            int min,
            int max
    ) {
        double result;

        while (true) {
            System.out.println("Введите " + type + ": ");
            try {
               result = this.scanner.nextDouble();
               break;
            } catch(InputMismatchException e) {
                System.out.println("Некорректный ввод");
                this.scanner.next();
            }
        }

        return result;
    }

    public int readLimit() {
        int result = 1;

        while (true) {
            System.out.println("Введите лимит: ");
            try {
                result = this.scanner.nextInt();
                break;
            } catch(InputMismatchException e) {
                System.out.println("Некорректный ввод");
                this.scanner.next();
            }
        }

        return result;
    }
}
