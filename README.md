# Stack_Vs_Queue
Proyecto 1 de Taller de Abstracción de Datos.
Bachilleres: Angel Osuna 28.407.265
         Anagelys Mata 28.186.370
         
Stack vs Queue
Estructura del proyecto 1  
Package(Paquete de java):com.mycompany.stackvsqueue almacena todos las clases utilizadas para la implementación del codigo
Implementación de clases:
A.- Clase Main(StackVsQueue): Utilizada para crear los metodos necesario para el manejo de Archivos
   Importaciones: 
         .-File: Utilzado para manejo de archivos, se añaden a dicho manejo los import: 
                       FileReader: Lectura de archivos.
                       FileNotFoundException: Manejo de excepciones de archivos.
                       PrintWriter: Creación y Escritura de archivos.
         .-BufferedReader: Utilizado para la lectura de archivos requeridos.
         .-IOException: Utilizado para manejo de errores en java.
## Metodos                                
   Los metodos en la clase Main manejan todo lo relacionado a archivos donde se utilizan instancias de otras clases como StackGroup y QueueGroup
           .-Main: Usado para crear instancias de los StackGroup y QueueGroup para que los siguientes metodos realicen las operaciones deseada tambien se utiliza para ejecutar dichas operaciones y obtener el archivo de salida requerido.
           .-CreateStackPokedex && CreateQueuePokedex: Crean a partir de las instrucciones de un archivo(Ingresado previamente) su respectiva pila y cola con los objetos necesario para la implementación del codigo.
           .-showStackPokedex && showQueuePokedex: Muestran el resultado de los metodos anteriores para corroborar que su funcionalidad haya sido la correcta mas se usa para imprimir dichos datos en el archivo de salida
           .-CreateStackTeam && CreateQueueTeam: Crean a partir de las instrucciones de un archivo(Ingresado previamente) una nueva pila y una nueva cola tomandos objetos de las pila y cola creadas por los metodos anteriores (CreateStackPokedex && CreateQueuePokedex) segun las indicaciones necesarias.
           .-Encounter: A partir de las instrucciones de un archivo(Ingresado previamente) procesa los encuentros entre los dos equipos ya elegidos dando resultados entre ganadores o empate depende de un metodo para dicho proceso que es el
                 *-compareTypes: Metodo utilizado en Encounter para comparar los tipos de cada equipo devolviendo un valor especifico para cada resultado posible (Entre 0,1,-1).
            .-crearArchivo && EscribirArchivo: Utilizados para el exclusivo manejo de el archivo de salida ambos dan el archivo con la información requerida guardandose en la carpeta EYS.

 ## Archivos
   Archivos en el proyecto para realizar acciones en el metodo main, su carpeta a destacar es:
        EYS: Carpeta creada para la contención de los archivos manejados por este programa.
Encontramos el archivo de Entrada y se guarda el archivo de Salida que se crea durante su ejecución(siendo dicho archivo de salida el objetivo del programa).

      
## Aspectos a tomar encuenta con los metodos y files:
1.-Todos los metodos son dependientes de un archivo ingresado para su perfecta ejecución (referido a los files del proyecto).
2.-El archivo de entrada debe colocarse en la carpeta EYS para su ejecución contando con tener el nombre y extensión requeridas(Entrada.mpdm).
3.-Todos los metodos buscan dos linea especifica sobre la cual trabajar por lo q se toma en cuenta dichas lineas como condicional para ejecutarse debidamente(Una para recibir la instrucción y una segunda para trabajar con dichos parametros) ejemplo:

 CreateStackPokedex
     depende de 
       .-CREATE STACK POKEDEX como instruccion para ejecutarse
       .-Charmander/Fire, Charmeleon/Fire, Charizard/Fire, Chikorita/Grass, Psyduck/Water, Meganium/Grass, Chimchar/Fire, Cacnea/Grass, Wailmer/Water como parametros para trabajar

4.-los metodos show y el metodo Encounter se abstiene de la regla anterior requeriendo de una sola linea del archivos para su ejecución

5.- Los metodos crearArchivo && EscribirArchivo no requieren instrucciones del archivo de entrada puesto que trabajan para dar uno de salida sin necesidad de recibir la instruccion.

