import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstSeleniumClass {
    WebDriver driver;
    @Test
    public void firstSeleniumInteractionTest ()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement formAuthlink =driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        formAuthlink.click();

        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");
        WebElement passwrdField = driver.findElement(By.name("password"));
        passwrdField.sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        WebElement successMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(successMessage.isDisplayed(),"the success msg should be displayed");
        String textOfSuccMsg = successMessage.getText();
        Assert.assertTrue(textOfSuccMsg.contains("You logged into a secure area!"));
        driver.quit();

    }
    @Test
            public void test2()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> allLinks = driver.findElements(By.xpath("//li/a"));
        Assert.assertEquals(allLinks.size(), 44, "The # of Links should be 44");
        driver.quit();
    }


}
