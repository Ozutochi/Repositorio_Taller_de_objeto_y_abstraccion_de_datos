
package com.mycompany.stackvsqueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
public class StackVsQueue {

public static void main(String[] args) {
       Group StackPokedex = new StackGroup() {}; 
       Group TeamStack = new StackGroup() {}; 
       Group AuxiliarStack = new StackGroup() {}; 
       Group QueuePokedex = new QueueGroup() {};
       Group TeamQueue = new QueueGroup() {};
       Group AuxiliarQueue = new QueueGroup() {};
       
       crearArchivo("EYS\\Salida.mpdm");
       
     CreateStackPokedex((StackGroup) StackPokedex);  
     String SalidaStackPokedex= showStackPokedex((StackGroup) StackPokedex);
      
     CreateQueuePokedex((QueueGroup) QueuePokedex);
     String SalidaQueuePokedex= showQueuePokedex((QueueGroup) QueuePokedex);
    
     CreateStackTeam((StackGroup) StackPokedex, (StackGroup) TeamStack,(StackGroup)AuxiliarStack );
     String SalidaStackTeam = showStackTeam((StackGroup) TeamStack);
      
     CreateQueueTeam((QueueGroup) QueuePokedex, (QueueGroup) TeamQueue, (QueueGroup) AuxiliarQueue);
     String SalidaQueueTeam = showQueueTeam((QueueGroup) TeamQueue);
     
     String SalidaEncounter = Encounter((StackGroup) TeamStack,(QueueGroup) TeamQueue);
    
     EscribirArchivo("EYS\\Salida.mpdm",SalidaStackPokedex,SalidaQueuePokedex,SalidaStackTeam,SalidaQueueTeam,SalidaEncounter);
}

private static void CreateStackPokedex(StackGroup StackPokedex ){
      
    try {
    BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));

    String primeraLinea = lector.readLine();

    if (primeraLinea != null && primeraLinea.equals("CREATE STACK POKEDEX")) {
    
        int numeroLineaDeseada = 1; 

        for (int i = 1; i < numeroLineaDeseada; i++) {
            lector.readLine();
        }

        String lineaDeseada = lector.readLine();

        if (lineaDeseada != null) {
            String[] bloques = lineaDeseada.split(",");
            for (String bloque : bloques) {
                String[] partes = bloque.split("/");
                if (partes.length == 2) {
                    String name = partes[0].trim();
                    String type = partes[1].trim();
                    StackPokedex.add(new PocketMonster(name, type));
                }
            }
        }
    }

    lector.close();
}
    catch(IOException e){
        System.out.println("Error al leer el archivo "+e.getMessage());
    }
    
    
}

private static String showStackPokedex(StackGroup StackPokedex) {
    StringBuilder result = new StringBuilder();
    try {
        BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));
        String lineaDeseada;

        while ((lineaDeseada = lector.readLine()) != null) {
            if (lineaDeseada.equals("SHOW STACK POKEDEX")) {
                result.append("Lista del equipo STACK:\n").append(StackPokedex.show()).append("\n");
                break; 
            }
        }
    } catch (IOException e) {
        result.append("Error al leer el archivo ").append(e.getMessage());
    }
    return result.toString();
}

private static void CreateQueuePokedex(QueueGroup QueuePokedex ){
      
    try {
    BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));

       
          
         String lineaDeseada;
     while((lineaDeseada = lector.readLine())!= null){     
          if (lineaDeseada.equals("CREATE QUEUE POKEDEX")) {
       
    
        String lineaDeseadaPokemon = lector.readLine();
             
        if (lineaDeseadaPokemon != null) {
            String[] bloques = lineaDeseadaPokemon.split(",");
            for (String bloque : bloques) {
                String[] partes = bloque.split("/");
                if (partes.length == 2) {
                    String name = partes[0].trim();
                    String type = partes[1].trim();
                    QueuePokedex.add(new PocketMonster(name, type));
                }
            }              
              
            }
    }
          
     }    
    lector.close();
}
    catch(IOException e){
        System.out.println("Error al leer el archivo "+e.getMessage());
    }
    
    
}

