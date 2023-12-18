
package com.mycompany.stackvsqueue;

public class Nodo {
    PocketMonster pokemon;
    Nodo next;
    
    public Nodo(){
      this.pokemon=null;
      this.next=null;
    }
    public Nodo(PocketMonster pokemon){
        this.pokemon=pokemon;
        this.next=null;
    }
    public Nodo(PocketMonster pokemon,Nodo nodo){
        this.pokemon=pokemon;
        this.next=nodo;
    }
    
    public PocketMonster getNodo(){
        return pokemon;
    }
    public void setNodo(PocketMonster pokemon){
        this.pokemon=pokemon;
    }
    
    public Nodo getNext(){
        return next;
    }
    
    public void setNext(Nodo next){
        this.next=next;
    }
    
}
