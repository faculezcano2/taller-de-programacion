/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

/**
 *
 * @author Facu
 */
public class Trayectoria extends Premiaciones{

    public Trayectoria(int dimF) {
        super(dimF);
    }
    
    
    public  String otorgarPremio(int x){
        String aux="";
        for(int i=0;i<this.getDimL();i++){
            if(this.getPostulante(i).getAntiguedad()>x){
                aux = aux + this.getPostulante(i).getNombre()+"\n";
            }
        }
        return aux;
    }
}
