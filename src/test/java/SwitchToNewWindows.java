import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class SwitchToNewWindows {

    WebDriver driver;

    @BeforeTest
    public void SetUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void TearDownTest() {
    //    driver.quit();
    }


    @Test
    public void ICanSwitchToSecondWindowTest(){
        driver.navigate().to("https://google.com");
        String winHandleBefore = driver.getWindowHandle();

        // Perform the click operation that opens new window
        ((JavascriptExecutor)driver).executeScript("window.open();");

        //Switch to new window opened
        Set<String> winHandleAfter = driver.getWindowHandles();
        for(String winHandle : winHandleAfter){
            if (!winHandle.contains(winHandleBefore) ){
                driver.switchTo().window(winHandle);
            }
        }

        // Perform the actions on new window
        driver.navigate().to("https://gmail.com");
        // Close the new window, if that window no more required
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

    }

    @Test
    public void ICanSwitchToNewTabTest() {
        driver.get("http://yahoo.com");
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://google.com");
    }
}
