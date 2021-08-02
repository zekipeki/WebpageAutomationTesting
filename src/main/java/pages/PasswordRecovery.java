package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PasswordRecovery {
    WebDriver driver;

    //sign in
    private By signInButton = By.className("login");

    //Forgot Your Password?
    private By ForgotYourPassword = By.cssSelector("#login_form > div > p.lost_password.form-group > a");

    //message
    private By Message1 = By.cssSelector(".box > p:nth-child(2)");

    //provide email address
    private By emailField = By.id("email");
    private By retrievePassword = By.className("submit");

    private By Message2 = By.cssSelector(".alert");

    //back to login
    private By backToLogIn= By.cssSelector("#form_forgotpassword > fieldset > p > button");

    public PasswordRecovery (WebDriver driver) {this.driver=driver;}


    //sign in
    public void clickSignInButton() {driver.findElement(signInButton).click();}

    //Forgot Your Password? button
    public void clickForgotYourPassword(){driver.findElement(ForgotYourPassword).click();}

    // guide message to user
    public void messageToUser1(){

        String message1= driver.findElement(Message1).getText();
        Assert.assertEquals(message1, "Please enter the email address you used to register. We will then send you a new password.");
        System.out.print(message1);
    }

    //provide email address
    public void populateEmailAdress(String strEmailAddress) {driver.findElement(emailField).sendKeys(strEmailAddress);}
    public void clickRetrievePassword() {driver.findElement(retrievePassword).click();}

    //back to login
    public void clickBackToLogIn() {
        driver.findElement(backToLogIn).click();
    }

    public void messageToUser2(String EmailAddress){
        String message2 = driver.findElement(Message2).getText();
        Assert.assertEquals(message2, "A confirmation email has been sent to your address: "+EmailAddress);
        System.out.print("\n\n"+ message2);
    }

    public void recoverPassword(String EmailAddress){
        this.clickSignInButton();
        this.clickForgotYourPassword();
        this.messageToUser1();
        this.populateEmailAdress(EmailAddress);
        this.clickRetrievePassword();
        this.clickBackToLogIn();
        this.messageToUser2(EmailAddress);

    }

}
