package test;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Registration;
import pages.Shopping;
import additional.UserPersonalInformation;
import pages.PasswordRecovery;
import pages.SignIn;

import java.util.concurrent.TimeUnit;

public class Tests {
    WebDriver driver;
    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        //report = new ExtentReports("C:\\Users\\sumej\\OneDrive\\Desktop\\Report.html");
        //test = report.startTest("Verify Shopping");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(enabled = false )
    public void testShoppingAndRegistration() {


        UserPersonalInformation person= new UserPersonalInformation();

        person.setEmailAddress("personpere@example.com");
        person.setPassword("pass123");
        person.setFirstName("Miko");
        person.setLastName("Oli");
        person.setCompany("Rad");
        person.setAddress1("Adresa");
        person.setAddress2("adresa");
        person.setState("Florida");
        person.setCity("NY City");
        person.setCountry("United States");
        person.setPostcode("12365");
        person.setOther("Other");
        person.setMobilePhone("123369");

        Registration user = new Registration(driver);
        user.registerUser(person);

        Shopping shopping = new Shopping(driver);
        shopping.doShopping("Faded Short Sleeve T-shirts", "2");

    }

    @Test(enabled = false)
    public void testPasswordRecovery(){
        PasswordRecovery passwordRecovery = new PasswordRecovery(driver);
        passwordRecovery.recoverPassword("miromiric@example.com");
    }

    @Test(enabled = true)
    public void testOrderEnormous(){
        SignIn obj=new SignIn(driver);
        obj.logUser("miromiric@example.com","miro2");

        Shopping shopping = new Shopping(driver);
        shopping.doShopping("Faded Short Sleeve T-shirts", "9");

    }


    @AfterTest
    public void afterTest() {

        driver.quit();
        //report.endTest(test);
        //report.flush();
    }


}


