/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Facu
 */
public class LibroElectronico extends Libro {
    private String formato;
    private double mb;

    public LibroElectronico(String formato,double mb, String titulo, double precio) {
        super(titulo, precio);
        this.formato = formato;
        this.mb = mb;
    }

    public String getFormato() {
        return formato;
    }

    public double getMb() {
        return mb;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }

    public double obtenerPrecio(){
        return ((this.getMb()*2.5)+this.getPrecio());
    }
}
