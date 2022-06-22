package app;


import app.Contenedores.Stock;
import app.GestionDeCaja.Producto;

import java.util.ArrayList;
import java.util.Date;

public class App {
    private Stock<Producto> stock1;
    private Stock<Producto> stock2;
    private Stock<Producto> stock3;
    private double recaudacion;
    private ArrayList<Ticket> tickets;

    public App()  {
        stock1 = new Stock<>(100);
        stock2 = new Stock<>(100);
        stock3 = new Stock<>(100);
        Producto producto = new Producto("leche",232,231,2,"litro",2,"heladera",new Date(1,1,1));
        Producto producto2 = new Producto("carne picada",231,31,4,"kilo",2,"carnes",new Date(4,4,5));
        Producto producto3= new Producto("lavandina",233,21,3,"litro",2,"limpieza",new Date(3,2,2));
        agregarForzado(producto);
        agregarForzado(producto2);
        agregarForzado(producto3);
        recaudacion = 0;
        tickets = new ArrayList<>();
    }


    public void agregarForzado(Producto producto)
    {
        switch (producto.getSeccion()) {
            case "heladera" -> stock1.agregar(producto);
            case "carnes" -> stock2.agregar(producto);
            case "limpieza" -> stock3.agregar(producto);
        }
    }

    public void comprar(Producto productoElegido, Ticket ticket)
    {
        if (productoElegido != null) {
            ticket.generarProducto(productoElegido);
            productoElegido.setStock(productoElegido.getStock()-1);
            recaudacion+= productoElegido.getPrecio();
        }
    }

    public void finalizarCompra(Ticket ticket)
    {
        tickets.add(ticket);
    }


    public Producto devolverProducto(int codigo)
    {
        Producto producto;
        if(stock1.buscar(codigo)!=null) {
            producto=stock1.buscar(codigo);
            return producto;
        }else if(stock2.buscar(codigo)!=null){
            producto=stock2.buscar(codigo);
            return producto;
        }else if(stock3.buscar(codigo)!=null){
            producto=stock3.buscar(codigo);
            return producto;
        }else return null;
    }

    public String mostrarHeladera()
    {
        return stock1.mostrar();
    }
    public String mostrarCarne()
    {
        return stock2.mostrar();
    }
    public String mostrarLegumbres()
    {
        return stock3.mostrar();
    }

    public String mostrar()
    {
        return "heladera :\n"+ stock1.mostrar() + "\n"+"carnes :\n"+stock2.mostrar()+"\nlimpieza :\n"+stock3.mostrar();
    }

    public String agregar(String nombre,Integer codigo, double precio, int stock, String unidadMedida, double cantidadMedida,String seccion,Date fechaVencimiento)
    {
        Producto producto= new Producto(nombre,codigo,precio,stock,unidadMedida,cantidadMedida,seccion,fechaVencimiento);
        String agregadoCorrecto = "producto agregado";
        String resultado = "seccion no encontrada, intente nuevamente";

        switch (seccion) {
            case "heladera" -> {
                stock1.agregar(producto);
                resultado = agregadoCorrecto;
            }
            case "carnes" -> {
                stock2.agregar(producto);
                resultado = agregadoCorrecto;
            }
            case "limpieza" -> {
                stock3.agregar(producto);
                resultado = agregadoCorrecto;
            }
        }
        return resultado;
    }

    public String eliminar(int codigo)
    {
        Producto producto = devolverProducto(codigo);
        String retorno = "se quito el producto";
        String resultado = "error en quitar el producto";

        if (stock1.quitar(producto))
        {
            resultado= retorno;
        }else if(stock2.quitar(producto)){
            resultado= retorno;
        }
        else if(stock3.quitar(producto)){
            resultado= retorno;
        }
        return resultado;
    }

    public void abrirCaja(String nombre)
    {
        //ManejoDeArchivos archivoStock = new ManejoDeArchivos(nombre);
        //this.stock= archivoStock.leerP();
    }

    public boolean modificarProducto(int codigo, String nombreM, int codigoM, double precioM, int stockM, String unidadDeMedidaM, double cantidadDeMedidaM, Date fechaNuevo)
    {
        boolean on = false;
        if(stock1.buscar(codigo)!=null) {
            stock1.modificarNombreProducto(codigo,nombreM);
            stock1.modificarCodigoProducto(codigo,codigoM);
            stock1.modificarPrecioProducto(codigo,precioM);
            stock1.modificarStockProducto(codigo,stockM);
            stock1.modificarMedidaProducto(codigo,unidadDeMedidaM,cantidadDeMedidaM);
            stock1.modificarVencimientoAlimento(codigo,fechaNuevo);
            on = true;
        }else if(stock2.buscar(codigo)!=null){
            stock2.modificarNombreProducto(codigo,nombreM);
            stock2.modificarCodigoProducto(codigo,codigoM);
            stock2.modificarPrecioProducto(codigo,precioM);
            stock2.modificarStockProducto(codigo,stockM);
            stock2.modificarMedidaProducto(codigo,unidadDeMedidaM,cantidadDeMedidaM);
            stock2.modificarVencimientoAlimento(codigo,fechaNuevo);
            on = true;
        }else if(stock3.buscar(codigo)!=null){
            stock3.modificarNombreProducto(codigo,nombreM);
            stock3.modificarCodigoProducto(codigo,codigoM);
            stock3.modificarPrecioProducto(codigo,precioM);
            stock3.modificarStockProducto(codigo,stockM);
            stock3.modificarMedidaProducto(codigo,unidadDeMedidaM,cantidadDeMedidaM);
            stock3.modificarVencimientoAlimento(codigo,fechaNuevo);
            on = true;
        }
        return on;
    }

    public boolean agregarStock(int codigo,int cantidad)
    {
        boolean on = false;
        if(stock1.buscar(codigo)!=null) {
            stock1.agregarStockProducto(codigo,cantidad);
            on = true;
        }else if(stock2.buscar(codigo)!=null){
            stock2.agregarStockProducto(codigo,cantidad);
            on = true;
        }else if(stock3.buscar(codigo)!=null){
            stock3.agregarStockProducto(codigo,cantidad);
            on = true;
        }
        return on;
    }

    public boolean quitarStock(int codigo,int cantidad)
    {
        boolean on = false;
        if(stock1.buscar(codigo)!=null) {
            stock2.quitarStockProducto(codigo,cantidad);
            on = true;
        }else if(stock2.buscar(codigo)!=null){
            stock2.quitarStockProducto(codigo,cantidad);
            on = true;
        }else if(stock3.buscar(codigo)!=null){
            stock3.quitarStockProducto(codigo,cantidad);
            on = true;
        }
        return on;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

}
