import Domain.Calculadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculadora calculadora;
    // Iniciar el objeto antes de cada test
    @BeforeAll
    public static void init(){
        calculadora = new Calculadora();
    }
    @Test
    public void whenCalculatorInitializedThenReturnTrue(){
        assertTrue(calculadora.getStatus());
    }
    @Test
    public void whenAdditionTwoNumberThenReturnCorrectAnswer() {
        assertEquals(5,calculadora.adittion(2,3));
    }
    @Test
    public void whenSubtractTwoNumberThenReturnCorrectAnswer() {
        assertEquals(2,calculadora.subtract(5,3));
    }
    @Test
    public void whenDivisionThenReturnCorrectAnswer(){
        assertEquals(2,calculadora.division(8,4));
    }
    @Test
    public void whenDivisionByZeroThenThrowException(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            calculadora.division(5,0);
        });
        assertEquals("No se puede dividir por cero",exception.getMessage());
    }
    // Test para la multiplicacion
    @Test
    public void whenMultiplyThenrReturnCorrectAnswer(){
        assertEquals(8,calculadora.multiply(4,2));
    }
    // Test para la potenciacion
    @Test
    public void whenPowerThenReturnCorrectAnswer()
    {
        assertEquals(16,calculadora.power(-4,2));
    }
    // Test para logartimo con base 10
    @Test
    public void whenLogarithmThenReturnCorrectAnswer()
    {
        assertEquals(2,calculadora.logarithm10(100));
    }
    // Test para el logaritmo de 0
    @Test
    public void whenLogarithmByBaseZeroThenThrowException(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            calculadora.logarithm10(0);
        });
        assertEquals("No se puede obtener el logaritmo de cero",exception.getMessage());
    }
    // Test para el logaritmo de un numero negativo
    @Test
    public void whenLogarithmByNegativeBaseThenThrowException(){
        Throwable exception = assertThrows(IllegalArgumentException.class,()->{
            calculadora.logarithm10(-3);
        });
        assertEquals("No se puede obtener el logaritmo de un numero negativo",exception.getMessage());
    }
}
