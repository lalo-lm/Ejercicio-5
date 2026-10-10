public class CampusEventCard extends Card {
    private final String tipoEvento;
    private final String efecto;

    public CampusEventCard(int id, String name, int energyCost, String description,
                           String tipoEvento, String efecto) {
        super(id, name, energyCost, description);
        this.tipoEvento = tipoEvento;
        this.efecto = efecto;
    }

    @Override
    public void playCard(Player player, Board board) {
        board.applyEffect(tipoEvento + ": " + efecto);
        player.modifyEnergy(1);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo de evento: " + tipoEvento + " | Efecto: " + efecto;
    }
}
