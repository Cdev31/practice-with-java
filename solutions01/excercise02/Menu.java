package solutions01.excercise02;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    private final Scanner input;
    private final TimeZoneMonitor dateTimeZone = new TimeZoneMonitor();
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Menu() {
        this.input = new Scanner(System.in);
    }

    private String[] getSystemInfo() {
        String[] systemInfo = new String[3];

        systemInfo[0] = System.getProperty("user.name");
        systemInfo[2] = ZoneId.systemDefault().toString();

        // Hora del sistema CON zona (para que sea coherente con el ejercicio)
        ZonedDateTime nowSystem = ZonedDateTime.now(ZoneId.systemDefault());
        systemInfo[1] = nowSystem.format(FMT);

        return systemInfo;
    }

    private void showNowHour() {
        System.out.print("Ingrese la zona horaria deseada (ej: Asia/Manila): ");
        String zone = this.input.nextLine().trim();

        System.out.println(this.dateTimeZone.getZoneHour(zone));
    }

    private void showCompareZoneHour() {
        System.out.print("Ingrese la zona horaria deseada: ");
        String zone = this.input.nextLine().trim();

        System.out.println(this.dateTimeZone.compareLocalHourZone(zone));
    }

    private void showCompareRangeMinutesZoneHour() {
        System.out.print("Ingrese zona horaria del evento: ");
        String zone = this.input.nextLine().trim();

        System.out.print("Ingrese la fecha del evento (yyyy-MM-dd HH:mm:ss): ");
        String date = this.input.nextLine().trim();

        System.out.println(this.dateTimeZone.eventHandleMinutes(zone, date));
    }

    public void mainMenu() {
        int option;

        do {
            String[] info = getSystemInfo();
            System.out.println("\nBienvenido al mini sistema de gestion de zonas horarias");
            System.out.println("User: " + info[0]);
            System.out.println("Now (system): " + info[1]);
            System.out.println("System Zone: " + info[2]);

            System.out.println("\nElija una de las siguientes opciones:");
            System.out.println("[1] Mostrar hora actual en otra zona");
            System.out.println("[2] Comparar zona del sistema vs otra zona (diferencia de huso)");
            System.out.println("[3] Cuenta regresiva: minutos faltantes para un evento en otra zona");
            System.out.println("[0] Salir");

            try {
                option = input.nextInt();
                input.nextLine();

                switch (option) {
                    case 1 -> showNowHour();
                    case 2 -> showCompareZoneHour();
                    case 3 -> showCompareRangeMinutesZoneHour();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opcion invalida.");
                }
            } catch (Exception e) {
                System.out.println("Ingresa un numero valido.");
                input.nextLine();
                option = -1;
            }
        } while (option != 0);

        input.close();
    }
}