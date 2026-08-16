public class NumeroRetardos {
    public static void mostrar() {
        try {
            String contenido = java.nio.file.Files.readString(java.nio.file.Path.of("lista.json"));
            java.util.regex.Matcher buscador = java.util.regex.Pattern
                    .compile("\\\"estado\\\"\\s*:\\s*\\\"R\\\"")
                    .matcher(contenido);
            int retardos = 0;

            while (buscador.find()) {
                retardos++;
            }

            System.out.println("Numero de retardos: " + retardos);
        } catch (java.io.IOException e) {
            System.out.println("No se pudo leer lista.json");
        }
    }
}
