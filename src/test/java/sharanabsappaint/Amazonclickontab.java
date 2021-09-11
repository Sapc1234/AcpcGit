package sharanabsappaint;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazonclickontab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);

		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));

		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("1+").doubleClick().build().perform();

		// give me the count of links in the page

		System.out.println(driver.findElements(By.tagName("a")).size());

		// give me the count of links in the footer section

		WebElement footersection = driver.findElement(By.id("navFooter"));

		System.out.println(footersection.findElements(By.tagName("a")).size());

		WebElement columnsection = driver
				.findElement(By.xpath("//div[@id='navFooter'] //div[@class='navFooterLinkCol navAccessibility'] [2]"));

		System.out.println(columnsection.findElements(By.tagName("a")).size());

		for (int i = 1; i < columnsection.findElements(By.tagName("div")).size(); i++)

		{
			String clickoneachTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnsection.findElements(By.tagName("a")).get(i).sendKeys(clickoneachTab);
		}

		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		if (it.hasNext()) 
		
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

}
