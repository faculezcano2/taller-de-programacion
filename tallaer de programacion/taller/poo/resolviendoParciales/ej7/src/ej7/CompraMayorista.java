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
public class CompraMayorista extends Compra{
    private int cuit;

    public CompraMayorista(int nro, int dimF, int cuit) {
        super(nro, dimF);
       this.cuit = cuit;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    
    
    public double obtenerPrecioAPagar(int i){
        return (this.obtenerProducto(i).getPrecioMayotista()-(this.obtenerProducto(i).getPrecioMayotista()*0.21));
        
    }
}
