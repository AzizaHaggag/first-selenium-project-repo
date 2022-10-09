import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SecondSeleniumClass {
    WebDriver driver;
    @Test
    public void secondSeleniumInteractionTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement shiftingContent = driver.findElement(By.xpath("//a[text()='Shifting Content']"));
        shiftingContent.click();
        WebElement example1 = driver.findElement(By.xpath("//a[text()='Example 1: Menu Element']"));
        example1.click();
        List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
        Assert.assertEquals(allLinks.size(), 5, "The # of links should be 5");
        driver.quit();





    }
}
