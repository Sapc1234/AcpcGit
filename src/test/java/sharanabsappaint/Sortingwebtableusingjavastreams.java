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

public class Sortingwebtableusingjavastreams {

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

		// click onthat column it get sorted

		driver.findElement(By.xpath("//tr//th[1]")).click();

		// capture all the webelement into list
		// once capture each webElement lets do getText firts Row

		List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

		// capture text of all webElements into new list(original"),it is also sorted
		// but you comapre with sorted list
		// this stream repeats based upon ur condition
		List<String> ol = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(ol);

		// sort in the original list of step 4->sorted list
		// once you get sorted list this will declare as a original list
 
		List<String> sortedList = ol.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		// cpmare the original list vs sorted list
		Assert.assertTrue(ol.equals(sortedList));
		
		
		
		 List<String> price;
		// scan the name column with gettext ->Beans & you should print the price of
		// theBeans
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggi(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println(a));
			if (price.size() < 1)

			{

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();

			}
		} while (price.size() < 1);

	}

	private static String getPriceVeggi(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
