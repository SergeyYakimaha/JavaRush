package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        logger.debug("constructor Solution: " + "value1 = " + value1);
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(111, "222", new Date());
        solution.divide(1, 0);
        solution.divide(10, 5);
        solution.calculateAndSetValue3(52);
    }

    public void calculateAndSetValue3(long value) {
        logger.trace("run calculateAndSetValue3 divide");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("method calculateAndSetValue3: " + value1);
        } else {
            value1 = (int) value;
            logger.debug("method calculateAndSetValue3: " + value1);
        }
    }

    public void printString() {
        logger.trace("run printString divide");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("run printDateAsLong divide");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        try {
            logger.trace("run method divide");
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("method divide: " + "arg1 = " + number1 + " " + "arg2 = " + number2 + " Exception = " + e);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("method setValue1: " + value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("method setValue2: " + value2);
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("method setValue3: " + value3);
    }
}
