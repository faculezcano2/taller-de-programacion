/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

/**
 *
 * @author Facu
 */
/*
5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:
getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate
Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local.
*/

import PaqueteLectura.Lector;

public class ej4 {
    public static void main(String[] args){
        int dimF = 20;
        Partido [] vec = new Partido [dimF];
        
        System.out.println("Ingrese el nombre del visitante: ");
        String nomVisitante = Lector.leerString();
        int dimL=0;
        while((dimL<dimF) && (!nomVisitante.equals("zzz"))){
            vec[dimL] = new Partido();
            vec[dimL].setVisitante(nomVisitante);
            
            System.out.println("Ingrese el nombre del local: ");
            String nomLocal = Lector.leerString();
            vec[dimL].setLocal(nomLocal);
            System.out.println("Ingrese los goles del local: ");
            int golL = Lector.leerInt();
            vec[dimL].setGolesLocal(golL);
            System.out.println("Ingrese los goles del visitante: ");
            int golV = Lector.leerInt();
            vec[dimL].setGolesVisitante(golV);
            
            dimL++;
            System.out.println("Ingrese el nombre del visitante: ");
            nomVisitante = Lector.leerString();
        }
        
        int cantGanoRiver = 0;
        int cantGolesBoca = 0;
        for(int dimLi=0;dimLi<dimL;dimLi++){
            System.out.println("Equipo local: " + vec[dimLi].getLocal().toUpperCase()+ " goles local: " + vec[dimLi].getGolesLocal() + " VS "+ " Equipo visitante: " +vec[dimLi].getVisitante().toUpperCase()+" goles visitante: "+ vec[dimLi].getGolesVisitante() );
            
            if(vec[dimLi].getGanador().equals("river")){
                cantGanoRiver++;
            }
            
            if(vec[dimLi].getLocal().equals("boca")){
                cantGolesBoca = cantGolesBoca + vec[dimLi].getGolesLocal();
            }
            
        }
        System.out.println("la cantidad de partidos que ganó River: "+ cantGanoRiver);
        System.out.println("total de goles que realizó Boca jugando de local: "+ cantGolesBoca);
    }
}
