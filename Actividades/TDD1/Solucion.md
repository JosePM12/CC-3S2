## Solucion

**Ejercicio 1**

Metodo con errores:

``` 
/**
 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo
 */
class Metodo {
    boolean andAll(boolean[] bits) {
        boolean result = bits[0];
        for(int i=1; i<31; i++) {
            result = result && bits[i];
        }
        return result;
    }
}
``` 

- `andAll([true, true, true, ..., true, true]) // 32 valores true` 

``` 
public class Ejercicio1 {
    public static void main(String[] args) {
        boolean bits[];
        bits = new boolean[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = true;
        }
        Metodo m = new Metodo();
        System.out.println(m.andAll(bits));
    }
}
``` 

En este caso obtenemos como resultado **true**

- `andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true ` 

``` 
public class Ejercicio1 {
    public static void main(String[] args) {
        boolean bits[];
        bits = new boolean[32];
        for (int i = 0; i < 32; i++) {
            if (i%2 == 0) {
                bits[i] = false;
            } else {
                bits[i] = true;
            }
        }
        Metodo m = new Metodo();
        System.out.println(m.andAll(bits));
    }
}
``` 

En este caso obtenemos como resultado `false`

- Jessica dice que todo está OK. Pero desafortunadamente su código tiene un error off-by-one . ¿Qué expresión tiene el error? 

Un error off-by-one sucede cuando se pretende realizar un bucle `n` veces, pero por error de tipeo en el codigo, el bucle se ejecuta `n-1` veces o `n+1` veces. En el primer caso, no se arroja alguna expresion de error ya que el compilador no detecta este tipo de error. En el segundo caso, el compilador arroja un error del tipo `out of bonds` para el indice.

- ¿Cuál podría ser el número de casos de prueba requeridos para probar esta función exhaustivamente?

Ya que tenemos un arreglo de 32 entradas, donde cada entrada puede tomar dos valores, para probar esta funcion exhaustivamente necesitariamos 2^32 casos.

**Ejercicio 2**

En la década de 1990, el vehículo de lanzamiento Ariane 5, diseñado y construido para la Agencia Espacial Europea, se autodestruyó 37 segundos después de su primer lanzamiento. El motivo fue un error del software de control que no se detectó. El software de guía del Ariane 5 se reutilizó del Ariane 4, que era un cohete más lento. Cuando el cálculo de la velocidad se convirtió de un número de coma flotante de 64 bits (el mismo que un número en TypeScript, aunque este software no se escribió en TypeScript) a un número entero con signo de 16 bits, desbordó el número entero pequeño y provocó una excepción. El controlador de excepciones se había deshabilitado por razones de eficiencia, por lo que el software de guía se bloqueó. Sin guía, el cohete también se estrelló. El costo de la falla fue de mil millones de dólares.

 ¿Qué ideas demuestra esta historia? 

- Probar todas las entradas posibles es la mejor solución a este problema. 

**Ejercicio 3**

Un conjunto de pruebas es correcto si: 

- Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal 

**Ejercicio 4**

Un conjunto de pruebas vacío no contiene casos de prueba. Suponiendo una especificación no trivial, un conjunto de pruebas vacío es: 

- Pequeña

**Ejercicio 5**

Supongamos que deseas dividir el espacio de entrada de esta función de raíz cuadrada:

```
/**
 * @param x debe ser no negativo
 * @retorna la raiz cuadrada de x
 */
public static int sqrt(int x)
```

Evalúe la calidad de cada una de las siguientes particiones candidatas. ¿Son los subdominios propuestos separados y completos, formando así una partición? ¿Son correctos, en el sentido de que cada subdominio puede ser cubierto por un caso de prueba legal? Para una buena partición debes marcar las tres alternativas.


```
// particion: x < 0; x >= 0
```

- Los subdominios están completos 
- Los subdominios son disjuntos

```
// particion: x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto

```
- Los subdominios son disjuntos
- Los subdominios son correctos

```
// particion: x=0, x=1, x=7, x=16
``` 
- Los subdominios son correctos

**Ejercicio 6**

Ahora considera esta especificación:

```
/**
 * @param x un entero 
 * @param y un entero, donde x, y no son ambos 0
 * @retorna el GCD de x e y
 */
/
public static int gcd(int x, int y);
```

Evalúa cada una de las siguientes particiones candidatas para gcd.

```
// particion: x e y no son  0
``` 

