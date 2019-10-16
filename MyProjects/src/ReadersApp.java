import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ReadersApp {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/1.txt"));

        System.out.println("Use bufferedReader");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();

        FileReader fileReader = new FileReader("c:/1.txt", Charset.defaultCharset());

        System.out.println("Use fileReader");
        while (fileReader.ready()){
            // Если без приведения к типу (char), то будут байты
            System.out.print(fileReader.read());
            //System.out.print((char)fileReader.read());
        }
        fileReader.close();
    }
}
