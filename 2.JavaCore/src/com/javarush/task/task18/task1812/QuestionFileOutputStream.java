package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream wrapper;

    public QuestionFileOutputStream(AmigoOutputStream wrapper){
        this.wrapper = wrapper;
    }

    @Override
    public void flush() throws IOException {
        wrapper.flush();
    }

    @Override
    public void write(int b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        wrapper.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        wrapper.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        if (bufferedReader.readLine().equals("Д"))
            wrapper.close();
    }

    public static void main(String[] args) throws IOException {
    }
}

