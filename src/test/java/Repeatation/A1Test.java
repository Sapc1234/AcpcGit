package Repeatation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1Test

{

	public static void main(String[] args) throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.getCurrentUrl();
		driver.getTitle();
		driver.manage().window().maximize();

		String[] itemsNeeded = { "Cauliflower", "Cucumber", "Beetroot" };

		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded)

	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			// Cucumber - 1 Kg
			// i want only Cucumber
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// convert array into array list for easy search
			// check wheather name you extracted is present in array list or not

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{

				j++;
				// click to add cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length)

				{
					break;
				}

			}
		}
	}

}