private static String showQueuePokedex(QueueGroup QueuePokedex){
    
                        
    StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("CREATE QUEUE POKEDEX")) {
               result.append("Lista del equipo QUEUE:\n").append(QueuePokedex.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   return result.toString();
}

private static void CreateStackTeam(StackGroup StackPokedex, StackGroup TeamStack, StackGroup AuxiliarStack ) {
    try {
        BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));

        String lineaActual;
        while ((lineaActual = lector.readLine()) != null) {
            if (lineaActual.equals("CREATE STACK TEAM")) {
          
                String lineaDeseadaEquipo = lector.readLine();

                if (lineaDeseadaEquipo != null) {
                    String[] bloques = lineaDeseadaEquipo.split(" ");
                        
             
                    for (String type : bloques) {
                 
                        Nodo recorrido = StackPokedex.UltimoValorIngresado;
                         
                        while (recorrido!= null) {
                          
                          if (recorrido.pokemon.getType().equalsIgnoreCase(type)) {
                  TeamStack.add(StackPokedex.remove());
              
                    while (AuxiliarStack .tamaño>0) {
                        StackPokedex.add(AuxiliarStack.remove());
                        
                        }
                    recorrido = StackPokedex.UltimoValorIngresado;  
                           break;
                            
}                     else {
                     AuxiliarStack.add(StackPokedex.remove());
                   recorrido = recorrido.next;
         
                       }

                                 
                             
                            
                     
                        }
                        
                        
                        
                    }
                    while(TeamStack.tamaño>3){
                        TeamStack.remove();
                    }
                    
                
                    break;  
                }
            }
        }

        lector.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo " + e.getMessage());
    }
}

private static String showStackTeam(StackGroup TeamStack){
    
     StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("CREATE STACK TEAM")) {
               result.append("Lista del equipo STACK:\n").append(TeamStack.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   return result.toString();
    
}

private static void CreateQueueTeam(QueueGroup QueuePokedex, QueueGroup TeamQueue, QueueGroup AuxiliarQueue) {
    try {
        BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));

     
        String lineaActual;
        while ((lineaActual = lector.readLine()) != null) {
            if (lineaActual.equals("CREATE QUEUE TEAM")) {
            
                String lineaDeseadaEquipo = lector.readLine();

                if (lineaDeseadaEquipo != null) {
                    String[] bloques = lineaDeseadaEquipo.split(" ");
                        
             
                    for (String type : bloques) {
                 
                        Nodo recorrido = QueuePokedex.startCola;
                         
                        while (recorrido!= null) {
                          
                          if (recorrido.pokemon.getType().equalsIgnoreCase(type)) {
                  TeamQueue.add(QueuePokedex.remove());
              
                    while (!AuxiliarQueue.Vacio()) {
                       
                        QueuePokedex.add(AuxiliarQueue.remove());
                        
                        }       
                    break;
                           
                            
}                     else {
                     AuxiliarQueue.add(QueuePokedex.remove());
                          
                     recorrido = recorrido.next;
           
                       }
                        }        
                    }
                    while(TeamQueue.tamaño>3){
                        System.out.println(TeamQueue.show());
                        TeamQueue.remove();
                    }
                    
                
                    break;  
                }
            }
        }

        lector.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo " + e.getMessage());
    }
}

private static String showQueueTeam(QueueGroup TeamQueue){
    
    StringBuilder result = new StringBuilder();
   try{
       BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));
       String lineaDeseada;
       while((lineaDeseada = lector.readLine())!= null){    
           if (lineaDeseada.equals("SHOW QUEUE TEAM")) {
               result.append("Lista del equipo QUEUE:\n").append(TeamQueue.show()).append("\n"); 
           }
       }
   }  
   catch(IOException e){
       result.append("Error al leer el archivo ").append(e.getMessage());
   }
   return result.toString();
}

