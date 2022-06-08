package app.Archivos;

import app.Contenedores.ContenedorEmpleados;
import app.Producto;
import app.Contenedores.Stock;
import app.Usuarios.Administrador;
import app.Usuarios.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

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
    public void escribirArchivoP(ArrayList<Producto>listado) {

        try {

            FileOutputStream stream = new FileOutputStream(nombre);
            ObjectOutputStream objectOut = new ObjectOutputStream(stream);

            for (Producto producto : listado)
            {
                objectOut.writeObject(producto);
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
    public Stock<Producto> leerP()
    {

        HashMap<Integer,Producto> listado= new HashMap<>();

        try {

            FileInputStream stream = new FileInputStream(nombre);
            ObjectInputStream objectInput = new ObjectInputStream(stream);

            int i=1;
            while(i==1)
            {
                Producto aux =(Producto) objectInput.readObject();

                listado.put(aux.getCodigo(),aux);
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
        Stock<Producto> contenedor= new Stock<>(listado);

        return  contenedor;
    }
}
