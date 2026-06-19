import java.util.ArrayList;

public class Partida {

    private ArrayList<Carta> mano;
    private ArrayList<Aliado> lineaDeDefensa;
    private ArrayList<Totem> totemsActivos;

    private int reservaDeOro;
    private int defensaDelCastillo;

    public Partida() {

        mano = new ArrayList<>();
        lineaDeDefensa = new ArrayList<>();
        totemsActivos = new ArrayList<>();

        reservaDeOro = 0;
        defensaDelCastillo = 0;

    }

    public int getReservaDeOro() {
        return reservaDeOro;
    }

    public int getDefensaDelCastillo() {
        return defensaDelCastillo;
    }

    public void aumentarReservaOro(int cantidad) {

        reservaDeOro += cantidad;

    }

    public void aumentarDefensaCastillo(int cantidad) {

        defensaDelCastillo += cantidad;

        if (defensaDelCastillo < 0) {
            defensaDelCastillo = 0;
        }

    }

    public void agregarCartaAMano(Carta carta) {

        //completar

    }

    public void mostrarMano() {

        //completar

    }

    public void jugarCartaOro() {

        //completar

    }

    public void bajarAliado() {

        //completar

    }

    public void equiparArma() {

        //completar

    }

    public void activarTotem() {

        //completar

    }

    public void calcularDefensaCastillo() {

        //completar

    }

    public void mostrarEstadoGeneral() {

        //completar

    }

}
