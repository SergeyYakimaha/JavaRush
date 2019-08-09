package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {

        Human grandFather1 = new Human("Вася", true, 80);
        Human grandFather2 = new Human("Миша", true, 88);

        Human grandMother1 = new Human("Маша", false, 70);
        Human grandMother2 = new Human("Клава", false, 77);

        Human father = new Human("Батя", true, 45, grandFather1, grandMother1);
        Human mother = new Human("Мама", false, 40, grandFather2, grandMother2);

        Human daughter1 = new Human("Дочь_1", false, 20, father, mother);
        Human daughter2 = new Human("Дочь_2", false, 15, father, mother);

        Human son = new Human("Сын", true, 10, father, mother);

        System.out.println(grandFather1.toString());
        System.out.println(grandFather2.toString());

        System.out.println(grandMother1.toString());
        System.out.println(grandMother2.toString());

        System.out.println(father.toString());
        System.out.println(mother.toString());

        System.out.println(daughter1.toString());
        System.out.println(daughter2.toString());

        System.out.println(son.toString());
    }

    public static class Human {
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}