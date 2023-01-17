/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej6;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Facu
 */
public class SorteoComun extends Sorteo{

    public SorteoComun(double premio) {
        super(premio);
    }
    
    public Persona ganador(){
        GeneradorAleatorio.iniciar();
        int num = GeneradorAleatorio.generarInt(4);
        Persona [] vec = this.obtenerVec();
        return vec[num];
    }

    
}
