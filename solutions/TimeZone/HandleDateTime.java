package solutions.TimeZone;

import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HandleDateTime {

    HandleDateTime() {
    }

    private boolean isValidZone(String zoneId) {
        try {
            ZoneId zone = ZoneId.of(zoneId);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private boolean isDateValid(String date) {
        return date.matches("^\\d{4}/\\d{2}/\\{2} [0-2][0-9]:[0-6][0-9]:[0-6][0-9]$");
    }

    public String getZoneHour(String timeZone) {

        if (isValidZone(timeZone) != true)
            return "La zona ingresada es invalida";

        ZoneId zone = ZoneId.of(timeZone);
        Instant instantNow = Instant.now();
        ZonedDateTime zoneHour = instantNow.atZone(zone);

        return Optional.of(zoneHour).toString();
    }

    public Object compareLocalHourZone(String zone) {

        if (isValidZone(zone) != true)
            return "Zona invalida";

        ZoneId zoneId = ZoneId.of(zone);

        ZonedDateTime zoneHour = ZonedDateTime.now(zoneId);
        ZonedDateTime systemZoneHour = ZonedDateTime.now();

        int rangeMinutes = Math.abs(zoneHour.getMinute() - systemZoneHour.getMinute());

        List<Object> data = new ArrayList<>();
        data.add(zoneHour.toString());
        data.add(systemZoneHour.toString());
        data.add(rangeMinutes);

        return data;
    }

    public Object eventHandleMinutes(String zone, String date) {
        if (isDateValid(date) != true || isValidZone(zone) != true)
            return "Informacion proporcionada invalida";

        ZoneId zoneId = ZoneId.of(zone);
        ZonedDateTime zoneHour = ZonedDateTime.now(zoneId);

        ZonedDateTime eventZoneHour = ZonedDateTime.of(LocalDateTime.parse(date), zoneId);

        int rangeMinutes = Math.abs(zoneHour.getMinute() - eventZoneHour.getMinute());

        return rangeMinutes;
    }

}
