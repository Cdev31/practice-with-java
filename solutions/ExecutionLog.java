package solutions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExecutionLog {
    private String userName;
    private String dateAndHour;

    public ExecutionLog() {
        this.userName = "User:" + System.getProperty("user.name");

        LocalDateTime now = LocalDateTime.now();

        String dateFormated = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        this.dateAndHour = dateFormated;

    }

    public String getUserName() {
        return userName;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }

}
