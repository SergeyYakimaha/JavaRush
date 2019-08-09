package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {

        Set<String> set = new HashSet<String>();

        set.add("Лирика");
        set.add("Лира");
        set.add("Литр");
        set.add("Лента");
        set.add("Лимон");
        set.add("Лопасть");
        set.add("Лор");
        set.add("Лаг");
        set.add("Ларионов");
        set.add("Ломка");
        set.add("Лава");
        set.add("Лох");
        set.add("Лол");
        set.add("Лоно");
        set.add("Лореаль");
        set.add("Лангет");
        set.add("Лимонка");
        set.add("Лев");
        set.add("Лохангуст");
        set.add("Ливерпуль");

        return set;
    }

    public static void main(String[] args) {
        Set<String> s = createSet();
    }
}
