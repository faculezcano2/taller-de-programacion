/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10lezcano;

/**
 *
 * @author Facu
 */
public class Ej10lezcano {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroImpreso li= new LibroImpreso(true,"El principito", 200);
        LibroElectronico le = new LibroElectronico("jpg",20,"El principito",200);
        
        String a1 = "facundo";
        String a2 = "nilo";
        String a3 = "leandro";
        String a4 = "martina";
        String a5 = "veronica";
        String a6 = "leon";
                
        
        li.agregarAutor(a1);
        li.agregarAutor(a2);
        li.agregarAutor(a3);
        le.agregarAutor(a4);
        le.agregarAutor(a5);
        le.agregarAutor(a6);
        
        System.out.println(li.toString());
        System.out.println(le.toString());
        
    }
    
}
