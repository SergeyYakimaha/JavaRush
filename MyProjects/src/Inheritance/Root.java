package Inheritance;

public class Root {
    /* Раннее связывание */
//    Всегда помните, что приватные, статические и final-методы связываются при помощи статического связывания,
//    а виртуальные – динамического. Аналогично,
//    лучший пример статического связывания – перегрузка методов, а переопределение – динамического
    private void ptr() {
        System.out.println("Root");
    }

    public static void main(String[] args) {
        Root root = new Branch();
//      Т.к. private void ptr(), было раннее связывание
//      вызывается System.out.println("Root")
        root.ptr(); // ;
        Branch branch = (Branch) root;
        branch.ptr();
    }
}

class Branch extends Root {
    public void ptr() {
        System.out.println("Branch");
    }
}
