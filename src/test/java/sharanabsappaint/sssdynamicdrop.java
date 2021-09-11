package sharanabsappaint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sssdynamicdrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spicejet.com");
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();  //Dynamic dropdown with index
		
		//parent child relationship with xpath
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();//calender
	
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily]")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily]")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily]")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
