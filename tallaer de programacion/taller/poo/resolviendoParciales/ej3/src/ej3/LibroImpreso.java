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
public class LibroImpreso extends Libro{
    private boolean tapaDura;

    public LibroImpreso(boolean tapaDura, String titulo, double precio) {
        super(titulo, precio);
        this.tapaDura = tapaDura;
    }

    public boolean isTapaDura() {
        return tapaDura;
    }

    public void setTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }
    
    
    public double obtenerPrecio(){
        double precio;
        if(this.isTapaDura()){
            precio = this.getPrecio() + 500;
        }else{
            precio = this.getPrecio();
        }
        return precio;
    }
}
