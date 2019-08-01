/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

import java.util.LinkedList;

/**
 *
 * @author Erick
 */
public class InsertarArbol {   /*ESTA CLASE SIRVE PARA ENVIAR LOS RECORRIDOS
    DE LOS DATOS AL TEXT AREA*/
    
    Arbol nuevoArbol = new Arbol();
    
    public InsertarArbol(){
    
    }
    
    public boolean insertar(Integer dato) {
        return (this.nuevoArbol.agregar(dato));
    }
    
    /*ESTOS MÉTODOS SIRVEN PARA MOSTRAR LOS RECORRIDOS POSIBLES DEL ÁRBOL*/
    
    public String preOrden() {
        LinkedList it = this.nuevoArbol.preOrden();
        return (recorrido(it, "Preorden:"));
    }

    public String inOrden() {
        LinkedList it = this.nuevoArbol.inOrden();
        return (recorrido(it,  "Inorden:"));
    }

    public String postOrden() {
        LinkedList it = this.nuevoArbol.postOrden();
        return (recorrido(it, "Postorden:"));
    }
    
    /*Este método muestra los tipos de recorrido posibles del arbol, EL IT
    DE LA LISTA ENLAZADA SE COMPARA CON "i" PARA PODER IMPRIMIR EN EL TEXT
    ÁREA EL RECORRIDO DEL ARBOL BINARIO SEGÚN LOS NODOS INSERTADOS POR EL 
    TEXTFIELD*/
    
    private String recorrido(LinkedList it, String msg) {
        int i = 0;
        String r = msg + "\n";
        while (i < it.size()) {
            r += " " + it.get(i).toString();
            i++;
        }
        return (r);
    }

    //Metodo para buscar dato en el nodo
    public String buscar(Integer dato) {
        boolean siEsta = this.nuevoArbol.encontrar(dato);
        String r = "El dato:" + dato.toString() + "\n";
        r += siEsta ? "Si se encuentra en el arbol" : "No se encuentra en el arbol";
        return (r);
    }

}




