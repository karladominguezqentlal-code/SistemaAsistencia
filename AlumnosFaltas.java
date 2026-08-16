public class AlumnosFaltas {
    public static void mostrar() {
        try {
            String contenido = java.nio.file.Files.readString(java.nio.file.Path.of("lista.json"));
            java.util.regex.Matcher buscador = java.util.regex.Pattern
                    .compile("\\\"nombre\\\"\\s*:\\s*\\\"([^\\\"]+)\\\"\\s*,\\s*\\\"estado\\\"\\s*:\\s*\\\"F\\\"")
                    .matcher(contenido);
            boolean hayFaltas = false;

            System.out.println("Alumnos con falta:");
            while (buscador.find()) {
                System.out.println("- " + buscador.group(1));
                hayFaltas = true;
            }

            if (!hayFaltas) {
                System.out.println("No hay alumnos con falta.");
            }
        } catch (java.io.IOException e) {
            System.out.println("No se pudo leer lista.json");
        }
    }
}
