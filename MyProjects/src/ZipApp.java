import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipApp {

    public static void unZip(File zipName, String unZipName) throws IOException {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipName));

        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            File file = new File(unZipName, zipEntry.getName());
            if (zipEntry.isDirectory()) {
                file.mkdirs();
            } else {
                File parent = file.getParentFile();

                if (!parent.exists()) {
                    parent.mkdirs();
                }
            }

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(zipName));
            byte[] buffer = new byte[Math.toIntExact(zipEntry.getSize())];

            int location;

            while ((location = zipInputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, location);
            }
            zipEntry = zipInputStream.getNextEntry();
        }
    }

    public static void zip(String fileName, String zipFileName) throws IOException {
        Queue<File> queue = new PriorityQueue<>();
        List<File> listFile = new ArrayList<>();

        Collections.addAll(queue, Paths.get(fileName).toFile().listFiles());
        while (!queue.isEmpty()) {
            File file = queue.remove();
            if (file.isDirectory()) {
                Collections.addAll(queue, file.listFiles());
            } else
                listFile.add(file);
        }

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        for (File entryFile : listFile) {
            //zipOutputStream.putNextEntry(new ZipEntry(entryFile.getName()));
            // getAbsolutePath() чтобы сохранить структуру папок
            zipOutputStream.putNextEntry(new ZipEntry(entryFile.getAbsolutePath()));
            zipOutputStream.write(new FileInputStream(entryFile).readAllBytes());
            zipOutputStream.closeEntry();
        }
        zipOutputStream.close();

    }

    public static void main(String[] args) throws IOException {
        //ZipApp.zip("c:/TestZip", "c:/TestZip.zip");
        ZipApp.unZip(new File("c:/TestZip.zip"), "d:/111");
    }
}
