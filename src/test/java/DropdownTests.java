import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests {
    WebDriver driver;
    @Test
    public void test()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dropdown = driver.findElement(By.xpath("//li/a[text()='Dropdown']"));
        dropdown.click();
        Select selectfromDropdowm = new Select(driver.findElement(By.xpath("//select")));
        selectfromDropdowm.selectByVisibleText("Option 2");
        //selectfromDropdowm.selectByValue("1");
        //selectfromDropdowm.selectByIndex(2);
        Assert.assertEquals("Option 2",selectfromDropdowm.getFirstSelectedOption().getText(),"The selected Option should be Option2");

        for (WebElement option: selectfromDropdowm.getOptions())
        {
            System.out.println(option.getText());
        }
    }
}
