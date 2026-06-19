public abstract class Carta {

    private String nombre;
    private int costoOro;
    private String descripcion;

    public Carta(String nombre, int costoOro, String descripcion) {
        this.nombre = nombre;
        this.costoOro = costoOro;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoOro() {
        return costoOro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void mostrarCarta() {
        System.out.println("-----------------------");
        System.out.println("Carta: " + nombre);
        System.out.println("Costo: " + costoOro);
        System.out.println(descripcion);
    }
}
