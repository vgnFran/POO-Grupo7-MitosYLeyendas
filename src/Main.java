import java.util.Scanner;

public void main(){

    Scanner scanner = new Scanner(System.in);

    // crear mazo
    Partida partida = new Partida();
    int opcion;

    do {
        mostrarMenu();
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default:
                System.out.println("Opcion incorrecta.");
        }

    } while (opcion != 9);


}

void mostrarMenu(){

//        1 - Levantar carta del mazo
//        2 - Mostrar cartas en mano
//        3 - Jugar carta de oro
//        4 - Bajar aliado a la linea de defensa
//        5 - Equipar arma a un aliado
//        6 - Activar totem
//        7 - Mostrar linea de defensa
//        8 - Mostrar estado del castillo
//        9 - Salir
}