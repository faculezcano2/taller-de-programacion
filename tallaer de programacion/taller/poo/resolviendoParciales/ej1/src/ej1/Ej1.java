/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

/**
 *
 * @author Facu
 */

/*
1) Un psicólogo necesita un sistema para organizar su agenda semanal. El sistema
mantiene para c/u de los 5 días de atención y c/u de los 6 turnos (horarios) del día, la
información del paciente que tomó el turno. De los pacientes guarda: nombre, si tiene
obra social y costo a abonar por la sesión.
a)Genere las clases necesarias. Implemente constructores para iniciar: el sistema sin
pacientes; los pacientes a partir de toda su información.
b)Lea atentamente y luego implemente métodos que permitan:
- Agendar al paciente P en un día D y turno T. Asuma que el turno está libre. D y T son
válidos.
- Dado el nombre de un paciente, liberar todos sus turnos.
- Dado un día D y el nombre de un paciente, devolver si el paciente tiene agendado un
turno ese día. Asuma que D es válido.


c) Realice un programa que instancie el sistema. Cargue varios pacientes al sistema.
Libere turnos agendados. Para finalizar, imprima el resultado del inciso b.iii

*/
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agenda ag = new Agenda();
        
        Paciente p1 = new Paciente("Facundo", true, 29);
        Paciente p2 = new Paciente("martina", false, 32);
        Paciente p3 = new Paciente("leandro", true, 44);
        Paciente p4 = new Paciente("veronica", false, 25);
        
        ag.setPaciente(p1, 0, 1);
        ag.setPaciente(p2, 1, 3);
        ag.setPaciente(p3, 2, 5);
        ag.setPaciente(p4, 3, 2);
        
        System.out.println(ag.tieneTurno("Facundo", 0));
        
        ag.liberarTurnos("Facundo");
        System.out.println(ag.tieneTurno("Facundo", 0));
        
        
        
    }
    
}
