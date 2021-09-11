package sharanabsappaint;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ebay {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ebay.com/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footer = driver.findElement(By.id("hlGlobalFooter"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		WebElement column = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		/*String Beforeclicking = null;
		String Afterclicking;*/
		for(int i=0; i<column.findElements(By.tagName("a")).size(); i++)
			
		{
			String clickonTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickonTab);
		}
		
		Set<String> sap = driver.getWindowHandles();
		Iterator<String> it = sap.iterator();
		
		while(it.hasNext())
		
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		

	}

}
