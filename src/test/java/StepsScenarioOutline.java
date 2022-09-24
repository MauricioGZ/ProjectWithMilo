import com.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class StepsScenarioOutline {
    private static WebDriver driver;
    @Before
    public static void initDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chrome\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://automationpractice.com/index.php");
    }
    @Given("that I am on the main page of the store and have picked the item {string}")
    public void thatIAmOnTheMainPageOfTheStoreAndHavePickedTheItemXPath(String _xpath) {
        HomePage home = new HomePage(driver);
        home.selectItem(By.xpath(_xpath));
    }

    @When("I am in the item's page I select its color {string}, size {string} and a quantity equal to {int}")
    public void iAmInTheItemSPageISelectItsColorColorSizeSizeAndAQuantityEqualToQuantity(String _color, String _size, int _quantity) {
        ItemDetailPage itemDetail = new ItemDetailPage(driver);
        itemDetail.clearQuantity();
        //itemDetail.setColor(_color);
        itemDetail.setSize(_size);
        itemDetail.setQuantity(_quantity);
        itemDetail.addToCar();
    }

    @Then("the selected color {string}, the size {string} and quantity {int} have to correspond the shown values in the summary")
    public void theSelectedColorColorTheSizeSizeAndQuantityQuantityHaveToCorrespondTheShownValuesInTheSummary(String _color, String _size, int _quantity) {
        ResumePage resume = new ResumePage(driver);
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("layer_cart_product_attributes"))));

        //Assert.assertEquals(resume.getColor(),_color);
        Assert.assertEquals(resume.getSize(), _size);
        Assert.assertEquals(resume.getQuantity(), String.valueOf(_quantity));
    }

    @After
    public static void closeDriver(){
        driver.quit();
    }

}
