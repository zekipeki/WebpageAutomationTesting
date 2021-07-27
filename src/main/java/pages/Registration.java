package pages;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import additional.UserPersonalInformation;
import org.testng.Assert;

import java.util.List;

public class Registration {
    WebDriver driver;

    //sign in
    private By signInButton = By.className("login");
    //CREATE AN ACCOUNT
    private By emailField = By.id("email_create");
    private By createAnAccout = By.name("SubmitCreate");

    //registration
    private By firstName = By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By company = By.id("company");
    private By address1 = By.id("address1");
    private By address2 = By.id("address2");
    private By city = By.id("city");
    private By state = By.xpath("//*[@id=\"uniform-id_state\"]");
    private By postcode = By.id("postcode");
    private By country = By.xpath("//*[@id=\"id_country\"]");
    private By other = By.id("other");
    private By mobilePhone = By.xpath("//*[@id=\"phone_mobile\"]");
    private By submitAccount = By.id("submitAccount");
    private By password = By.id("passwd");
    private By homePage = By.xpath("//*[@id=\"header_logo\"]/a/img");


    public Registration(WebDriver driver) {
        this.driver = driver;
    }


    //sign in
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    //CREATE AN ACCOUNT
    public void populateEmailAdress(String strEmailAddress) {
        driver.findElement(emailField).sendKeys(strEmailAddress);
    }

    public void clickCreateAnAccount() {
        driver.findElement(createAnAccout).click();
    }


    //registration
    public void populateFirstName(String strFirstName) {
        driver.findElement(firstName).sendKeys(strFirstName);
    }

    public void populateLastName(String strLastName) {
        driver.findElement(lastName).sendKeys(strLastName);
    }

    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    public void populateCompany(String strCompany) {
        driver.findElement(company).sendKeys(strCompany);
    }

    public void populateAddress1(String strAddress1) {
        driver.findElement(address1).sendKeys(strAddress1);
    }

    public void populateAddress2(String strAddress2) {
        driver.findElement(address2).sendKeys(strAddress2);
    }

    public void populateCity(String strCity) {
        driver.findElement(city).sendKeys(strCity);
    }

    public void selectStateDropdown(String strState) {
        WebElement select = driver.findElement(state);
        List<WebElement> options = select.findElements(By.tagName("option"));

        for (WebElement option : options) {

            if (strState.equals(option.getText().trim()))

                option.click();
        }

    }

    public void populatePostcode(String strPostcode) {
        driver.findElement(postcode).sendKeys(strPostcode);
    }

    public void chooseCountry(String strCountry) {
        WebElement select = driver.findElement(country);
        List<WebElement> options = select.findElements(By.tagName("option"));

        for (WebElement option : options) {

            if (strCountry.equals(option.getText().trim()))

                option.click();
        }
    }

    public void populateOther(String strOther) {
        driver.findElement(other).sendKeys(strOther);
    }

    public void populateMobilePhone(String strMobilePhone) {
        driver.findElement(mobilePhone).sendKeys(strMobilePhone);
    }

    public void submitAccount() {
        driver.findElement(submitAccount).click();
    }

    public void returnToHomePage(){driver.findElement(homePage).click();}

    // DO fill Registration Details
    public void registerUser(UserPersonalInformation person) {

        this.clickSignInButton();
        this.populateEmailAdress(person.getEmailAddress());
        this.clickCreateAnAccount();
        this.populateFirstName(person.getFirstName());
        this.populateLastName(person.getLastName());
        this.setPassword(person.getPassword());
        this.populateCompany(person.getCompany());
        this.populateAddress1(person.getAddress1());
        this.populateAddress2(person.getAddress2());
        this.populateCity(person.getCity());
        this.selectStateDropdown(person.getState());
        this.populatePostcode(person.getPostcode());
        this.chooseCountry(person.getCountry());
        this.populateOther(person.getOther());
        this.populateMobilePhone(person.getMobilePhone());
        this.submitAccount();

        String confirmationTextRegistration = driver.findElement(By.className("info-account")).getText();
        Assert.assertEquals(confirmationTextRegistration, "Welcome to your account. Here you can manage all of your personal information and orders.");
        System.out.print("\n\n"+confirmationTextRegistration+" \n");


        this.returnToHomePage();
        //promjen

    }
}



