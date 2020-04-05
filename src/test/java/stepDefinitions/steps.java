package stepDefinitions;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class steps {
    ChromeDriver chromeDriver;
    @Given("I launch chrome browser")
    public void i_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        chromeDriver=new ChromeDriver();
    }

    @When("I open google homepage")
    public void i_open_google_homepage() {
        chromeDriver.get("http://www.google.com/");
    }

    @Then("I verify that the google homepage is showed in the browser")
    public void i_verify_that_the_google_homepage_is_showed_in_the_browser() {
        var status = chromeDriver.findElement(By.className("gLFyf")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Then("I input the {string} to search")
    public void i_input_the_keyword_to_search(String query){
        chromeDriver.findElement(By.className("gLFyf")).sendKeys(query);
        chromeDriver.findElement(By.className("gNO89b")).submit();
    }

    @Then("I verify the {string} is in the text box")
    public void i_verify_the_keyword_is_in_the_text_box(String query) throws InterruptedException {
        var status = chromeDriver.findElement(By.cssSelector("div[id='result-stats']")).isDisplayed();
        Assert.assertTrue(status);
        Assert.assertEquals(query, chromeDriver.findElement(By.className("gLFyf")).getAttribute("value"));
    }

    @Then("I close the chrome browser")
    public void i_close_the_chrome_browser() {
        chromeDriver.quit();
    }
}