6.-Cada metodo recibe un parametro creando el el metodo main necesario para su implementación lo cual lleva a lo siguiente:
Los metodos CreateStackPokedex && CreateQueuePokedex && showStackPokedex && showQueuePokedex requieren de una sola instancia que usan para guardar los pokemones o para mostrarlos en dicho caso.
Los metodos CreateStackTeam && CreateQueueTeam reciben tres parametro
          el primero recibe los pokemon guardados en la pokedex
          el segundo sirve para guardar los pokemones q seran usados en el enfrentamiento
          el ultimo es un auxiliar que ayuda a no perder pokemones a la hora de elegir algun pokemon que no se encuentre en la cila o el inico de cada grupo (utilizado como una pila o cola temporal hasta que se encuentre el pokemon deseado)

B.-Class Group: Una clase abstracta para implementar los metodos principales (Añadir-Remover-Mostrar)  de los grupos utilizados en el codigo(Stack y Queue).
No requiere metodo constructor ya que de esta no se debe crear ninguna instancia si no clase que extiendan de ella para utilizarse

C.- Class StackGroup && Class QueueGroup: Clases creadas para modificar la Pila y Cola necesitadas para realizar las operaciones estas extienden de la clase Group por lo que pueden usar sus metodos(Añadir-Remover-Mostrar) para su implementacion.
Requiere de dos clases para funcionar(Nodo-PocketMonster)
Ambas se diferencian por sus narutalezas por lo q sus atributos cambian:
StackGroup tiene un solo nodo UltimoValorIngresado puesto que su manejo (LIFO Last in-First out) permite trabajar en el las salidas y entradas.
QueueGroup debido a su naturaleza (FIFO First int-First out) necesita dos nodos startCola para realiza la salida y endCola para realizar el anexo de un nuevo objeto.

D.-Clase Nodo: Principalmente utilizada para el funcionamiento correcto de metodos de pilas y colas, sirve para observar mas a fondo como funciona el proceso de ingreso de parametros y su metodologia a la hora de anexarse, dependiendo de la manera requerida Pilas(LIFO Last in-First out) Colas(FIFO First int-First out)
Requieren de 2 parametros en este caso, un objeto de la clase PocketMonster y un nodo que actuaria como una posicion siguiente dependiendo de como se utilice.
Los metodos constructores estandar de estos se utilizaron en esta clase solo para observacion se puede ignorar alguno de los 3 dependiendo de las necesidades del usuario a la hora de utilizarlos.

F.-Clase PocketMonster: Crea los objetos necesarios para añadir a los grupos en este caso pokemones 
consta de dos atributos que son nombre y tipo, siendo con esto una clase sencilla hecha para asignar.

## Ejemplo de archivo de entrada (Entrada.mpdm)

CREATE STACK POKEDEX
Charmander/Fire, Charmeleon/Fire, Charizard/Fire, Chikorita/Grass, Psyduck/Water, Meganium/Grass, Chimchar/Fire, Cacnea/Grass, Wailmer/Water
SHOW STACK POKEDEX
CREATE QUEUE POKEDEX
Blastoise/Water, Feraligatr/Water, Sceptile/Grass, Gorebyss/Water, Piplup/Water, Tepig/Fire, Torchic/Fire, Typhlosion/Fire, Rapidash/Fire
SHOW QUEUE POKEDEX
CREATE STACK TEAM
Water Fire Grass
SHOW STACK TEAM
CREATE QUEUE TEAM
Grass Fire Fire
SHOW QUEUE TEAM
ENCOUNTER

## Ejemplo de archivo de salida
Lista del equipo STACK:
Wailmer/Water, Cacnea/Grass, Chimchar/Fire, Meganium/Grass, Psyduck/Water, Chikorita/Grass, Charizard/Fire, Charmeleon/Fire, Charmander/Fire, 
Lista del equipo QUEUE:
Blastoise/Water, Feraligatr/Water, Sceptile/Grass, Gorebyss/Water, Piplup/Water, Tepig/Fire, Torchic/Fire, Typhlosion/Fire, Rapidash/Fire, 
Lista del equipo STACK:
Cacnea/Grass, Chimchar/Fire, Wailmer/Water, 
Lista del equipo QUEUE:
Sceptile/Grass, Tepig/Fire, Torchic/Fire, 
Turn [1]
Cacnea/Grass VS Sceptile/Grass
--TIE--
Turn [2]
Cacnea/Grass VS Tepig/Fire
--Tepig/Fire wins--
Turn [3]
Chimchar/Fire VS Torchic/Fire
--TIE--
Turn [4]
Chimchar/Fire VS Sceptile/Grass
--Chimchar/Fire wins--
Turn [5]
Chimchar/Fire VS Tepig/Fire
--TIE--
--TIE MATCH---

