package sharanabsappaint;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentOnHandlingWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/windows");
	//	driver.findElement(By.linkText("Multiple Windows")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Click Here')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		Set<String> sap = driver.getWindowHandles();
		Iterator<String> it = sap.iterator();
		String parentWindow = it.next();
		String childWindow= it.next();
		driver.switchTo().window(childWindow);

		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

		driver.switchTo().window(parentWindow);
		
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());

	}

}
