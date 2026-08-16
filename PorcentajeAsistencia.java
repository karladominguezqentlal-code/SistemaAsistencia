public class PorcentajeAsistencia {
    public static void mostrar() {
        try {
            String contenido = java.nio.file.Files.readString(java.nio.file.Path.of("lista.json"));
            java.util.regex.Matcher buscador = java.util.regex.Pattern
                    .compile("\\\"estado\\\"\\s*:\\s*\\\"([PFR])\\\"")
                    .matcher(contenido);
            int total = 0;
            int presentes = 0;

            while (buscador.find()) {
                total++;
                if (buscador.group(1).equals("P")) {
                    presentes++;
                }
            }

            double porcentaje = total == 0 ? 0 : (presentes * 100.0) / total;
            System.out.printf("Porcentaje de asistencia: %.2f%%%n", porcentaje);
        } catch (java.io.IOException e) {
            System.out.println("No se pudo leer lista.json");
        }
    }
}
