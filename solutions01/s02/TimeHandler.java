package solutions01.s02;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeHandler {

  private final Instant hourAndDate;
  private final String userName;
  private final ZoneId Zone;
  private final ZonedDateTime systemDate;

  public TimeHandler(String userName, ZoneId systemZone, Instant hourAndDate,
      ZonedDateTime systemDate) {
    this.userName = userName;
    this.Zone = systemZone;
    this.hourAndDate = hourAndDate;
    this.systemDate = systemDate;
  }

  public Instant getHourAndDate() {
    return hourAndDate;
  }

  public ZoneId getZone() {
    return Zone;
  }

  public ZonedDateTime getSystemDate() {
    return systemDate;
  }

  public String getUserName() {
    return userName;
  }

}
