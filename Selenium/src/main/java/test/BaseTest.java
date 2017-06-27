package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	public static final String url = "https://mail.ru";
	public static final String login = "test.test9090";
	public static final String password = "qwerty_123";
	public static final String receipient = "natallia_karpets@epam.com";
	public static final String body = "body";
	public static final String current_user = "test.test9090@mail.ru";
	
	WebDriver driver;

	public static void main(String[] args) {

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/Natallia_Karpets/git/Module4_1/Selenium/src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

}