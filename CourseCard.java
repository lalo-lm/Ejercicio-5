public class CourseCard extends Card {
    private final int credits;
    private final int difficulty;

    public CourseCard(int id, String name, int energyCost, String description,
                      int credits, int difficulty) {
        super(id, name, energyCost, description);
        this.credits = credits;
        this.difficulty = difficulty;
    }

    @Override
    public void playCard(Player player, Board board) {
        player.modifyEnergy(credits);
        board.applyEffect("El curso " + getName() + " aporta "
                + credits + " puntos de energía. Dificultad: " + difficulty + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Créditos: " + credits
                + " | Dificultad: " + difficulty;
    }
}
