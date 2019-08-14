package com.javarush.task.task14.task1401;

/* 
Bingo!
*/

public class Solution {
    public static void main(String[] args) {
        Object obj = new Tiger();
    }

    private static void printResults(boolean cat, boolean tiger, boolean pet) {
        if (cat && tiger && pet) System.out.println("Bingo!");
    }

    static class Pet {
        public void doPetActions(){
            System.out.println("doPetActions");
        }
    }

    static class Cat extends Pet {
        public void doCatActions(){
            System.out.println("doCatActions");
        }
    }

    static class Tiger extends Cat {
        public void doTigerActions() {
            System.out.println("doTigerActions");
        }
    }

}
