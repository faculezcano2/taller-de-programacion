/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10lezcano;

/**
 *
 * @author Facu
 */
public class LibroElectronico extends Libro{
    private String formato;
    private double pesoMB;

    public LibroElectronico(String formato, double pesoMB, String titulo, double precioBase) {
        super(titulo, precioBase);
        this.formato = formato;
        this.pesoMB = pesoMB;
    }

    public String getFormato() {
        return formato;
    }

    public double getPesoMB() {
        return pesoMB;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setPesoMB(double pesoMB) {
        this.pesoMB = pesoMB;
    }
    
    public double precio(){
        return(this.getPrecioBase()+(this.getPesoMB()*2.5));
    }
}
