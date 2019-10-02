import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipApp {

    public static void unZip(String zipName, String unZipName) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName));

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null){
            FileOutputStream fileOutputStream = new FileOutputStream(zipEntry.getName());
            fileOutputStream.write(zipInputStream.readAllBytes());
            fileOutputStream.close();
            zipInputStream.closeEntry();
        }
    }

    /*
    *  public static void unzip(File source, String out) throws IOException {
    try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {

        ZipEntry entry = zis.getNextEntry();

        while (entry != null) {

            File file = new File(out, entry.getName());

            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                File parent = file.getParentFile();

                if (!parent.exists()) {
                    parent.mkdirs();
                }

                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

                    byte[] buffer = new byte[Math.toIntExact(entry.getSize())];

                    int location;

                    while ((location = zis.read(buffer)) != -1) {
                        bos.write(buffer, 0, location);
                    }
                }
            }
            entry = zis.getNextEntry();
        }
    }
}
    * */

    public static void zip(String fileName, String zipFileName) throws IOException {
        Queue<File> queue = new PriorityQueue<>();
        List<File> listFile = new ArrayList<>();

        Collections.addAll(queue, Paths.get(fileName).toFile().listFiles());
        while (!queue.isEmpty()){
            File file = queue.remove();
            if (file.isDirectory()){
                Collections.addAll(queue, file.listFiles());
            }
            else
                listFile.add(file);
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        for (File entryFile: listFile){
            //zipOutputStream.putNextEntry(new ZipEntry(entryFile.getName()));
            // getAbsolutePath() чтобі сохранить структуру папок
            zipOutputStream.putNextEntry(new ZipEntry(entryFile.getAbsolutePath()));
            zipOutputStream.write(new FileInputStream(entryFile).readAllBytes());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.close();

    }

    public static void main(String[] args) throws IOException {
        //ZipApp.zip("c:/www", "c:/www.zip");
        ZipApp.unZip("c:/www.zip", "c:/111");
    }
}
