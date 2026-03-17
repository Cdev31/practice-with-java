package solutions01.excercise03.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import solutions01.excercise03.models.ExecutionLog;

public class ExecutionLogManager {

    private UserManager userService;
    List<ExecutionLog> logs = new ArrayList<ExecutionLog>();

    public ExecutionLogManager() {
        userService = new UserManager();
    }

    public List<ExecutionLog> allLogs() {
        return logs;
    }

    public Object findByUser(int userId) {

        ExecutionLog exitsLog = logs.stream()
                .filter(log -> log.getUserId() == userId)
                .findAny()
                .orElse(null);

        return exitsLog;

    }

    public ExecutionLog findByLastLog() {

        return logs.get(logs.size() - 1);
    }

    public ExecutionLog findByOs(String operativeSystem) {

        ExecutionLog existLog = logs.stream()
                .filter(log -> log.getOperativeSystem() == operativeSystem)
                .findAny()
                .orElse(null);

        return existLog;
    }

    public boolean addLog(int userId, String logName, String description, LocalDateTime systemDate, String Os) {

        if (userService.userExistbyId(userId) == false)
            return false;

        ExecutionLog newLog = new ExecutionLog();
        newLog.setUserId(userId);
        newLog.setLogName(logName);
        newLog.setDescription(description);
        newLog.setSystemDate(systemDate);
        newLog.setOperativeSystem(Os);

        logs.add(newLog);
        return true;
    }
}
