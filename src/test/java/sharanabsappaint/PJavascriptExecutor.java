package sharanabsappaint;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PJavascriptExecutor {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("G:\\Downloads\\Screenshot.png. "));
		
		

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //td[4]"));

		int sum = 0;

		for (int i = 0; i < values.size(); i++)

		{

			sum = sum + Integer.parseInt(values.get(i).getText());

			// System.out.println(Integer.parseInt(values.get(i).getText()));

		}

		System.out.println(sum);
	
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum,total);
		
		
		   /*
		 * List<WebElement> numbers =
		 * driver.findElements(By.xpath("//div[@class='left-align'] //td[3]")); int sum
		 * = 0; for (int i = 0; i < numbers.size(); i++)
		 * 
		 * { sum = sum + Integer.parseInt(numbers.get(i).getText());
		 * 
		 * } System.out.println(sum);
		 * 
		 * List<WebElement> course =
		 * driver.findElements(By.xpath("//div[@class='left-align'] //td[2]"));
		 * 
		 * for (int i = 0; i < course.size(); i++)
		 * 
		 * { System.out.println(course.get(i).getText());
		 * 
		 * }
		 */

	}

}
