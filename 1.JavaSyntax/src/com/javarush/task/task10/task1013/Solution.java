package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstName;
        private String lastName;
        private int age;
        private int height;
        private double weight;
        private boolean sex;

        public Human(String firstName){
            this.firstName = firstName;
        }

        public Human(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(int age){
            this.age = age;
        }

        public Human(double weight){
            this.weight = weight;
        }

        public Human(boolean sex){
            this.sex = sex;
        }

        public Human(int age, int weight){
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, int age){
            this.firstName = firstName;
            this.age = age;
        }

        public Human(double weight, boolean sex){
            this.weight = weight;
            this.sex = sex;
        }

        public Human(boolean sex, int weight){
            this.sex = sex;
            this.weight = weight;
        }

        public Human(double weight, boolean sex, int age){
            this.weight = weight;
            this.sex = sex;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }
    }
}
