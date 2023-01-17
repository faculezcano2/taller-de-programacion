/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Facu
 * 
 * 
 * 
 * 
 * 5-A- Modifique la clase VisorFiguras: ahora debe permitir guardar las figuras a mostrar (a
    lo sumo 5) y también mostrar todas las figuras guardadas. Use la siguiente estructura
    B- Realice un programa que instancie el visor, guarde dos cuadrados y un rectángulo en el
    visor y por último haga que el visor muestre sus figuras almacenadas.
 */
public class VisorFigurasModificado {
    private int guardadas;
    private int capacidadMaxima=5;
    private Figura [] vector;



    public VisorFigurasModificado() {
        this.guardadas = 0;
        this.vector = new Figura[this.capacidadMaxima];
    }

     public void guardar(Figura f){
         if(this.quedaEspacio()){
             this.vector[this.guardadas] = f;
             this.guardadas++;
         }
     }


    public boolean quedaEspacio(){
        return (this.guardadas<this.capacidadMaxima);
     }

     public void mostrar(){
        int i =0;
        while(i<this.guardadas){
            System.out.println(this.vector[i].toString());
            i++;
        }
     }

    public int getGuardadas() {
        return guardadas;
    }

}
