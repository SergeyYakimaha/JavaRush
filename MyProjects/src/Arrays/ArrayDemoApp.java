package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayDemoApp {
    List<String> stringList = new ArrayList<>();
    int[] b = new int[5];

    public static void main(String[] args) {
        ConnectToDB connect;

        List<ConnectToDB> connectToDBList = new ArrayList<>();
        connectToDBList.add(new Firebird());
        connectToDBList.add(new Mysql());
        connectToDBList.add(new Oracle());

        for (ConnectToDB entry: connectToDBList) {
            entry.Connect();
        }


    }
}
