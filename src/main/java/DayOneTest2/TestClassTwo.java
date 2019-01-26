package DayOneTest2;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClassTwo {
	
	WebDriver driver;
	
	@BeforeTest
		public void setup()
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","C:\\chromedrv\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.google.lk");
		}

	@Test

		public void testSearch()
		{
			driver.findElement(By.name("q")).sendKeys("Selenium");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div[1]/a/h3")).click();
			
			String webTitle = driver.getTitle();
			Assert.assertEquals(webTitle, "Selenium - Web Browser Automation");
		}

	@AfterTest
		public void tearDown()
		{
			driver.close();
			driver.quit();
		}

}
