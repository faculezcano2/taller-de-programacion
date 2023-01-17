/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

/**
 *
 * @author Facu
 */
public class Ej9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Trayectoria tr = new Trayectoria(5);
        Publicaciones pb = new Publicaciones(5);
        
        Postulado p1 = new Postulado("Facundo",3,4);
        Postulado p2 = new Postulado("franco",2,3);
        Postulado p3 = new Postulado("nilo",1,2);
        Postulado p4 = new Postulado("alejo",3,4);
        Postulado p5 = new Postulado("martina",2,4);
        Postulado p6 = new Postulado("veronica",5,4);
        
        tr.agregarPostulado(p1);
        tr.agregarPostulado(p2);
        tr.agregarPostulado(p3);
        pb.agregarPostulado(p4);
        pb.agregarPostulado(p5);
        pb.agregarPostulado(p6);
        
        System.out.println(tr.otorgarPremio(2));
        System.out.println(pb.otorgarPremio(2));
        
    }
    
}
