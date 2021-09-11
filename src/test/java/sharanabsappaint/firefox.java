package sharanabsappaint;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firefox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\1234\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
       driver.get("http://www.google.com");
       System.out.println(driver.getTitle());
       System.out.println(driver.getCurrentUrl());
       driver.close();
	}

}
