package sharanabsappaint;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assinment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize the window

		driver.manage().window().maximize();

	driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();

	driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]/input")).click();

		String sap = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select abc = new Select(dropdown);
		abc.selectByVisibleText(sap);

		driver.findElement(By.id("name")).sendKeys(sap);
		driver.findElement(By.id("alertbtn")).click();
		//System.out.println(driver.switchTo().alert().getText());
		
		String text = driver.switchTo().alert().getText();
		
		if(text.contains(sap))
			
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");  
	
	
/*	driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
	String abc = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
	
	WebElement cdropdown = driver.findElement(By.id("dropdown-class-example"));
	Select dropdown = new Select(cdropdown);
	
	dropdown.selectByVisibleText(abc);
	
	driver.findElement(By.id("name")).sendKeys(abc);
	driver.findElement(By.id("alertbtn")).click();
	//System.out.println(driver.switchTo().alert().getText());
	
	String text = driver.switchTo().alert().getText();
	
	if(text.contains(abc))
	{
		System.out.println("pass");
	}
	else
		System.out.println("fail");
	} */

}
}
