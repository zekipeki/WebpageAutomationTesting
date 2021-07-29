package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SignIn {

    WebDriver driver;
    // Login

    By buttonLogin = By.className("login");
    //log in, ALREADY REGISTERED?
    By email = By.id("email");
    By password = By.id("passwd");
    By submitLogin = By.name("SubmitLogin");
    private By homePage = By.xpath("//*[@id=\"header_logo\"]/a/img");

    public SignIn(WebDriver driver) { this.driver = driver; }


    public void clickLoginButton(){driver.findElement(buttonLogin).click();}

    //login, ALREADY REGISTERED?

    public void setUserName(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickSignInButton() {
        driver.findElement(submitLogin).click();
    }
    public void returnToHomePage(){driver.findElement(homePage).click();}


    //DO log in

    public void logUser(String strEmail, String strPassword) {
        this.clickLoginButton();
        this.setUserName(strEmail);
        this.setPassword(strPassword);
        this.clickSignInButton();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");
        this.returnToHomePage();
    }
}
