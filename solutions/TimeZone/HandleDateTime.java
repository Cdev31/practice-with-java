package solutions.TimeZone;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HandleDateTime {

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public HandleDateTime() {
    }

    private boolean isValidZone(String zoneId) {
        try {
            ZoneId.of(zoneId);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public String getZoneHour(String timeZone) {
        if (!isValidZone(timeZone))
            return "La zona ingresada es invalida.";

        ZoneId zone = ZoneId.of(timeZone);

        // ✅ mismo instante, distinta zona
        Instant now = Instant.now();
        ZonedDateTime zdt = now.atZone(zone);

        return "Now (" + timeZone + "): " + zdt.format(FMT) + " | Instant: " + now;
    }

    public String compareLocalHourZone(String zone) {
        if (!isValidZone(zone))
            return "Zona invalida.";

        ZoneId target = ZoneId.of(zone);
        ZoneId system = ZoneId.systemDefault();

        // ✅ mismo instante
        Instant now = Instant.now();
        ZonedDateTime systemZdt = now.atZone(system);
        ZonedDateTime targetZdt = now.atZone(target);

        // ✅ diferencia real de huso: offsets (en minutos)
        int diffMinutes = (targetZdt.getOffset().getTotalSeconds() - systemZdt.getOffset().getTotalSeconds()) / 60;

        return """
                System: %s (%s)
                Target: %s (%s)
                Offset difference: %d minutes
                Instant: %s
                """.formatted(
                systemZdt.format(FMT), system,
                targetZdt.format(FMT), target,
                diffMinutes,
                now);
    }

    public String eventHandleMinutes(String zone, String date) {
        if (!isValidZone(zone))
            return "Zona invalida.";

        ZoneId zoneId = ZoneId.of(zone);

        // Parse con formato correcto
        LocalDateTime eventLocal;
        try {
            eventLocal = LocalDateTime.parse(date, FMT);
        } catch (DateTimeParseException e) {
            return "Fecha invalida. Usa formato: yyyy-MM-dd HH:mm:ss";
        }

        // ✅ evento en esa zona -> instante absoluto
        ZonedDateTime eventZdt = eventLocal.atZone(zoneId);
        Instant eventInstant = eventZdt.toInstant();

        Instant now = Instant.now();

        long minutes = Duration.between(now, eventInstant).toMinutes();

        if (minutes > 0) {
            return "Faltan " + minutes + " minutos para el evento. (Evento: " + eventZdt.format(FMT) + " " + zoneId
                    + ")";
        } else if (minutes < 0) {
            return "El evento ya ocurrio hace " + Math.abs(minutes) + " minutos. (Evento: " + eventZdt.format(FMT) + " "
                    + zoneId + ")";
        } else {
            return "El evento es AHORA. (Evento: " + eventZdt.format(FMT) + " " + zoneId + ")";
        }
    }
}