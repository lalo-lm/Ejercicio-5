import java.util.ArrayList;
import java.util.List;

public class Board {
    private String state = "El campus está tranquilo.";
    private final List<String> historialEfectos = new ArrayList<>();

    public void applyEffect(String effect) {
        state = effect;
        historialEfectos.add(effect);
    }

    public String getState() { return state; }
    public List<String> getHistorialEfectos() {
        return new ArrayList<>(historialEfectos);
    }

    @Override
    public String toString() { return state; }
}
