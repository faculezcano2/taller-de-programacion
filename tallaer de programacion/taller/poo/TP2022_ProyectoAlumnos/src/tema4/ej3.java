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
public class ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona per = new Persona("facundo",42027949,22);
        Trabajadores trab = new Trabajadores("jardinero","nilo",2677267,4);
        
        
        System.out.println(per.toString());
        System.out.println(trab.toString());
    }
    
}
