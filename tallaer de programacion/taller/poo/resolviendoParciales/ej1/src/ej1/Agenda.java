/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

/**
 *
 * @author Facu
 * 1) Un psicólogo necesita un sistema para organizar su agenda semanal. El sistema
mantiene para c/u de los 5 días de atención y c/u de los 6 turnos (horarios) del día, la
información del paciente que tomó el turno.
* 
* b)Lea atentamente y luego implemente métodos que permitan:
- Agendar al paciente P en un día D y turno T. Asuma que el turno está libre. D y T son
válidos.
- Dado el nombre de un paciente, liberar todos sus turnos.
- Dado un día D y el nombre de un paciente, devolver si el paciente tiene agendado un
turno ese día. Asuma que D es válido.
 */
public class Agenda {
    private int dia;
    private int turno;
    private int dimld;
    private int dimlt;
    private Paciente [][] matAgenda;

    public Agenda() {
        this.dia = 5;
        this.turno = 6;
        this.dimld=0;
        this.dimlt=0;
        this.matAgenda = new Paciente[this.dia][this.turno];
    }
    
    public void setPaciente(Paciente p, int d, int t){
        this.matAgenda[d][t] = p;
    }
    
    public void liberarTurnos(String nombre){
        int i=0;
        int j=0;
        while(i<this.dia){
            while(j<this.turno){
                if(this.matAgenda[i][j] == null){
                    j++;
                }else{
                    if(this.matAgenda[i][j].getNombre().equals(nombre)){
                        this.matAgenda[i][j].setNombre("");
                        this.matAgenda[i][j].setCosto(0);
                        this.matAgenda[i][j].setObra(false);
                    }
                j++;
                }
            }
            j=0;
            i++;
        }
    }
    
    public boolean tieneTurno(String nombre, int D){
        boolean aux=false;
        int i=0;
        while(i<6 && aux==false){
            if(this.matAgenda[D][i] == null){
                i++;
            }else{
                if(this.matAgenda[D][i].getNombre().equals(nombre)){
                    aux = true;
                }
                i++;
            }
           
        }
        return aux;
    }
    
 

}
