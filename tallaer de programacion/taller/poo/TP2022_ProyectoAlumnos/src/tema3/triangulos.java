/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Hewlett-Packard
 */

import PaqueteLectura.Lector;

public class triangulos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese el valor del primer lado: ");
        double lado1 = Lector.leerDouble();
        System.out.println("Ingrese el valor del segundo lado: ");
        double lado2 = Lector.leerDouble();
        System.out.println("Ingrese el valor del tercer lado: ");
        double lado3 = Lector.leerDouble();
        System.out.println("Ingrese el color de relleno: ");
        String relleno = Lector.leerString();
        System.out.println("Ingrese el color de linea: ");
        String linea = Lector.leerString();
        
        triangulo tri = new triangulo(lado1,lado2,lado3,relleno,linea);
        
        System.out.println("El perimetro del triangulo es: " + tri.calcularPerimetro());
        System.out.println("El area del triangulo es: " + tri.calcularArea());
        
        System.out.println(tri.toString());
    }
    
}
