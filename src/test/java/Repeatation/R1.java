package Repeatation;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class R1 {

	@Test(enabled = false)
	public void facebooklogin()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("sharanpadashetty637@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Sapc@1234");
		// driver.findElement(By.name("login")).click();
		// driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Test(enabled = false)
	public void SalesForce()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys("hello");
		driver.findElement(By.name("pw")).sendKeys("123456");
		driver.findElement(By.id("Login")).click();
		System.out.println(driver.findElement(By.id("error")).getText());
	}

	@Test(enabled = false)
	public void Dropdown() throws InterruptedException

	{

		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// Autosuggestive Dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");

		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options)

		{

			if (option.getText().equalsIgnoreCase("India"))

			{
				option.click();
				break;

			}
		}

		// Dynamic Dropdown

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']"))
				.click();

		// DropDown Looping ui
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 1; i < 5; i++)

		{

			driver.findElement(By.id("hrefIncAdt")).click();

		}

		driver.findElement(By.id("btnclosepaxoption")).click();

	}

	@Test(enabled = false)
	public void spicejet() throws InterruptedException

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		// Dynamic Dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);

		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //in this
		// find the object with the help of index

		// parent - child Relationship with xpath to identify object uniquly

		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		// Handling Calender

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// validating ui elements are disabled or enabled with attributes

		/*
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 * driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click()
		 * ;
		 * System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")
		 * ).isEnabled());
		 */

		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.cssSelector("#Div1")).getAttribute("style"));

		if (driver.findElement(By.cssSelector("#Div1")).getAttribute("style").contains("1"))

		{
			System.out.println("Its Enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		// handling checkboxes
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

		// count the no of checkboxes

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.findElement(By.id("divpaxinfo")).click();

		WebElement adrop = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select dropdown = new Select(adrop);
		dropdown.selectByValue("5");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(driver.findElement(By.cssSelector("#divpaxinfo")).getText(), "5 Adult");
		// Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4
		// Adult");

		WebElement cdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown1 = new Select(cdropdown);

		dropdown1.selectByVisibleText("INR");
		System.out.println(dropdown1.getFirstSelectedOption().getText());

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

	@Test(enabled = false)
	public void seze() throws InterruptedException

	{

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
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))

		{
			System.out.println("its disabled");
			Assert.assertTrue(true);
		}

		else

		{
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

	@Test(enabled = false)
	public void Actions() {
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		// ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		WebElement mov = driver.findElement(By.cssSelector("#nav-link-accountList"));

		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("mobile").doubleClick().build().perform();

		a.moveToElement(mov).contextClick().build().perform();

		// Drag and Drop will be continue frames class

	}

	@Test(enabled = false)
	public void WindowsHandles()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);

		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim()
				.split(" ")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

	@Test(enabled = false)
	public void AssignmentonWindowHandle()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
	}

	@Test(enabled = false)
	public void Frames()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

		System.out.println(driver.findElements(By.tagName("iframe")).size());

		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		// driver.findElement(By.cssSelector("#draggable")).click();

		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("#draggable"));
		WebElement target = driver.findElement(By.cssSelector("#droppable"));

		a.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
	}

	@Test(enabled = false)
	public void aFrame()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");

		driver.findElement(By.linkText("Nested Frames")).click();

		System.out.println(driver.findElements(By.tagName("frameset")).size());

		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		System.out.println(driver.findElement(By.id("content")).getText());
	}

	@Test(enabled = false)
	public void Scope()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1-how many links are there and what is the count of them?
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2-how many link are their in footer section

		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));

		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// 3-how many links are their in footersection first column

		WebElement coloumndriver = driver.findElement(By.xpath("//div[@id='gf-BIG']//table/tbody/tr/td[1]/ul"));

		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		// 4- click on each link in the column and check if pages are opening and go to
		// each and every tab grab the tittle and print it

		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++)

		{
			String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);

		}

		// open all the tabs and grab windows tittle and print in console
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext())

		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

	@Test(enabled = false)
	public void AmazonclickonlinkTab()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();

		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("one plus").doubleClick().build().perform();

		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement fdriver = driver.findElement(By.xpath("//div[@id='navFooter']"));
		System.out.println(fdriver.findElements(By.tagName("a")).size());

		// div[@id='navFooter'] //div[@class='navFooterLinkCol navAccessibility'] [2]

		WebElement cdriver = driver
				.findElement(By.xpath("//div[@id='navFooter'] //div[@class='navFooterLinkCol navAccessibility'] [1]"));

		System.out.println(cdriver.findElements(By.tagName("a")).size());

		for (int i = 0; i < cdriver.findElements(By.tagName("a")).size(); i++)

		{
			String clickonlinktab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			cdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
		}

		Set<String> sap = driver.getWindowHandles();
		Iterator<String> it = sap.iterator();

		while (it.hasNext())

		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

	}

	@Test(enabled = false)
	public void Calender()

	{
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize the window

		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#travel_date")).click();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] .datepicker-switch")).getText()
				.contains("May"))

		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> dates = driver.findElements(By.cssSelector(".day"));

		int count = driver.findElements(By.cssSelector(".day")).size();
		for (int i = 0; i < count; i++)

		{

			String text = driver.findElements(By.cssSelector(".day")).get(i).getText();
			if (text.equalsIgnoreCase("23"))

			{
				driver.findElements(By.cssSelector(".day")).get(i).click();
				break;
			}
		}

	}

	@Test(enabled = false)
	public void JavaScript() throws InterruptedException, IOException

	{
		// General chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// local chrome Browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Screenshot.jpg"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < values.size(); i++)

		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}

		System.out.println(sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		Assert.assertEquals(sum, total);

	}

	@Test(enabled = false)
	public void AjavaScript() throws IOException

	{
		// Desired Capabilites
		// General Chrome profile
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// local ChromeBrowser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window
		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies(); driver.manage().addCookie("asdf");
		 * driver.manage().deleteCookieNamed("sessionkey");
		 */
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\Screenshot.png"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.table-display').scrollby=5000");
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++)

		{
			sum = sum + Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);

		// Assignment
		WebElement table = driver.findElement(By.cssSelector(".table-display"));

		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("td")).size());

		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondrow = driver.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
	}

	@Test(enabled = false)
	public void BrokenLinks() throws IOException

	{
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		cap.acceptInsecureCerts();

		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		ChromeOptions c = new ChromeOptions();
		c.merge(cap);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		File sap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sap, new File("D:\\Screenshot.png"));

		// s1 ->is to get all the urls are tied upto the links using selenium
		// java methos will call the urls and get the status code
		
		// if status code is >400 then that url is not working ->links which tied to the
		// url is broken

		// a[href*='soapui']

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		for (WebElement link : links)

		{

			String url = link.getAttribute("href");
			// href will give complete url of that link

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();// this method will do just like what you have done on ur browser
			int responsecode = conn.getResponseCode();// this method will give you the code of the response what you
														// got?
			System.out.println(responsecode);
			a.assertTrue(responsecode < 400,
					"The link with Text" + link.getText() + "is Broken with code" + responsecode);

		}

		a.assertAll(); // if you write this end it will report it

	}

	// @Test
	public void Regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anil");

		int count = 0;
		for (int i = 0; i < names.size(); i++)

		{

			String actual = names.get(i);
			if (actual.startsWith("A"))

			{
				count++;
			}

		}
		System.out.println(count);
	}

	// @Test
	public void StreamFilter()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anilkumar");

		// their is no life for intermidate operatoin if their is no terminal operation
		// terminal op will execute only if inter op(filter) returns true
		// we can create a stream
		// how to use filter in stream api0

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		long d = Stream.of("Abhishek", "Don", "Arun", "Ram", "Anilkumar").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();

		System.out.println(d);

		// print aLL THE names of the list length >3
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));

	}

	// @Test
	public void StreamMap()

	{ // print all the names which have start with a and write with upper case
		Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anilkumar").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		// if want to print all the letters with upper case
		Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anilkumar").map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print the names which have first letter as a with uppercase and sorted

		List<String> names = Arrays.asList("Abhishek", "Don", "Aruna", "Rama", "Anil");

		names.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

	}

	// @Test
	public void MergingTwoList()

	{
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhishek");
		names.add("Don");
		names.add("Arun");
		names.add("Ram");
		names.add("Anilkumar");

		List<String> names1 = Arrays.asList("Abhishek", "Don", "Aruna", "Rama", "Anil");

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Aruna"));
		System.out.println(flag);
		Assert.assertTrue(flag);

	}

	//@Test
	public void StreamCollect()

	{
		List<String> ls = Stream.of("Abhishek", "Don", "Aruna", "Rama", "Anil").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).collect(Collectors.toList());

		System.out.println(ls.get(0));
		
		
		// print the unique number from this array
		
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		
		values.stream().distinct().forEach(s->System.out.println(s));
		
		// sort the array
		
		values.stream().sorted().forEach(s->System.out.println(s));
		
		// sort the array with unique style and print the third index

		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		
		System.out.println(li.get(3));
		
		

		

	}
	
	//@Test
	public void LiveDemo() throws IOException
	
	{
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// local ChromeBrowser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window
		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies(); driver.manage().addCookie("asdf");
		 * driver.manage().deleteCookieNamed("sessionkey");
		 */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\Screenshot.png"));
		
		//click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//capture all the webelement into list
		
		List<WebElement> el = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into list(original)
		
		List<String> ol = el.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort the original list
		
		List<String> sl = ol.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(ol.equals(sl));
		
		
		List<String> price;
		do
			
		{
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			
		
		 price  = rows.stream().filter(s -> s.getText().contains("Mango")).map(s -> getPriceVeggie(s))
		.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1)
			
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		
		}while(price.size()<1);
		
}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
	
	//@Test
	
	public void Searching() throws IOException
	
	{

		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// local ChromeBrowser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window
		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies(); driver.manage().addCookie("asdf");
		 * driver.manage().deleteCookieNamed("sessionkey");
		 */
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\Screenshot.png"));
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filterlist = veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filterlist.size());
		
	}
	
	@Test
	
	public void seleniumAlpha() throws IOException
	
	{
		DesiredCapabilities ch = DesiredCapabilities.chrome();
		ch.acceptInsecureCerts();
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// local ChromeBrowser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch);
		System.setProperty("webdriver.chrome.driver", "C:\\123\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);

		// maximize the window
		driver.manage().window().maximize();
		/*
		 * driver.manage().deleteAllCookies(); driver.manage().addCookie("asdf");
		 * driver.manage().deleteCookieNamed("sessionkey");
		 */
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.getCurrentUrl();
		driver.getTitle();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("G:\\Screenshot.png"));
		
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		
		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("21/10/1995");
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("21/10/1996");
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("21/10/1997");
		driver.findElement(withTagName("input").below(dateofBirth)).sendKeys("21/10/1998");
		
		WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(withTagName("input").toLeftOf(iceCreamLabel)).click();
		
		
		//Get me the label of first Radio button
		
		WebElement rb = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(withTagName("label").toRightOf(rb)).getText());
		
		


		
		
		
		
	}
}
