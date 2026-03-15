import solutions01.excercise01.ExecutionLoggerApp;

public class Main {

    public static void main(String[] args) {
        ExecutionLoggerApp exec = new ExecutionLoggerApp();

        System.out.println(exec.getUserName());
        System.out.println(exec.getOsName());
        System.out.println(exec.getJavaVersion());
        System.out.println(exec.getDateAndHour());
    }
}
