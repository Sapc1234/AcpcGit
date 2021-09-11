package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class spicejet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spicejet.com");

		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		WebElement staticdropDown = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select dropdown = new Select(staticdropDown);

		dropdown.selectByIndex(3);
		// System.out.println(dropdown.getFirstSelectedOption().getText());

		WebElement child_dropDown = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
		Select dropdown1 = new Select(child_dropDown);
		dropdown1.selectByValue("2");
		// System.out.println(dropdown.getFirstSelectedOption().getText());

		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());

		WebElement curency_dropDown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown11 = new Select(curency_dropDown);
		dropdown11.selectByVisibleText("BDT");
		Assert.assertEquals(dropdown11.getFirstSelectedOption().getText(), "BDT");
		// System.out.println(dropdown11.getFirstSelectedOption().getText());

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// validate ui element enabled or disable
		// System.out.println(driver.findElement(By.name("ctl00$mainContent$txt_Todate")).isEnabled());
		// System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}

		else

		{
			Assert.assertTrue(false);
		}

	}

}
