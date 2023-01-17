/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Hewlett-Packard
 */


/*
1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
los lados y s =((a+b+c)/2)
. La función raíz cuadrada es Math.sqrt(#)

*/




public class triangulo {

    private double lado1;
    private double lado2;
    private double lado3;
    private String colorRelleno;
    private String colorLinea;
    
    
    public triangulo(double lado1,double lado2,double lado3, String colorRelleno, String colorLinea){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }
    
    
    //- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
    
   //gets
    public double GetLado1(){
        return this.lado1;
    }
    
    public double GetLado2(){
        return this.lado2;
    }
    
    public double GetLado3(){
        return this.lado3;
    }
    
    public String GetColorRelleno(){
        return this.colorRelleno;
    }
    
    public String GetColorLinea(){
        return this.colorLinea;
    }
    
    //sets
    public void setLado1(double lado1){
        this.lado1 = lado1;
    }
    
    public void setLado2(double lado2){
        this.lado2 = lado2;
    }
    
    public void setLado3(double lado3){
        this.lado3 = lado3;
    }
    
    public void setColorRelleno(String colorRelleno){
        this.colorRelleno = colorRelleno;
    }
    
    public void setColorLinea(String colorLinea){
        this.colorLinea = colorLinea;
    }
    
    
    @Override
    public String toString(){
        String aux = "lado 1: "+ lado1+", lado 2: "+lado2+", lado 3: "+lado3+", color de relleno: "+this.colorRelleno+", color linea: "+this.colorLinea;
        return(aux);
    } 
    
    
    //- Calcular el perímetro y devolverlo (método calcularPerimetro)
    public double calcularPerimetro(){
        double perimetro = this.lado1 + this.lado2 + this.lado3;
        return(perimetro);
    }
    
    
    /*- Calcular el área y devolverla (método calcularArea)
    NOTA: Calcular el área con la fórmula Área = √s(s − a)(s − b)(s − c) , donde a, b y c son
    los lados y s =((a+b+c)/2)
    .   La función raíz cuadrada es Math.sqrt(#)
    */
    public double calcularArea(){
        double s = ((this.calcularPerimetro())/2);
        double area = Math.sqrt(s*(s-this.lado1)*(s-this.lado2)*(s-this.lado3));
        return(area);
    }
    
}




