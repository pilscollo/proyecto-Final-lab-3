package app.Archivos;

import app.Contenedores.ContenedorEmpleados;
import app.Usuarios.Administrador;
import app.Usuarios.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ManejoDeArchivos {
    private String nombre;

    public ManejoDeArchivos(String nombre) {
        this.nombre = nombre;
    }

    /// pasar hashmap a archivo
    public void escribirArchivo(ContenedorEmpleados contenedor) {
        ArrayList<Empleado> listado= contenedor.pasarAlistado();
        try {

            FileOutputStream stream = new FileOutputStream(nombre);
            ObjectOutputStream objectOut = new ObjectOutputStream(stream);

            for (Empleado empleado : listado)
            {
                objectOut.writeObject(empleado);
            }
            objectOut.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void escribirArchivo(ArrayList<Empleado>listado) {

        try {

            FileOutputStream stream = new FileOutputStream(nombre);
            ObjectOutputStream objectOut = new ObjectOutputStream(stream);

            for (Empleado empleado : listado)
            {
                objectOut.writeObject(empleado);
            }
            objectOut.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public ContenedorEmpleados leer()
    {

        ArrayList<String> listadoLog=new ArrayList<String>();
        HashMap<Integer,Empleado> listado= new HashMap<>();
        try {

            FileInputStream stream = new FileInputStream(nombre);
            ObjectInputStream objectInput = new ObjectInputStream(stream);

            int i=1;
            while(i==1)
            {
                Empleado aux =(Empleado) objectInput.readObject();
                listado.put(aux.getId(),aux);
                if(aux instanceof Administrador)
                {
                    Administrador admin = (Administrador)aux;
                    listadoLog.add(admin.getLog());

                }
                listado.put(aux.getId(),aux);
            }

            objectInput.close();

        }
        catch (EOFException e)
        {

        }
        catch (FileNotFoundException e)
        {

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        ContenedorEmpleados contenedor= new ContenedorEmpleados(100,listado,listadoLog);

        return  contenedor;
    }
}
