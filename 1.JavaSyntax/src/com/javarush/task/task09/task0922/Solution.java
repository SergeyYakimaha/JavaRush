package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date currentDate = dateFormat.parse(bufferedReader.readLine());

        SimpleDateFormat dateFormatConvert = new SimpleDateFormat("MMM dd, YYYY", Locale.ENGLISH);
        System.out.println(dateFormatConvert.format(currentDate).toUpperCase());
    }
}
