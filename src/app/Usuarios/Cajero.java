package app.Usuarios;

import java.io.Serializable;

public class Cajero extends Empleado implements Serializable {
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
