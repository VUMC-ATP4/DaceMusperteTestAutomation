import classroomSix.MyCalculator;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyCalculatorTestTest {

    MyCalculator myCalculator;

    @BeforeTest
    public void pirmsTesta(){
        System.out.println("Sākās tests");
        myCalculator = new MyCalculator();
    }

    @Test
    public void testSum(){
        System.out.println("Šis ir mans pirmais TestNG tests!");

        int actualResult = myCalculator.sum(13,25);
        int expectedResult = 38;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMultiply(){

        Assert.assertEquals(myCalculator.multiply(5,5),25);
    }


}
