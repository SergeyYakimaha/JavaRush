package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> longArrayList = new ArrayList<>();

        int[][] arrayPow = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arrayPow[i][j] = (int)Math.pow(i, j);
            }
        }

        try {
            for (long i = 0; i < N; i++) {
                long sum = 0;
                int lengthNumber = String.valueOf(i).length();
                for (int j = 0; j < lengthNumber; j++) {

                    long currNumber = Long.parseLong(String.valueOf(String.valueOf(i).charAt(j)));
                    sum +=(long)arrayPow[(int)currNumber][lengthNumber];
                }
                if (i == sum)
                    longArrayList.add(sum);
            }
        }
        catch (NumberFormatException e){

        }

        result = new long[longArrayList.size()];

        int i = 0;
        for (Long x : longArrayList)
            result[i++] = x.longValue();
        return result;
    }

    public static void main(String[] args) {
        long[] result = getNumbers(146511209);
        System.out.println();
    }
}
