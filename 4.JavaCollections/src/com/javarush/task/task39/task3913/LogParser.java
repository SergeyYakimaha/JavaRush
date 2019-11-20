package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {

    private Path logDir;
    private List<File> fileList = new ArrayList<>();
    private List<LogObject> logObjectList = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
        fillFileList();
        fillLogObjectList();
    }

    static class LogObject {
        private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        private String ip;
        private String user;
        private Date date;
        private Event event;
        private Integer task_num;
        private Status status;

        LogObject(String logLine) throws ParseException {
            String[] arrayLogAction = logLine.split("\t");
            this.ip = arrayLogAction[0];
            this.user = arrayLogAction[1];
            this.date = dateFormat.parse(arrayLogAction[2]);
            String[] events = arrayLogAction[3].split(" ");
            this.event = Event.valueOf(events[0]);
            if (events.length == 2)
                this.task_num = Integer.parseInt(events[1]);
            this.status = Status.valueOf(arrayLogAction[4]);
        }

        boolean isObjectCondition(Date after, Date before) {
            if (after == null & before == null)
                return true;
            if (after != null & before != null)
                if (date.after(after) && date.before(before))
                    return true;
            if ((after == null & before != null) && date.before(before))
                return true;
            if ((before == null & after != null) && date.after(after))
                return true;
            return false;
        }
    }

    // Возвращает список пользователей, которые что-то делали в указанный период
    private List<LogObject> getLogObjectListCondition(Date after, Date before) {
        List<LogObject> logObjects = new ArrayList<>();
        for (LogObject logObject : logObjectList) {
            if (logObject.isObjectCondition(after, before))
                logObjects.add(logObject);
        }
        return logObjects;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListCondition(after, before)) {
            set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListCondition(after, before)) {
            if (logObject.user.equals(user))
                set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListCondition(after, before)) {
            if (logObject.event.equals(event))
                set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListCondition(after, before)) {
            if (logObject.status.equals(status))
                set.add(logObject.ip);
        }
        return set;
    }

    private void fillLogObjectList() {
        try {
            for (File file : fileList) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null)
                    logObjectList.add(new LogObject(line));
                bufferedReader.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void fillFileList() {
        try {
            File[] files = logDir.toFile().listFiles();
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".log")) {
                    fileList.add(file);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}