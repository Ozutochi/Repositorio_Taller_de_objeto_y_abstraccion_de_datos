
package productocartesiano;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductoCartesiano {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Archivos\\test.input"));

            StringBuilder resultado = new StringBuilder(); // Creamos un StringBuilder para almacenar el resultado

            // Leer el archivo de entrada
            String entrada;
            while ((entrada = reader.readLine()) != null) {
                List<String> lista1 = Arrays.asList(entrada.split(" X ")[0].replaceAll("[\"{} ]", "").split(","));
                List<String> lista2 = Arrays.asList(entrada.split(" X ")[1].replaceAll("[\"{} ]", "").split(","));

                // Calcular el producto cartesiano
                List<List<String>> productoCartesiano = calcularProductoCartesiano(lista1, lista2);

                // Construir la representación del producto cartesiano como una cadena y añadirlo al StringBuilder
                resultado.append("{");
                for (int i = 0; i < productoCartesiano.size(); i++) {
                    resultado.append("(").append(String.join(", ", productoCartesiano.get(i))).append(")");
                    if (i != productoCartesiano.size() - 1) {
                        resultado.append(", ");
                    }
                }
                resultado.append("}\n"); // Añade un salto de línea después de cada producto cartesiano
            }

            // Escribir el resultado en el archivo utilizando el método EscribirArchivo
            EscribirArchivo("Archivos\\test.output", resultado.toString());
              System.out.println("Archivo Creado con exito buscar en la ruta src\\productocartesiano\\Archivos");
            // Cerrar los recursos
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void EscribirArchivo(String nombreArchivo, String producto) {
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.print(producto);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static <T> List<List<T>> calcularProductoCartesiano(List<T> lista1, List<T> lista2) {
        List<List<T>> resultado = new ArrayList<>();
        for (T elemento1 : lista1) {
            for (T elemento2 : lista2) {
                List<T> parOrdenado = new ArrayList<>();
                parOrdenado.add(elemento1);
                parOrdenado.add(elemento2);
                resultado.add(parOrdenado);
            }
        }
        return resultado;
    }
}

