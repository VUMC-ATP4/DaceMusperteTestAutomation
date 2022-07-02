package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Inventory_Page;
import pageObjects.Login_Page;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    public final String SAUCELAB_URL = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setupBrowser(){
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void localHTMLExerciseTest() throws InterruptedException {
        driver.get("file://C:\\Users\\dacea\\DaceMusperteTestAutomation\\src\\test\\resources\\elements.html");
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys("Šis ir teksts par mani, hello hello");
        WebElement linkElement = driver.findElement(By.linkText("Link Text"));
        linkElement.click();
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
        Assert.assertEquals(isStudentCheckbox.isSelected(), false);
        isStudentCheckbox.click();
        Assert.assertEquals(isStudentCheckbox.isSelected(), true);
        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);
        milakaKrasa.selectByIndex(3);
        String [] asdas = {"asdas", "asdasas"};
        List<WebElement> sarakstsArKrasanm =  milakaKrasa.getOptions();

        for (int i = 0; i < sarakstsArKrasanm.size(); i++) {
            System.out.println(sarakstsArKrasanm.get(i).getText());
        }

        WebElement nospiedManiPoga = driver.findElement(By.id("checkDataResultID"));
        nospiedManiPoga.click();

        WebElement vissIrLabiTeksts = driver.findElement(By.id("checkDataResultID"));
        wait.until(ExpectedConditions.elementToBeClickable(vissIrLabiTeksts));
        vissIrLabiTeksts.click();

        Thread.sleep(5000);

    }



    @Test
    public void successfulLoginTest() throws InterruptedException {
        driver.get(SAUCELAB_URL);
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByValue("hilo");
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByIndex(1);
        Thread.sleep(5000);
        WebElement linkedinLink = driver.findElement(By.linkText("LinkedIn"));
        linkedinLink.click();
        Thread.sleep(5000);
    }

    @Test
    public void errorMessagePasswordEmptyPageObjectTest() {
        driver.get(SAUCELAB_URL);
        Login_Page loginPage = new Login_Page(driver);
        loginPage.getUsernameInputField().sendKeys("Juris");
        loginPage.getPasswordInputField().sendKeys("");
        loginPage.getLoginButton().click();
        Assert.assertEquals(loginPage.getErrorText().getText(),"Epic sadface: Password is required");
    }

    public void errorMessageUsernameEmptyPageObjectTest() {
        driver.get(SAUCELAB_URL);
        Login_Page loginPage = new Login_Page(driver);
//        loginPage.getUsernameInputField().sendKeys("Juris");
//        loginPage.getPasswordInputField().sendKeys("");
//        loginPage.getLoginButton().click();
        loginPage.login("", "qwerty123");
        Assert.assertEquals(loginPage.getErrorText().getText(),"Epic sadface: Password is required");
    }

    @Test
    public void successLoginPageObject(){
        driver.get(SAUCELAB_URL);
        Login_Page loginPage = new Login_Page(driver);
        loginPage.getUsernameInputField().sendKeys("standard_user");
        loginPage.getPasswordInputField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        Inventory_Page inventoryPage = new Inventory_Page(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(),"PRODUCTS");
        inventoryPage.getLinkedinLink().click();

    }


        @Test
    public void errorMessagePasswordEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELAB_URL);
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("Dace");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        System.out.println(errorText.getText());
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Password is required";
        Assert.assertEquals(actualText, expectedText);

//        Thread.sleep(5000);

    }

    @Test
    public void errorMessageUsernameEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELAB_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.name("password"));
        passwordInputField.sendKeys("qwerty123");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        System.out.println(errorText.getText());
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username is required";
        Assert.assertEquals(actualText, expectedText);

//        Thread.sleep(5000);
    }

    @Test
    public void errorMessageUsernameAndPasswordEmptyTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELAB_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        System.out.println(errorText.getText());
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username is required";
        Assert.assertEquals(actualText, expectedText);

//        Thread.sleep(5000);
    }

    @Test
    public void errorMessageWrongCredentialsTest() throws InterruptedException {
        System.out.println("TESTS");
        driver.get(SAUCELAB_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("Juris");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("qwerty123");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
//        System.out.println(errorText.getText());
        String actualText = errorText.getText();
        String expectedText = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(actualText, expectedText);

//        Thread.sleep(5000);
    }

    @Test
    public void MyTest2(){
        System.out.println("TESTS");
        driver.get(SAUCELAB_URL);

    }

    //ul[@class='mainMenu__menu']/li/button[text()='Studijas']


    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc testa");
        driver.quit();
    }

}
