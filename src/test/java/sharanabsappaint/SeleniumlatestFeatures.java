package sharanabsappaint;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class SeleniumlatestFeatures 

{

	public static void main(String[] args) 
	
	{

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		
	/*	WebElement dateofBirth= driver.findElement(By.cssSelector("[for='dateofBirth']"));
	
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("21/10/1995"); */

	}

}
