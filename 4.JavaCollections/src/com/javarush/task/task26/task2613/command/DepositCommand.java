package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String cc = ConsoleHelper.askCurrencyCode();
        String[] cash = ConsoleHelper.getValidTwoDigits(cc);
        try {
            int amount = Integer.parseInt(cash[0])*Integer.parseInt(cash[1]);
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(cc).addAmount(Integer.parseInt(cash[0]), Integer.parseInt(cash[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, cc));
        }
        catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
