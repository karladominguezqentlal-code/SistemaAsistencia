
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PorcentajeAsistencia {

    public static void calcularPorcentaje(String rutaArchivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            Pattern pattern = Pattern.compile("\"estado\"\\s*:\\s*\"([PFRpfr])\"");
            Matcher matcher = pattern.matcher(contenido);

            int totalAlumnos = 0;
            int presentes = 0;
            int retardos = 0;

            while (matcher.find()) {
                String estado = matcher.group(1).toUpperCase();
                totalAlumnos++;

                if (estado.equals("P")) {
                    presentes++;
                } else if (estado.equals("R")) {
                    retardos++;
                }
            }

            if (totalAlumnos == 0) {
                System.out.println("No se encontraron resgistros en " + rutaArchivo);
                return;
            }

            double pctPuntual = ((double) presentes / totalAlumnos) * 100;
            double pctGlobal = ((double) (presentes + retardos) / totalAlumnos) * 100;

            System.out.println("--- PORCENTAJE DE ASISTENCIA ---");
            System.out.println("Total de alumnos procesados: " + totalAlumnos);
            System.out.printf("Asistencia puntual (Solo P): %.2f%%\n", pctPuntual);
            System.out.printf("Asistencia global (P + R):  %.2f%%\n", pctGlobal);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
                }
            }
        }


