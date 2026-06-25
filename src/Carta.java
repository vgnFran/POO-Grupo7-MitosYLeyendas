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
        return this.nombre;
    }

    public int getCostoOro() {
        return this.costoOro;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void mostrarCarta() {
        System.out.println("-----------------------");
        System.out.println("Carta: " + this.nombre);
        System.out.println("Costo: " + this.costoOro);
        System.out.println(this.descripcion);
    }
}
