/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej11;

/**
 *
 * @author Facu
 */
public class Ej11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Concurso con = new Concurso(20);
       
       Alumno al1 = new Alumno("Facundo",22,"guitarra");
       con.ingresarAlumno(al1, 0);
       con.ingresarPutaje("Facundo", 10);
       
       Alumno al2 = new Alumno("veronica",45,"armonica");
       con.ingresarAlumno(al2, 1);
       con.ingresarPutaje("veronica", 80);
       
       
       Alumno al3 = new Alumno("nilo",12,"bateria");
       con.ingresarAlumno(al3, 2);
       con.ingresarPutaje("nilo", 100);
       
       Alumno al4 = new Alumno("martina",17,"uquelele");
       con.ingresarAlumno(al4, 3);
       con.ingresarPutaje("martina", 6);
       
       Alumno al5 = new Alumno("leandro",24,"flauta");
       con.ingresarAlumno(al5, 4);
       con.ingresarPutaje("leandro", 3);
       
       

       
       System.out.println(con.mayorPuntaje().getNombre());
    }
    
}
