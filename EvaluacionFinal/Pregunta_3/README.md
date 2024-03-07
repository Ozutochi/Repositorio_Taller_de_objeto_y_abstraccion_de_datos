### En Java, defina una clase Moneda con subclases Dolar, Yen, Euro, Bolivar y Bitcoin. Defina métodos **dolares**, **yens**, **euros**, **bolivares**, y **bitcoins** sobre la clase Float que convierta el flotante en dolares, yens, euros, bolivares y bitcoins, respectivamente.- Defina un método **en** sobre la clase Moneda (y sus subclases por ende) que reciba un atomo entre :dolares, :yens, :euros, :bolivares y :bitcoins, y convierta la moneda en aquella representada por el atomo propuesto. Por ejemplo: 15.dolares.en(:euros) debe evaluar en 12.72 euros. Defina un método **comparar** sobre la clase Moneda, que reciba otra Moneda y las compare. Este método devuelve: :menor, :igual, :mayor. Por ejemplo: 50.bolivares.comparar(2.dolares) debe evaluar en :menor.

## Clase atom

Esta clase define una enumeración llamada Atom, que representa diferentes tipos de monedas.
Cada constante enum tiene un nombre y un valor asociado, 
donde el valor es una cadena que representa el nombre de la moneda en formato abreviado.

    DOLARES(":dolares"),
    YENS(":yens"),
    EUROS(":euros"),
    BOLIVARES(":bolivares"),
    BITCOINS(":bitcoins");
aqui se enumera las constantes de la enumeración. Cada constante enum representa un tipo de moneda y tiene un nombre y un valor asociado. Por ejemplo,
 DOLARES tiene el valor ":dolares", YENS tiene el valor ":yens", y así sucesivamente.

luego se declara una variable de instancia privada llamada nombre, que será utilizada para almacenar el nombre de la moneda.

    private final String nombre;

se crea el constructor
    Atom(String nombre) {
        this.nombre = nombre;
    }
que crea un parámetro de tipo String que representa el nombre de la moneda y lo asigna a la variable de instancia nombre.

y se utilizo el metodo
getNombre(), que es el metodo que devuelve el nombre de la moneda almacenado en la variable nombre.

Esta estructura enum se uso para definir un conjunto fijo de opciones que se pueden utilizar
en otros lugares del código, proporcionando una manera consistente de referirse a estos tipos 
de monedas en el programa representando el comportamiento de los atom en java.

## Clase Moneda

    import java.io.*;

    public class Moneda {
    private String nombre;
    private double valor;

    public Moneda(String nombre, double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }


Esta parte define la clase Moneda.

Tiene dos atributos privados: nombre 
(que representa el nombre de la moneda) y valor 
(que representa el valor de la moneda en relación con alguna otra moneda, en este caso, en dólares).



El constructor Moneda(String nombre, double valor) 
inicializa la moneda con el nombre y el valor especificados.

Los métodos getNombre() y getValor() 
son métodos de acceso para obtener el nombre y el valor de la moneda, respectivamente.(metodos comunes utilizados en java)

    public double en(Atom otraMoneda, double cantidad) {
        // Método para convertir la moneda actual a otra moneda
        if (otraMoneda == Atom.DOLARES) {
            return this.getValor() * cantidad; // Convertir a dólares
        } else if (otraMoneda == Atom.YENS) {
            return this.getValor() * cantidad / 0.006692; // Convertir a yenes
        } else if (otraMoneda == Atom.EUROS) {
            return this.getValor() * cantidad / 1.0896267; // Convertir a euros
        } else if (otraMoneda == Atom.BOLIVARES) {
            return this.getValor() * cantidad / 0.0277022; // Convertir a bolívares
        } else if (otraMoneda == Atom.BITCOINS) {
            return this.getValor() * cantidad / 66604.502; // Convertir a bitcoins
        } else {
            throw new IllegalArgumentException("Moneda no válida");
        }
    }


El método en(Atom otraMoneda, double cantidad) toma como argumentos una instancia 
de la enumeración Atom que representa la moneda a la que se va a convertir
y la cantidad de la moneda actual que se va a convertir.

En función del tipo de moneda especificado, 
el método realiza la conversión utilizando los valores de conversión predefinidos en las sub clases
y devuelve el valor convertido. para esto utiliza el comando this.getValor que devuelve el valor en dolares de la moneda que se quiere
convertir ejemplo el bolivar seria 0.0277022(aproximadamente) 

Si se especifica una moneda que no está definida en la enumeración Atom, 
el método lanza una excepción IllegalArgumentException.

    public String comparar(Moneda otraMoneda, double cantidadPrimeraMoneda, double cantidadSegundaMoneda) {
        // Método para comparar dos monedas
        if ((this.valor * cantidadPrimeraMoneda) < (otraMoneda.getValor() * cantidadSegundaMoneda)) {
            return ":menor";
        } else if ((this.valor * cantidadPrimeraMoneda) > (otraMoneda.getValor() * cantidadSegundaMoneda)) {
            return ":mayor";
        } else {
            return ":igual";
        }
    }
}

