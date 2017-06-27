package test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import page.AbstractPage;
import page.ComposePage;
import page.DraftPage;
import page.LoginPage;
import service.ServicePage;

public class DraftTest extends BaseTest {

	@Test
	public void draftMail() {
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signOn(login, password);
		ServicePage servicePage = new ServicePage(driver);
		String n = servicePage.createDraftWithSubjectAndBody();
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.waitForElementPresent(ComposePage.SAVED_STATE);
		DraftPage draftPage = new DraftPage(driver);
		draftPage.openDrafts();
		draftPage.assertDraftReceipient();
		assertEquals(draftPage.assertDraftReceipient(), receipient);
		draftPage.assertDraftSubj();
		assertEquals(draftPage.assertDraftSubj(), n);
		draftPage.assertDraftBody();
		assertEquals(draftPage.assertDraftBody(), body);
	}

}