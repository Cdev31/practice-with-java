package solutions.TimeZone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    private Scanner input;
    private HandleDateTime dataTimeZone = new HandleDateTime();

    public Menu() {

        this.input = new Scanner(System.in);

    }

    private String[] getSystemInfo() {

        String[] systemInfo = new String[3];
        systemInfo[0] = System.getProperty("user.name");
        systemInfo[1] = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        systemInfo[2] = ZoneId.systemDefault().toString();

        return systemInfo;
    }

    private void showNowHour() {
        System.out.println("Ingrese la zona horaria deseada: ");
        String zone = input.nextLine();

        System.out.println(this.dataTimeZone.getZoneHour(zone));
    }

    private void showCompareRangeMinutesZoneHour() {

    }

    public void mainMenu() {

        int option = 0;

        do {

            System.out.println("Bienvenido al mini sistema de gestion de zonas horarias");
            System.out.println(getSystemInfo()[0] + " " + getSystemInfo()[1] + " " + getSystemInfo()[2]);

            System.out.println("Elija una de las siguientes opciones:");
            System.out.println("[1] Mostrar hora actual en otra zona");
            System.out.println("[2] Comparar hora del sistema vs otra zona horaria");
            System.out.println("[3] Cuenta regresiva: minutos faltantes paa un evento en otra zona horaria");
            System.out.println("[0] salir");
            int choose = input.nextInt();

            switch (option = choose) {
                case 1:
                    showNowHour();
                    break;
                case 2:
                    break;
                case 3:
                    showCompareRangeMinutesZoneHour();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

}
