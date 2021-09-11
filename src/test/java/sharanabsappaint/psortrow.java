package sharanabsappaint;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class psortrow {

	public static void main(String[] args) {
		DesiredCapabilities ch = DesiredCapabilities.chrome();

		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();

		c.merge(ch);

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(c);

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr//th[1]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//tr//td[1]"));

		List<String> ol = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(ol);

		List<String> sortedList = ol.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		Assert.assertTrue(ol.equals(sortedList));
		
		List<String> price;
		//scan the name column with gettext (any one of them in the list)and also you should print the price of item which you taken
		do
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));

		 price = rows.stream().filter(s -> s.getText().contains("Orange ")).map(s -> getPriceVeggie(s))
				.collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		if(price.size()<1)
			
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
