package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        System.out.println(properties.getProperty("level"));

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);

        System.out.println(properties.getProperty("level"));

        //проходимся по всем ключам и печатаем все их значения на консоль
        for (String key : properties.stringPropertyNames())
        {
            System.out.println(properties.get(key));
        }
    }

    public Properties getProperties(String fileName) throws IOException {
        Path pathFile = Paths.get(fileName);
        Properties properties;

        if (Files.exists(pathFile)){
            properties = new Properties();
            if (fileName.endsWith(".xml"))
                properties.loadFromXML(new FileInputStream(pathFile.toFile()));
            else
                properties.load(new FileInputStream(pathFile.toFile()));
        } else
            return new PropertiesNullObject();

        return properties;
    }
}
