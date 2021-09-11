package sharanabsappaint;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class Filtersearch {

	public static void main(String[] args) throws IOException {
		DesiredCapabilities ch = DesiredCapabilities.chrome();

		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();

		c.merge(ch);

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(c);

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("E:\\aaa\\Screeshot.ping"));
		
		
		driver.findElement(By.id("search-field")).sendKeys( "Rice");
		
		
		List<WebElement> veggies = driver.findElements(By.xpath("//tr//td[1]"));
		
		//if i got 5 result when search rice how do you do that
		
		List<WebElement> filteredList = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(),filteredList.size()); 
		
		
		

	}

}
