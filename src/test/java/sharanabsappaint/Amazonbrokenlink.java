package sharanabsappaint;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Amazonbrokenlink {

	public static void main(String[] args) throws IOException {
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window

		// step1 :is to get all urls tied up to the links using selenium
		// java methods will call URL's and get the status code
		// if status code is >400 then that url is not working ->the link which tied to
		// url is broken

		driver.manage().window().maximize();
		driver.get(
				"https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_Cj0KCQjwnueFBhChARIsAPu3YkSglC_tRaHcoCPi84hHsFJdXZWPBvnLkz65oTFxUozUncvbJzH6fAYaAlBdEALw_wcB_k_&ext_vrnc=hi&gclid=Cj0KCQjwnueFBhChARIsAPu3YkSglC_tRaHcoCPi84hHsFJdXZWPBvnLkz65oTFxUozUncvbJzH6fAYaAlBdEALw_wcB");

		List<WebElement> links = driver.findElements(By.cssSelector("a[class='nav_a']"));
		SoftAssert a = new SoftAssert();

		for (WebElement link : links)

		{

			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int repcode = conn.getResponseCode();
			System.out.println(repcode);
			a.assertTrue(repcode < 400, "The link with Text" + link.getText() + "is broken with code" + repcode);
			/*
			 if (repcode > 400)
			 
			  
			  { 
			  
			  System.out.println("The link with Text" + link.getText() + "is broken with code" + repcode); 
			  Assert.assertTrue(false);
			
			  }
			 */

		}

	a.assertAll();

	}

}
