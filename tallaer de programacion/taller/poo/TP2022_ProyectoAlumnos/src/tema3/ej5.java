/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Facu
 */
import PaqueteLectura.Lector;
public class ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("ingrese el radio del circulo: ");
        double radio = Lector.leerDouble();
        System.out.println("ingrese el color de relleno del circulo: ");
        String colorRelleno =  Lector.leerString();
        System.out.println("ingrese el color de la linea del circulo: ");
        String colorLinea =  Lector.leerString();
        Circulo circ = new Circulo(radio,colorRelleno,colorLinea);
        
        System.out.println("area: "+circ.calcularArea()+"perimetri: "+circ.calcularPerimetro());
    }
    
}
