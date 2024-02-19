
package calculadoraaritmetica;

import java.util.Stack;

public class NodoArbol {
    
    String dato;
    NodoArbol hijoIzq,hijoDer;
    
    public NodoArbol(String dato){
        this.dato=dato;
        this.hijoDer=null;
        this.hijoIzq=null;
    }
    
    
    public String toString(){
        return " "+dato;
    }
    
    
    
    
    
    
}
