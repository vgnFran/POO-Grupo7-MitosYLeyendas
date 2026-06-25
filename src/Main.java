import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MazoCastillo mazo = new MazoCastillo();
        cargarMazo(mazo);

        Partida partida = new Partida();
        int opcion;

        System.out.println("=== MITOS Y LEYENDAS: DEFENSA DEL CASTILLO ===");

        do {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    levantarCarta(mazo, partida);
                    break;
                case 2:
                    System.out.println("=== CARTAS EN MANO ===");
                    partida.mostrarMano();
                    break;
                case 3:
                    jugarOro(partida, scanner);
                    break;
                case 4:
                    bajarAliado(partida, scanner);
                    break;
                case 5:
                    equiparArma(partida, scanner);
                    break;
                case 6:
                    activarTotem(partida, scanner);
                    break;
                case 7:
                    System.out.println("=== LINEA DE DEFENSA ===");
                    partida.mostrarLineaDeDefensa();
                    break;
                case 8:
                    partida.mostrarEstadoGeneral();
                    break;
                case 9:
                    System.out.println("Saliendo del juego. Hasta la proxima!");
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente nuevamente.");
            }

        } while (opcion != 9);

        scanner.close();
    }

    static void mostrarMenu() {
        System.out.println();
        System.out.println("=== MENU ===");
        System.out.println("1 - Levantar carta del mazo");
        System.out.println("2 - Mostrar cartas en mano");
        System.out.println("3 - Jugar carta de oro");
        System.out.println("4 - Bajar aliado a la linea de defensa");
        System.out.println("5 - Equipar arma a un aliado");
        System.out.println("6 - Activar totem");
        System.out.println("7 - Mostrar linea de defensa");
        System.out.println("8 - Mostrar estado del castillo");
        System.out.println("9 - Salir");
        System.out.print("Seleccione una opcion: ");
    }

    static void cargarMazo(MazoCastillo mazo) {
        // Cartas de Oro
        mazo.agregarCarta(new Oro("Monedas del Reino", "Otorga 3 monedas de oro.", 3));
        mazo.agregarCarta(new Oro("Tesoro Antiguo", "Un cofre lleno de riquezas.", 5));
        mazo.agregarCarta(new Oro("Tributo del Pueblo", "El pueblo entrega sus ahorros.", 2));

        // Aliados
        mazo.agregarCarta(new Aliado("Caballero de Hierro", 4, "Un guerrero completamente blindado.", 5, 6));
        mazo.agregarCarta(new Aliado("Arquero Elfino", 3, "Punteria infalible desde lejos.", 4, 3));
        mazo.agregarCarta(new Aliado("Ogro Guardian", 5, "Una bestia que defiende la entrada.", 3, 8));

        // Armas
        mazo.agregarCarta(new Arma("Espada Llameante", 2, "Una espada que arde en combate.", 4));
        mazo.agregarCarta(new Arma("Hacha de Piedra", 1, "Un arma rustica pero efectiva.", 2));

        // Totems
        mazo.agregarCarta(new Totem("Totem del Escudo", 3, "Protege el castillo con un aura defensiva.", 5));
        mazo.agregarCarta(new Totem("Totem de la Tierra", 4, "La tierra misma defiende el castillo.", 7));

        // Talismanes
        mazo.agregarCarta(new Talisman("Talisman de Luz", 2, "Restaura la defensa del castillo.", 4));
        mazo.agregarCarta(new Talisman("Amuleto Ancestral", 3, "Un amuleto de gran poder defensivo.", 6));

        System.out.println("Mazo cargado con 12 cartas.");
    }

    static void levantarCarta(MazoCastillo mazo, Partida partida) {
        if (mazo.estaVacio()) {
            System.out.println("El mazo esta vacio, no hay mas cartas para levantar.");
            return;
        }
        Carta carta = mazo.levantarCarta();
        partida.agregarCartaAMano(carta);
        System.out.println("--- Carta levantada ---");
        carta.mostrarCarta();
    }

    static void jugarOro(Partida partida, Scanner scanner) {
        System.out.println("=== CARTAS EN MANO ===");
        partida.mostrarMano();
        System.out.print("Ingrese el indice de la carta de oro a jugar: ");
        int indice = scanner.nextInt();
        partida.jugarCartaOro(indice);
    }

    static void bajarAliado(Partida partida, Scanner scanner) {
        System.out.println("=== CARTAS EN MANO ===");
        partida.mostrarMano();
        System.out.print("Ingrese el indice del aliado a bajar: ");
        int indice = scanner.nextInt();
        partida.jugarAliadoDesdeMano(indice);
    }

    static void equiparArma(Partida partida, Scanner scanner) {
        System.out.println("=== ALIADOS EN LINEA DE DEFENSA ===");
        partida.mostrarLineaDeDefensa();
        System.out.print("Ingrese el indice del aliado al que equipar el arma: ");
        int indiceAliado = scanner.nextInt();

        System.out.println("=== ARMAS EN MANO ===");
        partida.mostrarArmasEnMano();
        System.out.print("Ingrese el indice del arma (indice de la mano): ");
        int indiceArma = scanner.nextInt();

        partida.equiparArma(indiceAliado, indiceArma);
    }

    static void activarTotem(Partida partida, Scanner scanner) {
        System.out.println("=== CARTAS EN MANO ===");
        partida.mostrarMano();
        System.out.print("Ingrese el indice del totem a activar: ");
        int indice = scanner.nextInt();
        partida.jugarTotemDesdeMano(indice);
    }
}
