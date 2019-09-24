package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    private String fileName;

    public void fillInPropertiesMap() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
//        FileOutputStream FileOutputStream = new FileOutputStream(fileName);
//        save(FileOutputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "Comment");
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        for (HashMap.Entry<Object, Object> entry : prop.entrySet()) {
            properties.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution app = new Solution();
        app.fillInPropertiesMap();
    }
}
