package com.javarush.task.task09.task0926;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        int[] list5 = new int[] {1, 2, 3, 4, 5};
        int[] list2 = new int[] {1, 2};
        int[] list4 = new int[] {1, 2, 3, 4};
        int[] list7 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] list0 = new int[0];

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(list5);
        list.add(list2);
        list.add(list4);
        list.add(list7);
        list.add(list0);

        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
