package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {

		this.driver = driver;
	}

	public static final By LOGOUT = By.xpath(".//a[@id='PH_logoutLink']");
	public static final By LOGOUT_CHECK = By.xpath(".//a[@class='x-ph__link x-ph__link_last x-ph__auth__link' and @id='PH_authLink']");
	
	public void logOut() {
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(LOGOUT);
		abstractPage.waitForElementVisible(LOGOUT);
		driver.findElement(LOGOUT).click();
	}
	
	public String checkLogout(){
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(LOGOUT_CHECK);
		String logout = driver.findElement(LOGOUT_CHECK).getText();
		return logout;

	}
}
