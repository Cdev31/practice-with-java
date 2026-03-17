package solutions01.excercise03.models;

import java.time.LocalDateTime;

public class ExecutionLog {
    private int userId;

    private String logName;

    private LocalDateTime systemDate;

    private String operativeSystem;

    private String description;

    public String getLogName() {
        return logName;
    }

    public String getDescription() {
        return description;
    }

    public String getOperativeSystem() {
        return operativeSystem;
    }

    public LocalDateTime getSystemDate() {
        return systemDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public void setOperativeSystem(String operativeSystem) {
        this.operativeSystem = operativeSystem;
    }

    public void setSystemDate(LocalDateTime systemDate) {
        this.systemDate = systemDate;
    }
}
