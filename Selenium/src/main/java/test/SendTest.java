package test;

import org.testng.annotations.Test;

import page.AbstractPage;
import page.ComposePage;
import page.DraftPage;
import page.LoginPage;
import service.ServicePage;

public class SendTest extends BaseTest {
	
	@Test
	public void sendMail() {
		driver.get("https://mail.ru");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signOn("test.test9090", "qwerty_123");
		ServicePage servicePage = new ServicePage(driver);
		servicePage.createDraftWithSubjectAndBody();
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(ComposePage.SAVED_STATE);
		DraftPage draftPage = new DraftPage(driver);
		draftPage.openDrafts();
		draftPage.sendAndAssertDraftIsSent();

	}

}
