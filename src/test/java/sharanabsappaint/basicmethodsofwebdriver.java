package sharanabsappaint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicmethodsofwebdriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.getPageSource();
		System.out.println(driver.getCurrentUrl());
		driver.close(); // it closes current browser
		driver.quit(); // it closes all the browsers opened by selenium script

	}

}
