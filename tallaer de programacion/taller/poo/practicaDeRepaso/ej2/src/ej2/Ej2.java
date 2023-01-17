/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

/**
 *
 * @author Facu
 */
/*
2- Queremos un sistema para gestionar estacionamientos. Un estacionamiento conoce su
nombre, dirección, hora de apertura, hora de cierre, y almacena para cada número de piso
(1..N) y número de plaza (1..M), el auto que ocupa dicho lugar. De los autos se conoce
nombre del dueño y patente.
a) Genere las clases, incluyendo getters y setters adecuados.
b) Implemente constructores. En particular, para el estacionamiento:
- Un constructor debe recibir nombre y dirección, e iniciar el estacionamiento
con hora de apertura “8:00”, hora de cierre “21:00”, y para 5 pisos y 10 plazas
por piso. El estacionamiento inicialmente no tiene autos.
- Otro constructor debe recibir nombre, dirección, hora de apertura, hora de
cierre, el número de pisos (N) y el número de plazas por piso (M) e iniciar el
estacionamiento con los datos recibidos y sin autos.
c) Implemente métodos para:
- Dado un auto A, un número de piso X y un número de plaza Y, registrar al auto
en el estacionamiento en el lugar X,Y. Suponga que X, Y son válidos (es decir,
están en rango 1..N y 1..M respectivamente) y que el lugar está desocupado.
- Dada una patente, obtener un String que contenga el número de piso y plaza
donde está dicho auto en el estacionamiento. En caso de no encontrarse,
retornar el mensaje “Auto Inexistente”.
- Obtener un String con la representación del estacionamiento. Ejemplo: “Piso 1
Plaza 1: libre Piso 1 Plaza 2: representación del auto …
 Piso 2 Plaza 1: libre … etc”
- Dado un número de plaza Y, obtener la cantidad de autos ubicados en dicha
plaza (teniendo en cuenta todos los pisos).



d) Realice un programa que instancie un estacionamiento con 3 pisos y 3 plazas por piso.
Registre 6 autos en el estacionamiento en distintos lugares.
Muestre la representación String del estacionamiento en consola.
Muestre la cantidad de autos ubicados en la plaza 1.
Lea una patente por teclado e informe si dicho auto se encuentra en el
estacionamiento o no. En caso de encontrarse, la información a imprimir es el piso y
plaza que ocupa.

*/

import PaqueteLectura.Lector;
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estacionamiento estacio = new Estacionamiento("Estacionamiento FACU", "7 y 48", "8:00", "21:30", 3, 3);
        
        Auto auto1 = new Auto("facundo","111");
        Auto auto2 = new Auto("leandro","222");
        Auto auto3 = new Auto("nilo","333");
        Auto auto4 = new Auto("martina","444");
        Auto auto5 = new Auto("veronica","555");
        Auto auto6 = new Auto("diego","666");
        
        estacio.setAutoEnLugar(auto1, 0, 0);
        estacio.setAutoEnLugar(auto2, 0, 1);
        estacio.setAutoEnLugar(auto3, 1, 2);
        estacio.setAutoEnLugar(auto4, 2, 1);
        estacio.setAutoEnLugar(auto5, 1, 1);
        estacio.setAutoEnLugar(auto6, 0, 1);
        
        System.out.println("Muestre la representación String del estacionamiento en consola:");
        System.out.println(estacio.toString());
        
        System.out.println(estacio.cantAutosEnPlaza(1));
        
        System.out.println("Ingrese la patente a buscar: ");
        String patente = Lector.leerString();
        System.out.println(estacio.buscarAuto(patente));
        
    }
    
}
