package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private enum ParamsSQL {
        ip,
        user,
        date,
        event,
        status
    }

    private enum QueryType {
        QUERY_0_PARAMS,
        QUERY_1_PARAMS,
        QUERY_2_PARAMS
    }

    private Path logDir;
    private List<File> fileList = new ArrayList<>();
    private List<LogObject> logObjectList = new ArrayList<>();

    private Comparator<LogObject> comparatorLogObjectDate = new Comparator<LogObject>() {
        @Override
        public int compare(LogObject o1, LogObject o2) {
            return (o1.date.before(o2.date)) ? -1 : ((o1.date == o2.date) ? 0 : 1);
        }
    };

    public LogParser(Path logDir) {
        this.logDir = logDir;
        initLists();
    }

    private void initLists() {
        fillFileList();
        fillLogObjectList();
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

    // Возвращает список всех LogObject за указанный период
    private List<LogObject> getLogObjectListConditionDate(Date after, Date before) {
        List<LogObject> logObjects = new ArrayList<>();
        for (LogObject logObject : logObjectList) {
            if (logObject.isObjectCondition(after, before))
                logObjects.add(logObject);
        }
        return logObjects;
    }

    // Возвращает список LogObject для конкретного пользователя за указанный период
    public List<LogObject> getLogObjectListConditionDateAndUser(String user, Date after, Date before) {
        List<LogObject> logObjects = new ArrayList<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.user.equals(user))
                logObjects.add(logObject);
        }
        return logObjects;
    }

    class SQLExecutor {
        private LogParser logParser;
        private String query;
        private ParamsSQL field1;
        private ParamsSQL field2;
        private String value1;
        private Date after;
        private Date before;
        private List<LogObject> logObjectList;
        private QueryType queryType;

        private List<String> getParamsList() {
            int pos = -1;
            List<String> paramList = new ArrayList<>();
            for (int i = 0; i < query.length(); i++) {
                char c = query.charAt(i);
                if (c == '"') {
                    int nextPos = query.indexOf("\"", i +1);
                    String param = query.substring(i + 1, nextPos);
                    paramList.add(param);
                    i = nextPos + 1;
                }
            }
            return paramList;
        }

        public SQLExecutor(String query) throws ParseException {
            this.query = query;
            this.logParser = LogParser.this;
            this.logObjectList = logParser.logObjectList;

            List<String> params = getParamsList();

            if (params.size() > 0) {
                String[] fields = query.split(" ", 5);
                this.field1 = ParamsSQL.valueOf(fields[1]);
                this.field2 = ParamsSQL.valueOf(fields[3]);
            }

            switch (params.size()) {
                case 0:
                    this.queryType = QueryType.QUERY_0_PARAMS;
                    break;
                case 1:
                    this.queryType = QueryType.QUERY_1_PARAMS;
                    this.value1 = params.get(0);
                    break;
                case 3:
                    this.queryType = QueryType.QUERY_2_PARAMS;
                    this.value1 = params.get(0);
                    this.after = dateFormat.parse(params.get(1));
                    this.before = dateFormat.parse(params.get(2));
                    break;
            }
        }

        public Set<Object> execute() throws ParseException {
            Set<Object> objects;
            if (queryType != QueryType.QUERY_0_PARAMS)
                return executeWithParams();
            else
                return executeNoParams();
        }

        private List<LogObject> getWhereDataSetLogObjects(List<LogObject> logObjectList) throws ParseException {
            List<LogObject> resultLogObjects = new ArrayList<>();

            for (LogObject logObject : logObjectList) {
                switch (field2) {
                    case ip:
                        if (logObject.ip.equals(value1))
                            resultLogObjects.add(logObject);
                        break;
                    case date:
                        if (logObject.date.compareTo(dateFormat.parse(value1)) == 0)
                            resultLogObjects.add(logObject);
                        break;
                    case user:
                        if (logObject.user.equals(value1))
                            resultLogObjects.add(logObject);
                        break;
                    case event:
                        if (logObject.event == Event.valueOf(value1))
                            resultLogObjects.add(logObject);
                        break;
                    case status:
                        if (logObject.status == Status.valueOf(value1))
                            resultLogObjects.add(logObject);
                        break;
                }
            }
            return resultLogObjects;
        }

        private Set<Object> getResultDataSet(List<LogObject> logWhereObjectList) {
            Set<Object> resultSet = new HashSet<>();
            for (LogObject logObject : logWhereObjectList) {
                switch (field1) {
                    case ip:
                        resultSet.add((String) logObject.ip);
                        break;
                    case date:
                        resultSet.add((Date) logObject.date);
                        break;
                    case user:
                        resultSet.add((String) logObject.user);
                        break;
                    case event:
                        resultSet.add((Event) logObject.event);
                        break;
                    case status:
                        resultSet.add((Status) logObject.status);
                        break;
                }
            }
            return resultSet;
        }

        private Set<Object> executeNoParams() {
            Set<Object> objects = new HashSet<>();

            for (LogObject logObject : logObjectList) {
                switch (query) {
                    case ("get ip"):
                        objects.add((String) logObject.ip);
                        break;
                    case ("get user"):
                        objects.add((String) logObject.user);
                        break;
                    case ("get date"):
                        objects.add((Date) logObject.date);
                        break;
                    case ("get event"):
                        objects.add((Event) logObject.event);
                        break;
                    case ("get status"):
                        objects.add((Status) logObject.status);
                        break;
                }
            }
            return objects;
        }

        private Set<Object> executeWithParams() throws ParseException {
            return getResultDataSet(getWhereDataSetLogObjects(logObjectList));
        }

        private Set<Object> executeParamsWithDate() throws ParseException {
            return getResultDataSet(getWhereDataSetLogObjects(logParser.getLogObjectListConditionDate(after, before)));
        }
    }

    static class LogObject {
        private String logStringFromFile;
        private String ip;
        private String user;
        private Date date;
        private Event event;
        private Integer task_num;
        private Status status;

        LogObject(String logLine) throws ParseException {
            this.logStringFromFile = logLine;
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
            boolean isAfter = after == null;
            boolean isBefore = before == null;

            return ((isAfter || date.after(after)) && (isBefore || date.before(before)));
//            if (after == null & before == null)
//                return true;
//            if (after != null & before != null)
//                if (date.after(after) && date.before(before))
//                    return true;
//            if ((after == null & before != null) && date.before(before))
//                return true;
//            if ((before == null & after != null) && date.after(after))
//                return true;
//            return false;
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.user.equals(user))
                set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == event)
                set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.status == status)
                set.add(logObject.ip);
        }
        return set;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : logObjectList) {
            set.add(logObject.user);
        }
        return set;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            set.add(logObject.user);
        }
        return set.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.user.equals(user))
                set.add(logObject.event);
        }
        return set.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.ip.equals(ip))
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.LOGIN)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.DOWNLOAD_PLUGIN)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.WRITE_MESSAGE)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.SOLVE_TASK)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.SOLVE_TASK && logObject.task_num == task)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.DONE_TASK)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.DONE_TASK && logObject.task_num == task)
                set.add(logObject.user);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        List<LogObject> l = getLogObjectListConditionDateAndUser(user, after, before);
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == event)
                set.add(logObject.date);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.status == Status.FAILED)
                set.add(logObject.date);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.status == Status.ERROR)
                set.add(logObject.date);
        }
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
//        List<LogObject> logObjectsList = getLogObjectListConditionDateAndUser(user, after, before);
//        logObjectsList.sort(comparatorLogObjectDate);
//        for (LogObject logObject : logObjectsList) {
//            if (logObject.event == Event.LOGIN)
//                return logObject.date;
//        }
//        return null;
        List<Date> dates = new ArrayList<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == Event.LOGIN)
                dates.add(logObject.date);
        }
        return (dates.size() != 0) ? Collections.min(dates) : null;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<Date> dates = new ArrayList<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == Event.SOLVE_TASK && logObject.task_num == task)
                dates.add(logObject.date);
        }
        return (dates.size() != 0) ? Collections.min(dates) : null;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<Date> dates = new ArrayList<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == Event.DONE_TASK && logObject.task_num == task)
                dates.add(logObject.date);
        }
        return (dates.size() != 0) ? Collections.min(dates) : null;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == Event.WRITE_MESSAGE)
                set.add(logObject.date);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            if (logObject.event == Event.DOWNLOAD_PLUGIN)
                set.add(logObject.date);
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            set.add(logObject.event);
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.ip.equals(ip))
                set.add(logObject.event);
        }
        return set;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDateAndUser(user, after, before)) {
            set.add(logObject.event);
        }
        return set;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.status == Status.FAILED)
                set.add(logObject.event);
        }
        return set;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.status == Status.ERROR)
                set.add(logObject.event);
        }
        return set;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int solveTaskCount = 0;
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.SOLVE_TASK && logObject.task_num == task)
                solveTaskCount++;
        }
        return solveTaskCount;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int solveTaskCount = 0;
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.DONE_TASK && logObject.task_num == task)
                solveTaskCount++;
        }
        return solveTaskCount;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.SOLVE_TASK && logObject.task_num != null) {
                int value = map.getOrDefault(logObject.task_num, 0);
                map.put(logObject.task_num, value + 1);
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (LogObject logObject : getLogObjectListConditionDate(after, before)) {
            if (logObject.event == Event.DONE_TASK && logObject.task_num != null) {
                int value = map.getOrDefault(logObject.task_num, 0);
                map.put(logObject.task_num, value + 1);
            }
        }
        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> resultSet = null;
        try {
            SQLExecutor sqlExecutor = new SQLExecutor(query);
            resultSet = sqlExecutor.execute();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }

}