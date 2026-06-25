public class Aliado extends Carta implements Jugable {

    private int ataque;
    private int defensa;
    private Arma armaEquipada;

    public Aliado(String nombre, int costoOro, String descripcion, int ataque, int defensa) {
        super(nombre, costoOro, descripcion);
        this.ataque = ataque;
        this.defensa = defensa;
        this.armaEquipada = null;
    }

    public int getAtaque() {
        if (this.armaEquipada != null) {
            return this.ataque + this.armaEquipada.getBonusAtaque();
        }
        return this.ataque;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public boolean tieneArma() {
        return this.armaEquipada != null;
    }

    public void equiparArma(Arma arma) {
        if (this.armaEquipada != null) {
            System.out.println(this.getNombre() + " ya tiene un arma equipada.");
            return;
        }
        this.armaEquipada = arma;
        System.out.println(arma.getNombre() + " equipada en " + this.getNombre() + ".");
    }

    @Override
    public void jugar(Partida partida) {
        partida.bajarAliado(this);
    }

    public void mostrarAliado() {
        System.out.println("-----------------------");
        System.out.println("Aliado: " + this.getNombre());
        System.out.println("Ataque: " + this.getAtaque());
        System.out.println("Defensa: " + this.defensa);
        System.out.println("Arma: " + (this.armaEquipada != null ? this.armaEquipada.getNombre() : "ninguna"));
    }
}
