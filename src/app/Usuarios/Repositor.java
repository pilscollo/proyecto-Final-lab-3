package app.Usuarios;

public class Repositor extends Empleado {
    public Repositor( String nombre, String apellido) {
        super( nombre, apellido, "repositor");
    }

    @Override
    public String toString() {
        return super.toString()+ " " + " puesto: Repositor";
    }
}
