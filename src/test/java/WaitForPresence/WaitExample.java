package WaitForPresence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WaitExample {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://translate.google.com.ua");
        driver.findElement(By.id("source")).sendKeys("Привет Тест");
        driver.findElement(By.id("gt-submit")).click();
        By output = By.xpath("//*[@id=\"result_box\"]/span");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(output));

        System.out.println(driver.findElement(output).getText());
        driver.quit();
    }
}
