package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage(res.getString("before"));
        int sum = 0;
        do {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try {
                sum = Integer.parseInt(ConsoleHelper.readString());
                if (sum < 0) throw new NumberFormatException(res.getString("specify.not.empty.amount"));
                if (!manipulator.isAmountAvailable(sum)) {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    continue;
                }
                Map<Integer, Integer> withdrawBanknotes = manipulator.withdrawAmount(sum);
                withdrawBanknotes.keySet();
                List list = new ArrayList(withdrawBanknotes.entrySet());
                Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getKey() - o1.getKey();
                    }
                });

                for (Object o : list) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)o;
                    ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, manipulator.getCurrencyCode()));
                break; //If reached - It's ok. Goto end;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        } while (true);

    }
}
