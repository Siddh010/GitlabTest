
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
public class SampleTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
	  ChromeOptions capabilities = new ChromeOptions();
		capabilities.addArguments("--ignore-ssl-errors=yes");
		capabilities.addArguments("--ignore-certificate-errors");
		capabilities.addArguments("--allow-running-insecure-content");
		capabilities.addArguments("--remote-allow-origins=*");
		capabilities.setAcceptInsecureCerts(true);
    driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), capabilities);
	  System.out.println("#######START SERVER ###########");
    }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void tC1() {
    driver.get("https://www.google.co.in/");
    driver.manage().window().setSize(new Dimension(1346, 708));
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).sendKeys("TestNg");
    driver.findElement(By.xpath("//span[contains(.,\'testng\')]")).click();
    System.out.println("#######OPEN Google ###########");
    {
      WebElement element = driver.findElement(By.cssSelector(".gb_d"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
