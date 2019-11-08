package Reflection_API;

public class Woman extends Human implements Action {
    public Woman(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Я, " + this.getClass().getSimpleName()+ ", " + this.name + " очень мало кушаю");
    }

    @Override
    public void sleep() {
        System.out.println("Я, " + this.getClass().getSimpleName()+ ", " + this.name + " очень мало сплю");
    }


}
