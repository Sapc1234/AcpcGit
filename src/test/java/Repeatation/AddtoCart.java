package Repeatation;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart

{

	public static void main(String[] args) throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver,5);
		
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		

		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		driver.getCurrentUrl();
		driver.getTitle();
		Thread.sleep(3000);
		driver.manage().window().maximize();

		// Add2 item in cart
		// div.product-action button

		String[] itemsNeeded = { "Cauliflower", "Cucumber", "Beetroot", "Carrot" };
		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector("div[class='cart-preview active'] button")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	public static void addItems(WebDriver driver,String[] itemsNeeded)
	
	{
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();

			// convert array into array list for easy search
			// chech wheather name you extracted is present in array list or not

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{
				
				//click on add to cart
				j++;
				driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();

				if (j == itemsNeeded.length)

				{
					break;
				}
			}

		}
		
	}

}
