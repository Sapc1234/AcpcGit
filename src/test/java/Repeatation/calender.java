package Repeatation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

		while (!driver
				.findElement(By.cssSelector(
						"[class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-title'] span[class='ui-datepicker-month'] "))
				.getText().contains("october"))

		{
			driver.findElement(
					By.cssSelector("[id='ui-datepicker-div'] span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		List<WebElement> days = driver.findElements(By.cssSelector("[class='ui-state-default']"));

		int count = driver.findElements(By.cssSelector("[class='ui-state-default']")).size();

		for (int i = 0; i < count; i++)

		{
			String text = driver.findElements(By.cssSelector("[class='ui-state-default']")).get(i).getText();
			if (text.equalsIgnoreCase("25"))

			{
				driver.findElements(By.cssSelector("[class='ui-state-default']")).get(i).click();
				break;
			}
		}

	}

}
