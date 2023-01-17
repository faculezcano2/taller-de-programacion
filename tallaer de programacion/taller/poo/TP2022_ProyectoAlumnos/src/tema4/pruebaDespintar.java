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
public class pruebaDespintar {
    public static void main(String[] args) {
        Circulo circ = new Circulo(3,"rojo","blanco");
        Triangulo tri = new Triangulo(2,4,6,"violeta","azul");
        System.out.println("circulo: "+ circ.toString()+". triangulo: "+tri.toString());
        
        circ.despintar();
        tri.despintar();
        System.out.println("circulo: "+ circ.toString()+". triangulo: "+tri.toString());

        
    }
    
}
