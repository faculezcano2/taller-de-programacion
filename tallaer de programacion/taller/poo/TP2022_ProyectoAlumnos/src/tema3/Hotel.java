/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;

/**
 *
 * @author Facu
 */

/*
4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/
2000 y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación
*/

public class Hotel {
    private int cantHab;
    private Habitacion [] habitaciones;//  = new Habitacion[cantHab];

    public Hotel(int N) {
        this.cantHab = N;
        this.habitaciones = new Habitacion[this.cantHab];
        GeneradorAleatorio.iniciar();
        
        for(int i = 0; i<this.cantHab; i++){
            Habitacion hab = new Habitacion();
            hab.setOcupada(false);
            hab.setCosto(GeneradorAleatorio.generarDouble(6000)+2000);
            this.habitaciones[i] = hab;
        }
    }
    
   /* public void setCantHabs(int N){
        this.cantHab = N;
    }
*/
    
    public void setClienteEnHabitacion(Persona c, int x){
        this.habitaciones[x].setPer(c);
        this.habitaciones[x].setOcupada(true);
        //this.habitaciones[x].setCosto(costo);
    }
    
    
    public void aumentarCostoTodasHabs(double costo){
        for(int i = 0; i<this.cantHab; i++){
            this.habitaciones[i].setCosto(costo);
        }
    }

    @Override
    public String toString() {
        String aux;
        for(int i=0;i<this.cantHab;i++){
            if(this.habitaciones[i].isOcupada()){
                aux  = "Habitacion "+i+": costo: "+ this.habitaciones[i].getCosto()+". Está ocupada?: "+this.habitaciones[i].isOcupada()+". Info persona que ocupa la habitacion: " + this.habitaciones[i].toString()+". ";
            }else{
                aux = "Habitacion "+i+": costo: "+ this.habitaciones[i].getCosto()+". Está ocupada?: "+this.habitaciones[i].isOcupada();
            }
            System.out.println(aux);
        }
        return "";
    }
    
    
    
    
    
}
