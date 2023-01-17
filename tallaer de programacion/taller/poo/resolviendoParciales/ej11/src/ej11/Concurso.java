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
public class Concurso {
    private Alumno [][] matAlumnos;
    private int fila;
    private int col;
    private int contador[];

    public Concurso( int col) {
        this.fila = 5;
        this.col = col;
        this.matAlumnos = new Alumno[this.fila][this.col];
        this.contador = new int[this.fila];
        for(int i =0; i<this.fila;i++){
            this.contador[i] = 0;
        }
    }
    
    
    
    
    
    public void ingresarAlumno(Alumno alu, int num){
        this.matAlumnos[num][contador[num]] = alu;
        contador[num]++;
    }
    
    
    public void ingresarPutaje(String nombre, int puntaje){
        int i = 0;
        int j = 0;
        boolean es = false;
        while(i<this.fila && !es){
            while(j<contador[i] && !es){
                if(this.matAlumnos[i][j].getNombre().equals(nombre)){
                    this.matAlumnos[i][j].setPuntaje(puntaje);
                    es = true;
                    System.out.println("Se agrego el puntaje");
                }
                j++;
            }
            j=0;
            es = false;
            i++;
        }
    }
    
    public Alumno mayorPuntaje(){
        int max = 0;
        Alumno maxAlu = new Alumno("",0,"");
        for (int i =0;i<this.fila;i++){
            for(int j=0; j<contador[i];j++){
                if(this.matAlumnos[i][j].getPuntaje()>max){
                    max = this.matAlumnos[i][j].getPuntaje();
                    maxAlu.setEdad(this.matAlumnos[i][j].getEdad());
                    maxAlu.setInstrumento(this.matAlumnos[i][j].getInstrumento());
                    maxAlu.setNombre(this.matAlumnos[i][j].getNombre());
                    maxAlu.setPuntaje(this.matAlumnos[i][j].getPuntaje());
                }
            }
        }
        return maxAlu;
    }
}
