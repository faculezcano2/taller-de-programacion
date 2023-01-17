/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

/**
 *
 * @author Facu
 */
public class Producto {
    private int codigo;
    private double precioMayotista;
    private double precioMinorista;

    public Producto(int codigo, double precioMayotista, double precioMinorista) {
        this.codigo = codigo;
        this.precioMayotista = precioMayotista;
        this.precioMinorista = precioMinorista;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecioMayotista() {
        return precioMayotista;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecioMayotista(double precioMayotista) {
        this.precioMayotista = precioMayotista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }

    
}
