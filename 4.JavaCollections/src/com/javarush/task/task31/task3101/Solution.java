package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {

    private File pathRoot;
    private String resultFileName = "allFilesContent.txt";
    private File resultFile;
    private List<File> fileList = new ArrayList<>();

    public class CompFileName implements Comparator<File> {
        @Override
        public int compare(File file1, File file2) {
            String fileName1 = file1.getName();
            String fileName2 = file2.getName();
            return fileName1.compareTo(fileName2);
        }
    }

    private void writeFiles() throws IOException {
        final int buffer_size = 3;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile, true));

        for (File files : fileList) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(files));

            byte[] buffer = new byte[buffer_size];

            while (bufferedInputStream.available() > 0) //пока есть еще непрочитанные байты
            {
                // прочитать очередной блок байт в переменную buffer и реальное количество в count
                int count = bufferedInputStream.read(buffer);
                bufferedOutputStream.write(buffer, 0, count); //записать блок(часть блока) во второй поток
            }

            bufferedOutputStream.write("\n".getBytes());
            bufferedInputStream.close();
        }
        bufferedOutputStream.close();
    }

    private void run() throws IOException {
        selectFiles(pathRoot);
        fileList.remove(resultFile);
        Collections.sort(fileList, new CompFileName());
        writeFiles();
    }

    private void selectFiles(File path) {
        if (path.isFile()) {
            System.out.println("File: " + path);
            if (path.length() <= 50)
                fileList.add(path);
        } else {
            System.out.println("Directory: " + path);
            File files[] = path.listFiles();
            for (File dirOrFile : files) {
                selectFiles(dirOrFile);
            }
        }
    }

    public Solution(String pathRoot, String resultFileAbsolutePath) {
        this.pathRoot = new File(pathRoot);
        File file = new File(resultFileAbsolutePath);
        this.resultFile = new File(file.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(file, this.resultFile);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution(args[0], args[1]);
        solution.run();

    }
}