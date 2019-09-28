package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    private final int PART_OF_NAME = 1;          // 00001
    private final int PART_OF_CONTENT = 2;       // 00010
    private final int MIN_SIZE = 4;              // 00100
    private final int MAX_SIZE = 8;              // 01000

    public String getPartOfName() {
        return partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getListPath() {
        return foundFiles;
    }

    public List<Path> getFoundFiles() {
        return getListPath();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        int mask = ((partOfName != null) ? PART_OF_NAME : 0) +
                ((partOfContent != null) ? PART_OF_CONTENT : 0) +
                ((minSize > 0) ? MIN_SIZE : 0) +
                ((maxSize > 0) ? MAX_SIZE : 0);

        int resultSearch = 0;

        if ((mask & PART_OF_NAME) == PART_OF_NAME){
            if (file.getFileName().toString().contains(getPartOfName()))
                resultSearch += PART_OF_NAME;
        }

        if ((mask & PART_OF_CONTENT) == PART_OF_CONTENT) {
            if (new String(content).contains(getPartOfContent()))
                resultSearch += PART_OF_CONTENT;
        }

        if ((mask & MIN_SIZE) == MIN_SIZE) {
            if (content.length > getMinSize())
                resultSearch += MIN_SIZE;
        }

        if ((mask & MAX_SIZE) == MAX_SIZE) {
            if (content.length < getMaxSize())
                resultSearch += MAX_SIZE;
        }

        if (mask == resultSearch)
            foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
