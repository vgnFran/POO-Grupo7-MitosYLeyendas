public class Oro extends Carta implements Jugable {

    private int cantidadOro;

    public Oro(String nombre, String descripcion, int cantidadOro) {
        super(nombre, 0, descripcion);
        this.cantidadOro = cantidadOro;
    }

    public int getCantidadOro() {
        return this.cantidadOro;
    }

    @Override
    public void jugar(Partida partida) {
        partida.aumentarReservaOro(this.cantidadOro);
        System.out.println(this.getNombre() + " jugada. +" + this.cantidadOro + " oro.");
    }

    @Override
    public void mostrarCarta() {
        super.mostrarCarta();
        System.out.println("Oro que otorga: " + this.cantidadOro);
    }
}
