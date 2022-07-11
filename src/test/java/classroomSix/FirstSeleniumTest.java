package classroomSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void checkPageTitle(){
        String URL = "https://www.saucedemo.com/";
        WebDriver chromeBrowser = new ChromeDriver();
        chromeBrowser.get(URL);
        String expectedTitle = "Swag Labs";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        chromeBrowser.quit();
    }

    WebDriver chromeParluks;

    public final String expectedText = "Sauce Labs Backpack";

    @Test
    public void testPageTitle(){
        this.chromeParluks = new ChromeDriver();//atvert parlukprogrammu
        this.chromeParluks.navigate().to("https://www.lu.lv/");
        this.chromeParluks.manage().window().maximize();
        String expectedTitle = "Latvijas Universitāte";
        String actualTitle = chromeParluks.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterMethod
    public void closeBrowser(){
        chromeParluks.quit();
    }

    @Test
    public void tess12312323(){
        Assert.assertEquals("actuul text",expectedText);
        Assert.assertEquals("actuul text",expectedText);
    }


    @Test
    public void tess123123(){
        Assert.assertEquals("actuul text",expectedText);
    }


}