private static String Encounter(StackGroup TeamStack, QueueGroup TeamQueue) {
    StringBuilder result = new StringBuilder();
    
    try {
        BufferedReader lector = new BufferedReader(new FileReader("EYS\\Entrada.mpdm"));
        String lineaActual;

        int rounds = 1;
        while ((lineaActual = lector.readLine()) != null) {
            if (lineaActual.equals("ENCOUNTER")) {
                while (rounds <= 10) {
                    if (TeamStack.UltimoValorIngresado != null && !TeamQueue.Vacio()) {
                        int resultado = compareTypes(TeamStack.UltimoValorIngresado.pokemon.getType(),
                                TeamQueue.startCola.pokemon.getType());

                        result.append("Turn [").append(rounds).append("]\n");
                        result.append(TeamStack.UltimoValorIngresado.pokemon.getName()).append("/")
                                .append(TeamStack.UltimoValorIngresado.pokemon.getType()).append(" VS ")
                                .append(TeamQueue.startCola.pokemon.getName()).append("/")
                                .append(TeamQueue.startCola.pokemon.getType()).append("\n");

                        if (resultado == 1) {
                            TeamQueue.remove();
                            result.append("--").append(TeamStack.UltimoValorIngresado.pokemon.getName()).append("/")
                                    .append(TeamStack.UltimoValorIngresado.pokemon.getType()).append(" wins--\n");
                        } else if (resultado == -1) {
                            TeamStack.remove();
                            result.append("--").append(TeamQueue.startCola.pokemon.getName()).append("/")
                                    .append(TeamQueue.startCola.pokemon.getType()).append(" wins--\n");
                            TeamQueue.add(TeamQueue.remove());
                        } else if (resultado == 0) {
                            boolean todosIguales = true;
                            String tipoUltimoPokemon = TeamStack.UltimoValorIngresado.pokemon.getType();
                            Nodo recorridoCola = TeamQueue.startCola;
                            while (recorridoCola != null) {
                                if (!recorridoCola.pokemon.getType().equals(tipoUltimoPokemon)) {
                                    todosIguales = false;
                                    break;
                                }
                                recorridoCola = recorridoCola.next;
                            }
                            if (todosIguales) {
                                result.append("--TIE--\n");
                                break;
                            } else {
                                result.append("--TIE--\n");
                                TeamQueue.add(TeamQueue.remove());
                            }
                        }
                        rounds++;
                    } else {
                        break;
                    }
                } // rondas

                if (TeamStack.UltimoValorIngresado == null) {
                    result.append("--TEAM QUEUE WINS\n");
                } else if (TeamQueue.Vacio()) {
                    result.append("--TEAM STACK WINS\n");
                } else if (TeamStack.UltimoValorIngresado.pokemon.getType()
                        .equals(TeamQueue.startCola.pokemon.getType())) {
                    result.append("--TIE MATCH---\n");
                }
            }
        } // while

        lector.close();
    } catch (IOException e) {
        result.append("Error al leer el archivo ").append(e.getMessage()).append("\n");
    }

    return result.toString();
}

private static int compareTypes(String typeStack, String typeQueue) {
    
    if ((typeStack.equalsIgnoreCase("Water") && typeQueue.equalsIgnoreCase("Fire")) ||
        (typeStack.equalsIgnoreCase("Fire") && typeQueue.equalsIgnoreCase("Grass")) ||
        (typeStack.equalsIgnoreCase("Grass") && typeQueue.equalsIgnoreCase("Water"))) {
        return 1;  
    } else if ((typeStack.equalsIgnoreCase("Fire") && typeQueue.equalsIgnoreCase("Water")) ||
               (typeStack.equalsIgnoreCase("Grass") && typeQueue.equalsIgnoreCase("Fire")) ||
               (typeStack.equalsIgnoreCase("Water") && typeQueue.equalsIgnoreCase("Grass"))) {
        return -1; 
    } else {
        return 0;  
    }
}

private static void crearArchivo(String nombreArchivo){
    File archivo = new File(nombreArchivo);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.close();
    } catch (FileNotFoundException ex) {
       ex.printStackTrace(System.out);
    }
    
}

private static void EscribirArchivo(String nombreArchivo,String showStackPokedex,String showQueuePokedex,String StackTeam,String QueueTeam, String Encounter){
    File archivo = new File(nombreArchivo);
    try {
        PrintWriter salida = new PrintWriter(archivo);
        salida.print(showStackPokedex);
        salida.print(showQueuePokedex);
        salida.print(StackTeam);
        salida.print(QueueTeam);
        salida.print(Encounter);
        salida.close();
    } catch (FileNotFoundException ex) {
       ex.printStackTrace(System.out);
    }
    
}












}