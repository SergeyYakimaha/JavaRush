package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        Path fileName = Paths.get(args[0]);
//        Path zipFileName = Paths.get(args[1]);
        Path fileName = Paths.get("C:\\JavaRushData\\ouputFile.txt");
        Path zipFileName = Paths.get("C:\\JavaRushData\\JavaRushData.zip");

        FileInputStream zipFile = new FileInputStream(zipFileName.toFile());
        ZipInputStream zipInputStream = new ZipInputStream(zipFile);

        Map<Path, byte[]> mapZip = new HashMap<>();

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null){
            Path entryZipFile = Paths.get(zipEntry.getName());
            //System.out.println(new String(zipInputStream.readAllBytes()).toString());
            mapZip.put(entryZipFile, zipInputStream.readAllBytes());
            System.out.println(zipEntry.getName());
            zipEntry = zipInputStream.getNextEntry();
        }
        mapZip.put(fileName, Files.readAllBytes(fileName));
        System.out.println(mapZip.size());

        for (Map.Entry<Path, byte[]> entry: mapZip.entrySet()){
            System.out.println(new String(entry.getValue()).toString());
        }

    }
}
