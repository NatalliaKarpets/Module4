package test;

import static org.testng.Assert.assertEquals;
import page.InboxPage;
import page.LoginPage;

import org.testng.annotations.Test;

public class Selenium extends BaseTest {
		

	@Test
	public void loginTest() {
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signOn(login, password);
		InboxPage inboxPage = new InboxPage(driver);
		inboxPage.checkCurrentUser();
		assertEquals(inboxPage.checkCurrentUser(), current_user);

	}

}
