# Calculadora aritmetica
Proyecto 2 de Taller de Abstracción de Datos.

Bachilleres: Angel Osuna 28.407.265
             Anagelys Mata 28.186.370

Antes de proceder a explicar la como de desarrolló en proyecto en base a los objetivos establecidos se deben tener ciertas consideraciones
  
    1.- El proyecto indicaba la resolución de ecuaciones por medio de la notacion polaca inversa y su representacion mediante
    los arboles binarios que manejan sus propiedades de recursividad. Nuestro proyecto no cumplio al 100% las expecificaciones
    requeridas puesto que no conseguimos dar con la logica proporcional para la resolucion del segundo punto (Creacion del arbol binario y su representacion grafica)
    2.- Pese a nuestra nuestra dificultades al entender decidimos dejar las clases que desarrollamos para explicar la logica que queriamos desarrollar
    estas vienen incluidas en el proyecto mas sin embargo no son utilizados a la hora de ejecutar dicho proyecto puesto que
    su ejecución provocaria errores que se decio evitar
    3.- En la clase donde se desarrollaria el arbol se decidio dejar los comentarios creados(con system.out.print) para entender mejor como veriamos el metodo

### Clase Main(Calculadora Aritmetica)
     En esta clase, para este proyecto no se utilizo muy ampliamente puesto que simplemente se creo una instancia de la
    clase NPI(siglas de notacion polaca inversa) cuyo objeto llama al metodo leerArchivo donde se ejecuta la operacion que dara el 
    resultado que se aspira.

    Se tenia pensado para que obtuviera una instancia de la clase ArbolBinario para su ejecucion pero dicha instancia
    no se coloco debido a que no se obtendrian los resultados esperados

### Clase NPI(Notación polaca inversa)
    Iniciando con esta clase se observan todos las librerias importadas para la ejecucion de la misma
    .-import java.io.BufferedReader;
    .-import java.io.File;
    .-import java.io.FileNotFoundException;
    .-import java.io.FileReader;
    .-import java.io.FileWriter;
    .-import java.io.IOException;
    .-import java.io.PrintWriter;
    .-import java.util.Stack;
    .-import java.util.ArrayList;
    
    Como se observa se encuentran librerias tanto para la lectura de archivos(BufferedReader - FileReader) 
    su escritura(File-FileWriter) manejo de excepciones(FileNotFoundException-IOException) y creacion de pila 
    y lista(Stack-ArrayList)

Esta clase contiene los metodos

    1.- leerArchivos
    Este metodo se implementa para leer el archivo en este caso test1.input su logica permite leer linea por linea
    hasta que llegue al final(quedando la linea en null).
    Su funcion mas grande es leer cada caracter y asignarlos a una lista que se crea al inicio del metodo
    una vez ingresa en esta lista auxiliar llama a un metodo estatico de la misma clase donde se realizara la conversion
    de la cadena de caracteres(la ecuacion) en su notacion polaca inversa
    Ya convertida y evaluada se procedio a colocar un bucle while que vacie la lista para que la siguiente linea
    del archivo que se lea se adjunte a la lista sin repetir los valores que la fueron evaluados en la lista anterior
    Gracias a este procedimiento se envia el parametro necesario(la lista) que necesita el siguiente  codigo para funcionar

    2.-conversionNpi
    Este metodo utiliza la lista enviada por el anterior para obtener los datos a convertir, anexado a eso crea dos
    instancias tipo stack (pila y posFija)para realizaar su debida logica, tambien usa dos metodos estaticos de la clase los cuales son
    el metodo jerarquia y el metodo resolverNpi
    como jerarquia es un metodo que se utiliza unicamente en la conversion conviene explicarla antes de seguir adelante
        2.1.-Jerarquia
            Es un metodo sencillo que retorna valores enteros para diferenciar el orden de jerarquias de los operadores y operandos
            Si el elemento leido es un operador "+" o "-" retorna un valor de 1 en caso de ser "*" o "/" retorna 2
            como se observa los operadores + y - son iguales en valor como tambien * y / comparten valor esto para respetar 
            la precedencia de los operadores
            si no es ninguno de los casos anteriores retorna por defecto el -1 que vendrian siendo para este proyecto los operandos
            es decir los numeros
    
    una vez conocio esto continuamos con el metodo de conversion
    la logica usada consta de preguntar si los operadores tiene mayor prioridad a la hora de ser evaluados de ser asi
    se utiliza el stack dato para colocar los operadores en espera de q alguno tenga mayor prioridad
    Por ejemplo, para la expresión "2 + 2 * 3":
    "2" se agrega directamente a la pila posFija.
    "+" se coloca en la pila pila.
    "2" se agrega directamente a la pila posFija.
    "*" tiene una prioridad más alta que "+", por lo que se mantiene en la pila pila.
    "3" se agrega directamente a la pila posFija.
    Luego, se desapilan los operadores de la pila pila en orden de precedencia. En este caso, solo "*" se desapila y se agrega a la pila posFija.
    Finalmente, "+", que es el último operador restante en la pila "pila", se desapila y se agrega a la pila posFija.
    Esto resulta en la notación posfija "2 2 3 * +".
    Una vez colocada en orden correcto se manda a llamar al metodo para realizar su resolucion

    3.-ResolverNpi
    La funcion de este metodo es resolver la expresion polaca obtenida anteriormente, utiliza 3 metodos estaticos de la clase
    (esOperador-operacion-escribirArchivo) y crea dos stacks para su ejecucion(datos-NpiReal)
    definiendo los metodos que utiliza para entender mejor su logica tenemos que
              3.1.- esOperador es un metodo sencillo que define si el elemento que recibe es igaul a uno de los 4 operadores
              definidor en el (suma-resta-multiplicacion-division) devuelve verdadera si coinciden
              3.2.-operacion como su nombre lo indica realiza con los datos que recibe(dos enteros que son los operandos
              y un String q es el operador) las operaciones correspondientes segun su operador
              No encontramos una manera organica de representar la division entre 0 que es un error comun 
              debido a esto simplemente colocamos 0
              3.3.- Escribir archivos solo toma un elemento tipo string y lo imprime en el archivo de salida que se nos pidia
              este imprime en cada linea el resultado de los datos en el input
              primera linea del output es resultado de la primera linea del input y asi sucesivamente
    NpiReal se usa para invertir la pila que recibimos ya q el metodo anterior la da de manera inversa (cima es cola-cola es cima)
    y datos se usa para la logica de la resolucion. El algoritmo comienza a procesar cada elemento de la pila npiReal en un bucle while. 
    Para cada elemento:
    Si es un operador (+, -, *, /), se sacan los dos operandos superiores de la pila datos, se realiza la operación correspondiente y se coloca el resultado nuevamente en la pila datos
    Si es un número, se convierte a entero y se coloca en la pila datos.
    Si no es ni un operador ni un número, se registra un error(los numero deben ser enteros) (0.5=Error)
    Una vez procesados todos los elementos de la pila npiReal, el resultado final estará en la cima de la pila datos.
    Se saca el resultado final de la pila datos, se convierte a una cadena y se escribe en el StringBuilder llamado escribir que esta creado al inico del metodo .
    Finalmente, se llama a la función EscribirArchivo() para escribir el resultado en el archivo test1.output.
            
