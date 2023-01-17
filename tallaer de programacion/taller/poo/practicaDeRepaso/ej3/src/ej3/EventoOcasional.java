/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Facu
 */

/*
Un evento ocasional es un recital que además tiene el motivo (a beneficio, show de TV
o show privado), el nombre del contratante del recital y el día del evento.


iii. El evento ocasional debe saber responder al mensaje actuar de manera distinta:
 Si es un show de beneficencia se imprime la leyenda “Recuerden colaborar con…“
seguido del nombre del contratante.
 Si es un show de TV se imprime “Saludos amigos televidentes”
 Si es un show privado se imprime “Un feliz cumpleaños para…” seguido del
nombre del contratante.
Independientemente del motivo del evento, luego se imprime el listado de temas como
lo hace cualquier recital.


*/

public class EventoOcasional extends Recital{
    private String motivo;
    private String nombreContratante;
    private String dia;

    public EventoOcasional(String motivo, String nombreContratante, String dia, String nombreBanda, int cantCanciones) {
        super(nombreBanda, cantCanciones);
        this.motivo = motivo;
        this.nombreContratante = nombreContratante;
        this.dia = dia;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public String getDia() {
        return dia;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public String actuar(){
        String aux;
        if(this.getMotivo().equals("a beneficio")){
            aux = " Recuerden colaborar con… " + this.getNombreContratante();
        }else if(this.getMotivo().equals("tv")){
            aux = " Saludos amigos televidentes ";
        }else{
            aux = " Un feliz cumpleaños para… "+ this.getNombreContratante();
        }
        
        return aux + super.actuar();
    }
    
    /*Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV
y 150000 si es privado.*/
    public double calcularCosto(){
        int aux;
        if(this.getMotivo().equals("a beneficio")){
            aux = 0;
        }else if(this.getMotivo().equals("tv")){
            aux = 5000;
        }else{
            aux =  15000;
        }
        return aux;
    }
}

