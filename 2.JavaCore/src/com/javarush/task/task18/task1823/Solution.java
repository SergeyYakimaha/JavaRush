package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, FileNotFoundException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String filename;

        while (!(filename = bufferedReader.readLine()).equals("exit")) {
            new ReadThread(filename).start();
        }
        bufferedReader.close();

//        Thread.sleep(1000);
//        for (Map.Entry entry: resultMap.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private Map<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    int b = inputStream.read();
                    map.put(b, map.getOrDefault(b, 0) + 1);
                }
                int maxValue = Collections.max(map.values());
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxValue) {
                        synchronized (resultMap) {
                            resultMap.put(this.fileName, entry.getKey());
                        }
                    }
                }

                inputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
