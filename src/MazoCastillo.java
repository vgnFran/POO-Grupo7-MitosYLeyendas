import java.util.ArrayList;
import java.util.Random;

public class MazoCastillo {

    private ArrayList<Carta> cartas;

    public MazoCastillo() {
        cartas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    public void mostrarCartas() {

        for (Carta carta : cartas) {
            carta.mostrarCarta();
        }

    }

    public Carta levantarCarta() {

        if (estaVacio()) {
            return null;
        }

        Random random = new Random();

        int posicion = random.nextInt(cartas.size());

        Carta carta = cartas.get(posicion);

        cartas.remove(posicion);

        return carta;

    }

}
