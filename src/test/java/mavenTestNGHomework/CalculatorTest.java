import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {
    Calculator calculator;

    @BeforeMethod
    public void pirmsTesta(){
        System.out.println("Tests ir sācies!");
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
//        int actualResult = Calculator.result;
        int expectedResult = 8;

    }





}
