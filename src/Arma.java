public class Arma extends Carta implements Equipable {

    private int bonusAtaque;

    public Arma(String nombre, int costoOro, String descripcion, int bonusAtaque) {
        super(nombre, costoOro, descripcion);
        this.bonusAtaque = bonusAtaque;
    }

    public int getBonusAtaque() {
        return bonusAtaque;
    }

    @Override
    public void equiparEn(Aliado aliado) {
        aliado.equiparArma(this);
    }

    @Override
    public void mostrarCarta() {
        super.mostrarCarta();
        System.out.println("Bonus de ataque: +" + bonusAtaque);
    }
}