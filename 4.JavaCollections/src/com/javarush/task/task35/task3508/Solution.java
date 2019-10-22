package com.javarush.task.task35.task3508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
extends vs super
*/
public abstract class Solution {
    public abstract <T> void one(List<T> destination, List<T> source);

    public abstract <T> void two(List<T> destination, List<? extends T> source);

    public abstract <T> void three(List<? super T> destination, List<T> source);

    public abstract <T> void four(List<? super T> destination, List<? extends T> source);

    public static class Test extends Solution {

        @Override
        public <T> void one(List<T> destination, List<T> source) {
            destination.addAll(source);
        }

        @Override
        public <T> void two(List<T> destination, List<? extends T> source) {
            destination.addAll(source);
        }

        @Override
        public <T> void three(List<? super T> destination, List<T> source) {
            destination.addAll(source);
        }

        @Override
        public <T> void four(List<? super T> destination, List<? extends T> source) {
            destination.addAll(source);
        }
    }

    public static class Animal {}

    public static class WildAnimal extends Animal {}

    public static class Pet extends Animal {}

    public static class Cat extends Pet {}

    public static class Dog extends Pet {}

    public static class Crocodile extends WildAnimal {}

    public static void main(String[] args) {
        Test test = new Test();

        List<Animal> animalList = new ArrayList<>(Arrays.asList(new Animal(), new Animal()));
        List<WildAnimal> wildAnimalList = new ArrayList<>(Arrays.asList(new WildAnimal(), new WildAnimal()));
        List<Pet> petList = new ArrayList<>(Arrays.asList(new Pet(), new Pet()));
        List<Cat> catList = new ArrayList<>(Arrays.asList(new Cat(), new Cat()));
        List<Dog> dogList = new ArrayList<>(Arrays.asList(new Dog(), new Dog()));
        List<Crocodile> crocodileList = new ArrayList<>(Arrays.asList(new Crocodile(), new Crocodile()));

        test.one(petList, petList);
        test.two(wildAnimalList, crocodileList);
        test.three(animalList, catList);
        test.four(petList, dogList);


    }
}
