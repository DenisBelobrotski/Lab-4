import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Input {
    public static String scanText(String way) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(way));
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNext()) {
            stringBuilder.append(scanner.nextLine() + "\n");
        }
        return stringBuilder.toString();
    }
}
