package app;
public class Producto {

    //ATRIBUTOS
    private String nombre;
    private Integer codigo;
    private double precio;
    private int stock;
    private String unidadDeMedida; // kg, lt, gr, unidades
    private double cantidadDeMedida; // cantidad de la unidad de medida

    //CONSTRUcTOR
    public Producto(String nombre, Integer codigo, double precio, int stock, String unidadDeMedida, double cantidadDeMedida) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.stock = stock;
        this.unidadDeMedida = unidadDeMedida;
        this.cantidadDeMedida = cantidadDeMedida;
    }

    //GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public double getCantidadDeMedida() {
        return cantidadDeMedida;
    }

    public void setCantidadDeMedida(double cantidadDeMedida) {
        this.cantidadDeMedida = cantidadDeMedida;
    }

    public String medida() {
        return (cantidadDeMedida+" "+unidadDeMedida);
    }

    //METODOS

    @Override
    public String toString() {
        return("nombre: "+ nombre+ " "+ this.medida()+ "\ncodigo: "+ codigo+"\nprecio: "+ precio+"\ndisponibles: "+ stock);
    }

}