import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroFaltas {
    public static void mostrar() {
        try {
            String contenido = Files.readString(Path.of("lista.json"));
            Matcher buscador = Pattern.compile("\\\"estado\\\"\\s*:\\s*\\\"F\\\"").matcher(contenido);
            int faltas = 0;

            while (buscador.find()) {
                faltas++;
            }

            System.out.println("Numero de faltas: " + faltas);
        } catch (IOException e) {
            System.out.println("No se pudo leer lista.json");
        }
    }
}
