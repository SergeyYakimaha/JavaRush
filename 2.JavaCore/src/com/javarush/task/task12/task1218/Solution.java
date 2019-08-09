package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat {
        public void move() {
            System.out.println("Dog move");
        }

        public void eat() {
            System.out.println("Dog eat");
        }
    }

    public class Duck implements CanMove, CanFly, CanEat {
        public void move() {
            System.out.println("Duck move");
        }

        public void fly() {
            System.out.println("Duck fly");
        }

        public void eat() {
            System.out.println("Duck eat");
        }
    }

    public class Car implements CanMove {
        public void move() {
            System.out.println("Car move");
        }
    }

    public class Airplane implements CanMove, CanFly {
        public void move() {
            System.out.println("Airplane move");
        }

        public void fly() {
            System.out.println("Airplane fly");
        }
    }

}
