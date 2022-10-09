import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest {
    WebDriver driver;
    @Test
    public void dropdownTestInteractionTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropdown = driver.findElement(By.xpath("//li/a[text()='Dropdown']"));
        dropdown.click();
        Select selectfromDropdown = new Select(driver.findElement(By.id("dropdown")));
        selectfromDropdown.selectByVisibleText("Option 2");
        Assert.assertEquals(selectfromDropdown.getFirstSelectedOption().getText(),"Option 2", "The selected Option should be Option 2");




    }
}
