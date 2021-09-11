package sharanabsappaint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companions");

 		driver.findElement(By.id("travel_date")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='datepicker-switch']")).getText()
				.contains("July"))

		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));

		int count = driver.findElements(By.cssSelector(".day")).size();
		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if (text.equalsIgnoreCase("31"))

			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}

	 }
}
