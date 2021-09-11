package sharanabsappaint;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignmentonexplicitwait {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);. 
		

		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

	
	
		
		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

	
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[id='results']")));

		
		System.out.println(driver.findElement(By.cssSelector("div[id='results']")).getText());

	}

}
