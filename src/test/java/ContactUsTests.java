import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactUsTests {
    WebDriver driver;

    @BeforeTest
    public void SetUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/");
        driver.findElement(By.linkText("Contact us")).click();
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void testUntitledTestCase()  {

        //dropDown
        driver.findElement(By.id("id_contact")).click();
        new Select(driver.findElement(By.id("id_contact"))).selectByVisibleText("Webmaster");
        driver.findElement(By.id("id_contact")).click();
        driver.findElement(By.id("email")).sendKeys("qwerty@test.net");
        driver.findElement(By.id("id_order")).sendKeys("qwerty");
        driver.findElement(By.id("message")).sendKeys("Message in txtx");
        WebElement submitButton = driver.findElement(By.id("submitMessage"));
        submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='center_column']/p")).getText().contains("Your message has been successfully sent to our team.") );
    }
}
