package service;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import page.ComposePage;

public class ServicePage {

	WebDriver driver;

	public ServicePage(WebDriver driver) {

		this.driver = driver;
	}

	public String createDraftWithSubjectAndBody() {
		Random rand = new Random();
		String n = String.valueOf(rand.nextInt(50) + 1);
		ComposePage composePage = new ComposePage(driver);
		composePage.openCreateScreen();
		composePage.fillInReceipient("natallia_karpets@epam.com");
		composePage.fillInSubject(n);
		composePage.fillInBody("body");
		composePage.saveAsDraft();
		return n;

	}

	public void checkMessageIsSavedInDrafts() {
		ComposePage composePage = new ComposePage(driver);
		composePage.checkDraftIsSaved();
	}

}
