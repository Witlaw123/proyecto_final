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
public class Arbol { /*ESTA CLASE SIRVE PARA INSERTAR DATOS EN EL ARBOL E
    Y PREPARARLOS PARA QUE SE ACOMODEN PARA LOS DISTINTOS RECORRIDOS*/
    
    private Nodo raiz;
   
  
    
    public Arbol(){
    
        raiz = null;
    }
        
    public boolean agregar (int dato){
        Nodo nuevo = new Nodo (dato, null, null);
        insertar (nuevo, raiz);
        return true;
    }
    
    /*Con este método vamos a insertar los datos en el arbol de búsqueda*/
    
    public void insertar(Nodo nuevo, Nodo auxiliarN){
        if (this.raiz == null){
            raiz = nuevo;
        } else {
            if (nuevo.getDato() <= auxiliarN.getDato()){
                if (auxiliarN.getIzq() == null){
                    auxiliarN.setIzq(nuevo);
            } else {
                insertar (nuevo, auxiliarN.getIzq());    
            }
        } else {
            if (auxiliarN.getDer() == null) {
                auxiliarN.setDer(nuevo);
            } else {
                insertar(nuevo, auxiliarN.getDer());
                }
            }
        }
    }
    
        
   public String borrarMenor() {
        Nodo nuevo=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getIzq() == null) {
                raiz = raiz.getDer();
            } else {
                Nodo anterior = raiz;
                nuevo = raiz.getIzq();
                while (nuevo.getIzq() != null) {
                    anterior = nuevo;
                    nuevo = nuevo.getIzq();
                }
                
                anterior.setIzq(nuevo.getDer());
            }
            
        }
   return ("Valor eliminado: " + nuevo.getDato());
   }
    
   
   public String borrarMayor() {
        Nodo nuevo=raiz.getIzq();
        if (raiz != null) {
            if (raiz.getDer() == null) {
                raiz = raiz.getIzq();
            } else {
                Nodo anterior = raiz;
                nuevo = raiz.getDer();
                while (nuevo.getDer() != null) {
                    anterior = nuevo;
                    nuevo = nuevo.getDer();
                }
                
                anterior.setDer(nuevo.getIzq());
            }
        }
        return ("Valor eliminado: " + nuevo.getDato());
    }
   
   
   
   
    
    public Nodo getRaiz(){
        return raiz;
    }
    
    public void setRaiz (Nodo raiz){
        this.raiz = raiz;
        
    }
    
   /*MÉTODO PARA EL RECORRIDO PREORDEN, EL MÉTODO RECIBE LA RAIZ Y UNA LISTA
    ENLAZADA PARA IR ALMACENANDO EL RECORRIDO DE LOS NODOS - NO MODIFICAR
    POR NINGUN MOTIVO QUE FUE UN ROLLO PARA HACERLO ANDAR*/
    
    public LinkedList preOrden() {
        LinkedList recorrido = new LinkedList();
        preorden(raiz, recorrido);
        return recorrido;
    }
    
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

   /*MÉTODO PARA EL RECORRIDO INORDEN, EL MÉTODO RECIBE LA RAIZ Y UNA LISTA
    ENLAZADA PARA IR ALMACENANDO EL RECORRIDO DE LOS NODOS - NO MODIFICAR POR 
    NINGUN MOTIVO*/
    
    public LinkedList inOrden() {
        LinkedList recorrido = new LinkedList();
        inorden(raiz, recorrido);
        return recorrido;
    }
    
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    /*MÉTODO PARA EL RECORRIDO POSTORDEN, EL MÉTODO RECIBE LA RAIZ Y UNA LISTA
    ENLAZADA PARA IR ALMACENANDO EL RECORRIDO DE LOS NODOS - NO MODIFICAR
    POR NINGUN MOTIVO*/
    
    public LinkedList postOrden() {
        LinkedList recorrido = new LinkedList();
        postorden(raiz, recorrido);
        return recorrido;
    }
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }
    
     //Metodo para verificar si hay un nodo en el arbol
    public boolean encontrar(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }
    
}
