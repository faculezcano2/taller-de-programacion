/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej7;

/**
 *
 * @author Facu
 * 
 * 
 * 26)
1- Queremos representar compras minoristas y mayoristas. De cualquier compra se 
conoce: nro. y los productos comprados (como máximo N). De cada producto registra: 
código, precio mayorista y precio minorista. Además: las compras mayoristas tienen el 
CUIT del comprador; y las minoristas si el comprador es jubilado. 
a- Genere las clases necesarias. Provea constructores para iniciar las compras a partir de
toda su información, para una cantidad máxima de N productos comprados y sin
productos cargados. 
b- Implemente métodos en las clases que corresponda para permitir:
i- Agregar a la compra un producto que se recibe. Asuma que hay espacio.
ii- Obtener el precio a pagar por el i-ésimo producto de la compra sabiendo que: para las
compras minoristas el precio a pagar por dicho producto es el precio minorista
descontando 10% si es jubilado y para las compras mayoristas es el precio mayorista
descontando 21% de IVA. Asuma que “i” es válido y se recibe.
iii- Obtener la representación String de la compra siguiendo el ejemplo: 
“Nro:… , Productos comprados (código y precio pagado por el producto):…Total pagado:
…”
2) Realice un programa que instancie una compra mayorista y una minorista. Cargue 3 
productos a cada compra. Para finalizar, muestre la representación String de cada 
compra.
 * 
 */
public class Ej7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompraMayorista cM = new CompraMayorista(1,4,222);
        CompraMinorista cm = new CompraMinorista(true,2,4);
        
        Producto pro1 = new Producto(2,22,12);
        Producto pro2 = new Producto(3,32,22);
        Producto pro3 = new Producto(4,42,32);
        
        cM.agregarProducto(pro1);
        cM.agregarProducto(pro2);
        cM.agregarProducto(pro3);
        
        cm.agregarProducto(pro1);
        cm.agregarProducto(pro2);
        cm.agregarProducto(pro3);
        
        System.out.println("Compra mayorista: "+cM.toString());
        System.out.println("Compra minorista: "+cm.toString());
        
        
    }
    
}
