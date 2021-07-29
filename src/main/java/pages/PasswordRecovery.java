package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PasswordRecovery {
    WebDriver driver;

    //sign in
    By signInButton = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    //Forgot Your Password?
    By forgotYourPassword = By.partialLinkText("http://automationpractice.com/index.php?controller=password");

    //provide email address
    By emailField = By.id("email");
    By retrievePassword = By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button");

    //back to login
    By backToLogIn= By.partialLinkText("http://automationpractice.com/index.php?controller=authentication");

    public PasswordRecovery (WebDriver driver) {this.driver=driver;}


    //sign in
    public void clickSignInButton() {

        driver.findElement(signInButton).click();
        //String confirmationTextRecovery1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/text()")).getText();
        //Assert.assertEquals(confirmationTextRecovery1, "Please enter the email address you used to register. We will then send you a new password. ");
        //System.out.print("\n\n"+confirmationTextRecovery1+" \n");
    }

    //Forgot Your Password?
    public void clickForgotYourPassword(){driver.findElement(forgotYourPassword).click();}

    //provide email address
    public void populateEmailAdress(String strEmailAddress) {driver.findElement(emailField).sendKeys(strEmailAddress);}
    public void clickRetrievePassword() {driver.findElement(retrievePassword).click();}

    //back to login
    public void clickBackToLogIn() {

        //String confirmationTextRecovery2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText();
        //Assert.assertEquals(confirmationTextRecovery2, "A confirmation email has been sent to your address: miromiric@example.com");
        //System.out.print("\n\n"+confirmationTextRecovery2+" \n");
        driver.findElement(backToLogIn).click();
    }

    public void recoverPassword(String EmailAddress){
        this.clickSignInButton();
        this.clickForgotYourPassword();
        this.populateEmailAdress(EmailAddress);
        this.clickRetrievePassword();
        this.clickBackToLogIn();

    }

}
