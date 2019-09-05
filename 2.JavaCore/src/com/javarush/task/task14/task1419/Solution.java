package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

            FileInputStream fileInputStream = new FileInputStream("ggg");


        } catch (FileNotFoundException e) {
            exceptions.add(e);
        } catch (IOException e) {
            exceptions.add(e);
        } catch (Exception e) {
            exceptions.add(e);

        }

    }
}
