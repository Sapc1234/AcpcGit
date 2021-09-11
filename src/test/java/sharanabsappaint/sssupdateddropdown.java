package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sssupdateddropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		 driver.findElement(By.cssSelector("#divpaxinfo")).click();
		
	/*	 int i=1;
		 while(i<6)
		 {
			 driver.findElement(By.cssSelector("#hrefIncAdt")).click();
			 i++; 
		 } */
		
		 for(int i=1;i<5;i++)
		 {
			 driver.findElement(By.cssSelector("#hrefIncAdt")).click();
		 }
		 
			driver.findElement(By.cssSelector("#btnclosepaxoption")).click();
			Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(), "5 Adult");
			System.out.println(driver.findElement(By.cssSelector("#divpaxinfo")).getText());
			
			
	}

}
