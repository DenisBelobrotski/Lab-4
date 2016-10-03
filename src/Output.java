import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Output {
    public static void outTextInFile(String string, String way) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(way), false);
        for (String tempString : string.split("\n")) {
            fileWriter.write(tempString + "\n");
        }
        fileWriter.close();
        System.out.println("File was written successfully");
    }

    public static void outTextInConsole(String string) throws IOException {
        for (String tempString : string.split("\n")) {
            System.out.println(tempString);
        }
    }
}
