package Reflection_API;

public class Man extends Human implements Action {

    private int Weight;
    public int Height;

    public Man(String name, int age) {
        super(name, age);
    }

    public Man(String name, int age, int weight, int height) {
        super(name, age);
        Weight = weight;
        Height = height;
    }

    private Man() {
        this.name = "Some Man";
        this.age = 80;
        this.Height = 185;
        this.Weight = 75;
    }

    @Override
    public void eat() {
        System.out.println("Я, " + this.getClass().getSimpleName()+ ", " + this.name + " много кушаю");
    }

    @Override
    public void sleep() {
        System.out.println("Я, " + this.getClass().getSimpleName() + ", " + this.name + " много сплю");
    }
}
