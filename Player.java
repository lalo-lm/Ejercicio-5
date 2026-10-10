import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private int energy;
    private final List<Card> deck = new ArrayList<>();

    public Player(String name, int initialEnergy) {
        this.name = name;
        this.energy = Math.max(0, initialEnergy);
    }

    public String getName() { return name; }
    public int getEnergy() { return energy; }
    public List<Card> getDeck() { return new ArrayList<>(deck); }

    public boolean playCard(Card card, Board board) {
        if (card == null || !deck.contains(card)) return false;
        if (energy < card.getEnergyCost()) return false;

        energy -= card.getEnergyCost();
        deck.remove(card);
        card.playCard(this, board);
        return true;
    }

    public boolean takeCard(Deck deck) {
        Card card = deck.takeCard();
        if (card == null) return false;
        deck.addCard(card);
        return true;
    }

    public void skipTurn() {
        modifyEnergy(1);
    }

    public void modifyEnergy(int amount) {
        energy = Math.max(0, energy + amount);
    }

    @Override
    public String toString() {
        return name + " | Energía: " + energy + " | Cartas en mazo: " + deck.size();
    }
}
