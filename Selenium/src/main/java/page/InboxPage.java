package page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {

	WebDriver driver;

	public InboxPage(WebDriver driver) {

		this.driver = driver;
	}

	public static final By CURRENT_USER = By.xpath(".//*[@id='PH_user-email']");

	public String checkCurrentUser() {
		driver.findElement(By.xpath(".//*[@href='/messages/inbox/']")).click();
		String currentUser = driver.findElement(CURRENT_USER).getText();
		return currentUser;

	}
}
