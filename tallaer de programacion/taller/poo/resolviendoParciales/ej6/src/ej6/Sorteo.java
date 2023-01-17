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
public abstract class Sorteo {
    private double premio;
    private int dimL;
    private Persona [] vecPersonas;

    public Sorteo(double premio) {
        this.premio = premio;
        this.dimL = 0;
        this.vecPersonas = new Persona[99]; 
    }

    public double getPremio() {
        return premio;
    }

    public int getDimL() {
        return dimL;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }
    
    
    public int ingresaPersonaAlSorteo(Persona per){
        this.vecPersonas[this.dimL] = per;
        this.dimL++;
        return this.dimL-1;
    }
    
    public Persona quePersonaComproTalNum(int b){
        Persona per = this.vecPersonas[b];
        return per;
    }
    
    
    public Persona[] obtenerVec(){
        return this.vecPersonas;
    }
    
    public abstract Persona ganador();

    @Override
    public String toString() {
        return "Ganador del sorteo es : "+ this.ganador().toString() + " ganando la suma de: "+ this.getPremio();
    }
    
    
}
