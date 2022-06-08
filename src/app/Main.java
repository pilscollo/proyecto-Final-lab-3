package app;

import app.Archivos.ManejoDeArchivos;
import app.Contenedores.ContenedorEmpleados;

import app.Excepciones.ExcepcionEstado;
import app.Excepciones.ExcepcionNombreUsuario;
import app.Excepciones.ExcepcionPassword;
import app.Usuarios.Administrador;
import app.Usuarios.Cajero;
import app.Usuarios.Empleado;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner  sc;
    public static void main(String[] args) {

        sc= new Scanner(System.in);

        ManejoDeArchivos archivoEmpleados= new ManejoDeArchivos("archivoEmpleados.bin");

        ContenedorEmpleados usuarios =archivoEmpleados.leer();
        Fichero fichero = new Fichero();
        Empleado empleadoLogueado = null;

        int op2= -1;
        int op=0;


        while(op2!=2)
        {
            System.out.println("1. ingresar \n2. salir");
            op2= sc.nextInt();
            if(op2== 1) {
                try {
                    System.out.println("Nombre: ");
                    String nombre = sc.next();
                    System.out.println("apellido: ");
                    String apellido = sc.next();
                    System.out.println("password: ");
                    String password = sc.next();


                    empleadoLogueado = fichero.ingresoUsuario(nombre, apellido, password);
                    System.out.println();
                } catch (ExcepcionPassword e ) {
                    System.out.println(e);
                    empleadoLogueado=null;

                }catch (ExcepcionNombreUsuario e)
                {
                    System.out.println(e);
                    empleadoLogueado=null;

                }catch (ExcepcionEstado e)
                {
                    System.out.println(e);
                    empleadoLogueado=null;
                }


                if(empleadoLogueado!=null)
                {
                    op=1;
                }
                    while (op != 0) {
                        sc.nextLine();
                        if (empleadoLogueado instanceof Administrador) {
                            Administrador admin = (Administrador) empleadoLogueado;
                            boolean rta1 = false;
                            System.out.println("\n0.salir\n1. dar de baja con id\n2.dar de baja con nombre y apellido\n3.dar de alta con id\n4.dar de alta con nombre y apellido\n5.agregar administrador\n6.agregar Cajero\n7.listar");
                            System.out.println("ingrese opción: ");
                            op = sc.nextInt();

                            switch (op) {
                                case 0:
                                    archivoEmpleados.escribirArchivo(fichero.pasarALista());
                                    break;
                                case 1:
                                    System.out.println("id usuario: ");
                                    int id = sc.nextInt();
                                    rta1 = fichero.darDeBaja(id, admin);

                                    if (rta1 == false) {
                                        System.out.println("id no encontrado");
                                    } else {
                                        System.out.println("dada de baja exitosa");
                                    }
                                    break;
                                case 2:
                                    System.out.println("nombre usuario: ");
                                    String nombre1 = sc.next();
                                    System.out.println("apellido usuario: ");
                                    String apellido1 = sc.next();
                                    rta1 = fichero.darDeBaja(nombre1, apellido1, admin);

                                    System.out.println(rta1);
                                    if (rta1 == false) {
                                        System.out.println("nombre y apellido no encontrado");
                                    } else {
                                        System.out.println("dada de baja exitosa");
                                    }
                                    break;
                                case 3:
                                    System.out.println("id usuario: ");
                                    id = sc.nextInt();
                                    rta1 = fichero.darDeAlta(id, admin);

                                    if (!rta1) {
                                        System.out.println("id no encontrado");
                                    } else {
                                        System.out.println("dada de alta exitosa");
                                    }
                                    break;
                                case 4:
                                    System.out.println("nombre usuario: ");
                                    nombre1 = sc.next();
                                    System.out.println("apellido usuario: ");
                                    apellido1 = sc.next();
                                    rta1 = fichero.darDeAlta(nombre1, apellido1, admin);

                                    System.out.println(rta1);
                                    if (!rta1) {
                                        System.out.println("nombre y apellido no encontrado");
                                    } else {
                                        System.out.println("dada de alta exitosa");
                                    }
                                    break;
                                case 5:
                                    System.out.println("nombre: ");
                                    String nombre = sc.next();
                                    System.out.println("apellido: ");
                                    String apellido = sc.next();
                                    System.out.println("password: ");
                                    String password = sc.next();
                                    System.out.println("log: ");
                                    String log = sc.next();
                                    rta1 = fichero.agregarUsuario(nombre, apellido, password, log, admin);
                                    if (rta1) {
                                        System.out.println("usuario agregado con exito");
                                    } else {
                                        System.out.println("usuario ya existente");
                                    }
                                    break;
                                case 6:
                                    System.out.println("nombre: ");
                                    nombre = sc.next();
                                    System.out.println("apellido: ");
                                    apellido = sc.next();
                                    System.out.println("password: ");
                                    password = sc.next();
                                    rta1 = fichero.agregarUsuario(nombre, apellido, password, admin);
                                    if (rta1) {
                                        System.out.println("usuario agregado con exito");
                                    } else {
                                        System.out.println("usuario ya existente");
                                    }
                                    break;
                                case 7:
                                    System.out.println(fichero.listar(admin));
                                    break;
                                default:
                                    System.out.println("opcion invalida: ");
                                    break;

                            }

                        } else if (empleadoLogueado instanceof Cajero) {

                            System.out.println("soy cajero");
                            op=0;
                        }
                    }
                }

            }


        }





    /// ingreso del usuario


}