el metodo comparar compara dos monedas basándose en su valor.
 Toma como argumentos otra moneda y las cantidades de ambas monedas para comparar.

Compara el valor total de ambas cantidades de moneda y devuelve una cadena que indica 
si la primera moneda es menor, mayor o igual que la segunda moneda.

Las clases Dolar, Yen, Euro, Bolivar y Bitcoin son subclases de Moneda, cada una representa una moneda específica con su nombre y valor predefinidos. Estas clases simplemente llaman al constructor de la superclase Moneda 
con los valores apropiados para cada moneda. cabe resaltar que dichas clases usan el comando super
que sirve para llamar al constructor de la clase padre en este caso para definir la moneda y su valor en dolares

## Clase main

    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;
    import java.io.PrintWriter;

Estas son las importaciones de las clases que se utilizan en el código.

Estas importaciones son necesarias para 
operaciones de entrada/salida como java.io.File; java.io.BufferedReader;
    lectura de archivos java.io.FileReader;
    escritura de archivos java.io.PrintWriter;
    manejo de excepciones java.io.IOException; java.io.FileNotFoundException;

     public static void main(String[] args) {
     
        String archivoEntrada = "src\\conversionmonetaria\\Archivos\\test.input";
        String archivoSalida = "src\\conversionmonetaria\\Archivos\\test.output";


      procesarArchivo(archivoEntrada, archivoSalida);
    System.out.println("Archivo Creado con exito buscar en la ruta src\\conversionmontaria\\Archivos");
    }

