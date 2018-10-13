package WaitForPresence;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void SetUpTest() {
        driver = new ChromeDriver();
        wait=new WebDriverWait(driver, 20);

        driver.manage().window().maximize();
        driver.navigate().to("https://google.com/");
    }

    @AfterTest
    public void TearDownTest() {
        driver.quit();
    }

    @Test
    public void waitTest(){
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.RETURN);
        Assert.assertTrue(isElementPresent(By.cssSelector(".rc")));

    }

    private boolean isElementPresent(By locator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            driver.findElement(locator);
            return true;
        }
        catch (NoSuchElementException ex){
            return false;

        }
    }
}
