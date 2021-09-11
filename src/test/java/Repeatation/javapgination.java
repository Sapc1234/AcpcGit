package Repeatation;

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

public class javapgination {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// local ChromeBrowser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window
		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies(); driver.manage().addCookie("asdf");
		 * driver.manage().deleteCookieNamed("sessionkey");
		 */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.getCurrentUrl();
		driver.getTitle();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\Screenshot.png"));

		// click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture all the webelement into list

		List<WebElement> el = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into list(original)

		List<String> ol = el.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort the original list

		List<String> sl = ol.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(ol.equals(sl));

		List<String> price;
		do {

			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1)

			{
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub

		String Pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return Pricevalue;
	}

}