la clase main crea dos variables tipo string para guardar la ruta de los archivos de entrada y salida
se llama al metodo procesarArchivo que recibe estos string para tener las rutas de los archivos a utilizar
y por ultimo si el proceso se realiza correctamente lanza un mensaje a la consola donde indica que el archivo se creo correctamente


    public static void procesarArchivo(String archivoEntrada, String archivoSalida) {
          
          try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            StringBuilder resultado = new StringBuilder();

            String linea;
            while ((linea = lector.readLine()) != null) {
                // Procesar cada línea del archivo de entrada
                String[] partes = linea.split("\\.");
                double cantidad = Double.parseDouble(partes[0].replace(',', '.'));

                // Obtener las monedas involucradas y la operación
                String primeraMoneda = partes[1];
                String monedaDestino = partes[2].substring(4, partes[2].length() - 1);
                String operacion = partes[2].substring(0, 2);

                // Convertir las monedas a sus representaciones como objetos Atom
                Atom primeraMonedaAtom = Atom.valueOf(primeraMoneda.toUpperCase());
                Atom monedaDestinoAtom = Atom.valueOf(monedaDestino.toUpperCase());

                // Realizar la operación correspondiente
                if (operacion.equals("en")) {
                    resultado.append(String.format("%.2f", cantidad)).append(" ").append(primeraMoneda).append(" = ").append(String.format("%.9f", obtenerMoneda(primeraMonedaAtom).en(monedaDestinoAtom, cantidad))).append(" ").append(monedaDestino).append("\n");
                } else if (operacion.equals("co")) {
                    double cantidadPrimeraMoneda = Double.parseDouble(partes[0].replace(',', '.'));
                    String[] partesSegundaMoneda = partes[2].split("\\.");
                    String cantidadString = partesSegundaMoneda[0].substring(partesSegundaMoneda[0].indexOf("(") + 1);
                    double cantidadSegundaMoneda = Double.parseDouble(cantidadString.replace(',', '.'));
                    
                    Moneda primeraMonedaObj = obtenerMoneda(primeraMonedaAtom);
                    Moneda segundaMonedaObj = obtenerMoneda(monedaDestinoAtom);
                    
                    resultado.append(primeraMonedaObj.comparar(segundaMonedaObj, cantidadPrimeraMoneda, cantidadSegundaMoneda)).append("\n");
                }
            }
            lector.close();

            // Escribir el resultado en el archivo de salida
            EscribirArchivo(archivoSalida, resultado.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

el metodo procesar empieza creando un objeto tipo bufferedReader para leer las lineas del archivo de entrada
luego crea un stringBuilder para guardar los resultados que se desean escribir en el archivo de salida

una variable string se usa junto con un while para leer linea por linea el archivo de entrada hasta que la linea quede
vacia

se separa la linea del archivo por puntos que representan la cantidad de la primera moneda su formato(dolares-euros-bolivares etc)
luego el comando a realizar (sea para el metodo en o el comparar) y por ultimo la catidad y formato de la segunda moneda
esto se consigue gracias a String [] partes  =linea.split("\\.") que toma los puntos por referencia de separacion

    double cantidad = Double.parseDouble(partes[0].replace(',', '.'));
     
    String primeraMoneda = partes[1];
    String monedaDestino="";
    if (partes[2].startsWith("en")) {
    monedaDestino = partes[2].substring(4, partes[2].length() - 1);
    } else if (partes[2].startsWith("comparar")) {
     monedaDestino = partes[3].substring(0, partes[3].length() - 1);}

    String operacion = partes[2].substring(0, 2);

en esta parte de codigo se definen en variables los datos antes mencionados sin embargo son usadas en el metodo "en"
un double para la cantidad de la moneda que se va a convertir siendo la partes[0] es decir la primera separacion de la linea
seguido de el formato de la primera moneda partes[1]

mas adelante se necesita la moneda destino que se consigue con un if que condiciona 
si ese segmento empieza en "en" toma cierta parte para tener el formato de la moneda sin tener algun caracter sobrante
ejemplo
en(:bitcoins) esto permite que se lea desde la letra b(4 caracter) hasta la s(ultimo gracias al comando length() - 1 que elimina el ultimo parentesis

si no el segmento empieza por comparar hace el mismo procedimiento pero empezando de lugares distintos debido a la diferencia de caracteres entre ambas palabras("en" y "comparar")
comparar(2.dolares) comienza desde el punto que se crea cuando se va a comparar tomandolo como un segmento mas y se va hasta la ultima letra usando el mismo comando length() - 1 que elimina el ultimo parentesis



    Atom primeraMonedaAtom=Atom.valueOf(primeraMoneda.toUpperCase());
    Atom monedaDestinoAtom = Atom.valueOf(monedaDestino.toUpperCase());


se crean objetos tipo atoms parapoder trabajar con ellos 
en el procesamiento de la operación monetaria. 

se usa el metodo valueof que es un método estático que se utiliza para obtener una instancia de la enumeración correspondiente al nombre especificado.
Por ejemplo, si tienes una enumeración Atom con los  siguientes valores: DOLARES, YENS, EUROS, BOLIVARES, BITCOINS, 
y llamas a Atom.valueOf("EUROS"), el método valueOf()  devolverá el valor EUROS de la enumeración Atom.
cabe destacar que estan en mayusculas gracias al comando toUpperCase


     if (operacion.equals("en")) {
        resultado.append(String.format("%.2f", cantidad)).append(" ").append(primeraMoneda).append(" = ").append(String.format("%.9f", obtenerMoneda(primeraMonedaAtom).en(monedaDestinoAtom,cantidad))).append(" ").append(monedaDestino).append("\n");

       
    } else if (operacion.equals("co")) {
    double cantidadPrimeraMoneda = Double.parseDouble(partes[0].replace(',', '.'));
     String[] partesSegundaMoneda = partes[2].split("\\.");
    String cantidadString = partesSegundaMoneda[0].substring(partesSegundaMoneda[0].indexOf("(") + 1);
    double cantidadSegundaMoneda = Double.parseDouble(cantidadString.replace(',', '.'));

    Moneda primeraMonedaObj = obtenerMoneda(primeraMonedaAtom);
    Moneda segundaMonedaObj = obtenerMoneda(monedaDestinoAtom);
    resultado.append(primeraMonedaObj.comparar(segundaMonedaObj,cantidadPrimeraMoneda,cantidadSegundaMoneda)).append("\n");
    }
        
se usan los comandos if y else if para definir que metodo se va a utilizar

el if lleva al metodo en

donde se anexa a resultado los parametros deseados como la cantidad de la moneda,su formato,el metodo obtenermoneda que recibe la moneda ya transformada en atom y usa el metodo "en"  
que recibe la moneda en la que se va a convertir y la cantidad para realizar su proceso(explicado anteriormente)
por ultimo agregando el nombre de la moneda que se quiere obtener

el else if se ejecuta si el comando quiere comparar monedas y saca sus propios datos como por ejemplo

 double cantidadPrimeraMoneda = Double.parseDouble(partes[0].replace(',', '.')); la cantidad de la primera moneda
el comando replace usado en esta linea cambia las comas por puntos una manera de poder usar decimales sin que se vea
limitado por la implementacion de los puntos como separadores

    String[] partesSegundaMoneda = partes[2].split("\\.");
    String cantidadString = partesSegundaMoneda[0].substring(partesSegundaMoneda[0].indexOf("(") + 1);
    double cantidadSegundaMoneda = Double.parseDouble(cantidadString.replace(',', '.'));


se crea otra seccion de grupos para sacar las cantidad de la segunda moneda donde se separa por el punto
con el split y luego se guarda en un string la cantidad eliminando los caracteres que no se necesitan

por ultimo se guarda en un double utilizando el string con la cantidad y usando el comando replace para los decimales

    Moneda primeraMonedaObj = obtenerMoneda(primeraMonedaAtom);
    Moneda segundaMonedaObj = obtenerMoneda(monedaDestinoAtom);
    resultado.append(primeraMonedaObj.comparar(segundaMonedaObj,cantidadPrimeraMoneda,cantidadSegundaMoneda)).append("\n");
    }

se crean objetos moneda para obtener las monedas que se van a utilizar en la operacion y se 
anexan al resultado con el metodo comparar que recibe las dos cantidades de las monedas mas las monedas a comparar(explicada anteriromente)


por ultimo se llama al metodo escribir mandandole la ruta del archivo y el resultado que e viene almacenando

    public static Moneda obtenerMoneda(Atom atom) {
        if (atom == Atom.DOLARES) {
            return new Dolar();
        } else if (atom == Atom.YENS) {
            return new Yen();
        } else if (atom == Atom.EUROS) {
            return new Euro();
        } else if (atom == Atom.BOLIVARES) {
            return new Bolivar();
        } else if (atom == Atom.BITCOINS) {
            return new Bitcoin();
        } else {
            throw new IllegalArgumentException("Moneda no válida");
        }
    }



Este método obtenerMoneda es responsable de crear y devolver una instancia de la clase Moneda según el tipo de moneda especificado como un objeto Atom
Recibe un parámetro atom de tipo Atom, que representa el tipo de moneda que se desea obtener.

    Si el objeto Atom es igual a Atom.DOLARES, crea una nueva instancia de la clase Dolar (que es una subclase de Moneda) y la devuelve.
    Si el objeto Atom es igual a Atom.YENS, crea una nueva instancia de la clase Yen.
    Si el objeto Atom es igual a Atom.EUROS, crea una nueva instancia de la clase Euro.
    Si el objeto Atom es igual a Atom.BOLIVARES, crea una nueva instancia de la clase Bolivar.
    Si el objeto Atom es igual a Atom.BITCOINS, crea una nueva instancia de la clase Bitcoin.
    Si el objeto Atom no coincide con ninguna de las monedas definidas, lanza una excepción IllegalArgumentException con el mensaje "Moneda no válida".

por ultimo Retorna la instancia de la moneda creada según el tipo de moneda especificado.

     public static void EscribirArchivo(String nombreArchivo, String resultado) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(resultado);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
se crea el metodo escribirArchivo donde recibe el nombre del archivo donde se va a escribir y el string builder que 
tiene el resultado de la operacion que se realizo
se crea el archivo con el comando File archivo = new File(nombreArchivo);
y lo anexa al archivo el texto obtenido con el comando  salida.print(resultado);

### Pasos para la ejecucion del programa

    1.- Abrir la consola de comando

    2.- Escribir el comando cd y colocar la ruta del proyecto descargado donde se encuentren los archivos.java ejemplo:
    cd C:\Users\Anhell\Documents\NetBeansProjects\ConversionMonetaria\src\conversionmonetaria

    3.- Una vez en esa ruta se debe compilar cada clase de java con el siguiente comando: javac -d . "nombre-de-la-clase".java para compilar el programa
    se debe hacer de este orden:
     javac -d . atom.java moneda.java main.java
    
    después de ejecutar estos código el programa esta compilado lo que no debería dar ningún error

    4.- una vez compilado se crean archivos .class en una nueva carpeta, y se necesita el nombre de la nueva carpeta que se cree al compilar en
    este caso debería crearse una carpeta llamada:

    .-conversionmonetaria

    dentro de la carpéta se crearon los archivos .class que se deben utilizar para ejecutar el programa
    una vez con ello listo se debe aplicar el siguiente comando: 
    java conversionmonetaria.Main

    5.- Si se ejecuto con éxito en el archivo de salida test.output se escribieron los resultados deseados
    mostrando un mensaje diciendo Archivo Creado con exito buscar en la ruta src\conversionmonetaria\Archivos

## Observaciones

     1.- Como el programa usa un nombre especifico para trabajar los archivos Entrada_#Nr deben ser editados para su correcto uso:
     ejemplo
     Incorrecto: test.input_1
     Correcto: test.input 
     se elimina el "_numero" de el archivo q se desee utilizar dejando entrada

     2.-El archivo editado se debe colocar en la carpeta Archivos ruta: src\conversionmonetaria\Archivos
 
     3- Si se realizaron los pasos anteriores(ejecución del programa) no se necesita volver a compilar por lo que pueden realizar solamente los pasos 4 y 5
 
     4.- Los Archivos test tienen ejemplos de:
      bolivares a yens
      dolares a euros
      dolares a bitcoins
      monedas a su mismo formato(dolar a dolar o bolivar a bolivar)
      monedas con decimales
    etc

## Archivo de entrada(ejemplo de linea)
500.bolivares.en("bolivares")

## Archivo de salida(ejemplo de linea)
500.00 bolivares = 500.000000000 bolivares

    se tomaron 9 decimales para representar mejor al bitcoins en su ejemplo
