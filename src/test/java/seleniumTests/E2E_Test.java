package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class E2E_Test {


    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //////////https://www.seleniumeasy.com/selenium-tutorials/manage-webdriverdriver-executables-using-webdrivermanager
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        WebElement logo = driver.findElement(By.id("gh-la"));
        for(int j=1;j<40;j++){
            if(logo.isDisplayed()){
                break;
            }
            else {
                System.out.println("waiting for the logo to be visible.");
                Thread.sleep(500);
            }
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        /////https://www.youtube.com/watch?v=g6DXA_ND_Lo for highlighting in selenium
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','border: 2px solid red;');",logo);
        TimeUnit.SECONDS.sleep(5);
        js.executeScript("arguments[0].setAttribute('style','border: 2px solid yellow;');",logo);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("href found : "+driver.findElement(By.id("gh-la")).getAttribute("href"));
        //driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" + "&post_type=product");


//        List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
//        items.get(0).click();
//
//        WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
//        addToCart.click();
//
//
//        WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
//        cart.click();
//
//        WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
//        continueToCheckout.click();
//
//
//        Thread.sleep(5000);
//        WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
//        firstName.sendKeys("Lakshay");
//
//        WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
//        lastName.sendKeys("Sharma");
//
//        WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
//        emailAddress.sendKeys("test@gmail.com");
//
//        WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
//        phone.sendKeys("07438862327");
//
//        WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
//        countryDropDown.click();
//        Thread.sleep(2000);
//
//        List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
//        for(WebElement country : countryList){
//            if(country.getText().equals("India")) {
//                country.click();
//                Thread.sleep(3000);
//                break;
//            }
//        }
//
//        WebElement city = driver.findElement(By.cssSelector("#billing_city"));
//        city.sendKeys("Delhi");
//
//        WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
//        address.sendKeys("Shalimar Bagh");
//
//        WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
//        postcode.sendKeys("110088");
//
//        WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
//        shipToDifferetAddress.click();
//        Thread.sleep(3000);
//
//        List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
//        paymentMethod.get(0).click();
//
//        WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
//        acceptTC.click();
//
//        WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
//        placeOrder.submit();
//
        driver.quit();

    }
}
