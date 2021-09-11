package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		/*
		 * System.out.println(driver.findElements(By.tagName("iframe")).size());
		 * 
		 * driver.switchTo().frame(0); // it is used only you have 1 index
		 * 
		 * //driver.switchTo().frame(driver.findElement(By.cssSelector(
		 * "iframe[class='demo-frame']")));
		 * 
		 * // driver.findElement(By.id("draggable"));
		 * 
		 * Actions a = new Actions(driver);
		 * 
		 * WebElement source =driver.findElement(By.id("draggable"));
		 * 
		 * WebElement target =driver.findElement(By.id("droppable"));
		 * 
		 * a.dragAndDrop(source,target).build().perform();
		 * driver.switchTo().defaultContent();
		 * 
		 */
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		Actions a = new Actions(driver);
		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(Source,target).build().perform();

	}

}
