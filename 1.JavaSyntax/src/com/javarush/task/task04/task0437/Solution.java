package com.javarush.task.task04.task0437;

/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) {

            String s1 = "JavaRush - лучший сайт для изучения Java!";
            String s2 = new String("JavaRush - лучший сайт для изучения Java!");
            String s3 = new String("JavaRush - лучший сайт для изучения Java!");

            System.out.println(s1 == s2.intern());
            System.out.println(s2 == s3.intern());

    }
}
