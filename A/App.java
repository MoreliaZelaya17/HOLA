import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Hola, soy Eliza! Puedes empezar a hablar conmigo. Escribe 'Adiós' para salir.");

        while (true) {
            System.out.print("Tú: ");
            String respuestaUsuario = input.nextLine().toLowerCase();

            if (respuestaUsuario.equals("adiós")) {
                System.out.println("Eliza: Adiós. ¡Espero que hayas tenido una buena conversación!");
                break;
            } else if (respuestaUsuario.contains("mi")) {
               
                String sustantivo = obtenerSustantivo(respuestaUsuario);
                System.out.println("Eliza: Cuéntame más sobre " + "su " + sustantivo);
            } else if (respuestaUsuario.contains("amor") || respuestaUsuario.contains("odio")) {
               
                System.out.println("Eliza: Parece que tiene fuertes sentimientos al respecto.");
            } else {
                
                String[] respuestasAleatorias = {"Continúe", "Dígame más", "Continúe"};
                int indiceAleatorio = random.nextInt(respuestasAleatorias.length);
                System.out.println("Eliza: " + respuestasAleatorias[indiceAleatorio]);
            }
        }

        input.close();
    }

    public static String obtenerSustantivo(String respuesta) {
        String[] palabras = respuesta.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            if (palabras[i].equals("mi") && i < palabras.length - 1) {
                return palabras[i + 1];
            }
        }
        return "usted";
    }
}
