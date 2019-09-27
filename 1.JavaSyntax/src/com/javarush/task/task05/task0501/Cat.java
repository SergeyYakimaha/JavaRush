package com.javarush.task.task05.task0501;

/* 
Создание кота
*/

public class Cat {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == "")
            name = "Безымянный";
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    private String name;
    private int age;
    private int weight;
    private int strength;

    public Cat(String name, int age, int weight, int strength){
        setName(name);
        setAge(age);
        setWeight(weight);
        setStrength(strength);
    }

    public Cat(){

    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("", 10, 20, 30);
        Cat cat2 = new Cat();

        System.out.println(cat1.name);
        System.out.println(cat2.name);
    }
}
