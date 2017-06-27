package test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import page.LoginPage;
import page.LogoutPage;

public class LogoutTest extends BaseTest {
		
	@Test
	public void logOut() {
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signOn(login, password);
		// ServicePage servicePage = new ServicePage(driver);
		// servicePage.createDraftWithSubjectAndBody();
		LogoutPage logOut = new LogoutPage(driver);
		logOut.logOut();
		assertEquals(logOut.checkLogout(), "Вход");
	}

}
