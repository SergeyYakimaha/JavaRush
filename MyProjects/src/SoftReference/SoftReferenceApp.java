package SoftReference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftReferenceApp {
    public static void main(String[] args) {
//        long[] array1 = new long[2_000_000_00];
//        long[] array2 = new long[2_000_000_00];
//        long[] array3 = new long[2_000_000_00];

        SoftReference<long[]> array1Ref = new SoftReference(new long[2_000_000_00]);
        SoftReference<long[]> array2Ref = new SoftReference(new long[2_000_000_00]);
        SoftReference<long[]> array3Ref = new SoftReference(new long[2_000_000_00]);

        List<SoftReference<long[]>> list = new ArrayList<>();
        list.add(array1Ref);
        list.add(array2Ref);
        list.add(array3Ref);

        int i = 0;
        for (SoftReference<long[]> entry: list){
            if (entry.get() != null)
                System.out.println("Array #" + ++i + " length = " +entry.get().length);
            else
                System.out.println("Array #" + ++i + " is null");
        }
    }
}
