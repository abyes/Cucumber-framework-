package Steps_Definations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class Contact_us_Step_Def {
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
    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }
    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }
    @Given("I access the webpage")
    public void i_access_the_webpage() {
       driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("i enter the user name")
    public void i_enter_the_user_name() {
       driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("FN" +generateRandomNumber(5));

    }
    @And("last name")
    public void last_name() {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("LN" +generateRandomNumber(5));
    }
    @And("email address")
    public void email_address() {
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("ak" + generateRandomNumber(5) +"@gmail.com");
    }
    @And("message")
    public void message() {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys("ak" + generateRandomString(5) );



    }

    @When("i enter the user name specific {word}")
    public void i_enter_the_user_name_specific_joe(String fname) {
        driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys(fname);

    }
    @And("last name specifi {word}")
    public void last_name_specifi_board(String lname) {
        driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys(lname);
    }
    @And("email address specific {word}")
    public void email_address_specific_ak_gmail_com(String email) {
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
    }
    @And("message specific {string}")
    public void message_specific_test(String mess) {
        driver.findElement(By.xpath("//textarea[@name=\"message\"]")).sendKeys(mess);;
    }

    @And("I click on success message")
    public void i_click_on_success_message() {
     driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
    }
    @Then("the success message should display")
    public void the_success_message_should_display() {
        WebElement message_thanks=driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
       Assert.assertEquals(message_thanks.getText(),"Thank You for your Message!");
    }

}
