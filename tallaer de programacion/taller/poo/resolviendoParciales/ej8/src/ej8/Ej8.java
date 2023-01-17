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
public class Ej8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso con = new Concurso(4);
        
        Participante p1 = new Participante(42027949,"facundo",23);
        Participante p2 = new Participante(40027949,"mariana",20);
        Participante p3 = new Participante(46027949,"ignacio",19);
        Participante p4 = new Participante(44027949,"martina",17);
        
        Pareja par1 = new Pareja(p1,p2,"cumbia");
        
        Pareja par2 = new Pareja(p3,p4,"bachata");
        
        con.agregarPareja(par1);
        con.agregarPareja(par2);
        
        
        System.out.println("Pareja que mas dif de edad tiene en el torneo:\n participante1: "+ con.difMasEdad().getP1().getNombre() + ".\n participante2:" + con.difMasEdad().getP2().getNombre());
    }
    
}
