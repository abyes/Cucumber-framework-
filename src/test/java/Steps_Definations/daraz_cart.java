package Steps_Definations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class daraz_cart {
    private WebDriver driver;
    @Before
    public void setup1()
    {
        System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver =new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Given("User is on daraz URL")
    public void user_is_on_daraz_url() {
        driver.get("https://www.daraz.pk/?spm=a2a0e.login_signup.header.dhome.51e47d68yOlzQb#hp-flash-sale");

    }
    @When("User clicks on add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        driver.findElement(By.xpath("//body/div[4]/div[4]/div[2]/div[2]")).click();


    }
    @Then("product added in cart")
    public void product_added_in_cart() {

    }

}
