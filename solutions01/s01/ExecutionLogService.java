package solutions01.s01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExecutionLogService {

  ExecutionLog logData;

  public ExecutionLogService() {
    this.logData = new ExecutionLog();
  }

  private void loadData() {
    try {
      LocalDateTime now = LocalDateTime.now();
      String hourAndDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

      logData.setUserName(System.getProperty("user.name"));
      logData.setDateOfSystem(hourAndDate);
      logData.setJavaVersion(System.getProperty("java.version"));
      logData.setSystemName(System.getProperty("os.name"));

    } catch (Exception e) {
      System.err.println("Error en la carga de datos");
    }
  }

  public void showData() {
    loadData();

    System.out.println("Nombre de usuario: " + logData.getUserName());
    System.out.println("Nombre del sistema: " + logData.getSystemName());
    System.out.println("Version de java: " + logData.getJavaVersion());
    System.out.println("Hora actual del sistema: " + logData.getDateOfSystem());
  }

}
