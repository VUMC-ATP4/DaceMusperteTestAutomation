package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebPageTest {

    WebDriver chromeBrowser;

    @BeforeMethod
    public void openBrowser(){
        chromeBrowser = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser(){
        chromeBrowser.quit();
    }

    @Test
    public void test1(){
        chromeBrowser.get("https://www.valmierasnovads.lv/");
        String expectedTitle = "Valmieras novada pašvaldība";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @Test
    public void test2(){
        chromeBrowser.get("https://jk.lv/");
        String expectedTitle = "Juridiska Koledža – Juridiska Koledža";
        String actualTitle = chromeBrowser.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
