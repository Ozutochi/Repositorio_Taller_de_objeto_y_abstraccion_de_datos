package conversionmonetaria;

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
//si es mayor se multiplica si es menor se divide
    // Método para convertir la moneda actual a otra moneda
   public double en(Atom otraMoneda, double cantidad) {
    if (otraMoneda == Atom.DOLARES) {
        return this.getValor() * cantidad; // Convertir a dólares
    } else if (otraMoneda == Atom.YENS) {
        
       return this.getValor() * cantidad / 0.006692;
    
    } else if (otraMoneda == Atom.EUROS) {
         if(this.getValor()==66604.502 || this.getValor()==1.0896267){
            return this.getValor() * cantidad / 1.0896267;
        }
        else {
            return this.getValor() * cantidad * 1.0896267;
        }
   
    } else if (otraMoneda == Atom.BOLIVARES) {
        
        return this.getValor() * cantidad / 0.0277022;
        
          
        
    } else if (otraMoneda == Atom.BITCOINS) {
        return this.getValor() * cantidad / 66604.502; // Convertir a dólares y luego a bitcoins
    } else {
        throw new IllegalArgumentException("Moneda no válida");
    }
}


    // Método para comparar dos monedas
    public String comparar(Moneda otraMoneda,double cantidadPrimeraMoneda,double cantidadSegundaMoneda) {
        if ((this.valor*cantidadPrimeraMoneda) < (otraMoneda.getValor()*cantidadSegundaMoneda)) {
            return ":menor";
        } else if ((this.valor*cantidadPrimeraMoneda) > (otraMoneda.getValor()*cantidadSegundaMoneda)) {
            return ":mayor";
        } else {
            return ":igual";
        }
    }
}

class Dolar extends Moneda {
    public Dolar() {
        super("Dólar", 1.0);
    }
}

class Yen extends Moneda {
    public Yen() {
        super("Yen", 0.006692); // Valor aproximado en dólares según tasa de cambio actual
    }
}

class Euro extends Moneda {
    public Euro() {
        super("Euro", 1.0896267); // Valor aproximado en dólares según tasa de cambio actual
    }
}

class Bolivar extends Moneda {
    public Bolivar() {
        super("Bolívar", 0.0277022); // Valor aproximado en dólares según tasa de cambio actual
    }
}

class Bitcoin extends Moneda {
    public Bitcoin() {
        super("Bitcoin", 66604.502); // Valor aproximado en dólares según tasa de cambio actual
    }
}