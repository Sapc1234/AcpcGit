package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args)

	{

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		// driver.findElement(By.id("email")).sendKeys("8073048760");
		// driver.findElement(By.name("pass")).sendKeys("Sapc@2110");
		// driver.findElement(By.linkText("Forgotten password?")).click();

		/*
		 * driver.findElement(By.cssSelector("#email")).sendKeys("8073048760");
		 * driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Sapc@2110");
		 * //driver.findElement(By.cssSelector("#loginbutton")).click();
		 * driver.findElement(By.xpath("//button[@name='login']")).click();
		 */

		// cutomized xpath
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("8073048760");
		driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("Sapc@2110");
		driver.findElement(By.linkText("Forgotten password?")).click();
	}
	

	
	
	

}