## Clase NodoArbol
    Con esta clase se pensaba realizar la implementacion del arbol binario requerido pese a que no se pudo obtener como se deseaba 
    se explicara en lo mejor de lo posible su funcion
    Conteniendo 3 atributos la clase nodoArbol como su nombre indica representa los nodos del arbol binario a crear
    contiene una variable string llamada dato que tomara el valor del operador o del operando que se este evaluando
    tambien contiene dos atributos de su mismo tipo que representarian los hijos derecho e izquierdo de un nodo cuando
    este sea considerado como un nodo padre(caracteristica basica de un arbol binario)
    
    Contiene su constructor donde inicia sus atributos nodos (der-izq) en null y recibe el parametro a evaluar y lo asigna a su atributo
    El metodo toString no es relevante en la clase solo se añadio debido a que pensamos en q nos daria una vision mas clara del funcionamiento del arbol
    sin embargo no fue necesaria su implementacion

## Clase ArbolBinario
     La clase ArbolBinario tenia como objetivo crear el arbol y mostrarlo segun los parametros que lo representan debido a q no se pudo 
     el metodo contiene solo 3 metodos
     esOperador mismo metodo utilizado en la clase NPI para reconocer si el valor dado es un operador o un operando
     postOrden que se encarga de la recursividad del arbol llamandose a si mismo para representar en este caso en notacion polaca inversa
     los datos agregados al arbol. Se coloco este metodo solamente y no el preOrden puesto que su representacion es la misma que en
     la clase que creamos para realizar la notacion polaca inversa, lo tomamos como una verificacion de el trabajo realizado por la clase
     NPI.
     por ultimo esta el metodo agregar es el metodo que realizaria el arbol
    la logica que quisimos implementar el la siguiente
    tomamos una expresion y se transforma a notacion polaca inversa esa expresion es la que evaluariamos en este metodo quedando que
    los operadores se agregaran a la izquierda en el arbol y los numeros a la derecha siempre y cuando se cumplan ciertos requisitos
    en un ejemplo explicado seria 
    Logica de agregar
    [10, 3, *, 2, /, 3,* ] es un stack
    el metodo agregar recibe ese stack y realiza lo siguiente

    1.-primera iteracion
    si la raiz es vacia añade el primer termino en este caso *

    2.-siguiente iteracion (3)
    si el hijoderecho esta vacio y el hijoizquierdo esta vacio
    el elemento se añade en el hijo derecho de la raiz
    pero si el hijo izquierdo esta lleno el elemento ese hijo izquierdo pasa a ser padre
    y se repite hasta que el hijo izquierdo este vacio y el elemento se añade al hijo derecho
    en este caso el hijoizquierdo e hijoderecho estan vacios entonces el (3) se coloca en el hijo derecho de raiz(*)

    3.-siguiente iteracion(/)
    si es operador va a la izquierdo
    si la izquierda esta vacia se coloca en hijoizquierdo
    si no esta vacia ese hijo izquierdo pasa a ser padre y se repite
    hasta que hijoizquierdo este vacio
    en este caso izquierdo esta vacio asi q se coloca en hijoizquierdo de la raiz (*)

    4.-siguiente iteracion(2)
    si el hijoderecho esta vacio y el hijoizquierdo esta vacio
    el elemento se añade en el hijo derecho de la raiz
    pero si el hijo izquierdo esta lleno el elemento de ese hijo izquierdo pasa a ser padre
    y se repite hasta que el hijo izquierdo este vacio y el elemento se añade al hijo derecho
    en este caso el hijoizquierdo tiene un elemento(/) asi q pasa a ser padre (/)
    y como ese nuevo padre tiene los hijos vacios se coloca en la derecha

    5.-siguiente iteracion (*)
    si es operador va a la izquierda
    si la izquierda esta vacia se coloca en hijoizquierdo
    si no esta vacia ese hijo izquierdo pasa a ser padre y se repite
    hasta que hijoizquierdo este vacio
    en este caso izquierdo esta lleno (/) asi que ese pasa a ser padre y repite la pregunta
    como ahora si su hijo izquierdo esta vacio se coloca en el hijoizquierdo

    6.-siguiente iteracion(3)
    si el hijoderecho esta vacio y el hijoizquierdo esta vacio
    el elemento se añade en el hijo derecho de la raiz
     pero si el hijo izquierdo esta lleno el elemento ese hijo izquierdo pasa a ser padre
    y se repite hasta que el hijo izquierdo este vacio y el elemento se añade al hijo derecho
    en este caso el hijoizquierdo esta lleno (/) y pasa a ser padre vuelve a preguntar y esta lleno de nuevo asi q pasa a ser padre(*) hasta q su hijo izquierdo essta vacio
    como su hijo izquierdo y derecho estan vacios se coloca en el derecho

    7.-ultima iteracion(10)
    si el hijoderecho esta vacio y el hijoizquierdo esta vacio
    el elemento se añade en el hijo derecho de la raiz
     pero si el hijo izquierdo esta lleno el elemento ese hijo izquierdo pasa a ser padre
    y se repite hasta que el hijo izquierdo este vacio y el elemento se añade al hijo derecho
    en este caso el hijoizquierdo esta lleno(/) pasa a ser padre vuelve a preguntar y esta lleno de nuevo asi q pasa a ser padre(*) ahora si esta vacio pero el hijoderecho esta lleno (3) si esto pasa el metodo pregunta
    elemento actual (10)es mayor que el hijoderecho(3)
    si es mayor el hijoderecho pasa a hijo izquierdo y el elemento nuevo se coloca en hijoderecho
    si no el actual se coloca en hijoizquierdo

    Esta es la logica que teniamos en mente al realizar el arbol desafortunadamente no pudimos desarrollarla los system.out.print en el metodo
    agregar son hecho con el proposito de ver paso a paso el metodo como se ejecuta no tienen relevancia mas alla de mostrar visualmente 
    el proceso

