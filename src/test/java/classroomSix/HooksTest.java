package classroomSix;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HooksTest {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @BeforeMethod
    public void beforeMethod2(){
        System.out.println("Before Method2");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeTest
    public void beforeTest2(){
        System.out.println("Before Test2");
    }

    @Test
    public void test1(){
        System.out.println("TEST1");
    }

    @Test
    public void test2(){
        System.out.println("TEST2");
    }

}
