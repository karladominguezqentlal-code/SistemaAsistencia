import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            limpiarPantalla();
            System.out.println("\n--- CONTROL DE ASISTENCIA ---");
            System.out.println("1. Numero de faltas");
            System.out.println("2. Numero de retardos");
            System.out.println("3. Porcentaje de asistencia");
            System.out.println("4. Lista de alumnos con falta");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.print("Ingresa un numero del 1 al 5: ");
                teclado.next();
            }
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    limpiarPantalla();
                    NumeroFaltas.mostrar();
                    break;
                case 2:
                    limpiarPantalla();
                    NumeroRetardos.mostrar();
                    break;
                case 3:
                    limpiarPantalla();
                    PorcentajeAsistencia.mostrar();
                    break;
                case 4:
                    limpiarPantalla();
                    AlumnosFaltas.mostrar();
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }

            if (opcion != 5) {
                esperarCincoSegundos();
            }
        } while (opcion != 5);

        teclado.close();
    }

    public static void limpiarPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (Exception e) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public static void esperarCincoSegundos() {
        try {
            System.out.println("\nRegresando al menu en 5 segundos...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
