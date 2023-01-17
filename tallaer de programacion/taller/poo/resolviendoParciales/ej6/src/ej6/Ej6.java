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
 * 
 * 21)
Representar dos tipos de sorteos solidarios: común y avanzado. Ambos sorteos 
mantienen el valor en pesos del premio y guardan para cada bono (0..99) la información 
de la persona a la que fue asignado (nombre, dni y colaboración en pesos). Sin embargo, 
difieren en cierta funcionalidad (se detalla más adelante).
Lea 1 y 2 atentamente y luego implemente.
1- Genere las clases necesarias. Provea constructores para iniciar los sorteos a partir del 
premio en pesos (los bonos inicialmente no están asignados a nadie).
2- Implemente los métodos necesarios, en las clases que corresponda, para:
a. Agregar una persona al sorteo, devolviendo el nro. de bono que le tocó. Los nros. de 
bono se reparten en forma consecutiva comenzando de 0. Asuma que hay un nro. de 
bono disponible.
b. Obtener la persona que compró el nro. de bono B. Asuma que B es un nro. de bono 
válido.
c. Ejecutar el sorteo, devolviendo la persona ganadora, teniendo en cuenta que: en los 
sorteos comunes se elige el nro. de bono ganador aleatoriamente entre los nros. 
repartidos; en los sorteos avanzados la persona ganadora será la que aportó mayor 
colaboración en pesos.
3- Realice un programa que instancie un sorteo común y un sorteo avanzado con premio 
50.000$. Agregue personas a cada sorteo. Ejecute ambos sorteos e imprima la 
información obtenida de la ejecución. 
 * 
 * 
 * 
 * 
 */
public class Ej6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SorteoComun sc = new SorteoComun(50000);
        SorteoAvanzado sa = new SorteoAvanzado(50000);
        
        Persona per1 = new Persona("facundo",42027949,1000);
        Persona per2 = new Persona("martina",48027949,12009);
        Persona per3 = new Persona("veronica",24027949,100);
        Persona per4 = new Persona("nilo",4027949,10);
        
        
        
        sc.ingresaPersonaAlSorteo(per1);
        sc.ingresaPersonaAlSorteo(per2);
        sc.ingresaPersonaAlSorteo(per3);
        sc.ingresaPersonaAlSorteo(per4);
        sa.ingresaPersonaAlSorteo(per1);
        sa.ingresaPersonaAlSorteo(per2);
        sa.ingresaPersonaAlSorteo(per3);
        sa.ingresaPersonaAlSorteo(per4);
        
        System.out.println(sc.toString());
        System.out.println(sa.toString());
    }
    
}
