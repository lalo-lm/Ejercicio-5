import java.util.List;
import java.util.Scanner;

public class GameView {
    private final Scanner scanner = new Scanner(System.in);

    public int showMenu() {
        System.out.println("\n===== UVG CARD BATTLE =====");
        System.out.println("1. Listar cartas del mazo");
        System.out.println("2. Buscar carta por ID");
        System.out.println("3. Buscar carta por nombre");
        System.out.println("4. Ordenar mazo por costo de energía");
        System.out.println("5. Ver mano y jugar una carta");
        System.out.println("6. Tomar una carta");
        System.out.println("7. Pasar turno");
        System.out.println("8. Ver estado del juego");
        System.out.println("0. Salir");
        return leerEntero("Selecciona una opción: ");
    }

    public int readOption() { return leerEntero("Opción: "); }

    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
            }
        }
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public void showCards(List<Card> cartas) {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas.");
            return;
        }
        for (Card carta : cartas) System.out.println(carta);
    }

    public void showCard(Card carta) {
        if (carta == null) System.out.println("No se encontró la carta.");
        else System.out.println(carta);
    }

    public void showMessage(String mensaje) { System.out.println(mensaje); }
}
