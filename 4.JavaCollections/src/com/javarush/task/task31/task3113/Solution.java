package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static class SearchFileVisitor extends SimpleFileVisitor<Path> {
        private int fileCount = 0;
        private int directoryCount = -1;
        private int bytesCount = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            directoryCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            fileCount++;
            bytesCount += Files.readAttributes(file, BasicFileAttributes.class).size();
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Path rootPath = Paths.get(new Scanner(System.in).nextLine());

        SearchFileVisitor simpleFileVisitor = new SearchFileVisitor();

        if (!Files.isDirectory(rootPath))
            System.out.println(rootPath.toAbsolutePath().toString() + " - не папка");
        else {

            Files.walkFileTree(rootPath, simpleFileVisitor);

            System.out.println("Всего папок - " + simpleFileVisitor.directoryCount);
            System.out.println("Всего файлов - " + simpleFileVisitor.fileCount);
            System.out.println("Общий размер - " + simpleFileVisitor.bytesCount);
        }
    }
}
