package Class;

public class Child extends Parent {
    @Override
    public void Print() {
        super.Print();
        //System.out.println("Child");
    }

    public void PrintChild(){
        System.out.println("Print Child");
    }
}
