package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    public WebDriver driver;
    private By pageTitle = By.cssSelector("div[id='header_container'] span[class='title']");
    private By chooseAddToCart = By.id("add-to-cart-sauce-labs-backpack");

    private By shoppingCartContainer = By.id("shopping_cart_container");
    private By linkedinLink = By.linkText("LinkedIn");
    private By facebook = By.linkText("Facebook");
    private By twitter = By.linkText("Twitter");


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPageTitle(){
        return driver.findElement(pageTitle);
    }
    public WebElement chooseAddToCart() {return driver.findElement(chooseAddToCart);}

    public WebElement getLinkedinLink(){
        return driver.findElement(linkedinLink);
    }
    public WebElement getfacebook(){
        return driver.findElement(facebook);
    }
    public WebElement gettwitter(){
        return driver.findElement(twitter);
    }
}
