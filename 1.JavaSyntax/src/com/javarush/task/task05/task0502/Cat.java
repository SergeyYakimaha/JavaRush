package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public Cat(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    public boolean fight(Cat anotherCat) {
        int scoreThis = 0;
        int anotherCatscore = 0;

        if (this.age > anotherCat.age)
            scoreThis++;
        else if (this.age < anotherCat.age)
            anotherCatscore++;

        if (this.weight > anotherCat.weight)
            scoreThis++;
        else if (this.weight < anotherCat.weight)
            anotherCatscore++;

        if (this.strength > anotherCat.strength)
            scoreThis++;
        else if (this.strength < anotherCat.strength)
            anotherCatscore++;

        return scoreThis > anotherCatscore;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat(10, 10, 10);
        Cat cat2 = new Cat(20, 20, 20);
        Cat cat3 = new Cat(20, 20, 20);


        System.out.println(cat1.fight(cat2));
        System.out.println(cat2.fight(cat1));
        System.out.println(cat2.fight(cat3));

    }
}
