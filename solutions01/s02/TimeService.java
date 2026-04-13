package solutions01.s02;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeService {
  private static final DateTimeFormatter Format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z");

  public TimeHandler getInitialData() {
    String userName = System.getProperty("user.name");
    ZoneId systemZone = ZoneId.systemDefault();
    Instant now = Instant.now();
    ZonedDateTime systemDateTime = now.atZone(systemZone);

    return new TimeHandler(userName, systemZone, now, systemDateTime);
  }

  public ZoneId parseZone(String zoneText) {
    if (zoneText == null || zoneText.isBlank()) {
      throw new IllegalArgumentException("Zone cannot be empty");
    }
    return ZoneId.of(zoneText.trim());
  }

  public ZonedDateTime getCurrentTimeInZone(ZoneId targetZone) {
    Instant now = Instant.now();
    return now.atZone(targetZone);
  }

}
