package conversionmonetaria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        // Rutas de los archivos de entrada y salida



        // Procesar el archivo de entrada y escribir en el archivo de salida
        procesarArchivo("Archivos\\test.input", "Archivos\\test.output");
         System.out.println("Archivo Creado con exito buscar en la ruta src\\conversionmonetaria\\Archivos");
    }

    public static void procesarArchivo(String archivoEntrada, String archivoSalida) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            StringBuilder resultado = new StringBuilder();

            String linea;
while ((linea = lector.readLine()) != null) {
    // Procesar cada línea del archivo de entrada
    String[] partes = linea.split("\\.");
    double cantidad = Double.parseDouble(partes[0].replace(',', '.'));
    //String para el primer if
    String primeraMoneda = partes[1];
    String monedaDestino="";
  if (partes[2].startsWith("en")) {
    monedaDestino = partes[2].substring(4, partes[2].length() - 2);
} else if (partes[2].startsWith("comparar")) {
 monedaDestino = partes[3].substring(0, partes[3].length() - 1);


}

    String operacion = partes[2].substring(0, 2);
    
 
    
    //String para el segundo if

    
    
    
    Atom primeraMonedaAtom=Atom.valueOf(primeraMoneda.toUpperCase());
    Atom monedaDestinoAtom = Atom.valueOf(monedaDestino.toUpperCase());

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
    
    
    
    
    
    
}        lector.close();

            // Escribir el resultado en el archivo de salida
            EscribirArchivo(archivoSalida, resultado.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
}
