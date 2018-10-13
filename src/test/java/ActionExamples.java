import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionExamples {
    WebDriver driver;

    @Test
    public void ICanSwitchToFrame(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://jqueryui.com");

        driver.findElement(By.linkText("Resizable")).click();

        WebElement frameDraggable = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameDraggable);


        WebElement elDraggable = driver.findElement(By.id("resizable"));

        Dimension size=  elDraggable.getSize();
        new Actions(driver).moveToElement(elDraggable, size.width-2, size.height-2)
                .clickAndHold().moveByOffset(size.width, 200).release().perform();


    }
}
