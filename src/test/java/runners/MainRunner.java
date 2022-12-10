package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"} , glue = {"Steps_Definations"} ,tags = "@contactus",
monochrome =true, dryRun = false,
plugin = {"pretty" , "html:target/cucumber" , "json:target/cucumber.json"})

public class MainRunner extends AbstractTestNGCucumberTests {
}
