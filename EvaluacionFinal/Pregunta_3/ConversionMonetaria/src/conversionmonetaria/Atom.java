
package conversionmonetaria;


public enum Atom {
    DOLARES(":dolares"),
    YENS(":yens"),
    EUROS(":euros"),
    BOLIVARES(":bolivares"),
    BITCOINS(":bitcoins");

    private final String nombre;

    Atom(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}