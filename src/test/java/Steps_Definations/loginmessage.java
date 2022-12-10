package Steps_Definations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class loginmessage {
    private WebDriver driver;
    @Before
    public void setup()
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
    @Given("I access the login page")
    public void i_access_the_login_page() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html?");

    }

    @When("user enter username {string}")
    public void user_enter_username(String fname) {
       driver.findElement(By.xpath("//input[@id=\"text\"]")).sendKeys(fname);
    }
    //input[@id="password"]
    @And("passoword {}")
    public void passoword_webdriver123(String pass) {
       driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(pass);
    }

    @And("click on submit button")
    public void click_on_submit_button() {
driver.findElement(By.xpath("//button[@id=\"login-button\"]")).click();

    }

    @Then("the success message should validate")
    public void the_success_message_should_validate() {
        Alert alert = driver.switchTo().alert();
        alert.getText();
        Assert.assertEquals(alert.getText(),"validation succeeded");


    }




}
