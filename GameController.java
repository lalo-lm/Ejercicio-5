public class GameController {
    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        boolean playing = true;
        while (playing) {
            view.showMessage("\nTurno de: " + model.getCurrentPlayer());
            int opcion = view.showMenu();
            switch (opcion) {
                case 1:
                    view.showCards(model.getDeck().listCards());
                    break;
                case 2:
                    view.showCard(model.searchCard(view.leerEntero("ID de la carta: ")));
                    break;
                case 3:
                    view.showCard(model.searchCard(view.leerTexto("Nombre de la carta: ")));
                    break;
                case 4:
                    model.orderDeck();
                    view.showMessage("Mazo ordenado por costo de energía.");
                    break;
                case 5:
                    jugarCarta();
                    break;
                case 6:
                    view.showMessage(model.takeCard()
                            ? "Tomaste una carta." : "No quedan cartas en el mazo.");
                    break;
                case 7:
                    model.skipTurn();
                    view.showMessage("Turno terminado. Se recuperó 1 punto de energía.");
                    break;
                case 8:
                    view.showMessage("Jugador: " + model.getCurrentPlayer());
                    view.showMessage("Estado del tablero: " + model.getBoard().getState());
                    view.showMessage("Cartas restantes en el mazo: " + model.getDeck().amount());
                    view.showMessage("Tu mano:");
                    view.showCards(model.getCurrentPlayer().getDeck());
                    break;
                case 0:
                    playing = false;
                    view.showMessage("Gracias por jugar UVG Card Battle.");
                    break;
                default:
                    view.showMessage("Opción no válida.");
            }
        }
    }

    private void jugarCarta() {
        view.showMessage("Cartas en tu mano:");
        view.showCards(model.getCurrentPlayer().getDeck());
        int indice = view.leerEntero("Número de carta en la mano (1 = primera): ");
        if (model.playTurn(indice)) {
            view.showMessage("Carta jugada correctamente.");
            view.showMessage("Efecto del tablero: " + model.getBoard().getState());
        } else {
            view.showMessage("No se pudo jugar. Verifica el número de carta y tu energía.");
        }
    }
}
