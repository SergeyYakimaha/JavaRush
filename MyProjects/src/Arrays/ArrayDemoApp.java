package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDemoApp {
    List<String> stringList = new ArrayList<>();
    int[] b = new int[5];

    private static int summa(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int ddd = summa(60, 12);

        Iterator<Integer> iterator = list.iterator();
        Integer i1 = iterator.next();
        Integer i2 = iterator.next();
        Integer i3 = iterator.next();
        Integer i4 = iterator.next();

        System.out.println(ddd);

        System.out.println(summa(60, 90));

        System.out.println(ddd + 10);

    }
}
