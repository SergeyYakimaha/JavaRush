package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
        printMatrix(2, 3, 10.0);
        printMatrix(2, 3, (Integer)5);
        printMatrix(2, 3, 'C');
        printMatrix(2, 3, (short)5);
        printMatrix(2, 3, 1);
        printMatrix(2, 3, (byte)2);
        printMatrix(2, 3, (long)7);
        printMatrix(2, 3, (float)15.66);
    }

    public static void printMatrix(int m, int n, float value) {
        System.out.println("Заполняем объектами float");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, long value) {
        System.out.println("Заполняем объектами long");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, byte value) {
        System.out.println("Заполняем объектами byte");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, int value) {
        System.out.println("Заполняем объектами int");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, short value) {
        System.out.println("Заполняем объектами short");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, char value) {
        System.out.println("Заполняем объектами char");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Double value) {
        System.out.println("Заполняем объектами Double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Integer value) {
        System.out.println("Заполняем объектами Integer");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }


}
