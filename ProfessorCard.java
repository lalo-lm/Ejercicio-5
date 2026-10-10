public class ProfessorCard extends Card {
    private final String departament;
    private final int attentionCalls;
    private final int attentionTime;

    public ProfessorCard(int id, String nombre, int costoEnergia, String descripcion,
                            String departament, int attentionCalls, int attentionTime) {
        super(id, nombre, costoEnergia, descripcion);
        this.departament = departament;
        this.attentionCalls = attentionCalls;
        this.attentionTime = attentionTime;
    }

    @Override
    public void playCard(Player player, Board board) {
        player.modifyEnergy(1);
        board.applyEffect("El catedrático del departamento " + departament
                + " interviene. Llamadas de atención: " + attentionCalls
                + ", tiempo de atención: " + attentionTime + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Departamento: " + departament
                + " | Llamadas de atención: " + attentionCalls
                + " | Tiempo de atención: " + attentionTime;
    }
}
