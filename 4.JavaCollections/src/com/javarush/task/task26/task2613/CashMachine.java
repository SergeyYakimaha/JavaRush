package com.javarush.task.task26.task2613;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        CurrencyManipulator cmUSD = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD");
        CurrencyManipulator cmRUB = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("RUB");
        CurrencyManipulator cmUAH = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("UAH");

        CurrencyManipulator cmUSD1 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD");
        CurrencyManipulator cmUSD2 = CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD");

//        String currencyCode = ConsoleHelper.askCurrencyCode();
//        String[] strings = ConsoleHelper.getValidTwoDigits(currencyCode);

        //String[] usd_2_100 = ConsoleHelper.getValidTwoDigits(ConsoleHelper.askCurrencyCode());
        //String[] usd_1_200 = ConsoleHelper.getValidTwoDigits(ConsoleHelper.askCurrencyCode());

//        CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode).addAmount(Integer.parseInt(strings[0]),
//                Integer.parseInt(strings[1]));
//
//        System.out.println(CurrencyManipulatorFactory.getManipulatorByCurrencyCode("USD").getTotalAmount());

        ConsoleHelper.askOperation();




    }
}
