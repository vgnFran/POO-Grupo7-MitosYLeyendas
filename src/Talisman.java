public class Talisman extends Carta implements Jugable {

    private int recuperacionDefensa;

    public Talisman(String nombre, int costoOro, String descripcion, int recuperacionDefensa) {
        super(nombre, costoOro, descripcion);
        this.recuperacionDefensa = recuperacionDefensa;
    }

    @Override
    public void jugar(Partida partida) {

        partida.aumentarDefensaCastillo(recuperacionDefensa);

        System.out.println(getNombre() + " fue utilizado.");
    }
}
