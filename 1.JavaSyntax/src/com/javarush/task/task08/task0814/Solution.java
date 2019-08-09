package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {

        Set<Integer> set = new HashSet<Integer>();

        set.add(31);
        set.add(33);
        set.add(15);
        set.add(188);
        set.add(17);
        set.add(661);
        set.add(1545);
        set.add(1534535);
        set.add(1);
        set.add(145466);
        set.add(166);
        set.add(14555);
        set.add(16456);
        set.add(15335);
        set.add(155);
        set.add(551);
        set.add(15455);
        set.add(14455);
        set.add(14566);
        set.add(554541);

        return set;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            if (iterator.next() > 10)
                iterator.remove();
        }

        return set;
    }

    public static void main(String[] args) {
        Set<Integer> set = createSet();

        removeAllNumbersGreaterThan10(set);
    }
}
