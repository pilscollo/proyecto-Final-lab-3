package app;

import java.util.Date;

public class Alimento extends Producto{

    private Date fechaDeVencimiento;

    public Alimento(String nombre, int codigo, double precio, Integer stock, String unidadDeMedida, double cantidadDeMedida, Date fechaDeVencimiento) {
        super(nombre, codigo, precio, stock, unidadDeMedida, cantidadDeMedida);
        this.fechaDeVencimiento = fechaDeVencimiento;
    }



    public String getFechaDeVencimiento() {
        return fechaDeVencimiento.toString();
    }



    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }



    @Override
    public String toString() {
        return super.toString()+"\nfecha de vencimiento: "+fechaDeVencimiento;
    }

}