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
public class CompraMinorista extends Compra{

    private boolean jubilado;

    public CompraMinorista(boolean jubilado, int nro, int dimF) {
        super(nro, dimF);
        this.jubilado = jubilado;
    }

    public boolean isJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    
    public double obtenerPrecioAPagar(int i){
        double aux;
        if(this.isJubilado()){
            aux = (this.obtenerProducto(i).getPrecioMinorista()-(this.obtenerProducto(i).getPrecioMinorista()*0.1));
        }else{
            aux = this.obtenerProducto(i).getPrecioMinorista();
        }
        return aux;
    }
}