- Los subdominios no son disjuntos ya que solo tenemos un solo subdominio
- Los subdominios no estan completos ya que falta el caso en el que son 0
- Los subdominios son correctos ya que podemos cubrirlo por un caso de prueba legal

```
// particion: x es divisible por y; y es divisible por x; x e y son primeros relativos
```
`
- Los subdominios son disjuntos
- Los subdominios estan completos ya que se cubren todos los casos posibles
- Los subdominios son correctos

Podemos concluir que esta es una buena partición.

**Ejercicio 7**

Para esta función: 

```
/**`
 * @param winsAndLosses una cadena de a lo más 5 de consistiendo de los caracteres 'W' o 'L'
 * @retorna la fraccion de caracteres en winsAndLosses que son 'W'
 */

double winLossRatio(String winsAndLosses);
```
¿Cuáles son los valores límite apropiados para probar esta función?

Podemos particionar cada caracter de la cadena, supongamos que tenemos cada caracter b.

// particion en b:
//      b = 'W'
//      b = 'L'
// particion en a: 'W', 'L'.

Los valores limites para probar esta funcion serian dos:
- `a = 0` ya que no pueden haber menos de 0 `W` en la cadena
- `a = 5` ya que no pueden haber mas de 5 `W` en la cadena

**Ejercicio 8**

Considera la partición de `a` anterior:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición en realidad combina varios intereses distintos: el signo de `a`, la magnitud de `a` (pequeño o grande) y los valores límite 0 y 1. Podemos pensar en estos intereses como particiones independientes.
De entre las opciones a continuación, elija un subconjunto que serían particiones legales y que juntas captarían los mismos intereses.


- particion en a: `0, 1`
- particion en a: positivo, negativo
- particion en a: (donde "pequeño" encaja en long y "grande" no)

**Ejercicio 9**

Considera nuevamente esta partición `a` en un desde arriba:

```
// particion en a:
//     a = 0
//     a = 1
//     a es un entero pequeño > 1
//     a es un entero pequeño < 0
//     a es un entero grande positivo
//      a es un entero grande negativo (donde "pequeño" encaja en long y "grande" no)
```

Esta partición tiene 6 subdominios, por lo que pueden cubrirla 6 valores diferentes de `a`, uno elegido para cada subdominio. 

Supongamos que usamos estas tres particiones de a en su lugar:

```
// particion en a: 0, positivo, negativo
// particion en a: 1, !=1
// particion on a: donde "pequeño" encaja en long y "grande" no)
```

Si solo queremos cubrir cada subdominio de las tres particiones, ¿cuántos valores diferentes de a necesitaríamos?.

```
// particion en a: 0, positivo, negativo
```
En esta particion tenemos 3 subdominios por lo que necesitariamos 3 valores diferentes de `a`.

```
// particion en a: 1, !=1
```
En esta particion tenemos 2 subdominios por lo que necesitariamos 2 valores diferentes de `a`.

```
// particion on a: donde "pequeño" encaja en long y "grande" no)
```
En esta particion tenemos 2 subdominios por lo que necesitariamos 2 valores diferentes de `a`.


**Ejercicio 10**

A veces es conveniente pensar y escribir una partición de espacio de entrada en términos de la salida de la función, porque las variaciones en el comportamiento pueden ser más visibles allí. Por ejemplo: 

```
// particion en a.multiply(b): 0, positivo, negativo

```
es la abreviatura de la partición de tres subdominios que consta de:

```
 { (a,b) | a.multiply(b) = 0 }
 { (a,b) | a.multiply(b) > 0 }
 { (a,b) | a.multiply(b) < 0 }
```

Con este enfoque, ¿cuántos casos de prueba se necesitan para cubrir las siguientes tres particiones? 

```
// particion en a: 0, positivo, negativo
// particion en b: 0, positive, negativo
// particion en a.multiply(b): 0, positivo, negativo
```

```
// particion en a: 0, positivo, negativo
```
En esta particion tenemos 3 subdominios por lo que necesitariamos 3 valores diferentes de `a`.

```
// particion en b: 0, positivo, negativo
```
En esta particion tenemos 3 subdominios por lo que necesitariamos 3 valores diferentes de `b`.

```
// particion en a.multiply(b): 0, positivo, negativo
```
Esto va a depender de los valores que pueden tomar `a` y `b`

Se necesitarina 6 casos de prueba para cubrir las 3 particiones