package Reflection_API;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        List<Action> actionList = new ArrayList<>();

        humanList.add(new Man("Вася", 31));
        humanList.add(new Man("Петя", 20));
        humanList.add(new Woman("Катя", 65));
        humanList.add(new Woman("Маша", 10));

        actionList.addAll(humanList);

        for (Human human : humanList) {
            human.sleep();
        }

        Field[] manFields = Man.class.getFields();
        Field[] manDeclaredFields = Man.class.getDeclaredFields();

        Method[] manMethods = Man.class.getMethods();
        Method[] manDeclaredMethods = Man.class.getDeclaredMethods();

        Constructor[] manConstructors = Man.class.getConstructors();
        Constructor[] manDeclaredConstructors = Man.class.getDeclaredConstructors();
    }
}
