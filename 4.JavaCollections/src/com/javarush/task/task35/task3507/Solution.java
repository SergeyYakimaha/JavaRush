package com.javarush.task.task35.task3507;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException {
        List<File> fileList =  new ArrayList<>(Arrays.asList(new File(pathToAnimals).listFiles()));

        for (File file: fileList){
            //Class clazz = Class.forName(file.getAbsolutePath());

        }

        System.out.println(pathToAnimals);
        return null;
    }
}
