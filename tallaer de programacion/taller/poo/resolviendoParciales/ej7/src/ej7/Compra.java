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
public abstract class Compra {
    private int nro;
    private int dimF;
    private int diml;
    private Producto [] vecProductos;

    public Compra(int nro, int dimF) {
        this.nro = nro;
        this.dimF = dimF;
        this.diml = 0;
        this.vecProductos = new Producto[this.dimF];
    }

    public int getNro() {
        return nro;
    }

    public int getDimF() {
        return dimF;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setDimF(int dimF) {
        this.dimF = dimF;
    }

    
    public int getDiml(){
        return diml;
    }
    
  
    
    public void agregarProducto(Producto pro){
        this.vecProductos[this.diml] = pro;
        this.diml++;
    }
    
    public Producto obtenerProducto(int i){
        return this.vecProductos[i];
    }
    
    public abstract double obtenerPrecioAPagar(int i);

    @Override
    public String toString() {
        String productos = " ";
        double total = 0;
        for(int i=0;i<this.diml;i++){
            productos = productos + " codigo: "+this.vecProductos[i].getCodigo()+" precio pagado por este producto: "+ this.obtenerPrecioAPagar(i)+"\n";
            total = total + this.obtenerPrecioAPagar(i);
        }
        return "nro= " + this.nro + ". Productos:\n "+ productos + ". Total a pagar: "+ total;
    }
    
    
    
    
}
