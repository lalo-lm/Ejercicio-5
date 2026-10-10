import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {
    private final Deck deck = new Deck();
    private final List<Player> players = new ArrayList<>();
    private final Board board = new Board();
    private int currentTurn = 0;
    private final Random random = new Random();

    public GameModel() {
        initializeGame();
    }

    public void initializeGame() {
        String[] courseNames = {"Programación", "Cálculo", "Física", "Química"};
        String[] departments = {"Computación", "Matemática", "Ciencias"};
        String[] events = {"Semana de Parciales", "Feria de Clubes", "Día Deportivo"};
        for (int id = 1; id <= 12; id++) {
            int tipo = random.nextInt(3);
            int costo = random.nextInt(4) + 1;
            if (tipo == 0) {
                deck.addCard(new ProfessorCard(id, "Instructor " + id, costo,
                        "Un instructor aparece en el campus.", departments[random.nextInt(departments.length)],
                        random.nextInt(5) + 1, random.nextInt(4) + 1));
            } else if (tipo == 1) {
                deck.addCard(new CourseCard(id, courseNames[random.nextInt(courseNames.length)] + " " + id,
                        costo, "Una materia universitaria.", random.nextInt(4) + 1, random.nextInt(5) + 1));
            } else {
                String evento = events[random.nextInt(events.length)];
                deck.addCard(new CampusEventCard(id, evento + " " + id, costo,
                        "Un evento afecta la vida universitaria.", evento,
                        "El campus cambia temporalmente por el evento."));
            }
        }

        Player player = new Player("Jugador 1", 5);
        players.add(player);
        // Cada jugador recibe hasta tres cartas iniciales.
        for (int i = 0; i < 3; i++) player.takeCard(deck);
    }

    public Deck getDeck() { return deck; }
    public Board getBoard() { return board; }
    public Player getCurrentPlayer() { return players.get(currentTurn); }
    public List<Player> getPlayers() { return new ArrayList<>(players); }

    public Card searchCard(int id) { return deck.searchCard(id); }
    public Card searchCard(String name) { return deck.searchCard(name); }
    public void orderDeck() { deck.sortByCost(); }

    public boolean playTurn(int handIndex) {
        Player player = getCurrentPlayer();
        List<Card> hand = player.getDeck();
        if (handIndex < 1 || handIndex > hand.size()) return false;
        return player.playCard(hand.get(handIndex - 1), getBoard());
    }

    public boolean takeCard() {
        return getCurrentPlayer().takeCard(getDeck());
    }

    public void skipTurn() {
        getCurrentPlayer().skipTurn();
        currentTurn = (currentTurn + 1) % players.size();
    }
}
