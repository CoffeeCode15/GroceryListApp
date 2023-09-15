import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Start {
    public static void main(String[] args) {
        try {
            Stream<String> reader = Files.lines(Paths.get("src/Test.txt"));
            reader.forEach(System.out::println);
            reader.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
