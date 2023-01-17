/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Facu
 */
public class ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugadores jug1 = new Jugadores(10,7,"facundo",2000,2);
        Entrenadores ent1 = new Entrenadores(10,"nilo",2000,3);
        
        System.out.println(jug1.getGolesAnotados()/jug1.getPartJudados());
        System.out.println(jug1.toString());
        System.out.println(ent1.toString());
    }
    
}
