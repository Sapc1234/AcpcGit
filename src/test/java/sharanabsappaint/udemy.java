package sharanabsappaint;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class udemy {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.manage().window().maximize();

		driver.get("https://www.udemy.com/home/my-courses/learning/");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footer = driver.findElement(By.cssSelector(".footer-section.footer-section-main"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		for (int i = 0; i < footer.findElements(By.tagName("a")).size(); i++)

		{

			String clickonTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footer.findElements(By.tagName("a")).get(0).sendKeys(clickonTab);

		}

		Set<String> abc = driver.getWindowHandles();

		Iterator<String> it = abc.iterator();
		
		while(it.hasNext())
			
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
