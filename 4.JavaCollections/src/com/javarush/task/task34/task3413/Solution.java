package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        //for (long i = 0; i < 2_500_000; i++) {
        for (long i = 0; i < 20; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
        for(Map.Entry entry: cache.map().entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //cache.put(10L, new AnyObject(10L,"AnyObject#10","This is object #10"));
        //cache.put(50L, new AnyObject(50L,"AnyObject#50","This is object #50"));
    }
}