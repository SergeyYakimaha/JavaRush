package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public static class TableInterfaceWrapper implements TableInterface {
        private TableInterface wrapper;

        @Override
        public void printHeaderText() {
            System.out.println(wrapper.getHeaderText().toUpperCase());
        }

        public TableInterfaceWrapper(TableInterface wrapper) {
            this.wrapper = wrapper;
        }

        @Override
        public void setModel(List rows) {
            wrapper.setModel(rows);
            System.out.println(rows.size());
        }

        @Override
        public String getHeaderText() {
            return wrapper.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            wrapper.setHeaderText(newHeaderText);
        }
    }

    public static class A implements TableInterface {
        private String HeaderText = "aaaaa";

        @Override
        public void printHeaderText() {
            System.out.println(HeaderText);
        }

        @Override
        public void setModel(List rows) {

        }

        @Override
        public String getHeaderText() {
            return this.HeaderText;
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            this.HeaderText = newHeaderText;
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);

        void printHeaderText();
    }

    public static void main(String[] args) {
        TableInterface tableInterface = new A();
        TableInterface tableInterface1 = new TableInterfaceWrapper(new A());

        tableInterface.printHeaderText();
        tableInterface1.printHeaderText();

    }
}