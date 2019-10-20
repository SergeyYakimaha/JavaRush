package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
        List<Integer> integerArrayList = Solution.newArrayList(1,2,3);
        List<String> stringArrayList = Solution.newArrayList("1","2","3");
        List<Cat> catList = new ArrayList<>(Arrays.asList(new Cat("Мурка"), new Cat("Вася"), new Cat("Мурка")));

        HashSet<Cat> catHashSet = Solution.newHashSet(new Cat("Мурка"), new Cat("Вася"), new Cat("Мурка"));
        HashSet<Integer> integerHashSet = Solution.newHashSet(1, 2, 1, 3);

        HashMap<Integer, Cat> hashMap = Solution.newHashMap(integerArrayList, catList);

        int sum = 0;
        for (int j = 0; j < 10; j++) {
            sum += j;
        }

        System.out.println(sum);

        for (Cat cat: catHashSet) {
            System.out.println(cat.name);
        }

        for (Integer integer: integerHashSet) {
            System.out.println(integer);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }
    }

    @SafeVarargs
    public static <T> ArrayList<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @SafeVarargs
    public static <T> HashSet<T> newHashSet(T... elements) {
        return new HashSet<>(Arrays.asList(elements));
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        HashMap<K,V> hashMap = new HashMap<>();
        if (keys.size() != values.size())
            throw new IllegalArgumentException();
        else
        {
            for (int i = 0; i < keys.size(); i++) {
                hashMap.put(keys.get(i), values.get(i));
            }
        }
        return hashMap;
    }
}
