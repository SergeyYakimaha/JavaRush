package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
//    @JsonAutoDetect
//    public static class Cat
//    {
//        public String name;
//        public int age;
//        public int weight;
//        Cat(){}
//    }

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), clazz);
    }

    public static void main(String[] args) throws IOException {
//        Вариант 1
//        StringReader stringReader = new StringReader(new String(new FileInputStream("c:/JSON.txt").readAllBytes()));
//        ObjectMapper mapper = new ObjectMapper();
//        Cat cat = mapper.readValue(stringReader, Cat.class);

//        Вариант 2
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:/JSON.txt"));
//        ObjectMapper mapper = new ObjectMapper();
//        Cat cat = mapper.readValue(bufferedReader, Cat.class);
//        bufferedReader.close()
    }
}
