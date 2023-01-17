/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej8;

/**
 *
 * @author Facu
 */
public class Pareja {
    private Participante p1;
    private Participante p2;
    private String estilo;

    public Pareja(Participante p1, Participante p2, String estilo) {
        this.p1 = p1;
        this.p2 = p2;
        this.estilo = estilo;
    }

    public Participante getP1() {
        return p1;
    }

    public Participante getP2() {
        return p2;
    }
    
    public String getEstilo(){
        return estilo;
    }

    public void setP1(Participante p1) {
        this.p1 = p1;
    }

    public void setP2(Participante p2) {
        this.p2 = p2;
    }
    
    public void setEstilo(String estilo){
        this.estilo = estilo;
    }
    
    public int difEdad(){
        int edad;
        edad = (this.p1.getEdad() - this.p2.getEdad());
        if(edad<0){
            edad = edad * -1;
        }
        return edad;
    }
}
