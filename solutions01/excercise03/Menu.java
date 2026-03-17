package solutions01.excercise03;

import java.time.LocalDateTime;
import java.util.Scanner;

import solutions01.excercise03.service.ExecutionLogManager;

public class Menu {

    private Scanner input;
    private ExecutionLogManager logManager;

    public Menu() {
        this.input = new Scanner(System.in);
        logManager = new ExecutionLogManager();
    }

    private void addLogUi() {

        LocalDateTime systemDate;
        String Os;

        System.out.println("Ingrese el id del usuario: ");
        int userId = input.nextInt();

        System.out.println("Ingrese el nombre del log: ");
        String logName = input.nextLine();

        System.out.println("Ingrese la descripcion del log: ");
        String description;

        System.out.println();

    }

    private void listLogUi() {

    }

    private void getByUserUi() {

    }

    private void getLastLogUi() {

    }

    private void getLogsForSystem() {

    }

    public void menu() {
        System.out.println("Bienvenido a tu manejador de logs");

        int choose = 0;
        do {

            System.out.println("[1] - Agregar log");
            System.out.println("[2] - Listar logs");
            System.out.println("[3] - Filtrar por usuario");
            System.out.println("[4] - Obtener ultimo log");
            System.out.println("[5] - Agrupar por sistema operativo");
            System.out.println("[0] - Salir");

            try {
                choose = input.nextInt();
                input.nextLine();

                switch (choose) {
                    case 1 -> addLogUi();
                    case 2 -> listLogUi();
                    case 3 -> getByUserUi();
                    case 4 -> getLastLogUi();
                    case 5 -> getLogsForSystem();
                    case 0 -> System.out.println("Saliendo");
                    default -> System.out.println("...saliendo");
                }

            } catch (Exception e) {
                System.err.println("Ingresa un numero valido");
                input.nextLine();
                choose = -1;
            }

        } while (choose != 0);
        input.close();
    }

}
