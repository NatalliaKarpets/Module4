package test;

import org.testng.annotations.Test;

import page.LoginPage;
import service.ServicePage;

public class ComposeTest extends BaseTest{
	
	@Test
	public void createDraftWithSubjectAndBodyl() {
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.signOn(login, password);
		ServicePage servicePage = new ServicePage(driver);
		servicePage.createDraftWithSubjectAndBody();
		servicePage.checkMessageIsSavedInDrafts();
	}
	
	
	

}