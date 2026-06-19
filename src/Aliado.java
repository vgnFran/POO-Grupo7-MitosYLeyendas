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
        if (armaEquipada != null) {
            return ataque + armaEquipada.getBonusAtaque();
        }
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public boolean tieneArma() {
        return armaEquipada != null;
    }

    public void equiparArma(Arma arma) {
        if (armaEquipada != null) {
            System.out.println(getNombre() + " ya tiene un arma equipada.");
            return;
        }
        armaEquipada = arma;
        System.out.println(arma.getNombre() + " equipada en " + getNombre() + ".");
    }

    @Override
    public void jugar(Partida partida) {
        partida.bajarAliado();
    }

    public void mostrarAliado() {
        System.out.println("-----------------------");
        System.out.println("Aliado: " + getNombre());
        System.out.println("Ataque: " + getAtaque());
        System.out.println("Defensa: " + defensa);
        System.out.println("Arma: " + (armaEquipada != null ? armaEquipada.getNombre() : "ninguna"));
    }
}