package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforce1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\123\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=eu");
		
		
		driver.findElement(By.id("username")).sendKeys("123456");
		driver.findElement(By.name("pw")).sendKeys("456789");
		//driver.findElement(By.name("Login")).click();
		driver.findElement(By.xpath("//*[@id=\'Login\']")).click();
		System.out.println(driver.findElement(By.cssSelector("div#error.loginError")).getText());
		
		
		
	}

}
