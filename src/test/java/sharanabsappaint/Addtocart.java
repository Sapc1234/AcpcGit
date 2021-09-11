package sharanabsappaint;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();  
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(4000);
		// expected array
		int j = 0;
		String[] itemsNeeded = { "Brocolli", "Cucumber", "Beans", "Tomato" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++)

		{
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// format it to get actual vegitable name than pass it into your if condition
			// check wheather name you extracted is present in array or not
			// convert array into array list for easy search
			List itemsNeededList = Arrays.asList(itemsNeeded);

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
