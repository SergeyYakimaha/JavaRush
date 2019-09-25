package Inheritance;

public class Test {
    public static class Animal {
        public void print(){
            System.out.println("Animal");
        }

        public void printAnimal(){

        }
    }

    public class Dog extends Animal {
        @Override
        public void print() {
            System.out.println("Dog");
        }

        public void printDog(){

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

    public static void main(String[] args) {
        Test test = new Test();
        Test.Dog dog = test.new Dog();
    }



}
