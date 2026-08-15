package com.asistencia;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.Scanner;

public class SistemaDeAsistenciaG {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("       SISTEMA DE ASISTENCIA");
            System.out.println("======================================");
            System.out.println("1. Seleccionar archivo JSON");
            System.out.println("2. Porcentaje de asistencia");
            System.out.println("3. Número de faltas");
            System.out.println("4. Número de retardos");
            System.out.println("5. Alumnos con falta");
            System.out.println("6. Salir");
            System.out.println("======================================");

            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:

                    seleccionarArchivo();

                    break;

                case 2:

                    System.out.println(
                            "Porcentaje de asistencia"
                    );

                    break;

                case 3:

                    System.out.println(
                            "Numero de faltas"
                    );

                    break;

                case 4:

                    System.out.println(
                            "Numero de retardos"
                    );

                    break;

                case 5:

                    System.out.println(
                            "Numero de Alumnos con falta"
                    );

                    break;

                case 6:

                    System.out.println(
                            "¡Hasta luego Arturo Caballero!"
                    );

                    break;

                default:

                    System.out.println(
                            "Opción no válida."
                    );
            }

        } while (opcion != 6);

        teclado.close();
    }


    public static void seleccionarArchivo() {

        JFileChooser selector = new JFileChooser();

        FileNameExtensionFilter filtro =
                new FileNameExtensionFilter(
                        "Archivos JSON (*.json)",
                        "json"
                );

        selector.setFileFilter(filtro);

        selector.setDialogTitle(
                "Seleccionar archivo de asistencia"
        );

        int resultado =
                selector.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {

            File archivo =
                    selector.getSelectedFile();

            System.out.println();
            System.out.println(
                    "Archivo seleccionado:"
            );

            System.out.println(
                    archivo.getAbsolutePath()
            );

            System.out.println();
            System.out.println(
                    "Archivo cargado correctamente."
            );

        } else {

            System.out.println();
            System.out.println(
                    "No se seleccionó ningún archivo."
            );
        }
    }
}
