package sharanabsappaint;

import java.util.Arrays;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addtocartnewmethod {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		Thread.sleep(4000);

		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beans", "Tomato" };

		addItems(driver, itemsNeeded);
		/*
		 * addtocartnewmethod a =new addtocartnewmethod(); a.addItems(driver,
		 * itemsNeeded);
		 */

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));

		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

		// explicit wait

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException

	{

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{

			String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();
			/*
			 * format it to get actual vegitable name than pass it into your if condition
			 * check wheather name you extracted is present in array or not
			 *  convert array into array list for easy search
			 */

			List itemsNeededList = Arrays.asList(itemsNeeded);

			Thread.sleep(4000);

			if (itemsNeededList.contains(formattedName))

			{

				j++;

				// click to add to cart

				driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();

				if (j == itemsNeeded.length)

				{
					break;
				}
			}
		}
	}
}
