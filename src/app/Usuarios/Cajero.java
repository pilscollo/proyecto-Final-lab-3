package app.Usuarios;

public class Cajero extends Empleado {
    public Cajero( String nombre, String apellido, String password) {
        super( nombre, apellido, password);
    }

    // abrir caja
    // cerrar caja
    @Override
    public String toString() {
        return super.toString()+ " " + " puesto: Cajero";
    }
}
