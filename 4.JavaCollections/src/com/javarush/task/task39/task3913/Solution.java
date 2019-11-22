package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        LogParser logParser = new LogParser(Paths.get("d:/logs/"));

        System.out.println("-- 1 -- ");
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
        System.out.println(logParser.getUniqueIPs(null, new Date()));
        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, new Date()));
        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, null, new Date()));
        System.out.println(logParser.getIPsForStatus(Status.OK, null, new Date()));

        System.out.println("-- 2 -- ");
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null, new Date()));
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, new Date()));
        System.out.println(logParser.getUsersForIP("146.34.15.5", null, new Date()));
        System.out.println(logParser.getLoggedUsers(null, new Date()));
        System.out.println(logParser.getDownloadedPluginUsers(null, new Date()));
        System.out.println(logParser.getWroteMessageUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, new Date()));
        System.out.println(logParser.getSolvedTaskUsers(null, new Date()));
        System.out.println(logParser.getDoneTaskUsers(null, new Date()));
        System.out.println(logParser.getDoneTaskUsers(null, new Date(), 48));

        System.out.println("-- 3 -- ");
        System.out.println(logParser.getDatesForUserAndEvent("Amigo", Event.SOLVE_TASK, null, null));
        System.out.println(logParser.getDatesWhenSomethingFailed(null, null));
        System.out.println(logParser.getDatesWhenErrorHappened(null, new Date()));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo", null, new Date()));
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null, null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));

        System.out.println("-- 4 --");
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));

        System.out.println("-- 5 --");
        //System.out.println(logParser.execute("get event for date = \"30.08.2011 16:08:13\""));
        System.out.println(logParser.execute("get ip for user = \"Amigo\" and date between \"11.12.2013 0:00:00\" and \"03.01.2030 23:59:59\""));
        //System.out.println(logParser.execute("get status for user = \"Amigo\""));
        //System.out.println(logParser.execute("get event for ip = \"192.168.100.2\""));

    }
}