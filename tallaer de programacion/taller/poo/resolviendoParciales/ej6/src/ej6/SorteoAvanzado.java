/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6;

/**
 *
 * @author Facu
 */
public class SorteoAvanzado extends Sorteo{

    public SorteoAvanzado(double premio) {
        super(premio);
    }
    
    public Persona ganador(){
        Persona [] vec = this.obtenerVec();
        double max = 0;
        Persona maxPer = new Persona("",0,0);
        for(int i=0;i<this.getDimL();i++){
            if(vec[i].getColaboracion()>max){
                max = vec[i].getColaboracion();
                maxPer.setNombre(vec[i].getNombre());
                maxPer.setDni(vec[i].getDni());
                maxPer.setColaboracion(vec[i].getColaboracion());
            }
        }
        return maxPer;
    }
    
}
