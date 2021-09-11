package sharanabsappaint;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Scope {

	public static void main(String[] args) throws InterruptedException, IOException {

		DesiredCapabilities ch = DesiredCapabilities.chrome();
	//	ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		
		

		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(c);

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("E:\\Screenshot.png"));

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); // it is the concept of limiting webdriver scope

		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		WebElement colomndriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println(colomndriver.findElements(By.tagName("a")).size());

		// click on each link of the column check if the pages are opening

		// open all the tabs
		for (int i = 1; i < colomndriver.findElements(By.tagName("a")).size(); i++)

		{

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			colomndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);

		}

		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext())

		{

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}
}
