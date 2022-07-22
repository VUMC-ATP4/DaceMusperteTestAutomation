package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    private By myProduct = By.id("item_4_title_link");
    private By checkout = By.name("checkout");
    public WebElement productInCart(){
        return driver.findElement(myProduct);
    }
    public WebElement checkout(){return driver.findElement(checkout);}
}
