package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;


public class Shopping {
        WebDriver driver;

        //shopping
        private By quantity = By.xpath("//*[@id=\"quantity_wanted\"]");
        private By addToChart = By.xpath("//*[contains(text(),'Add to cart')]");
        private By proceed1 = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");
        private By proceed2 = By.xpath("/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]");
        private By proceed3 = By.xpath("//*[@id=\"center_column\"]/form/p/button");
        private By terms = By.name("cgv");
        private By proceed4 = By.xpath("//*[@id=\"form\"]/p/button");
        private By paymentMethod1 = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
        private By confirm = By.xpath("//*[@id=\"cart_navigation\"]/button");

        public Shopping(WebDriver driver) {
            this.driver = driver;
        }


        //shopping

        public void clickPreview(String strProductName) {
            driver.findElement(By.xpath("//*[contains(text(),'Faded Short Sleeve T-shirts')]")).click();
        }

        public void populateQuantity(String strQuantity) {

            driver.findElement(quantity).clear();
            driver.findElement(quantity).sendKeys(strQuantity);
        }

        public void addProductToChart() {
            driver.findElement(addToChart).click();
            //String message = driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/h2/text()")).getText();
            //Assert.assertEquals(message,"Product successfully added to your shopping cart");
            //System.out.print(message);
        }

        public void clickProceed1() {
            driver.findElement(proceed1).click();
            //String message = driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span/text()")).getText();
            //Assert.assertEquals(message,"Product successfully added to your shopping cart");
            //System.out.print(message);
        }

        public void clickProceed2() {
            driver.findElement(proceed2).click();
        }


        public void clickProceed3() {
            driver.findElement(proceed3).click();
        }

        public void clickTerms() {
            driver.findElement(terms).click();
        }

        public void clickProceed4() {
            driver.findElement(proceed4).click();
        }

        public void choosePaymentMethod() {
            driver.findElement(paymentMethod1).click();
        }

        public void confirmOrder() {
            driver.findElement(confirm).click();
        }




        //DO shopping

        public void doShopping(String strProductName, String strQuantity) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,800)");
            this.clickPreview(strProductName);

            js.executeScript("window.scrollBy(0,300)");

            this.populateQuantity(strQuantity);

            this.addProductToChart();

            this.clickProceed1();
            js.executeScript("window.scrollBy(0,300)");

            this.clickProceed2();

            js.executeScript("window.scrollBy(0,300)");

            this.clickProceed3();
            this.clickTerms();
            js.executeScript("window.scrollBy(0,300)");

            this.clickProceed4();
            js.executeScript("window.scrollBy(0,300)");

            this.choosePaymentMethod();
            js.executeScript("window.scrollBy(0,300)");

            this.confirmOrder();

            try {
                String ss1 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText();
                Assert.assertEquals(ss1,"Your order on My Store is complete.");
                System.out.print(ss1);

            }
            catch (NoSuchElementException e){
                System.out.print(e.getMessage());
                System.out.print("\n\n Oops, something went wrong.");}




        }

}
