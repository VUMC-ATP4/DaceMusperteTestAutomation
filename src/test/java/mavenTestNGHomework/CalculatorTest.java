package mavenTestNGHomework;

import classroomSix.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculatorTest {

    Calculator calculator;

    @BeforeTest
    public void pirmsTesta(){
        System.out.println("Sākās tests");
        calculator = new Calculator();
    }

    @Test
    public void testAddition(){
        System.out.println("Šis ir mans mājas darba TestNG tests - saskaitīšana!");

        int actualResult = calculator.add(13,25);
        int expectedResult = 38;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubstraction(){
        System.out.println("Šis ir mans mājas darba TestNG tests - atņemšana!");
        int actualResult = calculator.substract(25,13);
        int expectedResult = 12;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiplication(){
        System.out.println("Šis ir mans mājas darba TestNG tests - reizināšana!");
        int actualResult = calculator.multiply(8,2);
        int expectedResult = 16;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testDivision(){
        System.out.println("Šis ir mans mājas darba TestNG tests - dalīšana!");
        float actualResult = calculator.divide(8,2);
        float expectedResult = 4;
        Assert.assertEquals(actualResult, expectedResult);
    }






}
