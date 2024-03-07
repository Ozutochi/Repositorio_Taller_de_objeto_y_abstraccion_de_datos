### Considere una clase B hereda de otra clase A (esto es, B subclase de A). Considere una clase Lista, parametrizable en el tipo de sus elementos, ¿Qué relación de herencia, de haberla, tienen Lista<A> y Lista<B> ? ¿Qué decisión toma el lenguaje Java? Explique dicha decisión.

    En Java, la relación de herencia entre Lista<A> y Lista<B> no es directa, 
    incluso si B es una subclase de A. Esto significa que, a diferencia de la herencia de clases 
    regulares, Lista<B> no es una subclase de Lista<A>. La razón de esta decisión radica en cómo
    Java maneja los tipos genéricos y la herencia de tipos genéricos.Esto se puede atribuir a 
    que el parámetro de tipo T no es covariante en Java.

    La covarianza es una propiedad que permite que una subclase herede el comportamiento 
    de su clase padre y extienda su comportamiento de maneras que no son posibles en la clase padre.
     En el caso de los generics en Java, el parámetro de tipo T no es covariante, 
    lo que significa que no se puede heredar una lista de un tipo de objeto a una lista 
    de un tipo de objeto más específico.

    Cuando definimos una clase genérica como Lista<T>, estamos creando una plantilla que puede trabajar
    con cualquier tipo de dato. Sin embargo, en tiempo de compilación, Java realiza un proceso llamado 
    "erasure" (borrado de tipo), lo que significa que la información sobre los tipos de datos
    se elimina de los objetos de tipo genérico después de la compilación.


    Este proceso se realiza principalmente por razones de compatibilidad con versiones anteriores
    y para garantizar la interoperabilidad con el código existente que no utiliza genéricos.
    Sin embargo, tiene implicaciones importantes en cómo se manejan las relaciones de herencia
    entre tipos genéricos.

    Cuando definimos Lista<A> y Lista<B>, aunque B sea una subclase de A,
    Java no considera que Lista<A> y Lista<B> sean subtipos entre sí. Esto se debe a que,
    después del proceso de erasure, ambos se convierten en simplemente Lista. No hay distinción entre 
    Lista<A> y Lista<B> en tiempo de ejecución, lo que implica que no podemos asignar una variable
    de tipo Lista<A> a una variable de tipo Lista<B>, ya que el compilador no puede garantizar 
    la seguridad de tipos en tiempo de ejecución.

    Si Java permitiera la asignación directa entre Lista<A> y Lista<B>,
    podríamos introducir errores de tipo en tiempo de ejecución,
    ya que Lista<A> espera manejar elementos de tipo A y Lista<B> espera manejar elementos de tipo B,
    que es una subclase de A. Permitir una relación de herencia directa entre Lista<A> y Lista<B> 
    podría conducir a violaciones de tipos y comportamientos inesperados.

    Para lograr un comportamiento similar al esperado
    (es decir, poder pasar una Lista<B> donde se espera una Lista<A> debido a la relación de herencia entre B y A),
    se puede utilizar el operador de extensión de tipo genérico ? extends T,
    que permite que una lista de cualquier subclase de T sea aceptada donde se espera una Lista<T>. 
    Por ejemplo, List<? extends A> aceptará tanto List<A> como List<B>, siempre que B sea una subclase de A.





