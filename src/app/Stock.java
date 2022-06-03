package app;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Stock<T extends Producto> {

    private HashMap <Integer ,T> stock;
    private int capacidad;
    private int ocupado;

    public Stock(int capacidad) {
        stock = new HashMap<>();
        this.capacidad = capacidad;
        ocupado = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOcupado() {
        return ocupado;
    }

    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }

    public boolean agregar(T producto) { // devulve false si no lo agrego
        boolean agregado = false;

        Integer codigo = producto.getCodigo();

        if(ocupado<capacidad && !(stock.containsKey(codigo))) {
            stock.put(codigo, producto);
            agregado = true;
            ocupado = ocupado + 1;
        }


        return agregado;
    }

    public boolean quitar(T producto) { // devuelve false si no lo quito
        boolean quitado = false;

        Integer codigo = producto.getCodigo();

        if(stock.remove(codigo) != null) {
            quitado = true;
            ocupado--;
        }

        return quitado;
    }

    public String mostrar() { // devuelve un string con la lista de productos
        StringBuilder mapa = new StringBuilder();

        Iterator iterador = stock.entrySet().iterator();

        while(iterador.hasNext()) {
            Map.Entry<Integer, T> entrada = (Entry<Integer, T>) iterador.next();
            Integer clave = entrada.getKey();
            T producto = entrada.getValue();
            mapa.append(producto.toString()+"\n");
        }

        String lista = mapa.toString();
        return lista;
    }

    public T buscar(Integer clave) { //devuelve null si no lo encuentra
        T rta = null;
        if(stock.containsKey(clave)) {
            rta = stock.get(clave);
        }

        return rta;
    }

    public int espacioDisponible() {
        return capacidad-ocupado;
    }

}