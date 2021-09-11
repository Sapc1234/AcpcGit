package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2espice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spicejet.com");
		// Dynamic dropdown Select by parent child relaionship with xpath
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value= 'BLR']")).click();
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//div[@id= 'glsctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value= 'HBX']"))
				.click();
		System.out.println(driver
				.findElement(
						By.xpath("//div[@id= 'glsctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value= 'HBX']"))
				.getText());

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();// calender

		driver.findElement(By.name("ctl00$mainContent$rbtnl_Trip")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("its disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();// checkbox

		// Static dropdown
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		WebElement staticdropDown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select dropdown = new Select(staticdropDown);
		dropdown.selectByIndex(3);

		WebElement child_dropDown = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
		Select dropdown1 = new Select(child_dropDown);
		dropdown1.selectByValue("2");

		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());

		WebElement currency_Dropdown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));

		Select dropdown11 = new Select(currency_Dropdown);

		dropdown11.selectByIndex(3);
		System.out.println(dropdown11.getFirstSelectedOption().getText());

		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}

}