Lamentamos no haber podido completar el trabajo asignado. Esperamos que los procesos realizados hasta ahora sean validos y de acuerdo a lo pedido

## Pasos para ejecución del programa:

    1.- Abrir la consola de comando

    2.- Escribir el comando cd y colocar la ruta del proyecto descargado donde se encuentren los archivos.java ejemplo:
        cd C:\Users\Anhell\Documents\NetBeansProjects\CalculadoraAritmetica\src\calculadoraaritmetica

    3.- Una vez en esa ruta se debe compilar cada clase de java con el siguiente comando: javac -d . "nombre-de-la-clase".java para compilar el programa
    se debe hacer de este orden:
            javac -d . NPI.java NodoArbol.java ArbolBinario.java CalculadoraAritmetica.java

    todo en una misma linea de comando

    después de ejecutar estos código el programa esta compilado lo que no debería dar ningún error

    4.- una vez compilado se crean archivos .class en una nueva carpeta, y se necesita el nombre de la nueva carpeta que se cree al compilar en
    este caso debería crearse una carpeta llamada:
       
      .-calculadoraaritmetica
       
    dentro de la carpéta se crearon los archivos .class que se deben utilizar para ejecutar el programa
    una vez con ello listo se debe aplicar el siguiente comando: 
    java calculadoraaritmetica.CalculadoraAritmetica

    5.- Si se ejecuto con éxito en el archivo de salida test1.output se escribieron los resultados deseados elegidos de las ecuaciones encontradas en el archivo de entrada test1.input
    para efectos visuales puede abrir el archivo creado con el navegador


## Ultimas observaciones

    1.-los archivos de entrada y salida estan en una carpeta llamada datos
    2-no se crearon nuevos archivos puesto q las ecuaciones fueron anexadas al archivo de entrada con varias formas para diferentes resultados
    desafortunadamente no podran apreciarse por la falta del arbol binario
    3.-Lamentamos si a la hora de ejecutar los pasos difieren con respecto a los de nuestros compañeros, el sistema no reconocia las clases si no se colocan de esa especifica
    forma 
    4.-Nos disculpamos nuevamente por las operaciones faltantes
