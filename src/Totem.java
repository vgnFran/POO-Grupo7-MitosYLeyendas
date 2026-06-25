public class Totem extends Carta implements Jugable, AportaDefensa {

    private int bonusDefensa;

    public Totem(String nombre, int costoOro, String descripcion, int bonusDefensa) {
        super(nombre, costoOro, descripcion);
        this.bonusDefensa = bonusDefensa;
    }

    public int getBonusDefensa() {
        return this.bonusDefensa;
    }

    @Override
    public int getDefensa() {
        return this.bonusDefensa;
    }

    @Override
    public void jugar(Partida partida) {
        partida.activarTotem(this);
    }

    public void mostrarTotem() {
        System.out.println("-----------------------");
        System.out.println("Totem: " + this.getNombre());
        System.out.println("Costo: " + this.getCostoOro());
        System.out.println("Bonus defensa: +" + this.bonusDefensa);
        System.out.println(this.getDescripcion());
    }
}
