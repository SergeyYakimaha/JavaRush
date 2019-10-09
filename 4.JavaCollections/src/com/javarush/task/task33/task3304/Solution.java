package com.javarush.task.task33.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Конвертация из одного класса в другой используя JSON
*/
public class Solution {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        StringWriter writer = new StringWriter();

        First first = new First();
        convertToJSON(writer, first);
        System.out.println(writer.toString());

        StringWriter writer1 = new StringWriter();
        Second second = new Second();
        convertToJSON(writer1, second);
        System.out.println(writer1.toString());

        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, one);

        StringReader stringReader = new StringReader(writer.toString().replaceFirst(one.getClass().getSimpleName().toLowerCase(),
                resultClassObject.getSimpleName().toLowerCase()));

        return mapper.readValue(stringReader, resultClassObject);
    }


    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i = 10;
        public String name = "F";
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i = 20;
        public String name = "S";
    }
}
