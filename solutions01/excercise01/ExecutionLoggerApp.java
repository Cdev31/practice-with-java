package solutions01.excercise01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExecutionLoggerApp {
    private String username;
    private String osName;
    private String javaVersion;
    private String dateAndHour;

    public ExecutionLoggerApp() {
        this.username = "User: " + System.getProperty("user.name");
        this.osName = "Os: " + System.getProperty("os.name");
        this.javaVersion = "java version: " + System.getProperty("java.version");

        LocalDateTime now = LocalDateTime.now();
        String dateFormated = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        this.dateAndHour = dateFormated;
    }

    public String getUserName() {
        return username;
    }

    public String getOsName() {
        return osName;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public String getDateAndHour() {
        return dateAndHour;
    }
}
