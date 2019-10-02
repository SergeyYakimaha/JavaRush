import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipApp {
    public static Queue<File> queue = new PriorityQueue<>();
    public static List<File> listFile = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String root = "c:/MongoDB";

        Collections.addAll(queue, Paths.get(root).toFile().listFiles());
        while (!queue.isEmpty()){
            File file = queue.remove();
            if (file.isDirectory()){
                Collections.addAll(queue, file.listFiles());
            }
            else
                listFile.add(file);
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("c:/MongoDB  .zip"));
        for (File entryFile: listFile){
            //zipOutputStream.putNextEntry(new ZipEntry(entryFile.getName()));
            // getAbsolutePath() чтобі сохранить структуру папок
            zipOutputStream.putNextEntry(new ZipEntry(entryFile.getAbsolutePath()));
            zipOutputStream.write(new FileInputStream(entryFile).readAllBytes());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.flush();
        zipOutputStream.close();
    }
}
