# Examen Final valor 30 pts
## #1
Considere una clase B hereda de otra clase A (esto es, B subclase de A). Considere una clase Lista, parametrizable en el tipo de sus elementos, ¿Qué relación de herencia, de haberla, tienen Lista<A> y Lista<B> ? ¿Qué decisión toma el lenguaje Java? Explique dicha decisión. 6 ptos.

## #2
En Java, dadas 2 colecciones (de tipos posiblemente diferentes), se desea calcular el producto cartesiano de los elementos generados para cada una de ellas. Por ejemplo: el producto cartesiano de [:a, :b, :c] y [4,5] debe generar:
```
[:a, 4]
[:a, 5]
[:b, 4]
[:b, 5]
[:c, 4]
[:c, 5]
```
Nota #1: No importa el orden en que se devuelvan los elementos, sino que todos los elementos aparezcan.
Nota #2: El elemento [:a, 4] aparece en el ejemplo anterior pero [4, :a] no. El orden interno de las tuplas es importante. 11 puntos.

## #3
En Java, defina una clase Moneda con subclases Dolar, Yen, Euro, Bolivar y Bitcoin.
- Defina métodos **dolares**, **yens**, **euros**, **bolivares**, y **bitcoins** sobre la clase Float que convierta el flotante en dolares, yens, euros, bolivares y bitcoins, respectivamente.
- Defina un método **en** sobre la clase Moneda (y sus subclases por ende) que reciba un atomo entre :dolares, :yens, :euros, :bolivares y :bitcoins, y convierta la moneda en aquella representada por el atomo propuesto. Por ejemplo: 15.dolares.en(:euros) debe evaluar en 12.72 euros.
- Defina un método **comparar** sobre la clase Moneda, que reciba otra Moneda y las compare. Este método devuelve: :menor, :igual, :mayor. Por ejemplo: 50.bolivares.comparar(2.dolares) debe evaluar en :menor.
13 puntos.

Para las preguntas #2 y #3, pueden hacer 2 mains distintos asuman como es costumbre que la entrada y la salida seran mediante archivos llamados: test.input y test.output, donde cada linea del archivo de entrada es un comando a procesar. La fecha limite de entrega del proyecto es el jueves 07/03/2023 a las 7pm.
