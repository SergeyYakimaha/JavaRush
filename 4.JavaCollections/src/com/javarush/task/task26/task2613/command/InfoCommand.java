package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.util.ResourceBundle;

class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {
        ConsoleHelper.writeMessage(res.getString("before"));
        if (CurrencyManipulatorFactory.getAllCurrencyManipulators().size() == 0)
            ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                if (manipulator.hasMoney())
                    System.out.println(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                else
                    ConsoleHelper.writeMessage(res.getString("no.money"));
            }
        }
    }
}
