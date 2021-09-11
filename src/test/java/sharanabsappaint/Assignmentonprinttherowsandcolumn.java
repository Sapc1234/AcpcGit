package sharanabsappaint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentonprinttherowsandcolumn {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,300)");
		
		WebElement table = driver.findElement(By.cssSelector("#product"));
		
		System.out.println(table.findElements(By.tagName("tr")).size());
		
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondrow = driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		
		System.out.println(secondrow.get(0).getText());
		
		System.out.println(secondrow.get(1).getText());
		
		System.out.println(secondrow.get(2).getText());
		


	}

}
