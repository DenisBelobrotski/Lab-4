import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class Run {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter way to input file:");
            String inputWay = scanner.nextLine();
            System.out.println("What output mode do you prefer: console(true) or file(false)?");
            boolean mode = scanner.nextBoolean();
            String string = Input.scanText(inputWay);
            String newString = CommentCleaner.deleteComments(string);
            if (mode) {
                Output.outTextInConsole(newString);
            } else {
                System.out.println("Enter way to output file:");
                Scanner sc = new Scanner(System.in);
                String outputWay = sc.nextLine();
                Output.outTextInFile(newString, outputWay);
            }
        } catch (InputMismatchException e) {
            System.out.println("Uncorrect type!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Input/output exception!");
        }
    }
}
