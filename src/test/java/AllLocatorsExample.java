import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
        WebElement logId = driver.findElement(By.id("header_logo"));
        logId.click();

        driver.findElement(By.name("search_query")).sendKeys("123");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.linkText("Contact us")).click();

        driver.findElement(By.xpath("//table//tr//input[@name='FirstName']")).click();



    }
}