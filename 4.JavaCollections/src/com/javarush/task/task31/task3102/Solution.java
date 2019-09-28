package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {

    private static List<String> getFileTreeUseQueue(String root) throws IOException {
        Queue<File> fileTree  = new PriorityQueue<>();
        List<String> listFile = new ArrayList<>();
        File rootDir = new File(root);

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty())
        {

            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                listFile.add(currentFile.getAbsolutePath());
            }
        }

        return listFile;
    }


    private static List<String> getFileTree(String root) throws IOException {
        SearchSimpleFileVisitor searchSimpleFileVisitor = new SearchSimpleFileVisitor();
        Files.walkFileTree(Paths.get(root), searchSimpleFileVisitor);
        return searchSimpleFileVisitor.foundFiles;
    }

    public static class SearchSimpleFileVisitor extends SimpleFileVisitor<Path> {
        private List<String> foundFiles = new ArrayList<>();
        public List<String> getFoundFiles() {
            return foundFiles;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            foundFiles.add(file.toFile().getAbsolutePath());
            return super.visitFile(file, attrs);
        }
    }

    public static void main(String[] args) throws IOException {
        String root = "c:\\JavaRushData\\File";
        List<String> list = getFileTree(root);
        List<String> listQueue = getFileTreeUseQueue(root);

        for(String fileName: listQueue){
            System.out.println(fileName);
        }
    }
}
