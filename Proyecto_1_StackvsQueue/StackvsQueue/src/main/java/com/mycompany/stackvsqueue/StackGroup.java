
package com.mycompany.stackvsqueue;

public abstract class StackGroup extends Group {

    Nodo UltimoValorIngresado;
    int tamaño=0;
    
  
    
    @Override
    public void add(PocketMonster pokemon){
        Nodo Nuevo_Nodo = new Nodo(pokemon);
        
        Nuevo_Nodo.next=UltimoValorIngresado;
        UltimoValorIngresado = Nuevo_Nodo;
        tamaño++;
        
    }
    
    @Override
    public PocketMonster remove(){
        PocketMonster aux = UltimoValorIngresado.pokemon;
       UltimoValorIngresado = UltimoValorIngresado.next;
       tamaño--;
    return aux;
    }
    
    @Override
    public String show(){
       Nodo recorrido = UltimoValorIngresado;
       StringBuilder showTime = new StringBuilder(); 
       
       while(recorrido!=null){
       showTime.append(recorrido.pokemon.getName()).append("/").append(recorrido.pokemon.getType()).append(", ");
       recorrido= recorrido.next;
       
       }
       
       return showTime.toString();
    
    }
    
    
    
    
}
