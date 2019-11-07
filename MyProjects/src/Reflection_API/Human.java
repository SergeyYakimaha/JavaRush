package Reflection_API;

public abstract class Human implements Action{
    protected String name;
    int age;

    Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
