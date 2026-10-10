public abstract class Card {
    private final int id;
    private final String name;
    private final int energyCost;
    private final String description;

    public Card(int id, String name, int energyCost, String description) {
        this.id = id;
        this.name = name;
        this.energyCost = Math.max(0, energyCost);
        this.description = description;
    }

    public int getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public int getEnergyCost() { 
        return energyCost; 
    }
    public String getDescription() { 
        return description; 
    }

    public abstract void playCard(Player player, Board board);

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Costo: " + energyCost
                + " energía | " + description;
    }
}
