package Repeatation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addcart

{

	public static void main(String[] args)

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		// Add 1 item in cart
		// div.product-action button

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			String name = products.get(i).getText();

			if (name.contains("Brocolli"))

			{

				driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();
				break;
			}

		}
	}
	

}
