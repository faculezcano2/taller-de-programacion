/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

/**
 *
 * @author Facu
 */


/*
4- Una escuela de música arma coros para participar de ciertos eventos. Los coros poseen 
un nombre y están formados por un director y una serie de coristas. Del director se 
conoce el nombre, DNI, edad y la antigüedad (un número entero). De los coristas se conoce 
el nombre, DNI, edad y el tono fundamental (un número entero). Asimismo, hay dos tipos 
de coros: coro semicircular en el que los coristas se colocan en el escenario uno al lado 
del otro y coro por hileras donde los coristas se organizan en filas de igual dimensión.
a. Implemente las clases necesarias teniendo en cuenta que los coros deberían crearse 
con un director y sin ningún corista, pero sí sabiendo las dimensiones del coro.
b. Implemente métodos (en las clases donde corresponda) que permitan:
 agregar un corista al coro. 
o En el coro semicircular los coristas se deben ir agregando de izquierda 
a derecha
o En el coro por hileras los coristas se deben ir agregando de izquierda a 
derecha, completando la hilera antes de pasar a la siguiente.
 determinar si un coro está lleno o no. Devuelve true si el coro tiene a todos sus 
coristas asignados o false en caso contrario.
 determinar si un coro (se supone que está lleno) está bien formado. Un coro 
está bien formado si:
o En el caso del coro semicircular, de izquierda a derecha los coristas 
están ordenados de mayor a menor en cuanto a tono fundamental. 
o En el caso del coro por hileras, todos los miembros de una misma hilera 
tienen el mismo tono fundamental y además todos los primeros
miembros de cada hilera están ordenados de mayor a menor en cuanto 
a tono fundamental.
 devolver la representación de un coro formada por el nombre del coro, todos 
los datos del director y todos los datos de todos los coristas.





c. Escriba un programa que instancie un coro de cada tipo. Lea o bien la cantidad de 
coristas (en el caso del coro semicircular) o la cantidad de hileras e integrantes por 
hilera (en el caso del coro por hileras). Luego cree la cantidad de coristas necesarios,
leyendo sus datos, y almacenándolos en el coro. Finalmente imprima toda la 
información de los coros indicando si están bien formados o no
*/



public class Ej4 {
    public static void main(String[] args) {
        Persona dir1 = new Persona("facundo",42027949,22,4);
        Persona dir2 = new Persona("leandro",41028282,24,3);
        
        Persona cori1 = new Persona("veronica",42027949,22,4);
        Persona cori2 = new Persona("franco",4111111,12,1);
        Persona cori3 = new Persona("nahuel",4222222,62,2);
        Persona cori4 = new Persona("ramiro",4333333,32,3);
        Persona cori5 = new Persona("nilo",444444,26,4);
        Persona cori6 = new Persona("martina",4555555,22,4);
        
        CoroPorHileras coro1 = new CoroPorHileras(3,3,"coro1",dir1);
        CoroSemiCircular coro2 = new CoroSemiCircular(5,"coro2",dir2); 
        
        coro1.agregarCorista(cori1);
        coro1.agregarCorista(cori2);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        coro1.agregarCorista(cori6);
        
        
        
        
        
        coro2.agregarCorista(cori3);
        coro2.agregarCorista(cori4);
        coro2.agregarCorista(cori5);
        coro2.agregarCorista(cori6);
        
        System.out.println(coro1.estaOrdenado());
        System.out.println(coro2.estaOrdenado());
        System.out.println(coro1.toString());
        System.out.println(coro2.toString());
    }
    
}
