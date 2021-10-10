package stepDefinitions;

import cucumber.api.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class steps {
    WebDriver driver;

    @Given("^user is on eBayHome Page$")
    public void user_is_on_Home_Page() throws Exception{
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
                Thread.sleep(200);
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

        driver.quit();

    }
}
