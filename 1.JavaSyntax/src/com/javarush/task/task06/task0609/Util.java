package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        double q1 = Math.pow(x2 - x1, 2);
        double q2 = Math.pow(y1 - y2, 2);
        return Math.sqrt(q1 + q2);
    }

    public static void main(String[] args) {
        System.out.println(Util.getDistance(0, 1, 2,-2));
    }
}
