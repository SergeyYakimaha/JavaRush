package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandfatherName = reader.readLine();
        String grandmotherName = reader.readLine();
        String fatherName = reader.readLine();
        String motherName = reader.readLine();
        String sonName = reader.readLine();
        String daughterName = reader.readLine();

        Cat catGrandfather = new Cat(grandfatherName);
        Cat catGrandmother = new Cat(grandmotherName);;

        Cat catfather = new Cat(fatherName, null, catGrandfather);
        Cat catmother = new Cat(motherName, catGrandmother, null);

        Cat catson = new Cat(sonName, catmother, catfather);
        Cat catdaughter = new Cat(daughterName, catmother, catfather);

        System.out.println(catGrandfather);
        System.out.println(catGrandmother);
        System.out.println(catfather);
        System.out.println(catmother);
        System.out.println(catson);
        System.out.println(catdaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mother, Cat father) {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {
            String result = "The cat's name is " + name;

            if (mother == null)
                result = result + ", no mother ";
            else
                result = result + ", mother is " + mother.name;

            if (father == null)
                result = result + ", no father ";
            else
                result =  result + ", father is " + father.name;

            return result;
        }
    }

}
