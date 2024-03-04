
package calculadoraaritmetica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.ArrayList;


public class NPI {

public void leerArchivo() throws IOException{
    ArrayList<String> lista = new ArrayList<>();

     
        try{
            BufferedReader lector = new BufferedReader(new FileReader("Datos\\test1.input"));
        
            String recorrido;
     
            while((recorrido = lector.readLine())!=null){
             String bloques [] = recorrido.split(" ");
              
             for(String dato: bloques){
                    
               
                  lista.add(dato);
  
                
          }
               
         conversionNpi(lista);
              while(!lista.isEmpty()){
                  lista.clear();
              }
               
                
            }//fin del while para recorrer el archivos
       
        
        }catch(FileNotFoundException ex){
            System.out.println("Error al leer archivo"+ex);
        }
    }
   
public static void conversionNpi(ArrayList<String> lista) throws IOException {
 
   Stack<String> pila = new Stack<>();//pila aux para usar los datos
   Stack<String> posFija = new Stack<>();//pila para enviar
      for (int i = 0; i < lista.size(); i++) {
     
        if (jerarquia(lista.get(i)) > 0) {
            while (!pila.empty() && jerarquia(pila.peek()) >= jerarquia(lista.get(i))) {
                posFija.add(pila.pop());
            }
            pila.push(lista.get(i));
        } else {
            posFija.add(lista.get(i));
        }
    }
     while (!pila.empty()) {
        posFija.add(pila.pop());
    }
   
       
  
    resolverNpi(posFija);
  while (!pila.empty()) {
        posFija.pop();
    }
  
   
}
            
public static void resolverNpi(Stack<String> Npi) {
    StringBuilder escribir = new StringBuilder();
    Stack<Integer> datos = new Stack<>();
    Stack<String> npiReal = new Stack<>();//pila para enviar


    
    while(!Npi.empty()){
        npiReal.push(Npi.pop());
    } 
    while (! npiReal.empty()) {
        
        String elemento =  npiReal.pop();
      if (esOperador(elemento)) {
            int op2 = datos.pop();
            int op1 = datos.pop();
            int aux = operacion(op1, op2, elemento);
            datos.push(aux);
        }  
      else {try {
                int numero = Integer.parseInt(elemento);
                datos.push(numero);
            } catch (NumberFormatException e) {
                escribir.append("Error");
                 EscribirArchivo(escribir.toString());
                return;
            }
    }
    }

    int resultado = datos.pop();
    escribir.append(resultado);
    EscribirArchivo(escribir.toString());
}

public static boolean esOperador(String c) {
    return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
}

public static int operacion(int op1,int op2,String operador) {
        
    switch(operador){
        case "+": return op1+op2;
        case "-": return op1-op2;
        case "*": return op1*op2;
        case "/": 
            if(op2!=0){
                return op1/op2;
            }
            else{
           return 0;
              
            }
    }
    return 0;
    }
    
public static int jerarquia(String dato){
        
        switch(dato){
            case "+":
            case"-":
                return 1;
                
            case "*":
            case "/":
                return 2;
            default: return -1;    
                    
        }
        
    }
    
private static void EscribirArchivo(String resultado) {
        File archivo = new File("Datos\\test1.output");
        try {
            // Abre el archivo en modo de adición
            FileWriter fw = new FileWriter(archivo, true);
            PrintWriter salida = new PrintWriter(fw);
            salida.println(resultado);
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
