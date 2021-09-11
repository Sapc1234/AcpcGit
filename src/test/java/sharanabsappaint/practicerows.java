package sharanabsappaint;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practicerows {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//js.executeScript("window.scrollBy(0,500)");
		
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		WebElement table = driver.findElement(By.cssSelector(".tableFixHead"));
		
		System.out.println(driver.findElements(By.tagName("tr")).size());
		
		System.out.println(driver.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")));
		
		List<WebElement> thirdrow = driver.findElements(By.tagName("tr")).get(3).findElements(By.tagName("td"));
		
		System.out.println(thirdrow.get(0).getText());
		
		System.out.println(thirdrow.get(1).getText());
		
		System.out.println(thirdrow.get(2).getText());
		
		System.out.println(thirdrow.get(3).getText());
		
		
	}

}
