package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {

    WebDriver driver;

    private
    //log in, ALREADY REGISTERED?
    By email = By.id("email");
    By password = By.id("passwd");
    By submitLogin = By.name("SubmitLogin");

    public SignIn(WebDriver driver) { this.driver = driver; }


    //login, ALREADY REGISTERED?

    public void userName(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickSignInButton() {
        driver.findElement(submitLogin).click();
    }


    //DO log in

    public void logUser(String strEmail, String strPassword) {
        this.userName(strEmail);
        this.setPassword(strPassword);
        this.clickSignInButton();
    }
}
