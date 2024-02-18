
package com.mycompany.stackvsqueue;

public abstract class QueueGroup extends Group{
    
    Nodo startCola, endCola;
    int tamaño=0;
    
    public boolean Vacio(){
        if(startCola==null){
            return true;
        }
        else {
         return false;}
    }
    
    @Override
    public void add(PocketMonster pokemon){
        Nodo Nuevo_Nodo = new Nodo();
        Nuevo_Nodo.pokemon=pokemon;
        Nuevo_Nodo.next=null;
        
        if(Vacio()){
            startCola=Nuevo_Nodo;
            endCola=Nuevo_Nodo;
        }
        else{endCola.next=Nuevo_Nodo;
            endCola = Nuevo_Nodo;
        
    }
        tamaño++;

    }
      @Override
    public PocketMonster remove(){
        if(!Vacio()){
           PocketMonster pokemon = startCola.pokemon;
          
           
           if(startCola == endCola){
               startCola=null;
               endCola=null;
           }else{
               startCola = startCola.next;      
           }
           tamaño--;
           return pokemon;
        }
        else{
            PocketMonster nulo=null;
             tamaño--;
            return nulo;
        }
       
    }
      @Override
    public String show(){
        Nodo recorrido = startCola;
        StringBuilder showTime = new StringBuilder();
        while(recorrido!=null){
       showTime.append(recorrido.pokemon.getName()).append("/").append(recorrido.pokemon.getType()).append(", ");
       recorrido= recorrido.next;
       
       }
        
        
        return showTime.toString();
        
    }
    
    
    
    
    
    
    
}


