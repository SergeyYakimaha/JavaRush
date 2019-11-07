package com.javarush.task.task36.task3601;

public class View {
    Model model;
    Controller controller;

    public View() {
        this.model = new Model();
        this.controller = new Controller();
    }

    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }
}
