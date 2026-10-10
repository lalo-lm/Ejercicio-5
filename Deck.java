import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        if (card != null) cards.add(card);
    }

    public List<Card> listCards() {
        return new ArrayList<>(cards);
    }

    public Card searchCard(int id) {
        for (Card card : cards) {
            if (card.getId() == id) return card;
        }
        return null;
    }

    public Card searchCard(String name) {
        if (name == null) return null;
        for (Card card : cards) {
            if (card.getName().equalsIgnoreCase(name.trim())) return card;
        }
        return null;
    }

    public void sortByCost() {
        cards.sort(Comparator.comparingInt(Card::getEnergyCost));
    }

    public Card takeCard() {
        if (cards.isEmpty()) return null;
        return cards.remove(0);
    }

    public boolean isEmpty() { 
        return cards.isEmpty(); 
    }
    public int amount() { 
        return cards.size(); 
    }
}
