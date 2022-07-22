package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By approveMyData = By.id("continue");

    public WebElement firstName(){return driver.findElement(firstName);}
    public WebElement lastName(){return driver.findElement(lastName);}

}
