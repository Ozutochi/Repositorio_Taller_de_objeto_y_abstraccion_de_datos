### En Java, dadas 2 colecciones (de tipos posiblemente diferentes), se desea calcular el producto cartesiano de los elementos generados para cada una de ellas.Por ejemplo: el producto cartesiano de [:a, :b, :c] y [4,5]
    debe generar:
```
[:a, 4]
[:a, 5]
[:b, 4]
[:b, 5]
[:c, 4]
[:c, 5]
```

    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    Estas son las importaciones de las clases que se utilizan en el código.

    Estas importaciones son necesarias para:
    operaciones de entrada/salida como (java.io.File; java.io.BufferedReader;)
    lectura de archivos (java.io.FileReader;)
    escritura de archivos (java.io.PrintWriter;)
    manejo de excepciones (java.io.IOException; java.io.FileNotFoundException;)
    por ultimo se usaron importaciones para la manipulación de listas.java.util.List; java.util.Arrays; java.util.ArrayList;
 ```
    .-Se inicia un bloque try-catch para manejar posibles excepciones de entrada/salida (IOException).
    .-Se creo un BufferedReader para leer desde un archivo llamado "test.input"
    ubicado en la ruta especificada src\\productocartesiano\\Archivos\\test.input.
    .-Se creo un StringBuilder para almacenar el resultado del producto cartesiano.
    .-se uso una variable para recorrer las lineas del archivo String entrada;
    .-while ((entrada = reader.readLine()) != null) y un bucle while para recorrer cada linea del archivo hasta que no quede ninguna
    .-List<String> lista1 = Arrays.asList(entrada.split(" X ")[0].replaceAll("[\"{} ]", "").split(","));
      List<String> lista2 = Arrays.asList(entrada.split(" X ")[1].replaceAll("[\"{} ]", "").split(","));
     Se dividen las líneas leídas en dos listas separadas, lista1 y lista2 y se uso  el comando split para delimitar la X mas un replaceAll que elimina caracteres especificos en este caso comillas (se utilizo una barra invertida para que el progarama no tenga errores
     esta elimina las llaves y los espacios en blanco)
    .-List<List<String>> productoCartesiano = calcularProductoCartesiano(lista1, lista2);
      Se llama al método calcularProductoCartesiano  para calcular el producto cartesiano de las dos listas.
 ```
    .-resultado.append("{");
    Se agrega un "{" al StringBuilder para comenzar a construir la representación del producto cartesiano.
    .-for (int i = 0; i < productoCartesiano.size(); i++) {
    resultado.append("(").append(String.join(", ", productoCartesiano.get(i))).append(")");
    if (i != productoCartesiano.size() - 1) {
        resultado.append(", ");
    }
    }
    .-resultado.append("}\n");
    Se itera sobre el resultado del producto cartesiano y se construye una cadena para representar cada par ordenado.
    donde primero se anexa un parentesis de apertura seguido de los pares ordenados separados por una coma
    y el cierre del parentesis gracias al comando String.join
    .-luego con el if se pregunta si es el ultimo par ordenado, si no lo es se agrega una , y un espacio para separar los pares ordenados
    
 ```
    .-EscribirArchivo("src\\productocartesiano\\Archivos\\test.output", resultado.toString());
    .-Se llama al método EscribirArchivo para escribir el resultado en un archivo de salida llamado "test.output".
 ```
    .- private static void EscribirArchivo(String nombreArchivo, String producto) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.print(producto);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    se crea el metodo escribirArchivo donde recibe el nombre del archivo donde se va a escribir y el string builder que 
    tiene el resultado de la operacion que se realizo
    se crea el archivo con el comando File archivo = new File(nombreArchivo);
    y lo anexa al archivo el texto obtenido con el comando  salida.print(producto);

## Pasos para la ejecucion del programa

    1.- Abrir la consola de comando

    2.- Escribir el comando cd y colocar la ruta del proyecto descargado donde se encuentren los archivos.java ejemplo:
    cd C:\Users\Anhell\Documents\NetBeansProjects\ProductoCartesiano\src\productocartesiano

    3.- Una vez en esa ruta se debe compilar cada clase de java con el siguiente comando: javac -d . "nombre-de-la-clase".java para compilar el programa
    se debe hacer de este orden:
       javac -d . productocartesiano.java

    después de ejecutar estos código el programa esta compilado lo que no debería dar ningún error

    4.- una vez compilado se crean archivos .class en una nueva carpeta, y se necesita el nombre de la nueva carpeta que se cree al compilar en
    este caso debería crearse una carpeta llamada:
   
    .-productocartesiano
   
    dentro de la carpéta se crearon los archivos .class que se deben utilizar para ejecutar el programa
    una vez con ello listo se debe aplicar el siguiente comando: 
    java productocartesiano.ProductoCartesiano

    5.- Si se ejecuto con éxito en el archivo de salida test.output se escribieron los resultados deseados
    mostrando un mensaje diciendo Archivo Creado con exito buscar en la ruta src\productocartesiano\Archivos


Observacion

     1.- Como el programa usa un nombre especifico para trabajar los archivos Entrada_#Nr deben ser editados para su correcto uso:
     ejemplo
     Incorrecto: test.input1
     Correcto: test.input 
     se elimina el "numero" de el archivo q se desee utilizar dejando entrada

     2.-El archivo editado se debe colocar en la carpeta Archivos ruta: src\productocartesiano\Archivos
     
     3- Si se realizaron los pasos anteriores(ejecución del programa) no se necesita volver a compilar por lo que pueden realizar solamente los pasos 4 y 5
     
     4.- Los Archivos test tienen ejemplos de:
        String X int
        String X caracter
        int X string
        int X int
        caracter X float
        caracter X caracter
        etc

Archivo de entreda(Ejemplo de linea)

    {"Cadena", "String", "Prueba"} X {4, 5}

Archivo de salida (Ejemplo de linea)

    {(Cadena, 4), (Cadena, 5), (String, 4), (String, 5), (Prueba, 4), (Prueba, 5)}
              
