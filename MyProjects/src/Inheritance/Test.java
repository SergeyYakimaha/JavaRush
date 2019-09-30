package Inheritance;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static class Animal {
        public void print() {
            System.out.println("Animal");
        }

        public void printAnimal() {
        }
    }

    public class Dog extends Animal {
        @Override
        public void print() {
            System.out.println("Dog");
        }

        public void printDog() {
        }
    }

    public class DogShepherd extends Dog {
        @Override
        public void print() {
            System.out.println("DogShepherd");
        }

        public void printDogShepherd() {
        }
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Test.Dog dog = test.new Dog();

        List<String> list = new ArrayList<>();

        try {
            int i = 5/0;
            list.get(8);
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

        System.out.println("Пошли дальше");
    }

}