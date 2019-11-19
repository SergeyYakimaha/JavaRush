package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDemoApp {
    List<String> stringList = new ArrayList<>();
    int[] b = new int[5];

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        Integer i1 = iterator.next();
        Integer i2 = iterator.next();
        Integer i3 = iterator.next();
        Integer i4 = iterator.next();

    }
}
