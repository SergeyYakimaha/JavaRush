package com.javarush.task.task31.task3106;

/*
Разархивируем файл
*/

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



public class Solution {
    static class PathComparator implements Comparator<Path> {
        @Override
        public int compare(Path path1, Path path2) {
            String filename1 = path1.toFile().getName();
            String filename2 = path2.toFile().getName();
            int fileNumber1 = Integer.parseInt(filename1.substring(filename1.lastIndexOf(".") + 1));
            int fileNumber2 = Integer.parseInt(filename2.substring(filename2.lastIndexOf(".") + 1));
            if (fileNumber1 == fileNumber2)
                return 0;
            return (fileNumber1 > fileNumber2) ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        Path pathResult = Paths.get(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[0]);
        List<Path> listZip = new ArrayList<>();
// Сохраняем части архива в listZip
        for (int i = 1; i < args.length; i++) {
            listZip.add(Paths.get(args[i]));
        }
// Сортируем для сохранения порядка
        Collections.sort(listZip, new PathComparator());
// Для каждой части архива создаем InputStream в streams
        List<InputStream> streams = new ArrayList<>();
        for (Path zipPath : listZip)
            streams.add(new FileInputStream(zipPath.toFile()));
// В byteArrayOutputStream склеим все части streams. Поток byteArrayOutputStream содердит все части архива
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        for (InputStream inputStream : streams) {
            int countOfBytes = 0;
            byte[] buffer = new byte[1024];
            while ((countOfBytes = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, countOfBytes);
            }
            inputStream.close();
        }
// Подсунем zipInputStream наш склеенный  ByteArrayOutputStream
        ByteArrayInputStream inStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ZipInputStream zipInputStream = new ZipInputStream(inStream);
// Т.к. часть всего одна, то ее и пишем в результирующий файл
        ZipEntry zipEntry = new ZipEntry(zipInputStream.getNextEntry());
        int countOfBytes = 0;
        byte[] buffer = new byte[1024];
        while ((countOfBytes = zipInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, countOfBytes);
        }
        zipInputStream.closeEntry();
        zipInputStream.close();
        fileOutputStream.close();
    }
}
