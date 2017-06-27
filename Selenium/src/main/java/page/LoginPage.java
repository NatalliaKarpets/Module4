package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	public void Login(WebDriver driver) {

	}

	private static final By LOGIN = By.xpath("//*[@id='mailbox__login']");
	private static final By DOMAIN = By.xpath("//*[@value='mail.ru']");
	private static final By PASSWORD = By.xpath("//*[@id='mailbox__password']");
	private static final By AUTH = By.xpath("//*[@id='mailbox__auth__button']");

	public void signOn(String login, String password) {
		driver.findElement(LOGIN).sendKeys(login);
		driver.findElement(DOMAIN).click();
		driver.findElement(PASSWORD).sendKeys(password);
		driver.findElement(AUTH).click();
	}

}
