import java.util.ArrayList;

public class Partida {

    private ArrayList<Carta> mano;
    private ArrayList<Aliado> lineaDeDefensa;
    private ArrayList<Totem> totemsActivos;

    private int reservaDeOro;
    private int defensaDelCastillo;

    public Partida() {

        this.mano = new ArrayList<>();
        this.lineaDeDefensa = new ArrayList<>();
        this.totemsActivos = new ArrayList<>();

        this.reservaDeOro = 0;
        this.defensaDelCastillo = 0;

    }

    public int getReservaDeOro() {
        return this.reservaDeOro;
    }

    public int getDefensaDelCastillo() {
        return this.defensaDelCastillo;
    }

    public void aumentarReservaOro(int cantidad) {
        this.reservaDeOro += cantidad;
    }

    public void aumentarDefensaCastillo(int cantidad) {
        this.defensaDelCastillo += cantidad;
        if (this.defensaDelCastillo < 0) {
            this.defensaDelCastillo = 0;
        }
    }

    public void agregarCartaAMano(Carta carta) {
        this.mano.add(carta);
        System.out.println(carta.getNombre() + " agregada a la mano.");
    }

    public void mostrarMano() {
        if (this.mano.isEmpty()) {
            System.out.println("La mano esta vacia.");
            return;
        }
        for (int i = 0; i < this.mano.size(); i++) {
            System.out.println("[" + i + "] " + this.mano.get(i).getNombre() + " - Costo: " + this.mano.get(i).getCostoOro());
        }
    }

    public void jugarCartaOro(int indice) {
        if (indice < 0 || indice >= this.mano.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        Carta carta = this.mano.get(indice);
        if (!(carta instanceof Oro)) {
            System.out.println("Esa carta no es de tipo Oro.");
            return;
        }
        Oro oro = (Oro) carta;
        oro.jugar(this);
        this.mano.remove(indice);
    }

    public void bajarAliado(Aliado aliado) {
        if (this.reservaDeOro < aliado.getCostoOro()) {
            System.out.println("No tenes oro suficiente para bajar a " + aliado.getNombre() + ".");
            return;
        }
        this.reservaDeOro -= aliado.getCostoOro();
        this.lineaDeDefensa.add(aliado);
        this.mano.remove(aliado);
        System.out.println(aliado.getNombre() + " bajado a la linea de defensa.");
    }

    public void equiparArma(int indiceAliado, int indiceArma) {
        if (indiceAliado < 0 || indiceAliado >= this.lineaDeDefensa.size()) {
            System.out.println("Aliado invalido.");
            return;
        }

        ArrayList<Arma> armasEnMano = new ArrayList<>();
        for (Carta c : this.mano) {
            if (c instanceof Arma) {
                armasEnMano.add((Arma) c);
            }
        }

        if (indiceArma < 0 || indiceArma >= armasEnMano.size()) {
            System.out.println("Arma invalida.");
            return;
        }

        Aliado aliado = this.lineaDeDefensa.get(indiceAliado);
        Arma arma = armasEnMano.get(indiceArma);

        arma.equiparEn(aliado);
        this.mano.remove(arma);
    }

    public void activarTotem(Totem totem) {
        if (this.reservaDeOro < totem.getCostoOro()) {
            System.out.println("No tenes oro suficiente para activar " + totem.getNombre() + ".");
            return;
        }
        this.reservaDeOro -= totem.getCostoOro();
        this.totemsActivos.add(totem);
        this.mano.remove(totem);
        System.out.println(totem.getNombre() + " activado.");
    }

    public void calcularDefensaCastillo() {
        int total = 0;
        for (Aliado aliado : this.lineaDeDefensa) {
            total += aliado.getDefensa();
        }
        for (Totem totem : this.totemsActivos) {
            total += totem.getDefensa();
        }
        this.defensaDelCastillo = total;
    }

    public void mostrarLineaDeDefensa() {
        if (this.lineaDeDefensa.isEmpty()) {
            System.out.println("La linea de defensa esta vacia.");
            return;
        }
        for (Aliado aliado : this.lineaDeDefensa) {
            aliado.mostrarAliado();
        }
    }

    public void jugarAliadoDesdeMano(int indice) {
        if (indice < 0 || indice >= this.mano.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        Carta carta = this.mano.get(indice);
        if (!(carta instanceof Aliado)) {
            System.out.println("Esa carta no es un Aliado.");
            return;
        }
        bajarAliado((Aliado) carta);
    }

    public void jugarTotemDesdeMano(int indice) {
        if (indice < 0 || indice >= this.mano.size()) {
            System.out.println("Indice invalido.");
            return;
        }
        Carta carta = this.mano.get(indice);
        if (!(carta instanceof Totem)) {
            System.out.println("Esa carta no es un Totem.");
            return;
        }
        activarTotem((Totem) carta);
    }

    public void mostrarArmasEnMano() {
        boolean hayArmas = false;
        int contador = 0;
        for (Carta c : this.mano) {
            if (c instanceof Arma) {
                System.out.println("[" + contador + "] " + c.getNombre() + " (Arma) - Bonus ataque: +" + ((Arma) c).getBonusAtaque());
                hayArmas = true;
            }
            contador++;
        }
        if (!hayArmas) {
            System.out.println("No hay armas en la mano.");
        }
    }

    public void mostrarEstadoGeneral() {
        System.out.println("=== ESTADO DE LA PARTIDA ===");
        System.out.println("Reserva de oro: " + this.reservaDeOro);
        this.calcularDefensaCastillo();
        System.out.println("Defensa del castillo: " + this.defensaDelCastillo);
        System.out.println("Cartas en mano: " + this.mano.size());
        System.out.println("Aliados en linea de defensa: " + this.lineaDeDefensa.size());
        System.out.println("Totems activos: " + this.totemsActivos.size());
    }

}
