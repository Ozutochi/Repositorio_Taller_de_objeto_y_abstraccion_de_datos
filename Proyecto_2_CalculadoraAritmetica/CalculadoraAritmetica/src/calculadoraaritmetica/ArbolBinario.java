
package calculadoraaritmetica;

import java.util.Stack;

 
public class ArbolBinario {
    
    NodoArbol raiz;
    
  
    public ArbolBinario(){
        raiz=null;
    }

   
public void agregar(Stack<String> datos){
        
        while(!datos.empty()){
            System.out.println("Mientras que la cadena no este vacia:"+datos.peek());
            
            String elemento = datos.pop();
            System.out.println("Elemento:" + elemento);
            NodoArbol nuevo = new NodoArbol(elemento);
            
            System.out.println("elemento del arbol creado:"+nuevo.dato);
            
            if(raiz==null){
                raiz=nuevo;
                System.out.println("raiz cuando esta es vacia:"+raiz.dato);
            }//fin del if que indica si la raiz es nula
            
            
            
            else{
                NodoArbol aux= raiz; 
                NodoArbol padre;
                
                System.out.println("dato del Auxiliar:"+aux.dato);
                System.out.println("no esta vacia");
                
                while(true){
                    System.out.println("Auxiliar dentro del while true: "+aux.dato);
                    padre=aux;
                    System.out.println("Padre:"+padre.dato);
                    
                    if(esOperador(elemento)){
                        System.out.println("si es un operador:"+elemento);
                        aux = aux.hijoIzq;
                        if(aux==null){
                         padre.hijoIzq=nuevo;
                            System.out.println("Padre"+padre);
                            System.out.println("hijo izq de padre: "+padre.hijoIzq.dato);
                         return;
                         
                        }//if que indica si el nuevo valor de aux es nulo
                      
                   
                    }//if que indica si el dato colocado es un operador
                    
                    
                    else{
                       
                        if(aux.hijoIzq!=null && aux.hijoDer==null){
                            aux=aux.hijoDer;
                           
                            padre.hijoDer=nuevo;
                             System.out.println(padre.dato);
                        }
                        
                         else if(aux.hijoIzq==null && aux.hijoDer==null){
                            
                            aux=aux.hijoDer;
                           
                            padre.hijoDer=nuevo;
                             System.out.println(padre.dato);
                        }
                        else if(aux.hijoIzq==null && aux.hijoDer!=null){
                            
                      if(Integer.parseInt(aux.hijoDer.dato)<Integer.parseInt(nuevo.dato)){
                          aux.hijoIzq=aux.hijoDer;
                          System.out.println(aux.hijoIzq.dato);
                          aux.hijoDer=nuevo;
                          System.out.println(aux.hijoDer.dato);
                      }
                        }
                        
               
                    }//si no es operador
                    
           
                }//final del while que dice true
                
                
                
            }//fin del else que indica si la raiz no es nula
        }//fin del while que indica que se repita el codigo miestras la cadena no este vacia
        
        
        
    }    
      

public void postOrden(NodoArbol r){
        if(r!=null){
            postOrden(r.hijoIzq);
            postOrden(r.hijoDer);
            System.out.println(r.dato);
        }
    }

public static boolean esOperador(String c) {
    return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
}


   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}

