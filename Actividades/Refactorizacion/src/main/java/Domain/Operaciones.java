package Domain;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

public class Operaciones {
    // Un clase de operaciones
    public Operaciones(){

    }
    public int adittion(int a, int b) {
        return  a + b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int division(int a, int b) {
        if(b==0){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } else{
            return a/b;
        }
    }

    public int multiply(int b, int a) {
        return a*b;
    }

    public int power(int a, int b) {
        return (int)pow(a,b);
    }


    public double logarithm10(int a) {
        if(a==0)
        {
            throw new IllegalArgumentException("No se puede obtener el logaritmo de cero");
        } else if (a<0) {
            throw  new IllegalArgumentException("No se puede obtener el logaritmo de un numero negativo");
        } else {
            return log10(a);
        }
    }
}
