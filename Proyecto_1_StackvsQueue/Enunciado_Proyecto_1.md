# Proyecto 1: Stack Vs Queue
Los eternos rivales Stack y Queue siempre se encuentra compitiendo. Con tus habilidades de programación crea un simulador para poner aprueba sus estrategias.

## Detalles de implementación
- Implemente una clase PocketMonster con los atributos:
    - type: String;
    - name: String;

    Solo existen 3 tipos: Water, Fire, Grass. Y se relacionan de la siguiente forma: Water > Fire, Fire > Grass, Grass > Water.

- Implemente una clase abstracta Group, que tenga los métodos: 
    - add: team.add(PocketMonster) -> Team
    - remove: team.remove() -> Team
    - show: team.show() -> String. Dicho String es una lista de los nombres de los PocketMonster que existen en el equipo en el orden correspondiente. Ejemplo: Charizard/Fire, Chikorita/Grass, Squirtle/Water. Finalizado en un salto de línea.

- Implemente un mecanismo de lectura de archivo este archivo tendra la extension ".mpdm" y contendra toda la data e instrucciones para realizar la corrida. Debe ser capaz de manejar errores de entrada en el archivo.

- Luego de que se compile el proyecto debe correrse de esta forma: ./proyecto1 test.mpdm

- Ejemplo archivo de entrada:
```
CREATE STACK POKEDEX
Charmander/Fire, Charmeleon/Fire, Charizard/Fire, Chikorita/Grass, Psyduck/Water, Meganium/Grass, Chimchar/Fire, Cacnea/Grass, Wailmer/Water
CREATE QUEUE POKEDEX
Blastoise/Water, Feraligatr/Water, Sceptile/Grass, Gorebyss/Water, Piplup/Water, Tepig/Fire, Torchic/Fire, Typhlosion/Fire, Rapidash/Fire
SHOW STACK POKEDEX
CREATE STACK TEAM
Fire Water Grass
CREATE QUEUE TEAM
Fire Fire Fire
SHOW STACK TEAM
ENCOUNTER
```

- Ejemplo archivo de salida:
```
Wailmer/Water, Cacnea/Grass, Chimchar/Fire, Meganium/Grass, Psyduck/Water, Chikorita/Grass, Charizard/Fire, Charmeleon/Fire, Charmander/Fire
STACK TEAM Cacnea/Grass, Wailmer/Water, Chimchar/Fire
TURN 1
Cacnea/Grass VS Tepig/Fire -> Tepig/Fire
TURN 2
Wailmer/Water VS Torchic/Fire -> Wailmer/Water
TURN 3
Wailmer/Water VS Typhlosion/Fire -> Wailmer/Water
TURN 4
Wailmer/Water VS Tepig/Fire -> Wailmer/Water
STACK TEAM WINS
```

- Existen 2 Finales Posibles para la linea de final del combate:
    - hay un ganador en cuyo caso se sigue el formato del ejemplo. Hay un ganador cuando el equipo del adversario se encuentra vacio.
    - no hay un ganador en cuyo caso se coloca solamente TIE. Esto sucede si ambos equipos tienen un solo elemento y es el mismo, dado que este encuentro seguiria indefinidamente en circunstancias normales. 

## Observaciones


## Detalles de la evaluación

El repositorio debe incluir un documento readme.md en el cual se indique: Estructura del proyecto y Detalles de implementación.

Los equipos deben estar conformados por 2 estudiantes inscritos en la materia Taller de Objetos y Abstraccion de Datos, en caso de que quede 1 alumno sin equipo puede trabajar de forma individual.

El profesor no recibirá más invitaciones al repositorio después del martes 12/12/2023 a las 6:00 am, equipo que no haya registrado para esa fecha se considera que no participará en la evaluación.

No se evaluará el contenido del repositorio que haya sido subido a github después de las 6:00 am del 18/12/2023.