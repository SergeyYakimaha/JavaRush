package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Path fileToAdd = Paths.get(args[0]);
        Path zipFile = Paths.get(args[1]);

        // Создаем поток чтения zip и поток записи zip
        Map<ZipEntry, ByteArrayOutputStream> content = new HashMap<>();
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(args[1]))) {

            ZipEntry entry;

            while ((entry = zipIn.getNextEntry()) != null) {
                ByteArrayOutputStream by = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = zipIn.read(buf)) != -1) {
                    by.write(buf, 0, count);
                }
                content.put(entry, by);
                zipIn.closeEntry();
            }
        }

        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            for (Map.Entry<ZipEntry, ByteArrayOutputStream> pair : content.entrySet()) {
                if (!(Paths.get(String.valueOf(pair.getKey())).getFileName().equals(fileToAdd.getFileName()))) {
                    zos.putNextEntry(new ZipEntry(pair.getKey().getName()));
                    zos.write(pair.getValue().toByteArray());
                    zos.flush();
                    zos.closeEntry();
                }
            }
            ZipEntry entry = new ZipEntry("new/" + fileToAdd.getFileName());

            zos.putNextEntry(entry);
            Files.copy(fileToAdd, zos);
            zos.closeEntry();
        }
    }
}